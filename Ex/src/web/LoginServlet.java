package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CategoryDao;
import Dao.LoginDao;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LoginDao jdbc = new LoginDao();
		CategoryDao cat_dao = new CategoryDao();

		//送信されてくるパラメーターのエンコード指定
		req.setCharacterEncoding("UTF-8");

		//セッションの宣言
		HttpSession session = null;

		//送信されたパラメーターを取得
		String submitName = req.getParameter("name");
		String submitId = req.getParameter("password");

		String[] index = jdbc.Access(submitName);

		//カテゴリーの取得
		ArrayList<String> cat_id = cat_dao.Access("cat_id");
		ArrayList<String> cat_name = cat_dao.Access("cat_name");

		if ((submitName == null || submitId == null) ||
				(submitName == "" || submitId == "")) {

			req.setAttribute("errormsg", "名前またはパスワードを入力してください");
			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/login.jsp");
			rd.forward(req, resp);

			return;
		} else if (!(submitName.equals(index[0]) || submitId.equals(index[1]))) {

			req.setAttribute("errormsg", "名前またはパスワードが一致しません");
			RequestDispatcher rd = req.getRequestDispatcher("/EcSite/login.jsp");
			rd.forward(req, resp);

			return;
		}

		//セッションの開始
		session = req.getSession(true);

		session.setAttribute("cat_name", cat_name);
		session.setAttribute("cat_id", cat_id);

		session.setAttribute("login_cd", index[0]);
		session.setAttribute("login_pw", index[1]);
		session.setAttribute("login_name", index[2]);

		RequestDispatcher rd = req.getRequestDispatcher("/EcSite/kensaku.jsp");
		rd.forward(req, resp);

	}

}
