package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class shousaiServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//送信されてくるパラメーターのエンコード指定
		req.setCharacterEncoding("UTF-8");

		//セッションの指定
		HttpSession ses = req.getSession(true);

		//shousaiServletが実行されたとき表示
		System.out.println("shousaiServlet実行しました");

		//インスタンス化
		shousaiDAO shousai = new shousaiDAO();

		//選択されたidを変数idに代入する
		int id = Integer.parseInt(req.getParameter("id"));

		//idの中に何が入っているか確認する
		System.out.println(id);

		//prodaust型の変数に格納する
		ProductBean bean = shousai.shousai(id);

		//セッションに値をセットする
		                  //暗号
		ses.setAttribute("shouhin", bean);

		//kensaku.jspに飛ばす
		RequestDispatcher rd = req.getRequestDispatcher("/shoukai1.jsp");
		rd.forward(req, resp);

	}

}
