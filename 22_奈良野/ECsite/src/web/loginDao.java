package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDao {

    public userBean login(String name, String password){
        //userBeanのインスタンス化
        userBean ub = new userBean();
        //SQLに必要なもの
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps= null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/ecsite";
            String id = "root";
            String pwd = "password";

            conn = DriverManager.getConnection(url,id,pwd);
            //プリコンパイルを使って入力されたname,passをDB内で検索
            String query = "select * from user where user_name = ? and login_pw = ?";
            ps = conn.prepareStatement(query);
            //？,？の中にjspのnameとpasswordを挿入
            ps.setString(1, name);
            ps.setString(2, password);
            //SQL実行
            rs = ps.executeQuery();

            //検索結果をubのメソッドを使って格納
            //すべて網羅するまでループ
            while(rs.next()){
                ub.setId(rs.getInt(1));
                ub.setName(rs.getString("user_name"));
                ub.setPass(rs.getString("login_pw"));

            }
        //ClassNotFoundExceptionの例外発生でprintStackTrace
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        //SQLExceptionの例外発生でprintStackTrace
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try{
                if(conn != null){
                    conn.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(rs != null){
                    rs.close();
                }
            //SQLExceptionの例外発生でprintStackTrace
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return ub;
    }
}