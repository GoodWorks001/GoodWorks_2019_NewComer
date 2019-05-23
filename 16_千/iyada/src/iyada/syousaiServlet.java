package iyada;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class syousaiServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//送信されてくるパラメータのコーディングの指定
		req.setCharacterEncoding("UTF-8");
		//セッションの開始
		HttpSession ses = req.getSession();
		//DAOクラスのインスタンス化
		DAO dao = new DAO();
		//送信されたパラメータの取得
		String ko_do = req.getParameter("cod");
		//エラー発見用
		System.out.println("DX");

		//商品情報検索メソッドの呼び出し
		ProductBean pro = dao.syouhinKensaku(ko_do);
		//商品情報確認
		System.out.println("ここからpro結果");
		System.out.println(pro.getCat_id());
		System.out.println(pro.getPro_cd());
		System.out.println(pro.getPro_image());
		System.out.println(pro.getPro_msg());
		System.out.println(pro.getPro_name());
		System.out.println(pro.getPro_price());
		System.out.println(pro.getStock_no());
		//ここまで

		//在庫数を変数に格納
		int zaiko = pro.getStock_no();
		//セッションに商品情報と在庫を格納
		ses.setAttribute("pro", pro);
		ses.setAttribute("zaiko", zaiko);

		//確認用メッセージ
		System.out.println("詳細サーブレット終了です");
		//遷移するためのテンプレ
		RequestDispatcher rd = req.getRequestDispatcher("syouhin.jsp");
		//遷移だ
		rd.forward(req, resp);
	}
}
