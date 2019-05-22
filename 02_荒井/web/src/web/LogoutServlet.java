package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//送信されてくるパラメーターのエンコード指定
				req.setCharacterEncoding("UTF-8");

				//セッションの指定
				HttpSession ses = req.getSession(false);

				if(ses != null) {
					ses.invalidate();
				}


				//kanryou.jspに飛ばす
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, resp);

	}

}
