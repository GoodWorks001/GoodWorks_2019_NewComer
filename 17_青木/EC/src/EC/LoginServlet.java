package EC;

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
		req.setCharacterEncoding("Windows-31J");
		HttpSession session = req.getSession(true);
		String name = req.getParameter("name");
		String pass = req.getParameter("password");
		if(name==""|pass=="") {
			req.setAttribute("message", "IDまたはパスワードを入力してください");
			//遷移先の指定
			RequestDispatcher rd2 = req.getRequestDispatcher("/login.jsp");
			//rdに投げてる
			rd2.forward(req,resp);
		} else {
			Login_DAO DAO = new Login_DAO();
			String key = DAO.jdbc(name, pass);
			if(key != null) {
				DAO.jdbc2();
				System.out.println(DAO.catlist);
				System.out.println(DAO.cat_idlist);
				session.setAttribute("login_name", name);
				session.setAttribute("login_pass", pass);
				session.setAttribute("category", DAO.catlist);
				session.setAttribute("category_id", DAO.cat_idlist);
				//遷移先の指定
				RequestDispatcher rd = req.getRequestDispatcher("/search2.jsp");
				//rdに投げてる
				rd.forward(req,resp);
			} else {
				req.setAttribute("message", "IDまたはパスワードが正しくありません");
				//遷移先の指定
				RequestDispatcher rd2 = req.getRequestDispatcher("/login.jsp");
				//rdに投げてる
				rd2.forward(req,resp);
			}
		}
	}
}
