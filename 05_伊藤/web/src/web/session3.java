package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class session3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// セッションの開始
		/* falseの場合はnullか、既存のセッションオブジェクトを返す */
		HttpSession session = req.getSession(false);
		if (session != null) {
			// セッションを終了する
			session.invalidate();
		}
		// 送信されてくるパラメータのエンコーディングの指定
		// 送信後に表示する文字をエンコーディングする
		resp.setContentType("text/html;charset=Windows-31J");
		// 以下、HTML形式で出力されるためのコード
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Session Servlet 3</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 3</h1>");
		out.println("<p>セッションを終了しました</p>");
		out.println("</body>");
		out.println("</html>");

	}
}
