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

		//セッションの開始
		HttpSession session = req.getSession(true);

		//データの格納
		session.setAttribute("name","たかお");
		req.setAttribute("age",new Integer(20));

		//ServletからJSPを呼び出すメソッド
		RequestDispatcher rd = req.getRequestDispatcher("test.jsp");
		rd.forward(req, resp);

	}


}
