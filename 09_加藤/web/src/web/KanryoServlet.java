package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KanryoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("完了サーブレット開始");

		//送信されてくるパラメータのエンコーディング指定
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession(false);

		if(session != null) {
			//セッションのデータを削除するロジック
			session.invalidate();
			RequestDispatcher rd = req.getRequestDispatcher("/login_ec.jsp");
			rd.forward(req, resp);
		}

		System.out.println("完了サーブレット終了");
	}
}
