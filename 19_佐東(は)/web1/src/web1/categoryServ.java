package web1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ECpack.DAO;

public class categoryServ extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		       DAO oda = new DAO();
		       //インスタンス化してます↑

				RequestDispatcher rd = req.getRequestDispatcher("/search.jsp");
				rd.forward(req, resp);
				//遷移先を選定してます↑

	}


}
