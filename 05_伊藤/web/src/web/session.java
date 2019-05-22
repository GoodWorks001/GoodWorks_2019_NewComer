package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class session extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// セッションの開始
		/*trueの場合はセッションオブジェクトの生成か、
		  既存のセッションオブジェクトを返す*/
		HttpSession session = req.getSession(true);
		// sessionにデータを格納（"オブジェクト名","格納するオブジェクト"）
		//"loginUser"に"KnowledgeTaro"を格納
		session.setAttribute("loginUser", "KnowledgeTaro");
		// 送信されてくるパラメータのエンコーディングの指定
		// 送信後に表示する文字をエンコーディングする
		resp.setContentType("text/html;charset=Windows-31J");
		// 以下、HTML形式で出力されるためのコード
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Session Servlet 1</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 1</h1>");
		out.println("<p>セッションを開始しました</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
