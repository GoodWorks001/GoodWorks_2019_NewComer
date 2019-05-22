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
		//beanの取得 インスタンス化
		EmpBean bean = new  EmpBean();
		//EmpBeanクラスのsetNmaeとsetAgeに値を格納
		bean.setName("吉野くん");
		bean.setAge(999);
		//リクエストオブジェクトにぶち込んでる（keyがempでvalueがbean)
		//reqに"emp"という名前でbeanの値を格納
		req.setAttribute("emp", bean);

		//RequestDispatcherを用いてuseBeanに遷移先の指定
		RequestDispatcher rd = req.getRequestDispatcher("useBean.jsp");
		//RequestDispatcherを用いて実際に遷移する
		rd.forward(req, resp);



	}
}
