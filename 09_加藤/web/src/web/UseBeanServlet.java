package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UseBeanServlet extends HttpServlet {

	//サーブレット上で実行するため
	//doGetメソッドを使用する

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//インスタンス化
		EmpBean bean = new EmpBean();
		//EmpBeanクラスに名前をセットしている
		bean.setName("KnowledgeTaro");
		//EmpBeanクラスに２０をセットしている
		bean.setAge(20);
		//empという名称でbeanを格納している
		req.setAttribute("emp", bean);
		//RequestDispatcherを用いて、遷移先を指定
		//RequestDispatcherを用いて、遷移先に飛ばしている
		RequestDispatcher rd = req.getRequestDispatcher("/useBean.jsp");
		rd.forward(req, resp);
	}
}