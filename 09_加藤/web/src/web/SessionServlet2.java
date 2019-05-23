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
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Session Servlet 2</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 2</h1>");
		//セッションオブジェクトを取得するためのメソッド
		//セッションが継続していない場合は、引数をfalseに設定
		//セッションが継続している場合は、引数をtrueに設定する
		HttpSession session = req.getSession(true);
		//セッションが継続していないためエラー処理を行うメソッド
		if (session == null) {
			out.println("<p>セッションが開始されていません</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		//以下がセッションが正常に継続している場合の処理を行うメソッド
		//セッションが正常に継続していることを
		//ブラウザ上で表示するロジック
		out.println("<p>セッションが継続しています</p>");
		out.println("<p>"+session.getAttribute("loginUser")+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
