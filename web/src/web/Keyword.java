package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Keyword extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		req.setCharacterEncoding("UTF-8");

		if(session != null) {
			String keyword = req.getParameter("keyword");
			System.out.println(keyword);
			JDBC_SR jd = new JDBC_SR();
			jd.getKeyword(keyword);
			session.setAttribute("name", jd.listnamere);
			session.setAttribute("price", jd.listpricere);
			session.setAttribute("cd", jd.listcdre);

			RequestDispatcher rd = req.getRequestDispatcher("SearchResult.jsp");
			rd.forward(req,resp);

		}else {
			RequestDispatcher rd = req.getRequestDispatcher("LoggedOut.jsp");
			rd.forward(req,resp);
		}
		// TODO 自動生成されたメソッド・スタブ
		//super.doPost(req, resp);
	}
}
