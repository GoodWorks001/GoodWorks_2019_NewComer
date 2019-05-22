package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UseBeanServlet extends HttpServlet {

	@Override
	//
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                 throws ServletException, IOException{

		
		//インスタンス化
		EmpBean bean = new EmpBean();
		
		//EmpBeanクラスのsetNameメソッドに値を代入
		bean.setName("KnowledgeTaro");
		
		//s
		bean.setAge(20);
		
		//setattributeでオブジェクトを格納リクエストオブジェクトに格納(keyがempでvalue がbean)
		//bean
		request.setAttribute("emp", bean);
		
		//usebean.jsbに遷移する
		RequestDispatcher rd = request.getRequestDispatcher("/useBean.jsp");
		
		//rdに対してrequestとresponseを投げる
		rd.forward(request, response);
	}
}
