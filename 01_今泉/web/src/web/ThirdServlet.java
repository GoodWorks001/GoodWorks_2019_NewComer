package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest
			req, HttpServletResponse resp) throws ServletException, IOException {

		//送信されてくるパラメータのエンコーディングの設定
				req.setCharacterEncoding("UTF-8");
		        //送信したパラメータの取得（文字列）
				String b = req.getParameter("name");
				String x = req.getParameter("param");
				String y = req.getParameter("age");
				String z = req.getParameter("gen");
				String a = req.getParameter("lan1");
				String c = req.getParameter("lan2");
				String d = req.getParameter("lan3");

		        //以下、HTML形式で出力されるためのコード
				resp.setContentType("text/html; charset = UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<body>");
				out.println("<h1>"+"お名前："+b+"</h1>");

				out.println("<h1>"+"年齢："+y+"</h1>");
				out.println("<h1>"+"性別："+z+"</h1>");

				if(a==null&&c==null&&d==null) {
					out.println("<h1>"+"興味のある言語："+" "+"</h1>");
				}

				else if (a==null&&c==null) {
					out.println("<h1>"+"興味のある言語："+d+"</h1>");

				}

				else if(c==null&&d==null) {
					out.println("<h1>"+"興味のある言語："+a+"</h1>");
				}

				else if(a==null&&d==null) {
					out.println("<h1>"+"興味のある言語："+c+"</h1>");
				}
				else if(a==null) {
					out.println("<h1>"+"興味のある言語："+c+" "+d+"</h1>");
				}
				else if(c==null) {
					out.println("<h1>"+"興味のある言語："+a+" "+d+"</h1>");
				}
				else if(d==null) {
					out.println("<h1>"+"興味のある言語："+a+" "+c+"</h1>");
				}

				else {
				out.println("<h1>"+"興味のある言語："+a+" "+" "+c+" "+d+"</h1>");
				}

				out.println("<h1>"+"なにか一言："+x+"</h1>");

				out.println("</body>");
				out.println("</head>");
				out.println("</html>");
				out.close();

			}

	}

