package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class session2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 送信されてくるパラメータのエンコーディングの指定
		// 送信後に表示する文字をエンコーディングする
		resp.setContentType("text/html;charset=Windows-31J");
		// 以下、HTML形式で出力されるためのコード
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Session Servlet 2</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 2</h1>");
		// セッションの継続の確認
		/* falseの場合はnullか、既存のセッションオブジェクトを返す */
		HttpSession session = req.getSession(false);
		// セッションが継続されていなかったときの処理
		if (session == null) {
			out.println("<p>セッションを開始されていません</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		// セッションが継続しているときの処理
		out.println("<p>セッションが継続しています");
		//sessionオブジェクトから格納したものを表示
		out.println("<p>" + session.getAttribute("loginUser") + "</p>");
		out.println("</body>");
		out.println("</html>");

	}
}
