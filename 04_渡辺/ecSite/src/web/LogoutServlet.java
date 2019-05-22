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

		//文字コードの設定
		req.setCharacterEncoding("UTF-8");

        //セッションを保持していたら破棄する
		HttpSession ses = req.getSession(false);
		if (ses != null) {
			System.out.println("セッションを破棄します");
			ses.invalidate();
		}

		//ログイン画面に戻る
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
}
