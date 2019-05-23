package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("カートサーブレット開始");

		//送信されてくるパラメータのエンコーディング指定
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession(false);

		//金額のパラメータ名を取得している
		int price = Integer.parseInt(req.getParameter("price"));
		//購入個数のパラメータ名を取得している
		int order = Integer.parseInt(req.getParameter("order"));
		//商品名のパラメータ名を取得している
		String name = req.getParameter("name");
		//商品名用アレイリストの作成
		ArrayList<String>namelist = new ArrayList<String>();
		//価格用アレイリストの作成
		ArrayList<Integer>pricelist = new ArrayList<Integer>();
		//購入個数用アレイリストの作成
		ArrayList<Integer>orderlist = new ArrayList<Integer>();

		if(session.getAttribute("cart_name") != null) {
			System.out.println("カートサーブレット if文開始");

			//アレイリストで作成した商品名用変数にセッションから得た情報を格納している
			namelist = (ArrayList<String>)session.getAttribute("cart_name");
			//アレイリストで作成した価格用変数にセッションから得た情報を格納している
			pricelist = (ArrayList<Integer>)session.getAttribute("cart_price");
			//アレイリストで作成した購入個数用変数にセッションから得た情報を格納している
			orderlist = (ArrayList<Integer>)session.getAttribute("cart_order");
			//アレイリストに取得した商品名用パラメータ名の情報を格納
			namelist.add(name);
			//アレイリストに取得した価格用パラメータ名の情報を格納
			pricelist.add(price);
			//アレイリストに取得した購入個数用パラメータ名の情報を格納
			orderlist.add(order);
			session.setAttribute("cart_name", namelist);
			session.setAttribute("cart_price", pricelist);
			session.setAttribute("cart_order", orderlist);

			RequestDispatcher rd = req.getRequestDispatcher("/cart_ec.jsp");
			rd.forward(req, resp);
			System.out.println("カートサーブレット if文終了");
		//カートの中身がない状態
		} else {
			System.out.println("カートサーブレット else文開始");
			namelist.add(name);
			pricelist.add(price);
			orderlist.add(order);
			session.setAttribute("cart_name", namelist);
			session.setAttribute("cart_price", pricelist);
			session.setAttribute("cart_order", orderlist);

			RequestDispatcher rd = req.getRequestDispatcher("/cart_ec.jsp");
			rd.forward(req, resp);
			System.out.println("カートサーブレット else文終了");
		}
		System.out.println("カートサーブレット終了");
	}
}
