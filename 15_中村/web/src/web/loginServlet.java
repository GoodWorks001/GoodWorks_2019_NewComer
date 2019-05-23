package web;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet(name="login",urlPatterns="/login")
public class loginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    //セッションの開始
		HttpSession session = req.getSession(true);
		
		//送信されてくるパラメータのコーティングの指定
		req.setCharacterEncoding("UTF-8");
		
		//送信されたパラメータ【nameとpass】の取得
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
        //session.setAttribute("zyouhou", true);
		session.setAttribute("flg", "true");
		System.out.println(name);
		System.out.println(pass);

		if((name.equals("") || name == null)|| pass.equals("") || pass ==null) {
            
			//入力しなかったとき遷移
			RequestDispatcher rd=req.getRequestDispatcher("errar1.jsp");
            //session.setAttribute("zyouhou", "");
			rd.forward(req, resp);
			System.out.print("ミス１");
			return;
		}
		//インスタンス化
		LoginDao ld = new LoginDao();


           if(ld.isLogin(name,pass)) {//ログイン成功したとき

        	   //セッションにユーザー情報保存
        	   session.setAttribute("user", ld.getUser());
        	   req.setAttribute("CategoryList", ld.getCategoryList());
        	   
        	   //遷移
        	   RequestDispatcher rd2=req.getRequestDispatcher("login.jsp");
               rd2.forward(req, resp);
               System.out.print("成功");
               return;

           }else {//名前かパスが違うとき

        	   //遷移
        	   RequestDispatcher rd=req.getRequestDispatcher("errar2.jsp");
        	   //session.setAttribute("zyouhou", "!=");
               rd.forward(req,resp);
               System.out.print("ミス2");
               return;
           }

		}
	}








