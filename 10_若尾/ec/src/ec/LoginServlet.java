package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("ログインサーブレットを開始しました");

		HttpSession session = req.getSession(true);

		//web上の表示設定をUTF-8に設定
		resp.setContentType("text/html; charset = UTF-8");
		req.setCharacterEncoding("UTF-8");

		session.setAttribute("flg", "true");

		String name = req.getParameter("name");
		String pass = req.getParameter("pass");

		//インスタンス化
		LoginDAO dao = new LoginDAO();

		if(name == "" || pass == "") {
			//どちらかが入力されていない場合
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req,resp);
		}else {
			boolean flg = dao.login(name,pass);
			if(flg) {
				//ログイン成功
				//検索jsp飛ばします
				session.setAttribute("login_cd",dao.getUb());
				RequestDispatcher rd = req.getRequestDispatcher("kensaku.jsp");
				rd.forward(req,resp);

			}else {
				//ログイン失敗
				//ログインjspに飛ばします
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req,resp);
			}
		}

	}
}
