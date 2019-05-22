package EC;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		HttpSession session = req.getSession(false);
		HttpSession session2 = req.getSession(true);
		int price= Integer.parseInt(req.getParameter("price"));
		int order= Integer.parseInt(req.getParameter("order"));
		String name = req.getParameter("pro_name");
		ArrayList<String>namelist = new ArrayList<String>();
		ArrayList<Integer>pricelist = new ArrayList<Integer>();
		ArrayList<Integer>orderlist = new ArrayList<Integer>();

		if(session2.getAttribute("cart_name") != null) {
			namelist = (ArrayList<String>)session2.getAttribute("cart_name");
			pricelist = (ArrayList<Integer>)session2.getAttribute("cart_price");
			orderlist = (ArrayList<Integer>)session2.getAttribute("cart_order");
			namelist.add(name);
			pricelist.add(price);
			orderlist.add(order);
			session2.setAttribute("cart_name", namelist);
			session2.setAttribute("cart_price", pricelist);
			session2.setAttribute("cart_order", orderlist);
			//遷移先の指定
			RequestDispatcher rd2 = req.getRequestDispatcher("/cart.jsp");
			//rdに投げてる
			rd2.forward(req,resp);
		}else {
			namelist.add(name);
			pricelist.add(price);
			orderlist.add(order);
			session2.setAttribute("cart_name", namelist);
			session2.setAttribute("cart_price", pricelist);
			session2.setAttribute("cart_order", orderlist);

			RequestDispatcher rd2 = req.getRequestDispatcher("/cart.jsp");
			//rdに投げてる
			rd2.forward(req,resp);
		}
	}
}
