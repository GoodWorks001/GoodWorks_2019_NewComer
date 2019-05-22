package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDao {

	private LoginUserBean user = new LoginUserBean();

	public Boolean isLogin(String name, String pass) {

		boolean flag = false;
		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";

		//DB接続する際に使う
		Connection cnct = null;
		//SQL実行結果を格納する
		Statement st = null;
		//SQL実行に使うやつ
		ResultSet rs = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// ログインコード・パス
			rs = st.executeQuery("SELECT * FROM user;");

			while (rs.next()) {
				int sID = rs.getInt(1);
				String sName = rs.getString(2);
				String sCode = rs.getString(3);
				String sPass = rs.getString(4);



				if (sName.equals(name) && sPass.equals(pass)) {
					flag = true;
					user.setId(sID);
					user.setName(sName);
					user.setCd(sCode);
					user.setPass(sPass);
					break;
				}
			}
			return flag;
         
			//クラス関連のエラーハンドリング
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			 
			//SQL関連のエラーハンドリング
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				//接続解除処理
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

	public LoginUserBean getUser() {
		return user;
	}

	public ArrayList<String> getCategoryList() {
		ArrayList<String> CategoryList = new ArrayList<String>();
		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite";
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
				CategoryList.add(rs.getString("cat_name"));
			}
			return CategoryList;
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

		return CategoryList;

	}





}
