package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KakuKanServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(true);
		DAO_Update UD = new DAO_Update();
		int uid = 0;
		int procd = 0;
		int kakaku = 0;
		int zaiko = 0;
		int kosuu = 0;

		Bean bean = (Bean) session.getAttribute("UID");

		ArrayList<Integer> KOList = new ArrayList<>();
		ArrayList<Integer> PROCDList = new ArrayList<>();
		ArrayList<Integer> ZAIKOList = new ArrayList<>();
		ArrayList<Integer> KAKAKUList = new ArrayList<>();

		KOList = (ArrayList) session.getAttribute("kosuusaigo");
		PROCDList = (ArrayList) session.getAttribute("cdsaigo");
		ZAIKOList = (ArrayList) session.getAttribute("stocksaigo");
		KAKAKUList = (ArrayList) session.getAttribute("pricesaigo");

		System.out.println("確認のため");
		System.out.println(KOList.get(0));
		System.out.println(PROCDList.get(0));
		System.out.println(ZAIKOList.get(0));
		System.out.println(KAKAKUList.get(0));

		for (int i = 0; i < KOList.size(); i++) {
			uid = bean.getUserID();
			procd = PROCDList.get(i);
			kakaku = KAKAKUList.get(i);
			zaiko = ZAIKOList.get(i);
			kosuu = KOList.get(i);

			UD.insert(uid, procd, kakaku, kosuu);
			UD.zaikoUP(kosuu, procd);
		}
		session.removeAttribute("namesaigo");
		session.removeAttribute("pricesaigo");
		session.removeAttribute("kosuusaigo");
		session.removeAttribute("cdsaigo");
		session.removeAttribute("stocksaigo");

		RequestDispatcher dis = req.getRequestDispatcher("/kanryou.jsp");
		//投げる
		dis.forward(req, resp);
	}
}
