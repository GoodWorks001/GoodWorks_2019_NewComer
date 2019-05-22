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

		// エンコーディングを指定
		req.setCharacterEncoding("UTF-8");
		// パラメータに変数に格納
		String next = req.getParameter("next");
		String back = req.getParameter("back");
		//購入は購入確認画面、続けるは検索画面に遷移
		if (next != null) {
			// RequestDispatcherを用いてuseBeanに遷移先の指定
			RequestDispatcher rd = req.getRequestDispatcher("buy.jsp");
			// RequestDispatcherを用いて実際に遷移する
			rd.forward(req, resp);
		} else if (back != null) {
			// RequestDispatcherを用いてuseBeanに遷移先の指定
			RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
			// RequestDispatcherを用いて実際に遷移する
			rd.forward(req, resp);// RequestDispatcherを用いてuseBeanに遷移先の指定

		}

	}
}
