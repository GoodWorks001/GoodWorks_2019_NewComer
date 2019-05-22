package web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UpDateServlet2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 //送信されてくるパラメータのコーディングの指定
        req.setCharacterEncoding("UTF-8");
        //商品情報格納用リストの作成
        ArrayList<Integer> Kosulist = new ArrayList<Integer>();
        ArrayList<detailBean> dlist = new ArrayList<detailBean>();
        ArrayList<Integer> Golist = new ArrayList<Integer>();

        //セッションの開始
        HttpSession ses = req.getSession();
        //セッションに保存されているカート内の情報を取得
        Kosulist = (ArrayList<Integer>)ses.getAttribute("cart3");
        dlist = (ArrayList<detailBean>)ses.getAttribute("cart2");

        for(int i = 0;i<Kosulist.size();i++) {
            int kosu = Kosulist.get(i);
            int pri = dlist.get(i).getPrice();
            Golist.add((int)(pri*kosu*1.08));
        }

        //DAOクラスのインスタンス化
        UpDateDao uDao = new UpDateDao();
        insertDao iDao = new insertDao();

        try {
            uDao.update(dlist, Kosulist);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        //ユーザーidの取得
        userBean u = (userBean)ses.getAttribute("user");
        int user = u.getId();

        //Calendarクラスのオブジェクトを生成する
        Calendar cl = Calendar.getInstance();

        //SimpleDateFormatクラスでフォーマットパターンを設定する
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(cl.getTime()));

        try {
        	for(int i=0;i<Kosulist.size();i++) {
        		iDao.insert(user, Golist.get(i) ,dlist.get(i).getP_cd());
        	}

        } catch (Exception e) {
            e.printStackTrace();
        }


        //カート関連のセッションを破棄
        ses.setAttribute("cart", null);
        ses.setAttribute("cart2", null);
        ses.setAttribute("cart3", null);
        ses.setAttribute("id", null);

        //遷移するためのテンプレ
        RequestDispatcher rd = req.getRequestDispatcher("BuyDone.jsp");
        //遷移だ
        rd.forward(req, resp);

	}
}
