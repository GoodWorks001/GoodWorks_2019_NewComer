package search;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InSearchServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		req.setCharacterEncoding("UTF-8");

		String keyword = req.getParameter("keyword");
		System.out.println(keyword);
		// インスタンス化
		SearchJDBCkekka jd = new SearchJDBCkekka();
		jd.getKeyword(keyword);
		// sessionにjd.list格納
		session.setAttribute("name", jd.listnamere);
		session.setAttribute("price", jd.listpricere);
		session.setAttribute("cd", jd.listcdre);
		// リザルト画面へ
		RequestDispatcher rd = req.getRequestDispatcher("SearchResult.jsp");
		rd.forward(req, resp);

	}

}
