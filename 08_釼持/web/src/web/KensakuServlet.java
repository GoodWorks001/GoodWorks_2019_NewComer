package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KensakuServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("Windows-31J");

		DAO_KenSyou dlk = new DAO_KenSyou();
		String kensaku = req.getParameter("kensaku");
		String category = req.getParameter("category");

		String dlkCategoryName1 = dlk.selectCategoryName(1);
		String dlkCategoryName2 = dlk.selectCategoryName(2);
		String dlkCategoryName3 = dlk.selectCategoryName(3);

		if (kensaku != null || category != null) {
			if (kensaku.equals("炊飯器") || category.equals(dlkCategoryName1)) {
				String dlkName = dlk.selectName(1001);
				int dlkPrice = dlk.selectPrice(1001);

				req.setAttribute("DLKCATEGORY1", dlkCategoryName1);
				req.setAttribute("DLKCATEGORY2", dlkCategoryName2);
				req.setAttribute("DLKCATEGORY3", dlkCategoryName3);
				req.setAttribute("DLKNAME", dlkName);
				req.setAttribute("DLKPRICE", dlkPrice);
				int num = 1;
				req.setAttribute("NUM", num);

				RequestDispatcher dis = req.getRequestDispatcher("/kensaku.jsp");
				//投げる
				dis.forward(req, resp);
			} else if (kensaku.equals("GOD") || category.equals(dlkCategoryName2)) {
				String dlkName = dlk.selectName(1002);
				int dlkPrice = dlk.selectPrice(1002);
				req.setAttribute("DLKCATEGORY1", dlkCategoryName1);
				req.setAttribute("DLKCATEGORY2", dlkCategoryName2);
				req.setAttribute("DLKCATEGORY3", dlkCategoryName3);
				req.setAttribute("DLKNAME", dlkName);
				req.setAttribute("DLKPRICE", dlkPrice);
				int num = 2;
				req.setAttribute("NUM", num);

				RequestDispatcher dis = req.getRequestDispatcher("/kensaku.jsp");
				//投げる
				dis.forward(req, resp);
			} else if (kensaku.equals("パソコン") || category.equals(dlkCategoryName3)) {
				String dlkName = dlk.selectName(1003);
				int dlkPrice = dlk.selectPrice(1003);
				req.setAttribute("DLKCATEGORY1", dlkCategoryName1);
				req.setAttribute("DLKCATEGORY2", dlkCategoryName2);
				req.setAttribute("DLKCATEGORY3", dlkCategoryName3);
				req.setAttribute("DLKNAME", dlkName);
				req.setAttribute("DLKPRICE", dlkPrice);
				int num = 3;
				req.setAttribute("NUM", num);

				RequestDispatcher dis = req.getRequestDispatcher("/kensaku.jsp");
				//投げる
				dis.forward(req, resp);
			} else {
				int num = 4;
				req.setAttribute("DLKCATEGORY1", dlkCategoryName1);
				req.setAttribute("DLKCATEGORY2", dlkCategoryName2);
				req.setAttribute("DLKCATEGORY3", dlkCategoryName3);
				req.setAttribute("NUM", num);
				RequestDispatcher dis = req.getRequestDispatcher("/kensaku.jsp");
				dis.forward(req, resp);
			}
		} else {
			int num = 0;
			req.setAttribute("DLKCATEGORY1", dlkCategoryName1);
			req.setAttribute("DLKCATEGORY2", dlkCategoryName2);
			req.setAttribute("DLKCATEGORY3", dlkCategoryName3);
			req.setAttribute("NUM", num);
			RequestDispatcher dis = req.getRequestDispatcher("/kensaku.jsp");
			dis.forward(req, resp);
		}
	}
}
