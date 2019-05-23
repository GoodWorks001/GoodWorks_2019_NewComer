package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KakuninServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("確認サーブレット開始");

		//送信されてくるパラメータのエンコーディング指定
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession(false);
		//DAOクラスをインスタンス化
		DAO dao = new DAO();


		ArrayList<String>namelist = new ArrayList<String>();
		ArrayList<Integer>pricelist = new ArrayList<Integer>();
		ArrayList<Integer>orderlist = new ArrayList<Integer>();

		if(session != null) {
			System.out.println("確認サーブレット if文開始");
			String user_name = (String)session.getAttribute("login_name");

			int user_id = 0;
			int pro_cd = 0;
			int mei_price = 0;
			int stock = 0;
			int new_stock = 0;


			user_id =dao.user_name(user_name);
			namelist = (ArrayList<String>)session.getAttribute("cart_name");
			pricelist = (ArrayList<Integer>)session.getAttribute("cart_price");
			orderlist = (ArrayList<Integer>)session.getAttribute("cart_order");

			for(int i=0; i<namelist.size(); i++) {
				pro_cd = dao.pro_cd(namelist.get(i));
				mei_price = (pricelist.get(i) * orderlist.get(i));
				dao.meisai(user_id, pro_cd, mei_price);
				stock = dao.zaiko(namelist.get(i));
				new_stock = (stock - orderlist.get(i));
				dao.koshin(new_stock, namelist.get(i));
			}


			session.removeAttribute("cart_name");
			session.removeAttribute("cart_price");
			session.removeAttribute("cart_order");
			RequestDispatcher rd = req.getRequestDispatcher("/kanryo_ec.jsp");
			rd.forward(req, resp);
			System.out.println("確認サーブレット if文終了");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/login_ec.jsp");
			rd.forward(req, resp);
		}

		System.out.println("確認サーブレット終了");
	}
}
