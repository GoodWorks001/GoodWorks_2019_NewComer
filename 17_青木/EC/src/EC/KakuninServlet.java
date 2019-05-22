package EC;

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
		req.setCharacterEncoding("Windows-31J");
		HttpSession session = req.getSession(false);
		HttpSession session2 = req.getSession(false);

		ArrayList<String>namelist = new ArrayList<String>();
		ArrayList<Integer>pricelist = new ArrayList<Integer>();
		ArrayList<Integer>orderlist = new ArrayList<Integer>();

		if(session != null) {
			if(session2 != null) {
				Meisai_DAO DAO = new Meisai_DAO();
				String user_name = (String) session.getAttribute("login_name");
				System.out.println(user_name);
				int user_id = 0;
				int pro_cd = 0;
				int mei_price = 0;
				int stock = 0;
				int new_stock = 0;

				user_id = DAO.jdbc2(user_name);
				namelist = (ArrayList<String>)session2.getAttribute("cart_name");
				pricelist = (ArrayList<Integer>)session2.getAttribute("cart_price");
				orderlist = (ArrayList<Integer>)session2.getAttribute("cart_order");

				System.out.println(user_id);

				for(int i = 0;i<namelist.size();i++) {
					pro_cd = DAO.jdbc3(namelist.get(i));

					mei_price = (pricelist.get(i) * orderlist.get(i));

					DAO.jdbc1(user_id, pro_cd, mei_price);
					stock = DAO.jdbc5(namelist.get(i));
					new_stock = (stock - orderlist.get(i));
					DAO.jdbc4(new_stock, namelist.get(i));
				}

				session2.removeAttribute("cart_name");
				session2.removeAttribute("cart_price");
				session2.removeAttribute("cart_order");
				//遷移先の指定
				RequestDispatcher rd2 = req.getRequestDispatcher("/kanryou.jsp");
				//rdに投げてる
				rd2.forward(req,resp);
			}
		} else {
			RequestDispatcher rd2 = req.getRequestDispatcher("/login.jsp");
			//rdに投げてる
			rd2.forward(req,resp);
		}
	}
}
