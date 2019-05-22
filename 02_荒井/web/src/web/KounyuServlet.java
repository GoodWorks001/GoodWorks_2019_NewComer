package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KounyuServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("KounyuServlet実行しました。");

		//送信されてくるパラメーターのエンコード指定
		req.setCharacterEncoding("UTF-8");

		//セッションの指定
		HttpSession ses = req.getSession(false);

		//インスタンス
		kounyuDAO kounyu = new kounyuDAO();

		//カートを取得
		ArrayList<ProductBean> array = (ArrayList<ProductBean>) ses.getAttribute("cart");



		String a = (String)ses.getAttribute("login_cd");
		System.out.println(a);
		//値をとってきた
		int id = Integer.parseInt(a);



		//配列の中身をぐるぐる回す
		for (int i = 0; i < array.size(); i++) {

			//カートのリストから商品情報取り出す
			ProductBean pro = array.get(i); //何番めのやつを取り出す
			int pro_cd = pro.getCd(); //商品コードを持ってくる
			int price = pro.getPrice(); //単価を持ってくる
			int kosu = pro.getBuy(); //買った数を持ってくる

			kounyu.insert(pro_cd, id, kosu, price); //インサート

			kounyu.update(kosu, pro_cd); //在庫のアップデート

		}

		ses.removeAttribute("cart"); //カートのセッションを破棄する

		//kanryou.jspに飛ばす
		RequestDispatcher rd = req.getRequestDispatcher("/kanryou.jsp");
		rd.forward(req, resp);

	}

}
