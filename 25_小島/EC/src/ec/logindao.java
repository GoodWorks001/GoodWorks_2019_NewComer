package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logindao {


	public loginbean  access(String name, String pass) {

		loginbean lb = new loginbean();

		//MySQLに接続するための情報を変数に格納
		String url = "jdbc:mysql://localhost/EC";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//MySQLのJDBCドライバを使いますよ！
			Class.forName("com.mysql.jdbc.Driver");
			//引数にurl,id,pwを投げてＤＢにアクセス！
			cnct = DriverManager.getConnection(url,id,pw);
			//queryっていう変数にinsert文を代入している
				 String query = "select * from user where user_name = ? and login_pw = ?";
				 st = cnct.prepareStatement(query);
				 st.setString(1, name);
				 st.setString(2, pass);

				 System.out.println(query);
				 rs = st.executeQuery();

				 while(rs.next()){
					 lb.setName(rs.getString("user_name"));
					 lb.setPass(rs.getString("login_pw"));
				 }

			}catch (SQLException e){
				System.out.println("SQL");
			    e.printStackTrace();

	        }catch(Exception ex){
	        	System.out.println("Exception");
			    ex.printStackTrace();

		} finally {
			try {

				System.out.println("閉じるよ");
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				if (rs!=null) rs.close();
			} catch(Exception ex) { }
		}
		return lb;

}
}