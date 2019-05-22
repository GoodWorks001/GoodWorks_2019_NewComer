package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LkServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		req.setCharacterEncoding("UTF-8");
		// 入力したusernameを持ってくる
		String name = req.getParameter("name");
		System.out.println("入力した文字だよ" + name);
		// 入力したpasswordを持ってくる
		String pass = req.getParameter("password");
		System.out.println("入力したpasswordだよ" + pass);
		// インスタンス生成
		DAOLk lk = new DAOLk();
		// dbからusernameを持ってくる
		String dname = lk.selectname();
		System.out.println("データベースからもってきたよ" + dname);
		// dbからpasswordを持ってくる
		String dpass = lk.selectpass();
		System.out.println("データベースからもってきたよ" + dpass);

		//usernameとpasswordが合っている場合
		if (dname.equals(name) && dpass.equals(pass)) {
			int uid = lk.selectid(dname, dpass);
			user uz = new user();
			uz.setId(name);
			uz.setPw(pass);
			uz.setUserid(uid);
			session.setAttribute("UID", uz);
			RequestDispatcher a = req.getRequestDispatcher("/Kensaku");
			a.forward(req, resp);
			System.out.println("遷移");
			// req.setAttribute("NAME", name);
			// req.setAttribute("PASS", pass);
		} else if (name.equals("") || pass.equals("")) {
			RequestDispatcher a = req.getRequestDispatcher("login2.jsp");
			a.forward(req, resp);
			System.out.println("未入力です");
		} else {
			RequestDispatcher a = req.getRequestDispatcher("login3.jsp");
			a.forward(req, resp);
			System.out.println("名前またはパスワードが違います");
		}

	}
}
