package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class insertDao {
    //明細情報格納用メソッド
        public void insert(int user_id , int all , int pro_cd) throws SQLException {
            //接続のためのurlとIDとpassの設定
            String url = "jdbc:mysql://localhost/ecsite";
            String id = "root";
            String pass = "password";
            //ここまで
            //DB接続に接続する際に使うやつ
            Connection cnct = null;
            //SQL実行結果を格納するやつ
            PreparedStatement pst = null;
            //SQL実行するときに使うやつ
            ResultSet rs = null;
            try {
                //ドライバを使用する定義
                Class.forName("com.mysql.jdbc.Driver");
                //ログインのための設定
                cnct = DriverManager.getConnection(url,id,pass);

                //自動コミットモードの解除
                cnct.setAutoCommit(false);

                //Calendarクラスのオブジェクトを生成する
                Calendar cl = Calendar.getInstance();
                //SimpleDateFormatクラスでフォーマットパターンを設定する
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                //明細情報をinsertする
                String sql = "insert into meisai2(user_id,pro_cd,ko_date,mei_price) values(" + user_id + "," + pro_cd + ",'" + sdf.format(cl.getTime()) + "'," +all + ")";

                //pstに格納
                pst = cnct.prepareStatement(sql);

                //insert文実行
                pst.executeUpdate();
                //コミットしてるよ
                cnct.commit();

            } catch(ClassNotFoundException ex){
                //↑クラス関連のエラーハンドリング

            } catch(SQLException ex) {
                ex.printStackTrace();
                //↑SQL関連のエラーハンドリング
                cnct.rollback();
                //最後に必ず行う処理
            } finally {
                try {
                    //接続解除処理
                    if (rs!=null) rs.close();
                    if (pst!=null) pst.close();
                    if (cnct!=null) cnct.close();
                } catch(Exception ex) { }
            }
        }
}
