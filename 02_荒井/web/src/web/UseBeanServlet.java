package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//リクエストオブジェクトにEmpBeanのデータを格納して
// /useBean.jspにディスパッチするServletのコード例


public class UseBeanServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//インスタンス化
		EmpBean bean = new EmpBean();
		//setNameに値を格納
		bean.setName("KnowledgeTaro");
		//setAgeに値を格納
		bean.setAge(20);

		//リクエストオブジェクトにぶち込んでいる
		//(keyがempでvalueがbean)
		req.setAttribute("emp", bean);

		//RequestDispatcherを用いて、遷移先を指定している
		RequestDispatcher rd = req.getRequestDispatcher("/useBean.jsp");

		//RequestDispatcherを用いて吹っ飛ばしている(useBean.jsp)に
		rd.forward(req, resp);

	}



}
