package kanryo;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.CartBeans;

public class CartmodoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CartBeans cart = new CartBeans();
		HttpSession session = req.getSession(false);
		 HashMap<String, Integer[]>hm = cart.initCart();
		 session.removeAttribute("cart");
		 session.setAttribute("cart", hm);

		 RequestDispatcher rd = req.getRequestDispatcher("Search.jsp");
			rd.forward(req,resp);


	}

}

