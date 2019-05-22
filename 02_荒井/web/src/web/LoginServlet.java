package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ECDAOクラスをインスタンス化
		ECDAO dao = new ECDAO();

		//CatCADクラスをインスタンス化
		CatDAO cat = new CatDAO();

		//送信されてくるパラメーターのエンコード指定
		req.setCharacterEncoding("UTF-8");

		//セッションの指定
		HttpSession session = req.getSession(true);

		//送信されたパラメーターを取得
		String submitName = req.getParameter("name");
		String submitId = req.getParameter("passward");

		String[] index = dao.Access(submitName);

		//名前とパスワードどちらかがnullか空白だった場合、エラーメッセージ表示
		if ((submitName == null || submitId == null) || (submitName == "" || submitId == "")) {
			req.setAttribute("errormsg", "名前またはパスワードを入力してください");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);

			return;


			//名前かパスワードがの内容がDBの内容と一致していなければ
			//エラーメッセージ表示
		} else if (!(submitName.equals(index[0]) || submitId.equals(index[1]))) {
			req.setAttribute("errormsg", "名前またはパスワードが一致しません");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);

			return;

		}

		//セッションに値をセット
		session.setAttribute("login_cd", index[0]);
		session.setAttribute("login_pw", index[1]);
		session.setAttribute("login_name", index[2]);

		                      //暗号
		session.setAttribute("catgoryList", cat.getcatlist());   
		session.setAttribute("flg", "true");


		System.out.println("loginsevlet実行");  //loginservletが実行していれば左記表示


		//同一コンテクストのkensaku.jspへ転送する
		//ServletからJSPを呼び出す
		RequestDispatcher rd = req.getRequestDispatcher("Kensaku");
		rd.forward(req, resp);

	}

}
