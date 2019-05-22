package ecs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KensakuServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("検索servlet");
		HttpSession session = req.getSession(true);

		DAOShouhin ds = new DAOShouhin();

		int procdSUI = ds.pro_cdSUI();
		System.out.println("ここ大事" + procdSUI);
		int procdGOD = ds.pro_cdGOD();

		int procdPC = ds.pro_cdSUI();

		session.setAttribute("SUICD", procdSUI);
		session.setAttribute("GODCD", procdGOD);
		session.setAttribute("PCCD", procdPC);

		// dbで商品名検索
		// String productnameSUI=ds.selectpronameSUI();
		// System.out.println("データベースからもってきたよ"+productnameSUI);

		// String productnameGOD=ds.selectpronameGOD();
		// System.out.println("データベースからもってきたよ"+productnameGOD);

		// String productnamePC=ds.selectpronamePC();
		// System.out.println("データベースからもってきたよ"+productnamePC);

		// dbで価格を検索
		// int productpriceSUI=ds.selectpropriceSUI();
		// System.out.println("データベースからもってきたよ"+productpriceSUI);

		// int productpriceGOD=ds.selectpropriceGOD();
		// System.out.println("データベースからもってきたよ"+productpriceGOD);

		// int productpricePC=ds.selectpropricePC();
		// System.out.println("データベースからもってきたよ"+productpricePC);

		// dbでカテゴリー名を検索

		String catnameSUI = ds.selectcatnameSUI();
		System.out.println("データベースからもってきたよ" + catnameSUI);

		String catnameGOD = ds.selectcatnameGOD();
		System.out.println("データベースからもってきたよ" + catnameGOD);

		String catnamePC = ds.selectcatnamePC();
		System.out.println("データベースからもってきたよ" + catnamePC);

		// int zaikodbSUI=ds.ZaikoSUI();
		// System.out.println("データベースからもってきたよ"+zaikodbSUI);

		// int zaikodbGOD=ds.ZaikoGOD();
		// System.out.println("データベースからもってきたよ"+zaikodbGOD);

		// int zaikodbPC=ds.ZaikoPC();
		// System.out.println("データベースからもってきたよ"+zaikodbPC);

		// String syoukaiSUI=ds.syoukaiSUI();
		// System.out.println("データベースからもってきたよ"+syoukaiSUI);

		// String syoukaiGOD=ds.syoukaiGOD();
		// System.out.println("データベースからもってきたよ"+syoukaiGOD);

		// String syoukaiPC=ds.syoukaiPC();
		// System.out.println("データベースからもってきたよ"+syoukaiPC);

		// req.setAttribute("nameSUI", productnameSUI);
		// req.setAttribute("nameGOD", productnameGOD);
		// req.setAttribute("namePC", productnamePC);

		// req.setAttribute("priceSUI", productpriceSUI);
		// req.setAttribute("priceGOD", productpriceGOD);
		// req.setAttribute("pricePC", productpricePC);

		req.setAttribute("catSUI", catnameSUI);
		req.setAttribute("catGOD", catnameGOD);
		req.setAttribute("catPC", catnamePC);

		// req.setAttribute("zaikoSUI", zaikodbSUI);
		// req.setAttribute("zaikoGOD", zaikodbGOD);
		// req.setAttribute("zaikoPC", zaikodbPC);

		// req.setAttribute("syoukaiSUI", syoukaiSUI);
		// req.setAttribute("syoukaiGOD", syoukaiGOD);
		// req.setAttribute("syoukaiPC", syoukaiPC);

		int a = 0;
		req.setAttribute("FLG", a);
		RequestDispatcher dis = req.getRequestDispatcher("/kensaku.jsp");
		dis.forward(req, resp);

	}
}
