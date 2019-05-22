package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class shousai10 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = req.getSession(true);
		String cd = req.getParameter("itemNum");

		ses.setAttribute("itemNum2", cd);


		RequestDispatcher rd = req.getRequestDispatcher("shoukai2.jsp");
		rd.forward(req, resp);



	}

}
