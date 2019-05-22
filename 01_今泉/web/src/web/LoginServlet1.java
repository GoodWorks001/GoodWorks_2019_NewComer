package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("ログインサーブレットスタート");


		//インスタンス化
		ECDAO dao = new ECDAO();

		//インスタンス化
		CateDAO ctd =new CateDAO();

		//エンコーディングとMIMEタイプの設定
				req.setCharacterEncoding("UTF-8");

        //セッションの継続確認
		HttpSession session = req.getSession(true);

        //String型の変数にnameとpasswordの値を格納
		String submitName = req.getParameter("name");
		String submitId = req.getParameter("password");


		String [] index = dao.Access(submitName);


        //名前かパスワードが入力されないとき
		if((submitName == null || submitId ==null) || (submitName == "" || submitId == "")) {
			req.setAttribute("errormsg","名前またはパスワードを入力してください");
		RequestDispatcher rd =req.getRequestDispatcher("/Login1.jsp");
		 rd.forward(req, resp);

		 return;

		 //名前かパスワードが一致しないとき
	}else if(!(submitName.equals(index[0]) || submitId.equals(index[1]))){
		req.setAttribute("errormsg","名前またはパスワードが一致しません");
		RequestDispatcher rd =req.getRequestDispatcher("/Login1.jsp");
		 rd.forward(req, resp);

		 return;
	}


	session.setAttribute("login_id",index[0]);
	session.setAttribute("login_pw",index[1]);
	session.setAttribute("login_name",index[2]);

	System.out.println("ああ");
    req.setAttribute("catlist",ctd.cat_gets());

    System.out.println("いい");


	//RequestDispatcherを用いて、遷移先を指定している。
	 RequestDispatcher rd = req.getRequestDispatcher("/Category");
	 //RequestDispatcherを用いて値を投げている。
	 rd.forward(req, resp);

	}

}
