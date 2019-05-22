package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CategoryDao;
import Dao.SearchArraysDao;
import Dao.SearchStringsDao;

public class KensakuServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");

		String query = null, scope = null, choice = null;
		ArrayList<String> columns = new ArrayList<String>();

		//送信されてくるパラメーターのエンコード指定
		req.setCharacterEncoding("UTF-8");

		ArrayList<String> idList = new ArrayList<String>();
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> priceList = new ArrayList<String>();

		//送信されたパラメーターを取得
		String searchPass = req.getParameter("searchPass");
		String category = req.getParameter("category");
		String update = req.getParameter("update");
		String syousaiPass = req.getParameter("syousai");

		columns.add("pro_cd");
		columns.add("pro_name");
		columns.add("stock_no");
		columns.add("pro_price");
		columns.add("cat_id");
		columns.add("pro_img");
		columns.add("pro_msg");

		if (update != null) {

			if (searchPass != null
					&& !(req.getParameter("searchPass").equals(""))) {

				query = "From product Where ";
				scope = "pro_name Like ";
				choice = "%" + searchPass + "%";
			} else {

				query = "From product Where ";
				scope = "cat_id = ";
				choice = category;

				req.setAttribute("selectCat", category);
			}

			SearchArraysDao s_jdbc = new SearchArraysDao();

			idList = s_jdbc.Access(query, scope, choice, columns.get(0));
			nameList = s_jdbc.Access(query, scope, choice, columns.get(1));
			priceList = s_jdbc.Access(query, scope, choice, columns.get(3));

			if (nameList.size() != 0) {
				req.setAttribute("idList", idList);
				req.setAttribute("nameList", nameList);
				req.setAttribute("priceList", priceList);
			} else {
				req.setAttribute("ideList", null);
				req.setAttribute("nameList", null);
				req.setAttribute("priceList", null);
			}

			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/kensaku.jsp");
			rd.forward(req, resp);

		} else if (syousaiPass != null) {


			//Daoの宣言
			SearchStringsDao s_jdbc = new SearchStringsDao();
			CategoryDao c_jdbc=new CategoryDao();

			System.out.println("===========");
			//指定した商品の情報を取り出す
			String id = s_jdbc.SearchObj(columns.get(0),syousaiPass, columns.get(0));
			String name = s_jdbc.SearchObj(columns.get(0),syousaiPass, columns.get(1));
			String stock = s_jdbc.SearchObj(columns.get(0),syousaiPass, columns.get(2));
			String price = s_jdbc.SearchObj(columns.get(0),syousaiPass, columns.get(3));
			String img = s_jdbc.SearchObj(columns.get(0),syousaiPass, columns.get(5));
			String msg = s_jdbc.SearchObj(columns.get(0),syousaiPass, columns.get(6));

			System.out.println("===========");

			//指定した商品のカテゴリIDを取得して、カテゴリ名を調べる
			String cat_id = s_jdbc.SearchObj(columns.get(0),syousaiPass, columns.get(4));
			System.out.println("カテゴリIDは"+cat_id);
			String cat_name = c_jdbc.SearchCatName(cat_id);
			System.out.println("カテゴリ名は"+cat_name);

			req.setAttribute("id", id);
			req.setAttribute("name", name);
			req.setAttribute("stock", stock);
			req.setAttribute("price", price);
			req.setAttribute("cat_name", cat_name);
			req.setAttribute("img", img);
			req.setAttribute("msg", msg);

			itemBean ib = new itemBean();

			ib.setName(name);
			ib.setPrice(price);
			ib.setStock(stock);

			HttpSession session = req.getSession(false);

			session.setAttribute("itemBean", ib);

			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/syousai.jsp");
			rd.forward(req, resp);

		}
	}

}
