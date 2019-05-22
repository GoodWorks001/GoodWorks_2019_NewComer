package web1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Third extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String num = req.getParameter("num");
		String example2 = req.getParameter("example2");
		String male = req.getParameter("male");
		String[] jv = req.getParameterValues("jv");
		String ma = req.getParameter("ma");

		resp.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h1>名前</h1>");
		out.println("<p>"+num+"</p>");
		out.println("<h1>年齢</h1>");
		out.println("<p>"+example2+"</p>");
		out.println("<h1>性別</h1>");
		out.println("<p>"+male+"</p>");
		out.println("<h1>興味のある言語</h1>");
		for(String lg: jv) {
			out.println("<p>"+lg+"</p>");
		}
		out.println("<h1>何か一言</h1>");
		out.println("<p>"+ma+"</p>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		out.close();


	}

}
