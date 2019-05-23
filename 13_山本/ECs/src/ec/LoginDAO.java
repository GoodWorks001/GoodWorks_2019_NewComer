package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDAO {
	boolean flag = false;
	Connection cnct = null;
	Statement st = null;
	ResultSet rs = null;

	private UserBean user = new UserBean();

	public Boolean jdbc(String username, String userpass) {
		String url = "jdbc:mysql://localhost/ECsite"; // データベースを開くためのパス
		String id = "root"; // サーバーのユーザー名
		String pw = "password"; // サーバーのパスワード

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// ログインコード・パス
			rs = st.executeQuery("SELECT * FROM user;");

			while (rs.next()) {
				int uID = rs.getInt("user_id");
				String uName = rs.getString("user_name");
				String uCode = rs.getString("login_cd");
				String uPass = rs.getString("login_pw");

				if (uName.equals(username) && uPass.equals(userpass)) {
					System.out.println("DAO.uID:"+ uID);
					flag = true;
					user.setUserID(uID);
					user.setUserName(uName);
					user.setUserCode(uCode);
					user.setUserPassword(uPass);
					break;
				}
			}

			return flag;

		} catch (ClassNotFoundException ex) { // 指定したクラスが見つからないことを示す
			ex.printStackTrace();
			return false;
		} catch (SQLException ex) { // データベース接続に関する不具合のことを示す
			ex.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // 閉じる
				if (st != null) {
					st.close();
				} // 閉じる
				if (cnct != null) {
					cnct.close();
				} // データベースとの接続を切る
			} catch (Exception ex) {
			} // 例外のメッセージ表示
		}
	}

	public UserBean jdbc2(String username, String userpass) {
		String url = "jdbc:mysql://localhost/ECsite"; // データベースを開くためのパス
		String id = "root"; // サーバーのユーザー名
		String pw = "password"; // サーバーのパスワード

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// ログインコード・パス
			rs = st.executeQuery("SELECT * FROM user;");

			while (rs.next()) {
				int uID = rs.getInt("user_id");
				String uName = rs.getString("user_name");
				String uCode = rs.getString("login_cd");
				String uPass = rs.getString("login_pw");

				if (uName.equals(username) && uPass.equals(userpass)) {
					System.out.println("DAO.uID:"+ uID);
					user.setUserID(uID);
					user.setUserName(uName);
					user.setUserCode(uCode);
					user.setUserPassword(uPass);
				}
			}

			return user;

		} catch (ClassNotFoundException ex) { // 指定したクラスが見つからないことを示す
			ex.printStackTrace();
			return user;
		} catch (SQLException ex) { // データベース接続に関する不具合のことを示す
			ex.printStackTrace();
			return user;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} // 閉じる
				if (st != null) {
					st.close();
				} // 閉じる
				if (cnct != null) {
					cnct.close();
				} // データベースとの接続を切る
			} catch (Exception ex) {
			} // 例外のメッセージ表示
		}
	}

	public UserBean getUser() {
		return user;
	}

	public ArrayList<categoryBean> getCategoryList() {
		ArrayList<categoryBean> categoryList = new ArrayList<categoryBean>();

		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ECsite"; // データベースを開くためのパス
		String id = "root"; // サーバーのユーザー名
		String pw = "password"; // サーバーのパスワード

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// SQL文の指定
			rs = st.executeQuery("select * from category;");

			while (rs.next()) {
				categoryBean catB = new categoryBean();
				catB.setCatID(rs.getInt("cat_id"));// catIDの取得
				catB.setCatName(rs.getString("cat_name"));// catNameの取得
				categoryList.add(catB); // ArrayListにデータを追加
			}
			return categoryList; // 戻り値でカテゴリを返す。

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

	public boolean meisaiNo() {
		System.out.println("meisaiNo()開始");
		boolean flag = false;

		// url id pw を設定
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";

		try {
			// MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");// MYSQLにアクセス
			// DBに接続する
			cnct = DriverManager.getConnection(url, id, pw);

			// 接続に失敗したらSQLExceptionを投げる
			// 失敗した場合の布石
			st = cnct.createStatement();
			String sql = "SELECT * FROM meisai";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				flag = true;

			}
			System.out.println(flag);
			return flag;

		} catch (ClassNotFoundException ex) {// ClassNotfoundがでたらここ
			ex.printStackTrace();
			return flag;
		} catch (SQLException ex) {// SQLExceptionがでたらここ
			ex.printStackTrace();
			return flag;
		} finally {// ここは絶対に実行
			try {
				// 接続を解除
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
	}

	public int getNo() {
		// url id pw を設定
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";

		try {
			// MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");// MYSQLにアクセス
			// DBに接続する
			cnct = DriverManager.getConnection(url, id, pw);

			// 接続に失敗したらSQLExceptionを投げる
			// 失敗した場合の布石
			st = cnct.createStatement();
			String sql = "SELECT * FROM meisai";
			rs = st.executeQuery(sql);

			int num = 0;
			while (rs.next()) {
				num = rs.getInt("mei_id");

			}
			System.out.println(num);
			return num;

		} catch (ClassNotFoundException ex) {// ClassNotfoundがでたらここ
			ex.printStackTrace();
			int num = 1;
			return num;
		} catch (SQLException ex) {// SQLExceptionがでたらここ
			ex.printStackTrace();
			int num = 1;
			return num;
		} finally {// ここは絶対に実行
			try {
				// 接続を解除
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
	}
}