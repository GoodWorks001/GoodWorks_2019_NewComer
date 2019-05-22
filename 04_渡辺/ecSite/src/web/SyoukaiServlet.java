package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SyoukaiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("開始");

        req.setCharacterEncoding("UTF-8");

        //セッションの取得
        HttpSession ses = req.getSession(false);

        //セッションが取得されているか判定
        if(ses == null) {
            System.out.println("セッションがありません");
            //セッションがなかったらログイン画面に遷移
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
        }else {

            //詳細を見る商品のコードを取得
            String pro_cd = req.getParameter("pro_cd");

            DAO d = new DAO();

            //商品の情報を取り出す
            ProductBean p = d.getPro(pro_cd);


            ses.setAttribute("pro", p);

            RequestDispatcher rd = req.getRequestDispatcher("syousai.jsp");
            rd.forward(req, resp);
        }
    }
}
