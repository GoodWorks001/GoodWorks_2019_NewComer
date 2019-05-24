package ecs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KounyuServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(true);
		System.out.println("最後のさーぶれっとだ！！");
		// インスタンス生成
		UpdateDAO UD = new UpdateDAO();
		// 引数用の変数
		int uid = 0;
		int procd = 0;
		int kakaku = 0;
		int zaiko = 0;
		int kosu = 0;
		// インスタンス生成
		userBean US = (userBean) session.getAttribute("UID");

		ArrayList<Integer> KOlist = new ArrayList<>();
		ArrayList<Integer> PROCDlist = new ArrayList<>();
		ArrayList<Integer> ZAIKOlist = new ArrayList<>();
		ArrayList<Integer> KAKAKUlist = new ArrayList<>();

		KOlist = (ArrayList) session.getAttribute("cart2");
		PROCDlist = (ArrayList) session.getAttribute("cart4");
		KAKAKUlist = (ArrayList) session.getAttribute("cart1");
		ZAIKOlist = (ArrayList) session.getAttribute("cart3");

		System.out.println(KOlist.get(0));
		System.out.println(ZAIKOlist.get(0));
		System.out.println(PROCDlist.get(0));
		System.out.println(KAKAKUlist.get(0));

		for (int i = 0; i < KOlist.size(); i++) {

			uid = US.getUserid();
			procd = PROCDlist.get(i);
			kakaku = KAKAKUlist.get(i);
			zaiko = ZAIKOlist.get(i);
			kosu = KOlist.get(i);

			UD.insert(uid, procd, kakaku, kosu);

			UD.zaikoUP(kosu, procd);
		}

		session.removeAttribute("cart");
		session.removeAttribute("cart1");
		session.removeAttribute("cart2");
		session.removeAttribute("cart3");
		session.removeAttribute("cart4");

		RequestDispatcher rd = req.getRequestDispatcher("kanryou.jsp");
		rd.forward(req, resp);

	}
}
