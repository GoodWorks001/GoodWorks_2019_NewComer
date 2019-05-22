package web;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("開始");

		//文字コードの設定
		req.setCharacterEncoding("UTF-8");


		//入力内容を取得
		String id = req.getParameter("logName");
		String pw = req.getParameter("logPW");

		System.out.println("id："+id +"\tpw："+pw);

		if(!(id.equals("") || pw.equals("")) && (id != null || pw != null)) {
			//DB接続用クラスをインスタンス化
			DAO d = new DAO();

			try {
				//select文実行
				ResultSet rs = d.userSelect(id, pw);

				//一致するユーザーがいるかの判断
				boolean flg = rs.next();
				System.out.println("flg："+flg);

				if(flg==false) {
					req.setAttribute("msg", "名前またはパスワードが一致しません");
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
					System.out.println("名前またはパスワードが一致しません");

				} else {

					//インスタンス生成
					UserBean ub = new UserBean();

					//UserBeanに値を設定
					ub.setUser_id(rs.getString("user_id"));
					ub.setUser_name(rs.getString("user_name"));
					ub.setLogin_cd(rs.getString("login_cd"));
					ub.setLogin_pw(rs.getString("login_pw"));

					//セッションの取得
					HttpSession ses = req.getSession(true);

					//セッションにインスタンスを設定する
					ses.setAttribute("user", ub);

					//遷移先の指定
					RequestDispatcher rd = req.getRequestDispatcher("KensakuServlet");
					//画面遷移
					rd.forward(req, resp);

				}

				//DB切断
				d.dbClose();

			} catch (Exception ex) {
				//エラー内容を表示
				ex.printStackTrace();
				//DB切断
				d.dbClose();


			}

		}else {
			//reqestにメッセージを渡す
			req.setAttribute("msg", "名前またはパスワードを入力してください");
			//遷移先を指定
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			//遷移実行
			rd.forward(req, resp);
		}


	}
}
