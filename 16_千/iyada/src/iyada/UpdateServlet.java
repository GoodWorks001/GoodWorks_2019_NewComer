package iyada;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//送信されてくるパラメータのコーディングの指定
		req.setCharacterEncoding("UTF-8");
		//商品情報格納用リストの作成
		ArrayList<Integer> Kosulist = new ArrayList<>();
		ArrayList<String> Idlist = new ArrayList<>();
		ArrayList<Integer> Zaikolist = new ArrayList<>();
		//セッションの開始
		HttpSession ses = req.getSession();
		//セッションに保存されているカート内の情報を取得
		Kosulist = (ArrayList<Integer>) ses.getAttribute("cart2");
		Idlist = (ArrayList<String>) ses.getAttribute("id");
		Zaikolist = (ArrayList<Integer>) ses.getAttribute("zyaiko");

		//何個買ったか確認
		System.out.println("個数リストの");
		for (int x : Kosulist) {
			System.out.println(x);
		}

		//どの商品買ったかの確認
		System.out.println("idリストの");
		for (String x : Idlist) {
			System.out.println(x);
		}

		//在庫数の確認
		System.out.println("在庫リストの");
		for (int x : Zaikolist) {
			System.out.println(x);
		}

		//DAOクラスのインスタンス化
		DAO dao = new DAO();
		try {
			dao.update(Idlist, Kosulist, Zaikolist);
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		//明細IDの取得
		int count = (Integer) ses.getAttribute("mei");
		//ユーザーidの取得
		UserBean u = (UserBean) ses.getAttribute("user");
		String user = u.getUser_id();
		int user_id = Integer.parseInt(user);
		//Calendarクラスのオブジェクトを生成する
		Calendar cl = Calendar.getInstance();
		//商品コードの取り出し
		String pro_cd = (String) Idlist.get(0);

		//SimpleDateFormatクラスでフォーマットパターンを設定する
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(cl.getTime()));

		//購入総額の取得
		String a = req.getParameter("all");
		int all = Integer.parseInt(a);
		//ここまで

		try {

			dao.insert(count, user_id, all, pro_cd);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("インサート終了したよ");

		//明細IDの数を加算
		count += 1;
		//情報更新
		ses.setAttribute("mei", count);

		//カート関連のセッションを破棄
		ses.setAttribute("cart", null);
		ses.setAttribute("cart1", null);
		ses.setAttribute("cart2", null);
		ses.setAttribute("id", null);
		ses.setAttribute("zyaiko", null);

		//遷移するためのテンプレ
		RequestDispatcher rd = req.getRequestDispatcher("kanryou.jsp");
		//遷移だ
		rd.forward(req, resp);
	}

}
