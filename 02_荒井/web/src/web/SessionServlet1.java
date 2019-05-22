package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//セッションの開始プログラム
public class SessionServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);   //リクエストしている
		                                                //

		session.setAttribute("loginUser", "KnowledgeTaro");   //データの格納
		resp.setContentType("text/html;charset=Windows-31J");


		PrintWriter out = resp.getWriter();    //レスポンス


		out.println("<html>");      //出力
		out.println("<head><title>Session Servlet 1</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 1</h1>");
		out.println("<p>セッションを開始しました</p>");
		out.println("</body>");
		out.println("</html>");


	}

}
