package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ

		req.setCharacterEncoding("UTF-8");

		HttpSession ses =req.getSession(false);

		if(ses != null) {
			ses.invalidate();
		}

		RequestDispatcher rd =req.getRequestDispatcher("/login.jsp");
		rd.forward(req, resp);


	}

}
