package ecs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SyousaiServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		// beanインスタンス生成
		CartBean cb = new CartBean();
		// DAOインスタンス生成
		DAOShouhin ds = new DAOShouhin();
		req.setCharacterEncoding("UTF-8");
		// 確認用
		System.out.println("SyousaiSについたよ");
		// 検索された文字を持ってくる
		String name = req.getParameter("ss");
		System.out.println(name);

		// 詳細1が選択された場合
		if (name.equals("詳細1")) {
			// DAOのメソッドを実行したあと変数に格納
			String SUIname = ds.selectpronameSUI();
			String SUIcname = ds.selectcatnameSUI();
			int SUIkakaku = ds.selectpropriceSUI();
			int SUIzaiko = ds.ZaikoSUI();
			String SUIsyoukai = ds.syoukaiSUI();
			int SC = ds.pro_cdSUI();
            //beanにセット
			cb.setName(SUIname);
			cb.setCat(SUIcname);
			cb.setKakaku(SUIkakaku);
			cb.setZaiko(SUIzaiko);
			cb.setSyoukai(SUIsyoukai);
            //それぞれセッションに
			session.setAttribute("NAME", cb);
			session.setAttribute("NAME1", cb.getName());
			session.setAttribute("CNAME", cb.getCat());
			session.setAttribute("PRICE", cb.getKakaku());
			session.setAttribute("ZAIKO", cb.getZaiko());
			session.setAttribute("SYOUKAI", cb.getSyoukai());
			session.setAttribute("CD", SC);
            //画像
			session.setAttribute("IMG", "img/suihanki.jpg");
            //遷移先指定
			RequestDispatcher a = req.getRequestDispatcher("/shoukai.jsp");
			a.forward(req, resp);
        //確認用

		} else {
			System.out.println("だめ");
		}


		// 詳細２が選択された場合
		if (name.equals("詳細2")) {
			// DAOのメソッドを実行したあと変数に格納
			String GODname = ds.selectpronameGOD();
			String GODcname = ds.selectcatnameGOD();
			int GODkakaku = ds.selectpropriceGOD();
			int GODzaiko = ds.ZaikoGOD();
			String GODsyoukai = ds.syoukaiGOD();
			int GC = ds.pro_cdGOD();
			//beanにセット
			cb.setName(GODname);
			cb.setCat(GODcname);
			cb.setKakaku(GODkakaku);
			cb.setZaiko(GODzaiko);
			cb.setSyoukai(GODsyoukai);
			//それぞれセッションに
			session.setAttribute("CD", GC);
			session.setAttribute("NAME", cb);
			session.setAttribute("NAME1", cb.getName());
			session.setAttribute("CNAME", cb.getCat());
			session.setAttribute("PRICE", cb.getKakaku());
			session.setAttribute("ZAIKO", cb.getZaiko());
			session.setAttribute("SYOUKAI", cb.getSyoukai());
			session.setAttribute("IMG", "img/god.jpg");
			//遷移先指定
			RequestDispatcher a = req.getRequestDispatcher("/shoukai.jsp");
			a.forward(req, resp);
			//確認用

		} else {
			System.out.println("だめ");
		}


		// 詳細３が選択された場合
		if (name.equals("詳細3")) {
			// DAOのメソッドを実行したあと変数に格納
			String PCname = ds.selectpronamePC();
			String PCcname = ds.selectcatnamePC();
			int PCkakaku = ds.selectpropricePC();
			int PCzaiko = ds.ZaikoPC();
			String PCsyoukai = ds.syoukaiPC();
			int PC = ds.pro_cdPC();

			//beanにセット
			cb.setName(PCname);
			cb.setCat(PCcname);
			cb.setKakaku(PCkakaku);
			cb.setZaiko(PCzaiko);
			cb.setSyoukai(PCsyoukai);
			//それぞれセッションに
			session.setAttribute("CD", PC);
			session.setAttribute("NAME", cb);
			session.setAttribute("NAME1", cb.getName());
			session.setAttribute("CNAME", cb.getCat());
			session.setAttribute("PRICE", cb.getKakaku());
			session.setAttribute("ZAIKO", cb.getZaiko());
			session.setAttribute("SYOUKAI", cb.getSyoukai());
			session.setAttribute("IMG", "img/PC.jpg");
			//遷移先指定
			RequestDispatcher a = req.getRequestDispatcher("/shoukai.jsp");
			a.forward(req, resp);

			//確認用
		} else {
			System.out.println("だめ");
		}
	}
}
