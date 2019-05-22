package EC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SyouhinServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		HttpSession session = req.getSession(false);
		if(session != null) {
			String name = req.getParameter("p_name");
			int category = Integer.parseInt(req.getParameter("category"));
			String key = "";
			Syousai_DAO DAO = new Syousai_DAO();
			if(name != "" & category != 0) {
				DAO.jdbc1(name, category);
				session.setAttribute("name", DAO.namelist);
				session.setAttribute("price", DAO.pricelist);
				//遷移先の指定
				RequestDispatcher rd2 = req.getRequestDispatcher("/search.jsp");
				//rdに投げてる
				rd2.forward(req,resp);
			} else if(name == "" & category != 0) {
				DAO.jdbc1_2(category);
				session.setAttribute("name", DAO.namelist);
				session.setAttribute("price", DAO.pricelist);
				//遷移先の指定
				RequestDispatcher rd2 = req.getRequestDispatcher("/search.jsp");
				//rdに投げてる
				rd2.forward(req,resp);
			} else if(name != "" & category == 0) {
				key = DAO.jdbc1_3(name);
				if(key != "") {
					session.setAttribute("name", DAO.namelist);
					session.setAttribute("price", DAO.pricelist);
					//遷移先の指定
					RequestDispatcher rd2 = req.getRequestDispatcher("/search.jsp");
					//rdに投げてる
					rd2.forward(req,resp);
				} else {
					//遷移先の指定
					RequestDispatcher rd2 = req.getRequestDispatcher("/search3.jsp");
					//rdに投げてる
					rd2.forward(req,resp);
				}
			} else {
				System.out.println(DAO.namelist);
				//遷移先の指定
				RequestDispatcher rd2 = req.getRequestDispatcher("/search3.jsp");
				//rdに投げてる
				rd2.forward(req,resp);
			}
		} else {
			//遷移先の指定
			RequestDispatcher rd2 = req.getRequestDispatcher("/login.jsp");
			//rdに投げてる
			rd2.forward(req,resp);
		}

	}
}

