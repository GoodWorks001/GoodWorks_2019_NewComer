package web1;

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

		System.out.println("ログアウト開始！！！！");
		HttpSession ses =req.getSession(false);
		ses.invalidate();
		//セッションに登録しています
		RequestDispatcher rd = req.getRequestDispatcher("/LOGIN.jsp");
		rd.forward(req, resp);
		//遷移先を選定しています↑
		System.out.println("ログアウト終了！！！！");

	}
}
