package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//セッションオブジェクトを取得するためのメソッド
		//セッションを開始する場合は、引数をtrueにする
		HttpSession session = req.getSession(true);
		//データの格納を行うメソッド
		//左側が格納するオブジェクトにつける名称
		//右側が格納したいオブジェクト
		session.setAttribute("loginUser", "KnowledgeTaro");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//以下はhtmlで記載し、ブラウザ上で表示する
		out.println("<html>");
		out.println("<head><title>Session Servlet 1</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 1</h1>");
		out.println("<p>セッションを開始ました。</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
