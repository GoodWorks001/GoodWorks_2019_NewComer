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
		//送信されてくるパラメータのエンコーディング指定
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String name = req.getParameter("name");
		String pass = req.getParameter("password");

		//DAOクラスのインスタンス化
		DAO dao = new DAO();
		//DAOクラスからメソッドを呼び出す
		String naming = dao.login_name(name);
		String passing = dao.login_pass(pass);

		//sessionで値を送信する
		HttpSession session = req.getSession(true);
		resp.setContentType("text/html;charset=UTF-8");

		//ユーザ名とパスワードの認証後のロジック
		//認証成功の場合のロジック
		if(name.equals(naming) && pass.equals(passing)) {
			//ユーザ名をセットする
			session.setAttribute("login_name", name);
			//パスワードをセットする
			session.setAttribute("password", pass);
			//カテゴリーサーブレットに遷移する
			RequestDispatcher rd = req.getRequestDispatcher("/CategoryServlet");
			rd.forward(req, resp);
		//名前もしくはパスワードが入力されていない場合のロジック
		} else if(name.equals("") || pass.equals("")) {
			//未入力を促すエラーメッセージを出力させるjspファイルへ遷移する
			RequestDispatcher rd = req.getRequestDispatcher("/login_error2_ec.jsp");
			rd.forward(req, resp);
		//名前もしくはパスワードが異なってい他場合のロジック
		} else {
			//入力ミスを促すエラーメッセージを出力させるjspファイルへ遷移する
			RequestDispatcher rd = req.getRequestDispatcher("/login_error1_ec.jsp");
			rd.forward(req, resp);
		}
	}
}
