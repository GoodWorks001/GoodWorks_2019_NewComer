package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DetailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		//セッションの継続
		HttpSession session = req.getSession(false);

		String product = req.getParameter("pro_cd");
		System.out.println(req.getParameter("pro_cd"));
		int pro_cd = Integer.parseInt(product);


		DetailDAO dd = new DetailDAO();
		//DAOのないようをlistに保存
		ArrayList<String> alist = new ArrayList<String>();

		alist = dd.checkID(pro_cd);

		//alistをdetailとしてsessionに保存
		session.setAttribute("detail", alist);



		DetailBean db = dd.setZaiko(pro_cd);

		//
		//int zaiko = db.getStock_no();
		ArrayList<Integer>zaikolist = new ArrayList<Integer>();
		zaikolist.add(db.getStock_no());

		for(int a : zaikolist) {
			System.out.println(a +" : aaaaaaa");
		}
 		//


		session.setAttribute("zaiko", zaikolist);
		//System.out.println("今の在庫は・・・" + alist.get(2));

		//飛ぶ先を指定
		RequestDispatcher rd = req.getRequestDispatcher("/detail.jsp");
		//飛ばす
		rd.forward(req, resp);

	}

}
