package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	//dogetと入力後ctrl+spaceキーを同時
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{

		//Httpへのデータの格納
		HttpSession session=request.getSession(true);
		session.setAttribute("loginUser","KnowledgeTaro");

		//エンコーディングとMIMEの設定
		response.setContentType("text/html; charset=windows-31J");

		//servletでhtmlを書くための準備
		PrintWriter out = response.getWriter();

		//変数名の形式でhtmlを書く
		out.println("<html>");
		out.println("<head><title>Session Servlet 1</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 1</h1>");
		out.println("<p>セッションを開始しました</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
