package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class loginservlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//文字コード設定
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; char=utf8");

        //変数を定義して、login.jspから"name","password"を受け取る
        String name = request.getParameter("name");
        String pass = request.getParameter("password");

        //nameかpasswordに値が入っているかの判定式
        if(name == "" || pass == "") {
        	//err1へエラー文のセット
            request.setAttribute("err1", "NAMEまたはPASSを入力してください");
            //Login.jspへの遷移
            RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
            //rd.forward(request, response);
        }

        //loginDaoのインスタンス化
        loginDao LD = new loginDao();
        //ubにloginDaoのloginメソッドの値、nameとpassをわたす
        userBean ub = LD.login(name,pass);

        //ub.getName()の値がnullの場合の判定式
        if(ub.getName() == null) {
        	//err2へエラー文のセット
            request.setAttribute("err2", "NAMEまたはPASSが一致しません");
            //Login.jspへの遷移
            RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
        //ub.getName()の値がnullではないなら
        }else {
        	//sessionをtrueに
            HttpSession session = request.getSession(true);
            //sessionへloginという名前でubインスタンスの中身を格納
            session.setAttribute("login", ub);
            //上記と同じ
            session.setAttribute("cart", null);
            session.setAttribute("cart2", null);
            session.setAttribute("cart3", null);

            //userDaoをインスタンス化
            userDao uDao = new userDao();
            //beanにuserDaoのloginuserメソッドの値、nameとpassをわたす
            userBean bean = uDao.loginuser(name, pass);

            //sessionへuserという名前でbean インスタンスの中身を格納
            session.setAttribute("user", bean);

            //いつもの遷移
            RequestDispatcher rd = request.getRequestDispatcher("/NoProductSearch.jsp");
            rd.forward(request, response);
        }
    }
}
