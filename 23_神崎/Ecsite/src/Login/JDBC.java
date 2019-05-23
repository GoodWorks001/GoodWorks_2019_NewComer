package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	public  User user(String user_name, String login_pw) {

		// mysqlに接続するための情報を格納
		String url = "jdbc:mysql://localhost/ecsite";
		// String url = "jdbc:mysql://localhost/renshu?autoReconnect=true&useSSL=false";
		// mysqlに接続するための情報を格納
		String id = "root";
		// mysqlに接続するための情報を格納
		String pw = "password";
		// mysqlにconnectionを接続する
		Connection cnct = null;
		// sql実行結果を格納する変数
		Statement st = null;
		// sqlを実行するときに使う変数
		ResultSet rs = null;
		User us = new User();
		us.setUser_name("");
		us.setLogin_pw("");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,pw);
			st = cnct.createStatement();
			rs = st.executeQuery("select * from user where user_name='" + user_name + "'"
					+ " and login_pw='" + login_pw + "'");
			while (rs.next()) {
				us.setUser_name(rs.getString("user_name"));
				us.setUser_id(rs.getInt("user_id"));
				us.setLogin_pw(rs.getString("login_pw"));

				System.out.println("-------------------");
				System.out.println(us.getUser_name());
				System.out.println(us.getUser_id());
				System.out.println(us.getLogin_pw());
				System.out.println("-------------------");
			}
			System.out.println("JDBC2");
			return us;


			// エラーが起きた場合の処理
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundエラー");
			ex.printStackTrace();
			return us;

			// エラーが起きた場合の処理//
		} catch (SQLException ex) {
			System.out.println("SQLExceptionエラー");
			ex.printStackTrace();
			return us;

			//接続の解除
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				return us;
			} catch (Exception ex) {
			}
		}
	}

}

