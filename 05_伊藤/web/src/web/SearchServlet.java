package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// エンコーディングを指定
		req.setCharacterEncoding("UTF-8");

		// パラメータに変数に格納
		String name = req.getParameter("search");
		String category = req.getParameter("category");
		System.out.println(name);
		System.out.println(category);
		String syousaiPass = req.getParameter("syousai");
		System.out.println(syousaiPass);

		// syousaiPassに何も入っていないとき
		if (syousaiPass != null) {
			// インスタンス化
			NewproductDAO syoDAO = new NewproductDAO();
			// 指定した商品の情報を取り出す
			String cd = syoDAO.proJDBC(syousaiPass, "pro_cd");
			String name1 = syoDAO.proJDBC(syousaiPass, "pro_name");
			String stock = syoDAO.proJDBC(syousaiPass, "stock_no");
			String price = syoDAO.proJDBC(syousaiPass, "pro_price");
			String img = syoDAO.proJDBC(syousaiPass, "pro_img");
			String msg = syoDAO.proJDBC(syousaiPass, "pro_msg");
			String cat_id = syoDAO.proJDBC(syousaiPass, "cat_id");
			// cat_idをcat_nameに格納
			String cat_name = syoDAO.search_cat_id(cat_id);

			// 箱に情報を入れる
			req.setAttribute("cd", cd);
			req.setAttribute("name1", name1);
			req.setAttribute("stock", stock);
			req.setAttribute("price", price);
			req.setAttribute("img", img);
			req.setAttribute("msg", msg);
			req.setAttribute("cat_name", cat_name);

			System.out.println(cd);
			System.out.println(name1);
			System.out.println(stock);
			System.out.println(price);
			System.out.println(img);
			System.out.println(msg);

			// インスタンス化
			ProductBean bean = new ProductBean();
			// インスタンスに格納
			bean.setName(name1);
			bean.setPrice(price);
			bean.setStock(stock);
			// セッションを呼び出す
			HttpSession session = req.getSession(false);
			// sessionにネームを付けてインスタンスを格納
			session.setAttribute("ProductBean", bean);

			// 遷移先の指定
			RequestDispatcher rd = req.getRequestDispatcher("product.jsp");
			// 遷移実行
			rd.forward(req, resp);

		} else {

			// セッションに接続
			HttpSession session = req.getSession(true);

			ArrayList<String> list = new ArrayList<String>();
			// nameとcategoryがnullじゃない時
			if (name != "" && category != "null") {
				NewsearchDAO dao = new NewsearchDAO();
				list = dao.namekensaku(name);
				session.setAttribute("z", "false");
				System.out.println(1111);
				// nameが空白じゃない時
			} else if (name != "") {
				NewsearchDAO dao = new NewsearchDAO();
				list = dao.namekensaku(name);
				session.setAttribute("z", "false");
				System.out.println(3333);
				// categoryが空白じゃない時
			} else if (category != "null") {
				NewsearchDAO dao = new NewsearchDAO();
				list = dao.catkensaku(category);
				session.setAttribute("z", "false");
				System.out.println(2222);
				// それ以外の時
			} else {
				System.out.println("入力してください。");
			}

			// sessionに保存
			session.setAttribute("list", list);
			// 遷移先の指定
			RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
			// 遷移実行
			rd.forward(req, resp);

			System.out.println("サーブレット終了");
		}

	}
}
