package Login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("終了開始");


		HttpSession ses = req.getSession(false);
		ses.invalidate();

		RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
		rd.forward(req, resp);



	}

}
