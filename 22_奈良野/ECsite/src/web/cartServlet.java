package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class cartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //文字コードエンコーディング
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; char=utf8");
        //sessionがtrue
        HttpSession session = req.getSession();
        //変数pcdにProductDetailsのpcdを格納
        int pcd = Integer.parseInt(req.getParameter("pcd"));

        //cartDaoのインスタンス化
        cartDao cd = new cartDao();
        //dbにcdインスタンスのcartAllメソッドの値、pcdを格納
        detailBean db= cd.cartAll(pcd);

        //detailBean型アレイリスト、dlistを作成
        ArrayList<detailBean> dlist = new ArrayList<detailBean>();
        //Integer型アレイリスト、koslistを作成
        ArrayList<Integer> koslist = new ArrayList<Integer>();

        //変数kosuにProductDetailsのkosuを受け取る
        String kosu = req.getParameter("kosu");
        //上のkosuをint型に変換
        int kos = Integer.parseInt(kosu);

        //sessionの"cart2"がnullなら
        if(session.getAttribute("cart2")== null) {

        //それ以外なら
        }else {
            //dlistに"cart2"のリストを格納
            dlist=(ArrayList<detailBean>) session.getAttribute("cart2");
        }
        //sessionの"cart3"がnullなら
        if(session.getAttribute("cart3")== null) {

        //それ以外なら
        }else {
            //koslistに"cart3"のリストを格納
            koslist=(ArrayList<Integer>) session.getAttribute("cart3");
        }

        //sessionに"cart2"という名前でdlistを格納
        session.setAttribute("cart2", dlist);
        session.setAttribute("cart", cd);
        session.setAttribute("cart3", koslist);

        //dlistにdbをadd
        dlist.add(db);
        koslist.add(kos);

        //いつもの遷移処理
        RequestDispatcher rd = req.getRequestDispatcher("/Cart.jsp");
        rd.forward(req, resp);

    }

}
