package ec;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String name = request.getParameter("proName");
		String price = request.getParameter("proPrice");
		String id = request.getParameter("proId");
		String buynum = request.getParameter("stock");



		if (session.getAttribute("namelist") == null) {
			System.out.println("カート塗るよおおお");
			// アレイリストの作成
			ArrayList<String> nameLis = new ArrayList<String>();
			ArrayList<String> priceLis = new ArrayList<String>();
			ArrayList<String> idLis = new ArrayList<String>();
			ArrayList<String> buyLis = new ArrayList<String>();

			nameLis.add(name);
			priceLis.add(price);
			idLis.add(id);
			buyLis.add(buynum);

			session.setAttribute("namelist", nameLis);
			session.setAttribute("pricelist", priceLis);
			session.setAttribute("idlist", idLis);
			session.setAttribute("buylist", buyLis);

			int sum = 0;
			for (int i = 0; i < priceLis.size(); i++) {
				sum += ((Integer.parseInt(priceLis.get(i))) * Integer.parseInt(buyLis.get(i)));
			}

			double zeikeisan = sum * 0.08;
			int zei = (int) zeikeisan;
			int total = sum + zei;

			session.setAttribute("Tax", zei);
			session.setAttribute("total", total);

		} else {
			System.out.println("カートあるよおおお");
			// アレイリストの作成
			ArrayList<String> nameLis = ( ArrayList<String>) (session.getAttribute("namelist"));
			ArrayList<String> priceLis = ( ArrayList<String>) (session.getAttribute("pricelist"));
			ArrayList<String> idLis = ( ArrayList<String>) (session.getAttribute("idlist"));
			ArrayList<String> buyLis = ( ArrayList<String>) (session.getAttribute("buylist"));

			nameLis.add(name);
			priceLis.add(price);
			idLis.add(id);
			buyLis.add(buynum);


			session.setAttribute("namelist", nameLis);
			session.setAttribute("pricelist", priceLis);
			session.setAttribute("idlist", idLis);
			session.setAttribute("buylist", buyLis);


			int sum = 0;
			for (int i = 0; i < priceLis.size(); i++) {
				sum += ((Integer.parseInt(priceLis.get(i))) * Integer.parseInt(buyLis.get(i)));
			}

			double zeikeisan = sum * 0.08;
			int zei = (int) zeikeisan;
			int total = sum + zei;

			session.setAttribute("Tax", zei);
			session.setAttribute("total", total);

		}

		// jspフォルダにあるserch.jspを呼び出す
		RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
		// RequestDispatcherを用いてrequestとresponseの中身をふっ飛ばしてる。
		rd.forward(request, response);
	}
}
