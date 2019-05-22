package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KensakuServlet2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// インスタンス生成
		DAOSyouhin ds = new DAOSyouhin();
		req.setCharacterEncoding("UTF-8");
		// 検索した文字を持ってくる
		String ken = req.getParameter("kensaku");
		System.out.println("検索した文字だよ" + ken);
		// 検索したカテゴリーを持ってくる
		String cat = req.getParameter("category");
		System.out.println("選択したカテゴリーだよ" + cat);

		if (ken.equals("炊飯器") || cat.equals("調理家電")) {
			String SUIname = ds.selectpronameSUI();
			int SUIprice = ds.selectpropriceSUI();

			// 炊飯器のカテゴリーを持って来る
			String catnameSUI = ds.selectcatnameSUI();

			// ＧＯＤのカテゴリーを持って来る
			String catnameGOD = ds.selectcatnameGOD();

			// ＰＣのカテゴリーを持って来る
			String catnamePC = ds.selectcatnamePC();
			// 炊飯器という商品名をセット
			req.setAttribute("NAME", SUIname);
			// 炊飯器の価格をセット
			req.setAttribute("PRICE", SUIprice);

			// 検索画面にカテゴリーを渡す用
			req.setAttribute("catSUI", catnameSUI);
			req.setAttribute("catGOD", catnameGOD);
			req.setAttribute("catPC", catnamePC);
            //フラグセット
			int b = 1;
			req.setAttribute("FLG", b);
			//遷移先指定
			RequestDispatcher dis = req.getRequestDispatcher("/Kensaku.jsp");
			dis.forward(req, resp);

		} else if (ken.equals("GOD") || cat.equals("非売品")) {
			String GODname = ds.selectpronameGOD();
			int GODprice = ds.selectpropriceGOD();

			String catnameSUI = ds.selectcatnameSUI();

			String catnameGOD = ds.selectcatnameGOD();

			String catnamePC = ds.selectcatnamePC();

			req.setAttribute("NAME", GODname);
			req.setAttribute("PRICE", GODprice);

			// 検索画面にカテゴリーを渡す用
			req.setAttribute("catSUI", catnameSUI);
			req.setAttribute("catGOD", catnameGOD);
			req.setAttribute("catPC", catnamePC);

			int b = 2;
			req.setAttribute("FLG", b);
			RequestDispatcher dis = req.getRequestDispatcher("/Kensaku.jsp");
			dis.forward(req, resp);

		} else if (ken.equals("PC") || cat.equals("情報機器")) {
			String PCname = ds.selectpronamePC();
			int PCprice = ds.selectpropricePC();

			String catnameSUI = ds.selectcatnameSUI();
			// System.out.println("データベースからもってきたよ"+catnameSUI);

			String catnameGOD = ds.selectcatnameGOD();
			// System.out.println("データベースからもってきたよ"+catnameGOD);

			String catnamePC = ds.selectcatnamePC();
			// System.out.println("データベースからもってきたよ"+catnamePC);

			req.setAttribute("catSUI", catnameSUI);
			req.setAttribute("catGOD", catnameGOD);
			req.setAttribute("catPC", catnamePC);

			req.setAttribute("NAME", PCname);
			req.setAttribute("PRICE", PCprice);

			int b = 3;
			req.setAttribute("FLG", b);
			RequestDispatcher dis = req.getRequestDispatcher("/Kensaku.jsp");
			dis.forward(req, resp);
		} else {
			int b = 4;
			req.setAttribute("FLG", b);

			String catnameSUI = ds.selectcatnameSUI();
			// System.out.println("データベースからもってきたよ"+catnameSUI);

			String catnameGOD = ds.selectcatnameGOD();
			// System.out.println("データベースからもってきたよ"+catnameGOD);

			String catnamePC = ds.selectcatnamePC();
			// System.out.println("データベースからもってきたよ"+catnamePC);

			req.setAttribute("catSUI", catnameSUI);
			req.setAttribute("catGOD", catnameGOD);
			req.setAttribute("catPC", catnamePC);
			RequestDispatcher dis = req.getRequestDispatcher("/Kensaku.jsp");
			dis.forward(req, resp);
		}

	}
}
