package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	   	System.out.println("ログインサーブレット2開始");
    	//送信されてくるパラメータのエンコーディングの指定
    	req.setCharacterEncoding("UTF-8");
    	//受信したパラメータの取得　文字列
    	String name = req.getParameter("name");
    	String pass = req.getParameter("pass");

//コンソールで確認
    	System.out.println(name);
    	System.out.println(pass);

//何も入力していなかった
    	if(name == "" || pass == "") {
    		req.setAttribute("err1", "名前またはパスワードを入力してください");
    		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
    	}
    	//daoのインスタンス化
		logindao2 ld = new logindao2();
		try {
		Boolean rs =ld.access(name,pass);

		if(rs == true) {

			//セッションの開始
			HttpSession session = req.getSession(true);
			//user情報が入っているbeanをインスタンス化
			loginbean user = new loginbean();
			session.setAttribute("login", user);

			//取ってきたユーザー情報をセッションに格納
			int userId = ld.user(name, pass);
			session.setAttribute("userIdxx", userId);

			//取ってきたカテゴリー情報をセッションに格納
			session.setAttribute("catgoryList", ld.getCategoryList());

			//課題検索画面に遷移
			RequestDispatcher rd2=req.getRequestDispatcher("search2.jsp");
			rd2.forward(req, resp);
			System.out.println("サーブレットif文");

//間違えたの入力していたら
		}else {
			req.setAttribute("err2", "名前またはパスワードが違います");
    		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
			System.out.println("サーブレットelse文");

		}

		}catch(Exception ex){

		}

	}
}
