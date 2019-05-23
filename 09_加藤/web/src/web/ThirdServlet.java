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
		//送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");
		//送信したパラメータの取得（文字列）
		String param = req.getParameter("param");
		String param1 = req.getParameter("param1");
		String param2 = req.getParameter("param2");
		String param3 = req.getParameter("param3");
		String param4 = req.getParameter("param4");
		String param5 = req.getParameter("param5");
		String param6 = req.getParameter("param6");
		//以下、HTML形式で出力されるためのコード
		resp.setContentType("text/html; charset=UTF-8");
		//PrintWriterはcloseを記載しないとコンパイルエラーのままになる
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h1>お名前</h1>");
		out.println("<p>"+param+"</p>");
		out.println("<h1>年齢</h1>");
		out.println("<p>"+param1+"代</p>");
		out.println("<h1>性別</h1>");
		out.println("<p>"+param2+"</p>");
		out.println("<h1>興味のある言語</h1>");
		//Java言語がチェックされなかった場合は表示しない
		//チェックされた場合は表示する
		if(req.getParameter("param3")==null) {
		} else {
		out.println("<p>"+param3+"</p>");
		}

		//PHPがチェックされなかった場合は表示しない
		//チェックされた場合は表示する
		if(req.getParameter("param4")==null) {
		} else {
		out.println("<p>"+param4+"</p>");
		}

		//C言語がチェックされなかった場合は表示しない
		//チェックされた場合は表示する
		if(req.getParameter("param5")==null) {
		} else {
		out.println("<p>"+param5+"</p>");
		}
		out.println("<h1>何か一言</h1>");
		out.println("<p>"+param6+"</p>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		out.close();
	}
}
