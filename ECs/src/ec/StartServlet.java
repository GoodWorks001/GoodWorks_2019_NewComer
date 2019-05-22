package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//sessionスタート
		HttpSession session = req.getSession(true);

		//LoginDAOのインスタンス化
		LoginDAO ld = new LoginDAO();

		//sessionにkeyの名前を設定し値をぶち込む
		session.setAttribute("namelist", null);
		session.setAttribute("mei", null);
		session.setAttribute("miss",null);
		//sessionのあるmeiの中身の確認
		System.out.println(session.getAttribute("mei"));


		//meiがnullだったtrue
		if(session.getAttribute("mei") == null)
		{
			System.out.println("sessionにmei_idはございません。");
			//LoginDAOのmeisaiNoメソッドの呼び出しと値の代入
			boolean flag = ld.meisaiNo();
			if(flag) {//flagがtrueの時
				//meiにLoginDAOのgetNoメソッドの値をぶち込む
				int mei = ld.getNo();
				//meisaitableのIDが被らないように1加算する。
				mei += 1;
				//sessionのmeiに変数meiの中身をぶち込む
				session.setAttribute("mei", mei);
			}else {
				//sessionのmeiに1をぶち込む
				session.setAttribute("mei", 1);
			}
		} else {
			//meisaiにsessionのmeiの中身をぶち込む
			int meisai = (Integer)session.getAttribute("mei");
			//sessionのmeiにmeisaiの中身をぶち込む
			session.setAttribute("mei", meisai);
		}


		//飛ぶ先を指定
		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		//飛ばす
		rd.forward(req, resp);
	}

}
