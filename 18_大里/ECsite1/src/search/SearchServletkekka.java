package search;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchServletkekka extends HttpServlet {
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(false);

			String value = req.getParameter("category");
		    //インスタンス化
			SearchJDBCkekka jdbc = new SearchJDBCkekka();
			jdbc.getCategory(Integer.parseInt(value));

			//sessonに値を格納
			session.setAttribute("name", jdbc.listnamere);
			session.setAttribute("price", jdbc.listpricere);
			session.setAttribute("cd", jdbc.listcdre);

			//リザルト画面へ
			RequestDispatcher rd = req.getRequestDispatcher("SearchResult.jsp");
			rd.forward(req, resp);


	}
}
