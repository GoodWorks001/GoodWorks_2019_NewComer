package web;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OrderDao;
import Dao.SearchStringsDao;

public class KakuninServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//送信されたパラメーターを取得
		String next = req.getParameter("next");
		String back = req.getParameter("back");

		if (next != null) {

			int mei_id = 0;

			//セッションを呼び出す
			HttpSession session = req.getSession(false);

			SearchStringsDao s_Dao = new SearchStringsDao();
			OrderDao m_Dao = new OrderDao();

			String userId = (String) session.getAttribute("login_cd");
			ArrayList<String> names = (ArrayList<String>) session.getAttribute("names");
			ArrayList<String> prices = (ArrayList<String>) session.getAttribute("prices");
			ArrayList<Integer> kosuus = (ArrayList<Integer>) session.getAttribute("kosuus");
			ArrayList<Integer> stocks = (ArrayList<Integer>) session.getAttribute("stocks");

			ArrayList<String> errors = new ArrayList<String>();

			int goukei = 0;
			for (int j = 0; j < prices.size(); j++) {
				for (int k = 0; k < kosuus.get(j); k++) {
					int kakaku = (int) (Integer.parseInt(prices.get(j)) * 1.08);
					goukei = goukei + kakaku;
				}
			}

			System.out.println(stocks.get(0));

			Date date = new Date(Calendar.getInstance().getTimeInMillis());

			for (int i = 0; i < names.size(); i++) {

				mei_id = m_Dao.getId() + 1;

				int pro_id = Integer.parseInt(s_Dao.SearchObj("pro_name", names.get(i), "pro_cd"));

				System.out.println("pro_id = " + pro_id);

				String s_st = s_Dao.SearchObj("pro_name", names.get(i), "stock_no");
				int i_st = Integer.parseInt(s_st);

				int stock = i_st - kosuus.get(i);

				if (stock < 0) {
					String s="ご注文いただいた" + kosuus.get(i) + "個の" + names.get(i) + "は在庫切れのため、注文をキャンセルしました。";
					errors.add(s);
					continue;
				}

				m_Dao.InsertMeisai(mei_id, userId, pro_id, date, goukei);
				m_Dao.setZaiko(pro_id, stock);

				if (stock > 0)
					stocks.set(i, stock);

			}

			session.setAttribute("names", null);
			session.setAttribute("prices", null);
			session.setAttribute("kosuus", null);

			session.setAttribute("errorMsg", errors);

			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/order.jsp");
			rd.forward(req, resp);
		} else if (back != null) {
			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/kensaku.jsp");
			rd.forward(req, resp);
		}

	}
}
