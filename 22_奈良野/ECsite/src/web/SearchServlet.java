package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 送信されてくるパラメータのエンコーディングの指定
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        // 送信されてくるパラメータの取得（文字列)
        String search = req.getParameter("search");// 検索キーワード
        String category = req.getParameter("category");// 検索カテゴリ

        //SearchLogicインスタンス化
        SearchLogic sl = new SearchLogic();
        //ArrayList<String> dbにSearchLogicの検索メソッド内の値、search,categoryを格納
        ArrayList<String> db = sl.kensaku(search,category);
        //sessionにListという名前でdbインスタンスの中身を格納
        session.setAttribute("List", db);

        //dbインスタンスの中身がnullの場合の判定式
        if(db != null) {
        	//いつもの遷移処理
            RequestDispatcher rd = req.getRequestDispatcher("/ProductSearch.jsp");
            rd.forward(req, resp);
        //dbインスタンスの中身がnullではない場合の判定式
        }else {
        	//いつもの遷移処理
            RequestDispatcher rd = req.getRequestDispatcher("/NoProductSearch.jsp");
            rd.forward(req, resp);
        }

    }
}