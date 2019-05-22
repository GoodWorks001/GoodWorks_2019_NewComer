package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDao {
	public userBean loginuser(String name, String password){
		//	検索結果
		userBean ub = new userBean();
		//SQL

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps= null;



		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/ecsite";
			String id = "root";
			String pwd = "password";

			 conn = DriverManager.getConnection(url,id,pwd);
			 String query = "select * from user where user_name = ? and login_pw = ?";
			 ps = conn.prepareStatement(query);
			 ps.setString(1, name);
			 ps.setString(2, password);
			 rs = ps.executeQuery();

			 while(rs.next()){
				 ub.setId(rs.getInt("user_id"));

			 }

		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
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
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return ub;
	}
}
