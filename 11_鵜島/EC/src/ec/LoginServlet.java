package ec;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public boolean cheak;
	LoginDAO ld = new LoginDAO();


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("user_id");
		String pass = req.getParameter("pass");

		if((name.equals("") || name == null)||
				pass.equals("") || pass == null) {
			RequestDispatcher rd = req.getRequestDispatcher("/NotInputLogin.jsp");
			rd.forward(req, resp);
			return;

		}


		//name passを比較
		//一致していたら
		if(ld.isLogin(name, pass)) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user",name);
			System.out.println("user : " + name);
			session.setAttribute("categoryList", ld.getCategoryList());
			//飛ぶ先を指定
			RequestDispatcher rd = req.getRequestDispatcher("/search.jsp");
			//飛ばす
			rd.forward(req, resp);
			return;
		}else {//一致しなかった
			//飛ぶ先を指定
			RequestDispatcher rd = req.getRequestDispatcher("/ErrorLogin.jsp");
			//飛ばす
			rd.forward(req, resp);
			return;
		}

//		//飛ぶ先を指定
//		RequestDispatcher rd = req.getRequestDispatcher("/search.jsp");
//		//飛ばす
//		rd.forward(req, resp);


	}

}
