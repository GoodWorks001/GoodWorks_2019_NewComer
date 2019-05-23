package login;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.CartBeans;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String name2 = req.getParameter("name2");
		String pass2 = req.getParameter("pass2");

        //インスタンス化
		LoginJDBC jd = new LoginJDBC();
		//JDBCのメイン
		jd.main();
		//名前とパスが等しいなら
		if(jd.name1.equals(name2) && jd.pass1.equals(pass2)) {

			HttpSession session = req.getSession(true);
			session.setAttribute("loginUser",name2);

			//誰が買ったか保存するためのHashMap
			HashMap<String,Integer[]>hp = new HashMap<String,Integer[]>();
			CartBeans cb=new CartBeans();
			hp= cb.initCart();
			session.setAttribute("cart",hp);

			//商品検索画面へ
			RequestDispatcher rd = req.getRequestDispatcher("Search1");
			rd.forward(req,resp);

		//名前、またはパスワードが入力されていない場合に処理
		} else if (name2 == null || pass2 == null || name2 == "" || pass2 == "") {

			req.setAttribute("err2", "名前またはパスワードが入力されていません");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);

			//名前、パスワードが一致していない場合に処理
		} else {

			req.setAttribute("err1", "名前またはパスワードが一致しません");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);

		}

	}

}

