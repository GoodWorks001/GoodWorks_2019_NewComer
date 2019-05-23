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
		//送信したパラメータの取得()
		String param=req.getParameter("param");
		String age =req.getParameter("age");
		String sex =req.getParameter("sex");

		String gengo =req.getParameter("gengo");
		String gengo1 =req.getParameter("gengo1");
		String gengo2 =req.getParameter("gengo2");

		//String gengo =req.getParameter("gengo");
		String com1 =req.getParameter("com1");



		//以下、htmlでsyつりょくされるコード
		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h1>"+"名前: "+param+"</h1>");
		out.println("<h1>"+"年齢: "+age+"代"+"</h1>");
		out.println("<h1>"+"性別: "+sex+"</h1>");
		if(gengo != null && gengo1 != null && gengo2!=null) {
			out.print("<h1>"+"言語: "+gengo+"</h1>");
			out.print("<h1>"+","+gengo1+"</h1>");
			out.println("<h1>"+gengo2+"</h1>");
		}else if(gengo!=null && gengo1!=null && gengo2 == null) {
			out.println("<h1>"+"言語: "+gengo+"</h1>");
			out.println("<h1>"+","+gengo1+"</h1>");
		}else if(gengo!=null && gengo2!=null && gengo1 == null) {
			out.println("<h1>"+"言語: "+gengo+"</h1>");
			out.println("<h1>"+","+gengo2+"</h1>");
		}else if(gengo1 != null && gengo2!=null && gengo == null) {
			out.println("<h1>"+"言語: "+gengo1+"</h1>");
			out.println("<h1>"+","+gengo2+"</h1>");
		}else if(gengo1 != null && gengo2 == null && gengo == null) {
			out.println("<h1>"+"言語: "+gengo1+"</h1>");
		}else if(gengo1 == null && gengo2 != null && gengo == null) {
			out.println("<h1>"+"言語: "+gengo2+"</h1>");
		}else {
			out.println("<h1>"+"言語: "+gengo+"</h1>");
		}

		 /*String gengo[ ] = req.getParameterValues("gengo");
	        for (int m= 0; m < gengo.length; m++ ) {
	            out.println("<h1>"+gengo[m] + "</h1>");*/


		out.println("<h1>"+"なにか一言: "+com1+"</h1>");

		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		out.close();
	}
}


