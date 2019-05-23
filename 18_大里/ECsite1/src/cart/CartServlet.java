package cart;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		req.setCharacterEncoding("UTF-8");

		//HashMap何に使われてるかわからん
			HashMap<String, Integer[]> hp = (HashMap<String, Integer[]>) session.getAttribute("cart");

			//hiddonのやつ持ってくる
			String pro_name = req.getParameter("pro_name");
			int pro_price = Integer.parseInt(req.getParameter("pro_price"));
			int pro_order = Integer.parseInt(req.getParameter("quantity"));

			//インスタンス化
			CartBeans cb = new CartBeans();
			cb.setCart(hp, pro_name, pro_order, pro_price);
			hp = cb.getCart();
			session.setAttribute("cart", hp);

			//cartへ
			RequestDispatcher rd = req.getRequestDispatcher("Cart.jsp");
			rd.forward(req, resp);

	}

}
