package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KanryoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String logout = req.getParameter("logout");
		String back = req.getParameter("back");

		if(logout != null) {
			//セッションを呼び出す
			HttpSession session= req.getSession(false);

			//セッション切る
			session.invalidate();

		//RequestDispatcherを用いて、遷移先を指定している。
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		//RequestDispathaerを用いてふっ飛ばしてる。
		rd.forward(req, resp);

		 }else if(back != null) {
				//RequestDispatcherを用いて、遷移先を指定している。
				RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
				//RequestDispathaerを用いてふっ飛ばしてる。
				rd.forward(req, resp);

			}
		 }
}
