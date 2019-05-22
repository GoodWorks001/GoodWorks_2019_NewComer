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
		ArrayList<ProductBean> list = new ArrayList<>();
		//セッションの開始
		HttpSession ses = req.getSession();
		//セッションに保存されているカート内の情報を取得
		list = (ArrayList<ProductBean>)ses.getAttribute("cart");
		for(int i = 0; i<list.size(); i++) {
			list.get(i).setLaststock((Integer)ses.getAttribute("mei"));
			ses.setAttribute("mei", list.get(i).getLaststock() + 1);
		}

		//DAOクラスのインスタンス化
		DAO dao = new DAO();
		try {
			dao.update(list);
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}


		//明細IDの取得
		int count = (Integer)ses.getAttribute("mei");
		//ユーザーidの取得
		UserBean u = (UserBean)ses.getAttribute("user");
		String user = u.getUser_id();
		int user_id = Integer.parseInt(user);
		//Calendarクラスのオブジェクトを生成する
		Calendar cl = Calendar.getInstance();


		//SimpleDateFormatクラスでフォーマットパターンを設定する
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(cl.getTime()));

		//購入総額の取得
		String a = req.getParameter("all");
		int all = Integer.parseInt(a);
		//ここまで

		try {
			dao.insert(user_id,list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("インサート終了したよ");

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
