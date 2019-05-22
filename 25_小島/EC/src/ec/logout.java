package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logout extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session != null) {
			//セッションの終了
			session.invalidate();
			System.out.println("ログアウト");
			}

        //新しいセッション開始
		session = req.getSession(true);
		//カート中身を消す
		session.setAttribute("cart", null);
		System.out.println("1");
		session.setAttribute("Item", null);
		System.out.println("2");

		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}

}
