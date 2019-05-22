package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//送信されたパラメーターを取得
		String next = req.getParameter("next");
		String back = req.getParameter("back");

		if (next != null) {
			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/kakunin.jsp");
			rd.forward(req, resp);
		} else if (back != null) {
			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/kensaku.jsp");
			rd.forward(req, resp);
		}

	}
}
