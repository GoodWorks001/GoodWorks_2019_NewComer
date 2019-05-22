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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet開始");

		//セッションの接続
				HttpSession session = req.getSession(true);


		//文字コードの設定
		req.setCharacterEncoding("UTF-8");

		DAO dao = new DAO();
		//パラメータを取得
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		String user_id = dao.username(name);

		//セッションのzにtrueを格納
		session.setAttribute("z","true");
		session.setAttribute("login_cd", user_id);

		if(name == "" || pw == "") {
			
			//どちらか片方でも空白だった場合
			req.setAttribute("errormsg","入力してください。");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}else {
			//どちらも入力されていた場合
			boolean flg = dao.login(name, pw);
			if(flg) {
				//ログインに成功していた場合
				RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
				rd.forward(req, resp);
			}else {
				//ログインに失敗していた場合
				req.setAttribute("errormsg","一致しません。");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}
		}
		System.out.println("LoginServlet終了");
	}
}
