package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("商品サーブレット開始");
		// エンコーディングを指定
		req.setCharacterEncoding("UTF-8");
		// パラメータに変数に格納
		String cart = req.getParameter("cart");
		String back = req.getParameter("back");
		String stock = null;

		ArrayList<String> name1 = null;
		ArrayList<String> price1 = null;
		ArrayList<Integer> kosuu1 = null;
		ArrayList<Integer> stock1 = null;

		// セッションを呼び出す
		HttpSession session = req.getSession(false);

		if (session.getAttribute("name1") == null) {
			name1 = new ArrayList<String>();
			System.out.println("name1を新規作成");
			price1 = new ArrayList<String>();
			System.out.println("price1を新規作成");
			kosuu1 = new ArrayList<Integer>();
			System.out.println("kosuu1を新規作成");
			stock1 = new ArrayList<Integer>();
			System.out.println("stock1を新規作成");
		} else {
			name1 = (ArrayList<String>) session.getAttribute("name1");
			price1 = (ArrayList<String>) session.getAttribute("price1");
			kosuu1 = (ArrayList<Integer>) session.getAttribute("kosuu1");
			stock1 = (ArrayList<Integer>) session.getAttribute("stock1");
		}
//			//セッションに設定してなかったら新規で作る
//			if (session.getAttribute("name1") == null) {
//			name1 = new ArrayList<String>();
//			kosuu1 = new ArrayList<Integer>();
//			stock1 = new ArrayList<Integer>();
//		}



		Object obj = session.getAttribute("ProductBean");

		ProductBean ProductBean = (ProductBean) obj;

		System.out.println("ProductBeanは"+ProductBean);

		if (cart != null) {
			name1.add(ProductBean.getName());
			System.out.println("----------");
			System.out.println(name1);
			price1.add(ProductBean.getPrice());

			stock1.add(Integer.parseInt(ProductBean.getStock()));

			stock = req.getParameter("stock");
			kosuu1.add(Integer.parseInt(stock));

			session.setAttribute("name1", name1);
			System.out.println("=========");
			System.out.println(session.getAttribute("name1"));
			session.setAttribute("price1", price1);
			session.setAttribute("kosuu1", kosuu1);
			session.setAttribute("stock1", stock1);

			// 遷移先の指定
			RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
			// 遷移実行
			rd.forward(req, resp);

		} else if (back != null) {
			// 遷移先の指定
			RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
			// 遷移実行
			rd.forward(req, resp);
		}

		System.out.println("商品サーブレット終了");
	}
}
