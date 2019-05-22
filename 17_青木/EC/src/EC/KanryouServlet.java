package EC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KanryouServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
			//遷移先の指定
			RequestDispatcher rd2 = req.getRequestDispatcher("/login.jsp");
			//rdに投げてる
			rd2.forward(req,resp);
		}
	}
}
