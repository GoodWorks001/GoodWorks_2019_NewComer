package iyada;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class cartServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//送信されてくるパラメータのコーディングの指定
		req.setCharacterEncoding("UTF-8");
		//商品情報格納用リストの作成
		ArrayList<ProductBean> list = new ArrayList<>();
		//商品名格納用配列の宣言
		//セッションの開始
		HttpSession ses = req.getSession();
		//DAOクラスのインスタンス化
		DAO dao = new DAO();


		//送信されたパラメータの取得
		String name = req.getParameter("name");
		//価格の取得～int型に変更
		String p = req.getParameter("price");
		int price = Integer.parseInt(p);
		//購入数取得～int型に変更
		String k = req.getParameter("kosu");
		int kosu = Integer.parseInt(k);

		ProductBean bean = (ProductBean)ses.getAttribute("pro");
		bean.setKosuu(kosu);

		int all = bean.getPro_price() * kosu;
		bean.setAll(all);


		//一度目商品選択ならlistを取得する必要なし
		if(ses.getAttribute("cart") == null) {

		}else {
			//二度目以降の商品選択の場合過去に選択された商品情報の取得
			list = (ArrayList)ses.getAttribute("cart");
		}


		list.add(bean);
		//ここまで
		//リストをセッションに保存
		ses.setAttribute("cart", list);
		//ここまで

		//遷移するためのテンプレ
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		//遷移だ
		rd.forward(req, resp);

	}
}
