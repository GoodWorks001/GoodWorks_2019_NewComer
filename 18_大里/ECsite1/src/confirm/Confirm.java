package confirm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

            //謎のHashMap
			HashMap<String, Integer[]> hm = (HashMap<String, Integer[]>) session.getAttribute("cart");
			//インスタンス化
			Stock cs = new Stock();
			cs.update(hm);
			session.removeAttribute("cart");

			RequestDispatcher rd = req.getRequestDispatcher("Kanryo.jsp");
			rd.forward(req, resp);

	}
}
