package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

	public class Session3Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {


	HttpSession session = request.getSession(false);
	if (session != null) {
		//セッションを終了する、セッションに何か入ってる場合
	session.invalidate();
	}
	response.setContentType("text/html;charset=Windows-31J");
	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println("<head><title>Session Servlet 3</title></head>");
	out.println("<body>");
	out.println("<h1>Session Servlet 3</h1>");
	out.println("<p>セッションを終了しました</p>");
	out.println("</body>");
	out.println("</html>");
	}
	}


