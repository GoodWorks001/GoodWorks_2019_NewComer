package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DispatchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//セッションの取得
		HttpSession session =req.getSession(true);

		//セッションに値を格納
		session.setAttribute("name", "高尾さん");
		req.setAttribute("age", "20");

		//test.jspに遷移先を指定
		RequestDispatcher rd = req.getRequestDispatcher("/test.jsp");
		//実際に遷移する
		rd.forward(req, resp);

	}
}
