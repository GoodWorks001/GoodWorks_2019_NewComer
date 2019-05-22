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
		System.out.println("ログインサーブレット実行");
		// インスタンス生成
		DAO dao = new DAO();
		int hantei = 0;
		// 遷移先指定
		String url = "login1.jsp";
		String user_id = req.getParameter("user_id");
		System.out.println(user_id);
		String login_pw = req.getParameter("login_pw");
		System.out.println(login_pw);
		HttpSession ses =req.getSession(true);
		if (login_pw.equals("") || user_id.equals("") || login_pw==null || user_id == null) {
			hantei = 1;
		} else {
			// daoメソッド実行
			int hantei1 = dao.login(user_id, login_pw);
			System.out.println(hantei);
			if (hantei1 == 1) {
				hantei=2;
			} else if(hantei==0){
				ses.setAttribute("USER",user_id);
				url = "CatServlet";
			}
		}
		ses.setAttribute("hantei", hantei);
		System.out.println(url);
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
		System.out.println("ログインサーブレット終了");

	}

}
