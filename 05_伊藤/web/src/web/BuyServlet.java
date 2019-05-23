package web;

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

public class BuyServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// エンコーディングを指定
		req.setCharacterEncoding("UTF-8");
		// パラメータに変数に格納
		String next = req.getParameter("next");
		String back = req.getParameter("back");


		// 購入は購入確認画面、続けるは検索画面に遷移
		if (next != null) {

			int mei_id = 0;
			//セッションを呼び出す
			HttpSession session =req.getSession(false);
			//インスタンス化
			meiDAO meiD=new meiDAO();

			int userid=0;
			ArrayList<String> name2=(ArrayList<String>)session.getAttribute("name1");
			ArrayList<String> price2=(ArrayList<String>)session.getAttribute("price1");
			ArrayList<Integer> kosuu2=(ArrayList<Integer>)session.getAttribute("kosuu1");
			ArrayList<Integer> stock2=(ArrayList<Integer>)session.getAttribute("stock1");

			int goukei =0;
			for(int j=0;j<price2.size();j++) {
				for(int k=0;k<kosuu2.get(j);k++) {
					int kakaku=(int)(Integer.parseInt(price2.get(j)) * 1.08);
					goukei =goukei +kakaku;
				}
			}

			System.out.println(stock2.get(0));

			Date date =new Date(Calendar.getInstance().getTimeInMillis());

			for(int i=0;i<name2.size();i++) {
				mei_id=meiD.getid()+1;

				int pro_id = Integer.parseInt(meiD.meisai(name2.get(i)));

				System.out.println("pro_id =" +pro_id);

				LoginBean bean = (LoginBean)session.getAttribute("login");
				userid=bean.getUser_id();

				meiD.InsertMeisai(mei_id,userid,pro_id,date,goukei);

				String s_st = meiD.zaiko(name2.get(i));
				int i_st=Integer.parseInt(s_st);

				int stock =i_st - kosuu2.get(i);
				meiD.setZaiko(pro_id,stock);

				if(stock > 0) {
					stock2.set(i, stock);
				}
			}
			//初期化
			session.setAttribute("name2", null);
			session.setAttribute("price2", null);
			session.setAttribute("kosuu2", null);

			// RequestDispatcherを用いてuseBeanに遷移先の指定
			RequestDispatcher rd = req.getRequestDispatcher("thinkyou.jsp");
			// RequestDispatcherを用いて実際に遷移する
			rd.forward(req, resp);
		} else if (back != null) {
			// RequestDispatcherを用いてuseBeanに遷移先の指定
			RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
			// RequestDispatcherを用いて実際に遷移する
			rd.forward(req, resp);// RequestDispatcherを用いてuseBeanに遷移先の指定

		}

	}
}