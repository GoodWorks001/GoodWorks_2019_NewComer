package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//セッションの終了プログラム
public class SessionServlet3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);


		if (session != null) {
			session.invalidate();    //現在のユーザーに対するセッションIDを無効化し
		                             //セッションオブジェクトを消滅させるメソッド
		}


		resp.setContentType("text/html;charset=Windows-31J");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head><title>Session Servlet 3</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 3</h1>");
		out.println("<p>セッションを終了しました</p>");      //セッションを終了した場合表示
		out.println("</body>");
		out.println("</html>");

	}

}
