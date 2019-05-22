package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//セッションの継続プログラム
public class SessionServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=Windows-31J");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head><title>Session Servlet 2</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 2</h1>");

		HttpSession session = req.getSession(false);   //セッション継続は左記のメソッドの引数をfalseにして
		                                                 //戻り値がnullでないことで確認できる

		if (session == null) {
			out.println("<p>セッションが開始されていません</p>");       //セッションが継続していないのでエラー処理を行う
		out.println("</body>");
		out.println("</html>");

		return;

		}

		out.println("<p>セッションが継続しています</p>");               //セッションが継続している場合表示
		out.println("<p>"+session.getAttribute("loginUser")+"</p>");
		out.println("</body>");
		out.println("</html>");


	}

}
