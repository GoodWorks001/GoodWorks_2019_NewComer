package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet extends HttpServlet {


		protected void doPost(HttpServletRequest req,
				HttpServletResponse resp)
				throws ServletException, IOException {
			HttpSession session = req.getSession(false);
			if(session !=null) {
				JDBC2 jdbc = new JDBC2();
				jdbc.main();
				session.setAttribute("name", jdbc.listname);
				session.setAttribute("price", jdbc.listprice);
				session.setAttribute("cd", jdbc.listcd);
				session.setAttribute("stock", jdbc.liststock);
				RequestDispatcher rd = req.getRequestDispatcher("Search.jsp");
				rd.forward(req, resp);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("errar1.jsp");
				rd.forward(req,resp);
			}


		}
}
