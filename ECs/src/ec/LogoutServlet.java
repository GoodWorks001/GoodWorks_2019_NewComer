package ec;

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

		HttpSession session = req.getSession(false);

		int meisai = (Integer)session.getAttribute("mei");

		if (session != null) {
			session.invalidate();//セッションを破棄
		}


		session =req.getSession(true);
		session.setAttribute("mei", meisai);

		//飛ぶ先を指定
		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		//飛ばす
		rd.forward(req, resp);
	}

}
