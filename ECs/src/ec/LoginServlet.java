package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(" LoginSerchServlet実行");
		// LoginDAOのインスタンス化
		LoginDAO da = new LoginDAO();
		// UserBeanのインスタンス化
		UserBean ub = new UserBean();
		//respomseの文字コードの指定
		response.setContentType("text/html;charset=UTF-8");

		//login.jspで入力したユーザー名とパスワードを取得しぶち込む
		String na = request.getParameter("name");
		String pa = request.getParameter("pass");
		//LoginDAOのjdbc2メソッドにユーザ名とパスワードを渡し、戻り値をUserBeanに渡す。
		ub = da.jdbc2(na, pa);
		//idにUserBeanのgetUserメソッドのuser_idを取得
		int id = ub.getUserID();
		System.out.println("userId:" + id);
		System.out.println(na + pa);
		System.out.println("DAO実行");
		//LoginDAOのjdbcメソッドに値を渡し判定結果を受取る
		boolean x = da.jdbc(na, pa);
		System.out.println("DAO終了");

		// カテゴリ
		ArrayList<categoryBean> CatList = new ArrayList<categoryBean>();

		CatList = da.getCategoryList();

		if (x == true) {

			HttpSession session = request.getSession(false);//session開始済みだからfalse
			//sessionに値をぶち込む
			session.setAttribute("catlist", CatList);
			session.setAttribute("username", na);
			session.setAttribute("uID", id);
			System.out.println("おっけ");
			// jspフォルダにあるserch.jspを呼び出す
			RequestDispatcher rd = request.getRequestDispatcher("/serch.jsp");
			// RequestDispatcherを用いてrequestとresponseの中身をふっ飛ばしてる。
			rd.forward(request, response);

		} else if (na.equals("") || pa.equals("")) {

			request.setAttribute("errer1", "名前またはパスワードを入力してください");
			System.out.println("エラー1");
			// jspフォルダにあるserch.jspを呼び出す
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			// RequestDispatcherを用いてrequestとresponseの中身をふっ飛ばしてる。
			rd.forward(request, response);
			System.out.println(" LoginSerchServlet終了");

		} else {
			request.setAttribute("errer2", "名前またはパスワードが一致しません");
			System.out.println("エラー2");
			// jspフォルダにあるserch.jspを呼び出す
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			// RequestDispatcherを用いてrequestとresponseの中身をふっ飛ばしてる。
			rd.forward(request, response);
			System.out.println(" LoginSerchServlet終了");
		}
	}
}
