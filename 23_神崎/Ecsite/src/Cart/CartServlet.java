package Cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Search.ProductBean;

public class CartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("カート開始");
		//エンコード設定
		req.setCharacterEncoding("UTF-8");

		//パラメータの取得
		String stock = req.getParameter("stock");
		System.out.println(stock);


		int t_kazu =Integer.parseInt(stock);
		ProductBean Pb = new ProductBean();
		//セッション取得
		HttpSession ses = req.getSession(true);
		//インスタンス化
		Pb =  (ProductBean)ses.getAttribute("PRO");
		Pb.setT_kazu(t_kazu);

		//カートアレイリスト
		if(ses.getAttribute("CART")==null) {
			System.out.println("カートアレイリスト作成");
			ArrayList<ProductBean> Cart = new ArrayList<ProductBean>();

			Cart.add(Pb);
			ses.setAttribute("CART",Cart);
		}else {
			//キャストしてます＝オブジェクト型→プロダクトBeanに変換
			//カートアレイリストにインスタンス追加
			ArrayList<ProductBean> Cart = (ArrayList<ProductBean>)ses.getAttribute("CART");

			//セッションにカートアレイリストをセット
			Cart.add(Pb);
			ses.setAttribute("CART",Cart);

		}

		//遷移先に移動
		RequestDispatcher rd = req.getRequestDispatcher("/Cart.jsp");
		rd.forward(req, resp);

		System.out.println("カート終了");

	}

}
