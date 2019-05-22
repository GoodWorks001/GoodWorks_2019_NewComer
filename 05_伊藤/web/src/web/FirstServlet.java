package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	//dogetと入力後ctrl + Space
	@Override
	protected void doGet(HttpServletRequest
			req, HttpServletResponse resp) throws ServletException, IOException {

		//エンコーディングとMIMEタイプの設定
		resp.setContentType("text/html;charset = UTF-8");
		//servletでHTMLを書くための準備をしている
		PrintWriter out = resp.getWriter();
		//変数名．の形式でHTMLが書ける
		out.print("<html>");
		out.print("<head><title>サンプルページ</title></head>");
		out.print("<body>");
		out.print("<h1>HelloWorld!</h1>");
		out.print("</body>");
		out.print("</html>");
		//HTMLの接続を切る
		out.close();
	}
}
