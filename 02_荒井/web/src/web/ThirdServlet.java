package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



		//エンコーディングの設定
		req.setCharacterEncoding("UTF-8");
		//送信したパラメータの取得（文字列)
		String pname =req.getParameter("name");
		String page = req.getParameter("age");
		String pgender = req.getParameter("gender");
		String plangage1 =req.getParameter("langage1");
		String plangage2 =req.getParameter("langage2");
		String plangage3 =req.getParameter("langage3");
		String pfree = req.getParameter("free");


		//以下、HTML形式で出力されるためのコード
		resp.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resp.getWriter();


		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h1>お名前</h1>");
		out.println("<p>"+pname);
		out.println("<h1>年齢</h1>");
		out.println("<p>"+page);
		out.println("<h1>性別</h1>");
		out.println("<p>"+pgender+"</p>");
		out.println("<h1>興味のある言語</h1>");
		out.println("<p>"+plangage1+plangage2+plangage3);
		out.println("<h1>一言</h1>");
		out.println("<p>"+pfree);


		out.println("</body>");
		out.println("</head>");
		out.println("</html>");

		out.close();


	}

}
