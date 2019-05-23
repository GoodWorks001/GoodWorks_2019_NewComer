package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class logindao2 {

	private loginbean user = new loginbean();

	public Boolean access(String name, String pass) {

		boolean flag = false;
		// DBにアクセスする情報変数
		System.out.println("daoきた");

		String url = "jdbc:mysql://localhost/EC";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// ログインコード・パス
			rs = st.executeQuery("SELECT * FROM user;");
			System.out.println("try");

			while (rs.next()) {
				//ユーザー情報を取得
				int sID = rs.getInt("user_id");
				String sName = rs.getString("user_name");
				String sPass = rs.getString("login_pw");
				System.out.println("while文");


				if (sName.equals(name) && sPass.equals(pass)) {
					System.out.println("if文");
					flag = true;
					//ユーザー情報をbeanにセット
					user.setId(sID);
					user.setName(sName);
					user.setPass(sPass);
					break;
				}else {
					System.out.println("else");
					flag = false;
					break;
				}
			}


		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
		return flag;
	}


	public int user(String name, String pass) {

		int flag =0;
		// DBにアクセスする情報変数
		System.out.println("daoきた");

		String url = "jdbc:mysql://localhost/EC";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// ログインコード・パス
			rs = st.executeQuery("SELECT * FROM user;");
			System.out.println("try");

			while (rs.next()) {
				int sID = rs.getInt("user_id");
				String sName = rs.getString("user_name");
				String sPass = rs.getString("login_pw");
				System.out.println("while文");


				if (sName.equals(name) && sPass.equals(pass)) {
					System.out.println("if文");
					user.setId(sID);
					user.setName(sName);
					user.setPass(sPass);
					flag = user.getId();
					break;
				}else {
					System.out.println("else");
					flag = 0;
					break;
				}
			}


		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
		return flag;
	}






	public ArrayList<String> getCategoryList() {
		ArrayList<String> categoryList = new ArrayList<String>();
		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/EC";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// SQL文の指定
			rs = st.executeQuery("SELECT cat_name FROM category;");

			while (rs.next()) {
				categoryList.add(rs.getString("cat_name"));
			}
			return categoryList;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}

		return categoryList;

	}

}



