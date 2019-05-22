package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class detailservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	//文字エンコーディング
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; char=utf8");
        //sessionをtrueに
        HttpSession session = req.getSession(true);
        //変数pcdにProductSearch.jspのhidden属性のname、idを格納
        int pcd = Integer.parseInt(req.getParameter("id"));

        //detailDaoのインスタンス化
        detailDao dd = new detailDao();
        //dbにdetailDaoのdetailメソッドの値、pcdをわたす
        detailBean db = dd.detail(pcd);

        //reqへ"result"という名前でdbインスタンスの中身を格納
        req.setAttribute("result", db);
        //sessionへ"pcd"という名前でpcdを格納
        session.setAttribute("pcd", pcd);

        //変数zaikoにdbインスタンスのgetStockメソッドの値を格納
        int zaiko = db.getStock();
        //sessionに"zai"という名前でzaikoを格納
        session.setAttribute("zai", zaiko);

        //いつもの遷移処理
        RequestDispatcher rd = req.getRequestDispatcher("/ProductDetails.jsp");
        rd.forward(req, resp);
    }
}