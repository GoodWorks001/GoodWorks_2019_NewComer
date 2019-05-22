package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KenSyouServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("Windows-31J");

		HttpSession session = req.getSession(true);
		Bean bean = new Bean();
		DAO_KenSyou dlk = new DAO_KenSyou();

		String name = req.getParameter("syousai");

		if (name.equals("詳細1")) {
			String dlkCategoryName = dlk.selectCategoryName(1);
			String dlkName = dlk.selectName(1001);
			int dlkPrice = dlk.selectPrice(1001);
			String dlksetumei = dlk.selectSetumei(1001);

			int dlkStock = dlk.selectStock(1001);
			int dlkCat = dlk.IDCAT(1001);

			RequestDispatcher dis = req.getRequestDispatcher("/syoukai1.jsp");

			bean.setCat(dlkCategoryName);
			bean.setName(dlkName);
			bean.setKakaku(dlkPrice);
			bean.setSyoukai(dlksetumei);

			bean.setZaiko(dlkStock);
			bean.setCatId(dlkCat);

			session.setAttribute("AttName", bean.getName());
			session.setAttribute("AttPrice", bean.getKakaku());

			session.setAttribute("dlkCat", dlkCat);
			session.setAttribute("dlkStock", dlkStock);

			session.setAttribute("IDC", bean.getCatId());
			session.setAttribute("Stock", bean.getZaiko());

			//System.out.println(session.getAttribute("Stock"));

			System.out.println("ID2 " + session.getAttribute("dlkCat"));
			System.out.println("Stock2 " + session.getAttribute("dlkStock"));

			session.setAttribute("sessionAtt", bean);

			req.setAttribute("PICNAME", "img/suihanki.jpg");
			//投げる
			dis.forward(req, resp);
		}
		if (name.equals("詳細2")) {
			String dlkCategoryName = dlk.selectCategoryName(2);
			String dlkName = dlk.selectName(1002);
			int dlkPrice = dlk.selectPrice(1002);
			String dlksetumei = dlk.selectSetumei(1002);

			int dlkStock = dlk.selectStock(1002);
			int dlkCat = dlk.IDCAT(1002);

			RequestDispatcher dis = req.getRequestDispatcher("/syoukai1.jsp");

			bean.setCat(dlkCategoryName);
			bean.setName(dlkName);
			bean.setKakaku(dlkPrice);
			bean.setSyoukai(dlksetumei);

			bean.setZaiko(dlkStock);
			bean.setCatId(dlkCat);

			session.setAttribute("AttName", bean.getName());
			session.setAttribute("AttPrice", bean.getKakaku());

			session.setAttribute("dlkCat", dlkCat);
			session.setAttribute("dlkStock", dlkStock);

			session.setAttribute("IDC", bean.getCatId());
			session.setAttribute("Stock", bean.getZaiko());

			session.setAttribute("sessionAtt", bean);

			req.setAttribute("PICNAME", "img/god.jpg");
			//投げる
			dis.forward(req, resp);
		}
		if (name.equals("詳細3")) {
			String dlkCategoryName = dlk.selectCategoryName(3);
			String dlkName = dlk.selectName(1003);
			int dlkPrice = dlk.selectPrice(1003);
			String dlksetumei = dlk.selectSetumei(1003);

			int dlkStock = dlk.selectStock(1003);
			int dlkCat = dlk.IDCAT(1003);

			RequestDispatcher dis = req.getRequestDispatcher("/syoukai1.jsp");

			bean.setCat(dlkCategoryName);
			bean.setName(dlkName);
			bean.setKakaku(dlkPrice);
			bean.setSyoukai(dlksetumei);

			bean.setZaiko(dlkStock);
			bean.setCatId(dlkCat);

			session.setAttribute("AttName", bean.getName());
			session.setAttribute("AttPrice", bean.getKakaku());

			session.setAttribute("dlkCat", dlkCat);
			session.setAttribute("dlkStock", dlkStock);

			session.setAttribute("IDC", bean.getCatId());
			session.setAttribute("Stock", bean.getZaiko());

			session.setAttribute("sessionAtt", bean);

			req.setAttribute("PICNAME", "img/PC.jpg");
			//投げる
			dis.forward(req, resp);
		}
	}
}
