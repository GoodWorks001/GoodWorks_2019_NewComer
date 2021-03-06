package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");
		//送信したパラメーターの取得(文字列)
		String param = req.getParameter("param");

		//以下、HTML形式で出力去れてるためのコード
		resp.setContentType("text/html;charset = UTF-8");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h1>" + param + "</h1>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");

		//HTMLに満足したらCLOSEしてね
		out.close();
	}
}
