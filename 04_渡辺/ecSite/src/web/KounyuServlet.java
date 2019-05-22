package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KounyuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //文字コードの設定
        req.setCharacterEncoding("UTF-8");

        //セッションを取得
        HttpSession ses = req.getSession(false);

        //セッションを取得しているか(ログインしているか)の確認
        if(ses == null) {
            System.out.println("セッションがありません");
            //セッションがなかったらログイン画面に遷移
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
        }else {

        	//引数用の変数
        	int uId = 0;
        	int sId = 0;
        	int money = 0;
        	int stock = 0;
        	int count = 0;

        	//DB接続クラスをインスタンス化
        	DAO d = new DAO();

            //カートのリストをセッションから取得
            ArrayList<ProductBean> cList = (ArrayList<ProductBean>)ses.getAttribute("cart");

            //ユーザー情報を取得
            UserBean u = (UserBean)ses.getAttribute("user");

            //カートの中身をすべて参照するまで繰り返す
            for(int i=0;i<cList.size();i++) {
                //カートから商品の情報を取り出す
                ProductBean p = cList.get(i);
                //引数用の変数に値を格納
                uId = Integer.parseInt(u.getUser_id());//ユーザーID
                sId = (p.getPro_cd());//商品コード
                money = p.getPro_price();//単価
                stock = p.getStock_no();//在庫
                count = p.getCount();//個数

                //在庫が足りなかった時は購入をキャンセル(したかった)
                if(stock<count) {
                	System.out.println("在庫が足りません");

                    RequestDispatcher rd = req.getRequestDispatcher("kanryou.jsp");
                    rd.forward(req, resp);
                }

                //meisaiテーブルにデータを追加
                d.addMeisai(uId, sId, money,count);
                //在庫数を減らす
                d.updateStock(count, sId);


            }

            //カートのセッション変数を破棄
            ses.removeAttribute("cart");

            //データベースを閉じる
            d.dbClose();

            //遷移先を指定して遷移実行
            RequestDispatcher rd = req.getRequestDispatcher("kanryou.jsp");
            rd.forward(req, resp);

        }

    }
}
