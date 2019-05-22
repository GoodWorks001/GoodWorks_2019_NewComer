package web;

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

public class FinishServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		ArrayList<ProductBean> list = new ArrayList<>();

		//それぞれの商品の合計を出すためのtotalを作成
        ArrayList<Integer> total = new ArrayList<>();

        //セッションの開始
		HttpSession session= req.getSession() ;

		//セッションに保存されているカート内の情報を所得
		list = (ArrayList<ProductBean>)session.getAttribute("cart");
		for(int i =0; i<list.size();i++) {
			int kosuu = list.get(i).getKosuu();
			int price =list.get(i).getPro_price();
			//それぞれの商品の合計値を所得【mei_price】
			total.add((int)(kosuu*price*1.08));
		}


		System.out.println("list :"+ list.get(0).getCat_id());
		System.out.println("list :"+ list.get(0).getPro_name());

		/*
		kosulist = (ArrayList<Integer>)session.getAttribute("cart2");
		System.out.println("kosulist :" + kosulist.get(0));
		list = (ArrayList<String>)session.getAttribute("id");
		zaikolist = (ArrayList<Integer>)session.getAttribute("zyaiko");
*/
//		for(int x : ) {
//			System.out.println(x);
//		}
//
//		for(String x :list) {
//			System.out.println(x);
//		}
//
//		for(int x :zaikolist) {
//			System.out.println(x);
//		}

		UpdateDao dao = new UpdateDao();
		CategoryDAO dao1 = new CategoryDAO();
		InsertDao dao2 = new InsertDao();
		try {
			//dao.update(list);
			dao.Testupdate(list);
		}catch (SQLException e1) {
			e1.printStackTrace();
		}

		//明細IDの取得
				//int count = (Integer)session.getAttribute("mei");
				//ユーザーidの取得
				LoginUserBean u = (LoginUserBean)session.getAttribute("user");
				int user = u.getId();
				//int user_id = Integer.parseInt(user);


				//Calendarクラスのオブジェクトを生成する
				Calendar cl = Calendar.getInstance();
				//商品コードの取り出し
				//String pro_cd = (String)list.get(0);

				//SimpleDateFormatクラスでフォーマットパターンを設定する
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println(sdf.format(cl.getTime()));

				//購入総額の取得
				String a = req.getParameter("all");

				System.out.println(a);
				int all = Integer.parseInt(a);
				//ここまで

				try {

					//dao2.insert(count, user, all ,pro_cd);

					for(int i = 0; i < list.size(); i++) {
						int pro = list.get(i).getPro_cd();
						dao2.Testinsert(user, total.get(i) ,pro);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("インサート終了したよ");


				//明細IDの数を加算
				//count += 1;
				//情報更新
				//session.setAttribute("mei", count);

				//カート関連のセッションを破棄
				/*
				session.setAttribute("cart", null);
				session.setAttribute("cart1", null);
				session.setAttribute("cart2", null);
				session.setAttribute("id", null);
				session.setAttribute("zyaiko", null);
                */
				session.setAttribute("cart", null);
				total.clear();
	    RequestDispatcher rd= req.getRequestDispatcher("finish.jsp");
        rd.forward(req, resp);
    }
}