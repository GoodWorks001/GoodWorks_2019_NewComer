package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//送信されたパラメーターを取得
		String logout = req.getParameter("logout");
		String back = req.getParameter("back");

		int[] zaiko= {10,1000,12,1,10};

		if (logout != null) {

			//セッションを呼び出す
			HttpSession session = req.getSession(false);

			/*			OrderDao dao=new OrderDao();

						//次に起動するとき用に在庫を復活
						for(int i=0;i<zaiko.length;i++) {
							dao.setZaiko(i+1, zaiko[i]);
						}*/

			//セッションを終了する
			session.invalidate();

			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/login.jsp");
			rd.forward(req, resp);
		} else if (back != null) {
			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/kensaku.jsp");
			rd.forward(req, resp);
		}
	}

}
