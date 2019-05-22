package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession(true);
		Bean bean = new Bean();
		bean = (Bean) session.getAttribute("sessionAtt");
		String kosuu = req.getParameter("kosuu");
		int kosuu2 = Integer.parseInt(kosuu);
		session.setAttribute("kosuudayo", kosuu2);
		bean.setKosuu(kosuu2);

		int cd = (int) session.getAttribute("dlkCat");
		int st = (int) session.getAttribute("dlkStock");

		int num = 0;
		req.setAttribute("NUM", num);

		//この時点でbeanに商品名、価格、個数が入る
		session.setAttribute("KAIMONO", bean);

		String na = (String) session.getAttribute("AttName");
		int ka = (int) session.getAttribute("AttPrice");

		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<Integer> priceList = new ArrayList<Integer>();
		ArrayList<Integer> kosuuList = new ArrayList<Integer>();
		ArrayList<Integer> cdList = new ArrayList<Integer>();
		ArrayList<Integer> stList = new ArrayList<Integer>();

		if (session.getAttribute("namesaigo") == null) {

		} else {
			nameList = (ArrayList<String>) session.getAttribute("namesaigo");
			priceList = (ArrayList<Integer>) session.getAttribute("pricesaigo");
			kosuuList = (ArrayList<Integer>) session.getAttribute("kosuusaigo");
			cdList = (ArrayList<Integer>) session.getAttribute("cdsaigo");
			stList = (ArrayList<Integer>) session.getAttribute("stocksaigo");
		}
		nameList.add(na);
		priceList.add(ka);
		kosuuList.add(kosuu2);
		cdList.add(cd);
		stList.add(st);

		session.setAttribute("namesaigo", nameList);
		session.setAttribute("pricesaigo", priceList);
		session.setAttribute("kosuusaigo", kosuuList);
		session.setAttribute("cdsaigo", cdList);
		session.setAttribute("stocksaigo", stList);

		RequestDispatcher dis = req.getRequestDispatcher("/cart.jsp");
		//投げる
		dis.forward(req, resp);
	}

}
