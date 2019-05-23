package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = req.getSession();
		int meisai = (Integer)ses.getAttribute("mei");
		//セッションが開始しているかの確認
		ses = req.getSession(false);
		//開始しているなら
		if(ses != null) {
			//セッションの終了
			ses.invalidate();
			System.out.println("ログアウト");
		}



		//新しいセッションの開始
		ses = req.getSession(true);
		//分岐用の値初期化
		ses.setAttribute("zyouhou", "true");
		ses.setAttribute("syouhin", "null");
		ses.setAttribute("cart", null);
		ses.setAttribute("mei", meisai);
		//遷移するためのテンプレ
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		//遷移だ
		rd.forward(req, resp);
	}
}
