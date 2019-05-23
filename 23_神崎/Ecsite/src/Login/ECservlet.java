package Login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import Cart.CartBeans;

public class ECservlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//各変数に取得した名前とパスワードを文字列として格納
		req.setCharacterEncoding("UTF-8");
		String name2 = req.getParameter("name2");
		System.out.println(name2);
		String pass2 = req.getParameter("pass2");
		String url = "";
		System.out.println(pass2);
		if (name2 == "" || pass2 == "") {
			url = "LoginNull.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, resp);
		} else {

			System.out.println("うぇーい");
			//JDBCのインスタンス化
			JDBC jd = new JDBC();
			User u = new User();
			u = jd.user(name2, pass2);
			//ログイン画面で入力した値とJDBCで取得した値が一致する場合
			System.out.println(u.getUser_name());
			System.out.println(u.getLogin_pw());
			 if (u.getUser_name().equals(name2) && u.getLogin_pw().equals(pass2)){
				url = "Servlet";
				HttpSession ses = req.getSession(true);
				ses.setAttribute("user", u.getUser_id());
				//遷移先に移動
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, resp);
			} else if(u.getUser_name().equals("") && u.getLogin_pw().equals("")){
				url = "LoginNG.jsp";
				//遷移先に移動
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req, resp);
			}

		}

	}

}