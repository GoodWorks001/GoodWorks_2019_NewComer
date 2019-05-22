package ecs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginDAO {

	String selectname () {

		String dbname="";
		//入るデータベース
		String url = "jdbc:mysql://localhost/ecsite";
		//ログインするときのユーザー名
		String id = "root";
		//ログインするときのパスワード
		String pw = "password";
		//DBに接続する際に使うやつ
		Connection cnct = null;
		//SQLを実行するときにつかうやつ
		Statement st = null;
		//SQL実行結果を格納するやつ
		ResultSet rs = null;
		try {
		//JDBCドライバのロードとインスタンス化
		Class.forName("com.mysql.jdbc.Driver");
		                          //DBMSに接続
		/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
	                             //接続に失敗した場合エラーを投げる
		/*Statement*/ st = cnct.createStatement();
		//検索する条件を書く
		//実行結果を変数に代入
		/*ResultSet*/rs = st.executeQuery("select*from user");
		//レコードが後ろに存在すればtrue
		while(rs.next()){
		//レコードのカラム値を取り出す
			//int dbuserid=rs.getInt("user_id");
			//System.out.println(dbuserid);
		 dbname=rs.getString("user_name");
		System.out.println(dbname);
		//String dblogin_cd=rs.getString("login_cd");
		//System.out.println(dblogin_cd);
		//String dbpass=rs.getString("login_pw");
		//System.out.println(dbpass);


		}

		} catch(ClassNotFoundException ex){
		ex.printStackTrace();
		} catch(SQLException ex) {
		ex.printStackTrace();
		//下記行でDBの接続を解除している
		} finally {
		try {
		if (rs!=null) rs.close();
		if (st!=null) st.close();
		if (cnct!=null) cnct.close();
		} catch(Exception ex) { }
		}
return  dbname;
	}
	String selectpass () {

		String dbpass="";
		//入るデータベース
		String url = "jdbc:mysql://localhost/ecsite";
		//ログインするときのユーザー名
		String id = "root";
		//ログインするときのパスワード
		String pw = "password";
		//DBに接続する際に使うやつ
		Connection cnct = null;
		//SQLを実行するときにつかうやつ
		Statement st = null;
		//SQL実行結果を格納するやつ
		ResultSet rs = null;
		try {
		//JDBCドライバのロードとインスタンス化
		Class.forName("com.mysql.jdbc.Driver");
		                          //DBMSに接続
		/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
	                             //接続に失敗した場合エラーを投げる
		/*Statement*/ st = cnct.createStatement();
		//検索する条件を書く
		//実行結果を変数に代入
		/*ResultSet*/rs = st.executeQuery("select*from user");
		//レコードが後ろに存在すればtrue
		while(rs.next()){
		//レコードのカラム値を取り出す
			//int dbuserid=rs.getInt("user_id");
			//System.out.println(dbuserid);
		 dbpass=rs.getString("login_pw");
		System.out.println(dbpass);
		//String dblogin_cd=rs.getString("login_cd");
		//System.out.println(dblogin_cd);
		//String dbpass=rs.getString("login_pw");
		//System.out.println(dbpass);


		}

		} catch(ClassNotFoundException ex){
		ex.printStackTrace();
		} catch(SQLException ex) {
		ex.printStackTrace();
		//下記行でDBの接続を解除している
		} finally {
		try {
		if (rs!=null) rs.close();
		if (st!=null) st.close();
		if (cnct!=null) cnct.close();
		} catch(Exception ex) { }
		}
return  dbpass;
	}

	int selectid (String name,String pass) {

		int userid=0;
		//入るデータベース
		String url = "jdbc:mysql://localhost/ecsite";
		//ログインするときのユーザー名
		String id = "root";
		//ログインするときのパスワード
		String pw = "password";
		//DBに接続する際に使うやつ
		Connection cnct = null;
		//SQLを実行するときにつかうやつ
		Statement st = null;
		//SQL実行結果を格納するやつ
		ResultSet rs = null;
		try {
		//JDBCドライバのロードとインスタンス化
		Class.forName("com.mysql.jdbc.Driver");
		                          //DBMSに接続
		/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
	                             //接続に失敗した場合エラーを投げる
		/*Statement*/ st = cnct.createStatement();
		//検索する条件を書く
		//実行結果を変数に代入
		/*ResultSet*/rs = st.executeQuery("select*from user where user_name='"+name+"'and login_pw'"+pass+"'");
		//レコードが後ろに存在すればtrue
		while(rs.next()){
		//レコードのカラム値を取り出す
			//int dbuserid=rs.getInt("user_id");
			//System.out.println(dbuserid);
		 userid=rs.getInt("user_id");
		System.out.println(userid);
		//String dblogin_cd=rs.getString("login_cd");
		//System.out.println(dblogin_cd);
		//String dbpass=rs.getString("login_pw");
		//System.out.println(dbpass);


		}

		} catch(ClassNotFoundException ex){
		ex.printStackTrace();
		} catch(SQLException ex) {
		ex.printStackTrace();
		//下記行でDBの接続を解除している
		} finally {
		try {
		if (rs!=null) rs.close();
		if (st!=null) st.close();
		if (cnct!=null) cnct.close();
		} catch(Exception ex) { }
		}
return  userid;
	}


}


