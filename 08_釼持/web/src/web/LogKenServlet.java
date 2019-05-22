package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogKenServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(true);

		//ログイン画面で入力されたもの
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		//インスタンス化
		DAO_LogKen dlk = new DAO_LogKen();
		//データベースからもらう
		String dlkName = dlk.selectName();
		String dlkPass = dlk.selectPass();
		String dlkCategory1 = dlk.selectCategory(1);
		String dlkCategory2 = dlk.selectCategory(2);
		String dlkCategory3 = dlk.selectCategory(3);

		//インスタンス化
		Bean bean = new Bean();

		//ログイン判定
		//ログインページに書いた名前とパスワードが一致したら
		if (dlkName.equals(name) && dlkPass.equals(password)) {
			//ユーザーIDを取得
			int uid = dlk.selectUserID(dlkName, dlkPass);
			//beanにセット
			bean.setUserID(uid);
			//セッションに保存
			session.setAttribute("UID", bean);
			session.setAttribute("NAME", name);
			session.setAttribute("PASSWORD", password);
			//beanにセット
			bean.setUseerName(name);
			bean.setPassword(password);
			//reqでセット
			req.setAttribute("DLKCATEGORY1", dlkCategory1);
			req.setAttribute("DLKCATEGORY2", dlkCategory2);
			req.setAttribute("DLKCATEGORY3", dlkCategory3);
			//検索画面で使用する
			int num = 0;
			req.setAttribute("NUM", num);
			//遷移先決定
			RequestDispatcher dis = req.getRequestDispatcher("/kensaku.jsp");
			//投げる
			dis.forward(req, resp);
		} else if (name.equals("") || password.equals("")) {
			//遷移先決定
			RequestDispatcher dis = req.getRequestDispatcher("/logError1.jsp");
			//投げる
			dis.forward(req, resp);
		} else { //遷移先決定
			RequestDispatcher dis = req.getRequestDispatcher("/logError2.jsp");
			//投げる
			dis.forward(req, resp);
		}

	}
}
