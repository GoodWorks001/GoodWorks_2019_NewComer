package web;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KensakuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("開始");

        //文字コードの設定
        req.setCharacterEncoding("UTF-8");

        //セッション取得
        HttpSession ses = req.getSession(false);

        //セッションが取得されているか判定
        if(ses == null) {
            System.out.println("セッションがありません");
            //セッションがなかったらログイン画面に遷移
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
        }else {

            ArrayList<ProductBean> pList = new ArrayList<ProductBean>();

            //入力内容を取得
            String cat = req.getParameter("cat");
            String word = req.getParameter("word");

            System.out.println("cat："+cat+"\tword："+word);

            //DAOをインスタンス化
            DAO d = new DAO();

            try {
                //select文実行
                ResultSet rs = d.proSelect(cat, word);

                //結果のすべてを見るまで繰り返す
                while(rs.next()) {

                    //インスタンス生成
                    ProductBean p = new ProductBean();
                    System.out.println("インスタンス生成");

                    //商品情報をインスタンスに設定
                    p.setPro_cd(rs.getInt("pro_cd"));
                    p.setPro_name(rs.getString("pro_name"));
                    p.setPro_price(rs.getInt("pro_price"));

                    //ArrayListにインスタンスを追加
                    pList.add(p);

                }

                //requestにArrayListを設定
                req.setAttribute("pro", pList);

                //遷移先を指定
                RequestDispatcher rd = req.getRequestDispatcher("kensaku.jsp");
                //遷移実行
                rd.forward(req, resp);

                //DB切断
                d.dbClose();



            } catch (Exception ex) {
                //エラー内容を表示
                System.out.println("検索サーブレットでエラー");
                ex.printStackTrace();

                d.dbClose();
            }
        }
    }
}
