package web;

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

		// エンコーディングを指定
		req.setCharacterEncoding("UTF-8");
		// セッションを呼び出す
		HttpSession session = req.getSession(true);
		// パラメータに変数に格納
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		// nameとpwが空白で かつ nameとpwがnullじゃないとき
		if (!(name.equals("") || pw.equals("")) && (name != null || pw != null)) {

			// インスタンス化
			loginDAO dao = new loginDAO();
			// daoに上のnameとpwを格納
			dao.JDBC(name, pw);
			// booleanでdaoを格納
			boolean ble = dao.JDBC(name, pw);
			RequestDispatcher rd;
			// trueの時にsearch.jspに飛ぶ
			if (ble == true) {
				rd = req.getRequestDispatcher("/search.jsp");
				LoginBean bean = new LoginBean();
				bean = dao.getBean();
				session.setAttribute("login", bean);

				// nameとpwが一致しないとき
			} else {
				req.setAttribute("msg", "名前またはパスワードが一致しません");
				rd = req.getRequestDispatcher("/login.jsp");
				System.out.println("ログインできませんでした");
			}

			// さらにnameというキーにStringのnameを格納
			req.setAttribute("name", name);
			req.setAttribute("pw", pw);

			session.setAttribute("z", "true");
			rd.forward(req, resp);
			// nameとpwが入力されていないとき
		} else {
			System.out.println("入力されていない");
			req.setAttribute("msg", "名前またはパスワードを入力してください");
			RequestDispatcher rd;
			rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);

		}
	}

}
