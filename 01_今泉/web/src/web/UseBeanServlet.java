package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UseBeanServlet extends HttpServlet {

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


        //インスタンス化
		 EmpBean bean = new EmpBean();

		//EmpBeanクラスのsetAgeメソッドに値をセットしている
		 bean.setName("KnowledgeTaro");

		 //EmpBeanクラスのsetAgeメソッドに値をセットしている
		 bean.setAge(20);

		 //リクエストオブジェクトに値を入れている（Keyがempでvalueがbeanの中身）
		 req.setAttribute("emp", bean);


		 //RequestDispatcherを用いて、遷移先を指定している。
		 RequestDispatcher rd = req.getRequestDispatcher("useBean.jsp");
		 //RequestDispatcherを用いて値を投げている。
		 rd.forward(req, resp);

	}
}

