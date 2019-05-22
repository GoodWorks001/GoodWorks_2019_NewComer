package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {
	//dopostをオーバーライド
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 送信されてくるパラメータのエンコーディングの指定
		// 送信後に表示する文字をエンコーディングする
		req.setCharacterEncoding("UTF-8");

		// 送信したパラメータの取得（文字列）
		// htmlのそれぞれのnameを探しに行く、入力した値を変数に代入
		String x = req.getParameter("name");
		String y = req.getParameter("age");
		String z = req.getParameter("sex");
		String a = req.getParameter("lag");
		String a1 = req.getParameter("lag1");
		String a2 = req.getParameter("lag2");
		String b = req.getParameter("freeans");


		// 以下、HTML形式で出力されるためのコード
		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");

		out.println("<h3>お名前<h3>");
		out.println(x);

		out.println("<h3>年齢<h3>");
		out.println(y);

		out.println("<h3>性別<h3>");
		out.println(z);
		//複数、値がある場合はif文を使う
		out.println("<h3>興味ある言語<h3>");
		if(a!=null) {
			out.print("Java");
			out.println(" , ");
		}
		if(a1!=null) {
			out.print("PHP");
			out.println(" , ");
		}
		if(a2!=null) {
			out.print("C言語");
			out.println("  ");
		}

		out.println("<h3>なにか一言<h3>");
		out.println(b);

		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}
}
