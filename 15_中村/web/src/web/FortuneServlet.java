package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FortuneServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		request.setCharacterEncoding("Windows-31J");
		
		//リクエストデータnameをgetparameterメソッドで所得
		String name =request.getParameter("name");

		String a = request.getParameter("year");
		int year = Integer.parseInt(a);

		String b = request.getParameter("month");
		int month = Integer.parseInt(b);

		String c = request.getParameter("date");
		int date = Integer.parseInt(c);

		//logicbeanインスタンス化
		LogicBean bean =new LogicBean();
		
		//resultbeanインスタンス化
        ResultBean bean1 = bean.execute(name,year,month,date);

        //リクエストobjectを格納(keyはresult,valueはbean1)
        request.setAttribute("result", bean1);

        //result.jsbに遷移する
		RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
		
		//rdにrequest値,response値を入れる
		rd.forward(request, response);
	}
}
