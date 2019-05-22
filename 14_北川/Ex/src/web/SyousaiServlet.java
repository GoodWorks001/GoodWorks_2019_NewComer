package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SyousaiServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//cartセッションの宣言
		//HttpSession cart = null;

		//送信されたパラメーターを取得
		String next = req.getParameter("next");
		String back = req.getParameter("back");
		String kosuu = null;

		ArrayList<String> names = null;
		ArrayList<String> prices = null;
		ArrayList<Integer> kosuus = null;
		ArrayList<Integer> stocks = null;

		//セッションを呼び出す
		HttpSession session = req.getSession(false);

		if (session.getAttribute("names") == null) {
			names = new ArrayList<String>();
			prices = new ArrayList<String>();
			kosuus = new ArrayList<Integer>();
			stocks = new ArrayList<Integer>();
		} else {
			names = (ArrayList<String>) session.getAttribute("names");
			prices = (ArrayList<String>) session.getAttribute("prices");
			kosuus = (ArrayList<Integer>) session.getAttribute("kosuus");
			stocks = (ArrayList<Integer>) session.getAttribute("stocks");
		}

		Object obj = session.getAttribute("itemBean");
		itemBean itemBean = (itemBean) obj;

		if (next != null) {

			names.add(itemBean.getName());
			prices.add(itemBean.getPrice());
			stocks.add(Integer.parseInt(itemBean.getStock()));

			kosuu = req.getParameter("kosuu");
			kosuus.add(Integer.parseInt(kosuu));

			session.setAttribute("names", names);
			session.setAttribute("prices", prices);
			session.setAttribute("kosuus", kosuus);
			session.setAttribute("stocks", stocks);

			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/cart.jsp");
			rd.forward(req, resp);
		} else if (back != null) {

			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/kensaku.jsp");
			rd.forward(req, resp);
		}
	}

}
