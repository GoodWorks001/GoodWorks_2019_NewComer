package ec;

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

public class updateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        //セッションの継続、取得
		HttpSession ses = req.getSession();
		//リストの生成
		ArrayList<ItemBean> list = new ArrayList<>();

		//セッションからカートの情報を取得
		list = (ArrayList<ItemBean>)ses.getAttribute("cart");
		for(int i=0; i<list.size(); i++) {
			//在庫数を計算
		   int order= list.get(i).getOrder();
		   int stock=list.get(i).getStock();
		   int num = stock-order;
		   list.get(i).setStock(num);
		   System.out.println(list.get(i).getCd());
		}
        //だおのインスタンス化
		updatedao ud = new updatedao();




		try {
			ud.update(list);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//ユーザー情報をログインサーブレットから持ってくる
		int user = (Integer)ses.getAttribute("userIdxx");
////セッションからカートの情報を取得
		ArrayList<ItemBean> pro_cd = (ArrayList<ItemBean>)ses.getAttribute("cart");

		int proId = pro_cd.get(0).getCd();
		Calendar cl = Calendar.getInstance();
		//SimpleDateFormatクラスでフォーマットパターンを設定する
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(sdf.format(cl.getTime()));

		//合計額を持ってくる
		String a = req.getParameter("all");
		int all = Integer.parseInt(a);
		insertdao dao = new insertdao();
		try {
			dao.insert(user, all,proId);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		RequestDispatcher rd = req.getRequestDispatcher("kanryou.jsp");
		rd.forward(req, resp);


	}

}
