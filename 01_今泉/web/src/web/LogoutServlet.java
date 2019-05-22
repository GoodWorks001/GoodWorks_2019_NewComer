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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 送信されてくるパラメータのエンコーディングの指定
				req.setCharacterEncoding("UTF-8");

				// セッションの継続
				HttpSession session = req.getSession(false);

				//sessionが継続中ならsessionを切断する
				if(session!=null) {
					session.invalidate();
				}

				//遷移先指定
				RequestDispatcher rd = req.getRequestDispatcher("Login1.jsp");
				rd.forward(req, resp);

	}

}
