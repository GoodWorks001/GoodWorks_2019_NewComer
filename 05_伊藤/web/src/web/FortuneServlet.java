package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FortuneServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("1");
		// エンコーディングを指定
		req.setCharacterEncoding("UTF-8");
		// パラメータに変数に格納
		String name = req.getParameter("name");
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));
		int date = Integer.parseInt(req.getParameter("date"));

		// LogicBeanのインスタンス化
		LogicBean x = new LogicBean();

		// LogicBeanのインスタンスに先に格納した値を格納
		x.execute(name, year, month, date);
		// ResultBeanのインスタンス化
		ResultBean z = new ResultBean();
		// ResultBeanのインスタンス化にx.executeを格納
		z = x.execute(name, year, month, date);

		// さらにresultというキーにｚを格納
		req.setAttribute("result", z);
		// さらにnameというキーにStringのnameを格納
		req.setAttribute("name", name);

		// RequestDispatcherを用いてuseBeanに遷移先の指定
		RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
		// RequestDispatcherを用いて実際に遷移する
		rd.forward(req, resp);

	}
}
