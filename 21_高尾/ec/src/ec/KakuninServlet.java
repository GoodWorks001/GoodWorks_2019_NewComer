package ec;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KakuninServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String next = req.getParameter("next");
		String back = req.getParameter("back");


		//次の画面に飛ぶとき
		if(next != null) {

			int mei_id = 0;

			//セッションが開始されてるか確認、されてなかったらnullを出す。
			HttpSession session = req.getSession(false);

			//meiDAOのインスタンス化
			meiDAO md = new meiDAO();

			//sessionに格納されていた配列や値を呼び出してそれぞれに格納
			String userId = (String)session.getAttribute("login_cd");
			ArrayList<String> names=(ArrayList<String>)session.getAttribute("names");
			ArrayList<String> prices=(ArrayList<String>)session.getAttribute("prices");
			ArrayList<Integer> kosuus=(ArrayList<Integer>)session.getAttribute("kosuus");
			ArrayList<Integer> stocks=(ArrayList<Integer>)session.getAttribute("stocks");

			int goukei =0;
			//DBに入れる合計金額を計算
			for(int j=0;j<prices.size();j++) {
				for(int k=0;k<kosuus.get(j); k++) {
					int kakaku =(int)(Integer.parseInt(prices.get(j)) * 1.08);
					goukei =goukei +kakaku;
				}
			}

			System.out.println(stocks.get(0));

			//Date型の変数dateに現在の日時を代入
			Date date = new Date(Calendar.getInstance().getTimeInMillis());

			for(int i=0;i<names.size();i++) {
				mei_id = md.getId() + 1;

				int pro_id = Integer.parseInt(md.meisai(names.get(i)));

				System.out.println("pro_id = "+pro_id);

				md.InsertMeisai(mei_id,userId,pro_id,date,goukei);

				String s_st = md.zaiko(names.get(i));
				int i_st = Integer.parseInt(s_st);

				int stock = i_st - kosuus.get(i);

				md.setZaiko(pro_id,stock);

				//ストックが1以上の時
				if(stock > 0) {
					stocks.set(i,stock);
				}
			}

			//初期化
			session.setAttribute("names", null);
			session.setAttribute("prices", null);
			session.setAttribute("kosuus", null);


		//RequestDispatcherを用いて、遷移先を指定している。
		RequestDispatcher rd = req.getRequestDispatcher("kanryo.jsp");
		//RequestDispathaerを用いてふっ飛ばしてる。
		rd.forward(req, resp);

		 }else if(back != null) {
				//RequestDispatcherを用いて、遷移先を指定している。
				RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
				//RequestDispathaerを用いてふっ飛ばしてる。
				rd.forward(req, resp);
			}
		 }
}
