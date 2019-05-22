package iyada;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginservlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//送信されてくるパラメータのコーディングの指定
		req.setCharacterEncoding("UTF-8");
		HttpSession ses = req.getSession(true);
		//送信されたパラメータの取得
		String name = req.getParameter("name");
		//取得した内容の一時表示
		System.out.println(name);
		//送信されたパラメータの取得
		String pw = req.getParameter("pw");
		//取得した内容の一時表示
		System.out.println(pw);

		//データベースに接続するためのクラスの作成
		DAO dao = new DAO();
		//ログイン処理の判定メソッド呼び出し
		boolean flg = dao.LOGIN(name, pw);
		//エラー発見用
		System.out.println("X1");
		//遷移するためのテンプレ
		RequestDispatcher rd ;
		if(flg) {
			//ログインに成功していた場合
			//遷移先を指定
			rd = req.getRequestDispatcher("Kensaku.jsp");
			//エラー確認用
			System.out.println("X2");
			//UserBeanのsetメソッド呼び出し
			UserBean user = dao.ses(name, pw);
			//エラー確認用
			System.out.println("X3");
			//セッションにユーザー情報保存
			ses.setAttribute("user", user);
		}else {
			//ログインが失敗していた場合
			rd = req.getRequestDispatcher("login.jsp");
			//エラーメッセージの設定
			if(name == "") {
				ses.setAttribute("zyouhou", "null");
			}else if(pw == "") {
				ses.setAttribute("zyouhou", "null");
			}else {
				ses.setAttribute("zyouhou", "!=");
			}
			//エラー発見用
			System.out.println("XX");
		}
		ArrayList<String> cat_name = dao.cate();
		for(String x : cat_name) {
			System.out.println(x);
		}
		ses.setAttribute("cattt", cat_name);
		//遷移だ
		rd.forward(req, resp);
	}
}

