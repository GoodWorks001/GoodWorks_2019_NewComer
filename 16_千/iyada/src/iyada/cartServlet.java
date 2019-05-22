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
		//商品名格納用配列の宣言
		ArrayList<String> Namelist = new ArrayList<>();
		ArrayList<Integer> Kakakulist = new ArrayList<>();
		ArrayList<Integer> Kosulist = new ArrayList<>();
		ArrayList<String> Idlist = new ArrayList<>();
		ArrayList<Integer> Zaizaikolist = new ArrayList<>();
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
		//商品IDの取得
		String id = req.getParameter("id");
		//現在庫獲得～int型に変更
		String z = req.getParameter("zaizaiko");
		int zaizaiko = Integer.parseInt(z);

		//一度目商品選択ならlistを取得する必要なし
		if(ses.getAttribute("cart") == null) {

		}else {
			//二度目以降の商品選択の場合過去に選択された商品情報の取得
			Namelist = (ArrayList)ses.getAttribute("cart");
		}
		//一度目商品選択ならlistを取得する必要なし
		if(ses.getAttribute("cart1") == null) {

		}else {
			//二度目以降の商品選択の場合過去に選択された商品情報の取得
			Kakakulist = (ArrayList)ses.getAttribute("cart1");
		}
		//一度目商品選択ならlistを取得する必要なし
		if(ses.getAttribute("cart2") == null) {

		}else {
			//二度目以降の商品選択の場合過去に選択された商品情報の取得
			Kosulist = (ArrayList)ses.getAttribute("cart2");
		}
		//一度目商品選択ならlistを取得する必要なし
		if(ses.getAttribute("id") == null) {

		}else {
			//二度目以降の商品選択の場合過去に選択された商品情報の取得
			Idlist = (ArrayList)ses.getAttribute("id");
		}
		//一度目商品選択ならlistを取得する必要なし
		if(ses.getAttribute("zyaiko")== null) {

		}else {
			//二度目以降の商品選択の場合過去に選択された商品情報の取得
			Zaizaikolist = (ArrayList)ses.getAttribute("zyaiko");
		}

		//リストに商品情報を格納
		Namelist.add(name);
		Kakakulist.add(price);
		Kosulist.add(kosu);
		Idlist.add(id);
		Zaizaikolist.add(zaizaiko);
		//ここまで
		//リストをセッションに保存
		ses.setAttribute("cart", Namelist);
		ses.setAttribute("cart1", Kakakulist);
		ses.setAttribute("cart2", Kosulist);
		ses.setAttribute("id", Idlist);
		ses.setAttribute("zyaiko", Zaizaikolist);
		//ここまで

		//遷移するためのテンプレ
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		//遷移だ
		rd.forward(req, resp);

	}
}
