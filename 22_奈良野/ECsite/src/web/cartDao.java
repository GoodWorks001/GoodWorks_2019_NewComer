package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class cartDao {

    //String型アレイリストcartList作成
    ArrayList<String> cartList = new ArrayList<String>();
    //detailBeanのインスタンス化
    detailBean bean = new detailBean();

    public detailBean cartAll(int pcd) {

        //cartBeanのインスタンス化
        cartBean cb = new cartBean();

        //JDBCドライバ読み込み
        Connection conn = null;
        ResultSet rs = null;
        Statement st= null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/ecsite";
            String id= "root";
            String pass = "password";

            conn = DriverManager.getConnection(url,id,pass);
            st = conn.createStatement();
            //productテーブルからpro_cd、pcdを検索
            String sql3 = "select * from product where pro_cd="+pcd;
            //sql実行
            rs = st.executeQuery(sql3);

            //	データベースから取得した値がある間
            while(rs.next()) {
                bean.setP_name(rs.getString("pro_name"));
                bean.setPrice(rs.getInt("pro_price"));
                bean.setStock(rs.getInt("stock_no"));
                bean.setP_cd(rs.getInt("pro_cd"));
            }
            //戻り値返す
            return bean;
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            //戻り値返す
            return bean;
        } catch (SQLException ex) {
            ex.printStackTrace();
            //戻り値返す
            return bean;
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
