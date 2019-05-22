package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class tuzuServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(true);

		//カートの中身を消す
		session.setAttribute("cart", null);
		System.out.println("1");
		session.setAttribute("Item", null);
		System.out.println("2");


		RequestDispatcher rd = req.getRequestDispatcher("search2.jsp");
		rd.forward(req, resp);

	}

}
