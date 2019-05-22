package ec;

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
		System.out.println("CartServlet実行");
		// 取得パラメーターのエンコーディング設定
		req.setCharacterEncoding("UTF-8");
		//数取得
		String a =req.getParameter("stock");
		System.out.println(a);
		int t_kazu = Integer.parseInt(a);
		//セッション取得
		HttpSession ses = req.getSession(false);
		//Productインスタンス化
		Product pro = new Product();
		pro = (Product)ses.getAttribute("PRO");
		System.out.println(pro.getCat_name());
		pro.setT_kazu(t_kazu);
		//カートアレイリスト
		if(ses.getAttribute("CART")==null) {
			System.out.println("アレイリスト作成");
			ArrayList<Product> cart = new ArrayList<Product>();
			System.out.println("set");
			cart.add(pro);
			System.out.println("セッションセット");
			ses.setAttribute("CART", cart);
		}else{
			ArrayList<Product> cart = (ArrayList<Product>)ses.getAttribute("CART");
			cart.add(pro);
			System.out.println("セッションセット");
			ses.setAttribute("CART", cart);
		}
		//遷移先に移動
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		rd.forward(req, resp);
		System.out.println("CartServlet終了");
	}

}
