package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchLogic {

    //String型アレイリスト"List"を作成
    ArrayList<String> List = new ArrayList<String>();

    public ArrayList<String> kensaku(String search,String category) {

        //detailBeanをインスタンス化
        detailBean db = new detailBean();

        //SQLに必要なもの
        Connection conn = null;
        ResultSet rs = null;
        Statement st= null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/ecsite";
            String id = "root";
            String pwd = "password";

            conn = DriverManager.getConnection(url,id,pwd);

            //検索メソッドのcategoryが未入力の場合の判定処理
            if(category=="") {
            	//searchを下のSQLで使えるようにする
                search = "'" + search + "'";
                st = conn.createStatement();
                //DBのproductテーブルから入力された文字、searchを検索
                String sql = "select * from product where pro_name = " + search;
                //SQL実行
                rs = st.executeQuery(sql);
            //検索メソッドのsearchが未入力の場合の判定処理
            }else {
            	//categoryを下のSQLで使えるようにする
                category = "'" + category + "'";
                st = conn.createStatement();
                //DBのproductテーブルから入力された文字、categoryを検索
                String sql2 = "select * from product where cat_id = " + category;
                //SQL実行
                rs = st.executeQuery(sql2);
            }

            while(rs.next()){
            	//String型アレイリスト"List"にSQLの検索結果を格納
                List.add(rs.getString("pro_name"));
                List.add(rs.getString("pro_price"));
                List.add(rs.getString("pro_cd"));

            }
            return List;
        //ここから先はいつものエラー処理
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            return List;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return List;
        }
        finally{
            try{
                if(conn != null){
                    conn.close();
                }
                if(st != null){
                    st.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

}
