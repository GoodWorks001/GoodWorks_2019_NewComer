package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//ログイン
//name passをDBと比較
public class LoginDAO {

	public static boolean cheak = true;

	//DBに接続する際のつかうやつ
	Connection cnct = null;
	//SQL実行結果を格納するやつ
	Statement st = null;
	//SQLを実行するのに使うやつ
	ResultSet rs = null;

	PreparedStatement pst = null;

	private LoginBean lb = new LoginBean();

	public void Initialize() {
		cheak = true;


	}





	public boolean isLogin(String name, String pass) {
		boolean flag = false;

		//url id pw を設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";

		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
			//DBに接続する
			cnct = DriverManager.getConnection(url,id,pw);

			//接続に失敗したらSQLExceptionを投げる
			//失敗した場合の布石
			st = cnct.createStatement();
			//rs = st.executeQuery("SELECT * FROM user");

			String sql = "Select * from user where user_id = ? and login_pw = ?";
			pst = cnct.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pass);
			rs = pst.executeQuery();

			while(rs.next()) {
				System.out.println("---情報取得---");
				String sID = rs.getString(1);
				System.out.println(sID);
				String sName = rs.getString(2);
				System.out.println(sName);
				String sCode = rs.getString(3);
				System.out.println(sCode);
				String sPass = rs.getString(4);
				System.out.println(sPass);

				flag = true;
				return flag;
			}

			return flag;

		}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
			ex.printStackTrace();
			return false;
		}catch(SQLException ex) {//SQLExceptionがでたらここ
			ex.printStackTrace();
			return false;
		} finally {//ここは絶対に実行
			try {
				//接続を解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			}catch(Exception ex) {}
		}

	}

	public LoginBean getLogin() {
		return lb;
	}


	//categoryを取得
	public ArrayList<String> getCategoryList(){
		ArrayList<String> categoryList = new ArrayList<String>();

		//url id pw を設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";


		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
			//DBに接続する
			cnct = DriverManager.getConnection(url,id,pw);

			//接続に失敗したらSQLExceptionを投げる
			//失敗した場合の布石
			st = cnct.createStatement();
			rs = st.executeQuery("SELECT cat_name FROM eccategory");

			while(rs.next()) {
				categoryList.add(rs.getString("cat_name"));
			}
			return categoryList;

		}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
			ex.printStackTrace();
		}catch(SQLException ex) {//SQLExceptionがでたらここ
			ex.printStackTrace();
		} finally {//ここは絶対に実行
			try {
				//接続を解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			}catch(Exception ex) {}
		}
		return categoryList;


	}


	public boolean meisaiNo() {
		boolean flag = false;

		//url id pw を設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";


		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
			//DBに接続する
			cnct = DriverManager.getConnection(url,id,pw);

			//接続に失敗したらSQLExceptionを投げる
			//失敗した場合の布石
			st = cnct.createStatement();
			String sql = "SELECT * FROM meisai";
			rs = st.executeQuery(sql);

			while(rs.next()) {
				flag = true;

			}
			return flag;

		}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
			ex.printStackTrace();
			return flag;
		}catch(SQLException ex) {//SQLExceptionがでたらここ
			ex.printStackTrace();
			return flag;
		} finally {//ここは絶対に実行
			try {
				//接続を解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			}catch(Exception ex) {}
		}
	}

	public int getNo() {
		//url id pw を設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";


		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
			//DBに接続する
			cnct = DriverManager.getConnection(url,id,pw);

			//接続に失敗したらSQLExceptionを投げる
			//失敗した場合の布石
			st = cnct.createStatement();
			String sql = "SELECT * FROM meisai";
			rs = st.executeQuery(sql);

			int num = 0;
			while(rs.next()) {
				num = rs.getInt("mei_id");

			}
			return num;

		}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
			ex.printStackTrace();
			int num = 1;
			return num;
		}catch(SQLException ex) {//SQLExceptionがでたらここ
			ex.printStackTrace();
			int num = 1;
			return num;
		} finally {//ここは絶対に実行
			try {
				//接続を解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			}catch(Exception ex) {}
		}
	}


	public boolean Cheak(String name, String pass) {
		//url id pw を設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";






		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
			//DBに接続する
			cnct = DriverManager.getConnection(url,id,pw);

			//接続に失敗したらSQLExceptionを投げる
			//失敗した場合の布石
			st = cnct.createStatement();

			String query = "SELECT * from user where login_cd = ? AND login_pw = ?";
			pst = cnct.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, pass);
			rs = pst.executeQuery();

			if(rs.next()) {
				System.out.println("!null");
				cheak = true;
				return true;
			}
			else {
				System.out.println("null");
				cheak = false;
				return false;
			}

		}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
			ex.printStackTrace();
			return false;
		}catch(SQLException ex) {//SQLExceptionがでたらここ
			ex.printStackTrace();
			return false;
		} finally {//ここは絶対に実行
			try {
				//接続を解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			}catch(Exception ex) {}
		}
	}



	public String setCatID(int n) {
		//url id pw を設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";

		String catid = null;





		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
			//DBに接続する
			cnct = DriverManager.getConnection(url,id,pw);

			//接続に失敗したらSQLExceptionを投げる
			//失敗した場合の布石
			st = cnct.createStatement();

			String query = "SELECT * from eccategory where cat_id = ?";
			pst = cnct.prepareStatement(query);
			pst.setInt(1, n);
			rs = pst.executeQuery();

			while(rs.next()) {
				catid = rs.getString("cat_name");
			}

		}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
			ex.printStackTrace();
		}catch(SQLException ex) {//SQLExceptionがでたらここ
			ex.printStackTrace();
		} finally {//ここは絶対に実行
			try {
				//接続を解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			}catch(Exception ex) {}
		}

		return catid;
	}



	public void Close() {
		try {
			// データベースとの接続を解除する
			if (this.cnct != null) {
				this.cnct.close();
			}
			if (this.pst != null) {
				this.pst.close();
			}
			if (this.rs != null) {
				this.rs.close();
			}
		} catch (SQLException se) {
			// データベースとの接続解除に失敗した場合
			se.printStackTrace();
		}
	}

	public static boolean getCheak() {
		return cheak;
	}

}
