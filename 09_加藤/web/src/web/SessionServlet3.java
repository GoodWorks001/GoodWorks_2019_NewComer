package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//セッションオブジェクトを取得するためのメソッド
		//セッションを終了する場合は引数をfalseに設定する
		HttpSession session = req.getSession(false);
		if (session != null) {
			//現在のユーザに対するセッションIDを無効化し
			//セッションオブジェクトを消滅させるメソッド
			session.invalidate();
		}
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//以下のhtmlはセッション終了したことを
		//ブラウザ上にて表示させるロジック
		out.println("<html>");
		out.println("<head><title>Session Servlet 3</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 3</h1>");
		out.println("<p>セッションを終了しました</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
