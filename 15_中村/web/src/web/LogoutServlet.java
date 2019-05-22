package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		//int meisai = (Integer)session.getAttribute("mei");
		//セッションが開始しているかの確認
		session = req.getSession(false);
		//開始しているなら
		if(session != null) {
			//セッションの終了
			session.invalidate();
			System.out.println("ログアウト");
		}
		
		//新しいセッションの開始
		session = req.getSession(true);
		//分岐用の値初期化
		//session.setAttribute("zyouhou", "true");
		//session.setAttribute("syouhin", "null");
		session.setAttribute("cart", null);
		//session.setAttribute("mei", meisai);
		//遷移するためのテンプレ
		RequestDispatcher rd = req.getRequestDispatcher("ecentry.jsp");
		//遷移だ
		rd.forward(req, resp);

	}
}
