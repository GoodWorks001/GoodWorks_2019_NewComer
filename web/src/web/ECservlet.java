package web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ECservlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//各変数に取得した名前とパスワードを文字列として格納
		req.setCharacterEncoding("UTF-8");
		String name2 = req.getParameter("name2");
		String pass2 = req.getParameter("pass2");

		//JDBCのインスタンス化
		JDBC jd = new JDBC();
		jd.main();
		//ログイン画面で入力した値とJDBCで取得した値が一致する場合に処理を実行
		if(jd.name1.equals(name2) && jd.pass1.equals(pass2)) {

			System.out.println(name2);


			//セッションにユーザーの名前を格納する
			HttpSession session = req.getSession(true);
			session.setAttribute("loginUser",name2);

			//セッションにカートオブジェクトを設定する
			HashMap<String,Integer[]>hp = new HashMap<String,Integer[]>();
			CartBean cb=new CartBean();
			hp= cb.initCart();
			session.setAttribute("cart",hp);
			System.out.println(name2);

//			// 検索画面全表示の判定オブジェクトをせっていする（初期値は１で全表示）
//			session.setAttribute("all",1);

			//商品検索画面へ遷移する
			RequestDispatcher rd = req.getRequestDispatcher("Servlet");
			rd.forward(req,resp);

		//名前、またはパスワードが入力されていない場合に処理を実行
		}else if ( name2 == null ||  pass2 == null || name2 == "" ||  pass2 == "") {

			//LoginNullへ画面を遷移する
			RequestDispatcher rd = req.getRequestDispatcher("errar1.jsp");
			rd.forward(req,resp);


		//それ以外、つまり名前、パスワードが一致していない場合に処理を実行
		}else {

			//LoginNGへ画面を遷移する
			RequestDispatcher rd = req.getRequestDispatcher("errar1.jsp");
			rd.forward(req,resp);

		}

	}
}
