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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		//セッションの継続
		HttpSession session = req.getSession(false);

		String name = req.getParameter("pro_name");
		System.out.println(name);
		String price = req.getParameter("pro_price");
		System.out.println(price);
		String pro_cd = req.getParameter("id");

		//int id = Integer.parseInt(pro_cd);

		String stock = req.getParameter("stockNum");
		System.out.println(stock);

		if (session.getAttribute("namelist") == null) {
			System.out.println("listはnullだよ");

			ArrayList<String> namelist = new ArrayList<String>();
			ArrayList<String> pricelist = new ArrayList<String>();
			ArrayList<String> cdlist = new ArrayList<String>();
			ArrayList<String> stocklist = new ArrayList<String>();

			namelist.add(name);

			pricelist.add(price);
			cdlist.add(pro_cd);

			//int s = Integer.parseInt(stock);
			stocklist.add(stock);

			session.setAttribute("namelist", namelist);
			session.setAttribute("pricelist", pricelist);
			session.setAttribute("cdlist", cdlist);
			session.setAttribute("stocklist", stocklist);

		} else {
			System.out.println("カートあるよ");
			//nanika haitteitara sonojouhou subete mottekuru
			ArrayList<String> namelist = (ArrayList<String>) (session.getAttribute("namelist"));
			ArrayList<String> pricelist = (ArrayList<String>) (session.getAttribute("pricelist"));

			ArrayList<String> cdlist = (ArrayList<String>) (session.getAttribute("cdlist"));
			ArrayList<String> stocklist = (ArrayList<String>) (session.getAttribute("stocklist"));

			System.out.println(namelist.get(0));

			namelist.add(name);
			cdlist.add(pro_cd);

			//int s = Integer.parseInt(stock);

			stocklist.add(stock);
			pricelist.add(price);


			session.setAttribute("namelist", namelist);
			session.setAttribute("pricelist", pricelist);
			session.setAttribute("cdlist", cdlist);
			session.setAttribute("stocklist", stocklist);

		}



		//値段のリスト
				ArrayList<String> ppp = new ArrayList<String>();
				//個数のリスト
				ArrayList<String> sss = new ArrayList<String>();

				ppp = (ArrayList<String>)(session.getAttribute("pricelist"));

				sss = (ArrayList<String>)(session.getAttribute("stocklist"));



				int sum = 0;
				for(int i = 0; i < ppp.size(); i++) {
					sum += ((Integer.parseInt(ppp.get(i))) * Integer.parseInt(sss.get(i)));
				}

				double sum2 = sum * 0.08;
				int syouhizei = (int)sum2;
				int goukei = sum + syouhizei;

				session.setAttribute("tax", syouhizei);
				session.setAttribute("goukei", goukei);





		//飛ぶ先を指定
		RequestDispatcher rd = req.getRequestDispatcher("/cart.jsp");
		//飛ばす
		rd.forward(req, resp);
	}

}
