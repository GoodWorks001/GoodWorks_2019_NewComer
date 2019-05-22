package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//以下HTML形式で出力させるためのコード
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Session Servlet 2</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 2</h1>");

		//セッションの継続の確認
		HttpSession session = req.getSession(false);

		//継続されてないなら
		if (session == null) {
		out.println("<p>セッションが開始されていません</p>");
		out.println("</body>");
		out.println("</html>");
		return;
		}
		//継続されているなら
		out.println("<p>セッションが継続しています</p>");
		out.println("<p>"+session.getAttribute("loginUser")+"</p>");
		out.println("</body>");
		out.println("</html>");

	}

}
