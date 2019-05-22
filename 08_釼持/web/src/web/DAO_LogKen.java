package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_LogKen {

	String selectName() {
		String dbName = "";
		//DBに接続する際に必要な情報を変数に格納
		//URL(jdbc:mysql://ホスト名:ポート番号/データベース名)
		String url = "jdbc:mysql://localhost/sekkei";
		//ID
		String id = "root";
		//PASSWORD
		String pw = "password";

		//DBに接続する際に使う
		Connection cnct = null;
		//SQLを実行するときに使う
		Statement st = null;
		//問い合わせの結果に行単位でアクセスするためのコンテナオブジェクト
		//SQLを実行結果を格納する
		ResultSet rs = null;

		try {
			//ドライバのロードとインスタンス化
			//MYSQLのJDBCドライバを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			//DBMSに接続
			cnct = DriverManager.getConnection(url, id, pw);
			//接続に失敗した場合エラーを投げる
			st = cnct.createStatement();
			//itemのデータベース
			//SQL文の実行,結果をrsに代入
			rs = st.executeQuery("SELECT * from user");
			//rsを1行ずつ(次の行がない場合false)
			while (rs.next()) {
				dbName = rs.getString("user_name");
			}
		} //クラスが見つからなかったら
		catch (ClassNotFoundException ex) {
			//エラー表示
			ex.printStackTrace();
		} //SQLExceptionのエラーが出たら
		catch (SQLException ex) {
			//エラー表示
			ex.printStackTrace();
		} finally {
			try {
				//rsがnullでなければ
				if (rs != null)
					//rsを接続を解除
					rs.close();
				//stがnullでなければ
				if (st != null)
					//stを接続を解除
					st.close();
				//cnctがnullでなければ
				if (cnct != null)
					//cnctを接続を解除
					cnct.close();
			} //Exceptionのエラーが出たら
			catch (Exception ex) {
			}
		}
		return dbName;
	}

	String selectPass() {
		String dbLoginPw = "";
		//DBに接続する際に必要な情報を変数に格納
		//URL(jdbc:mysql://ホスト名:ポート番号/データベース名)
		String url = "jdbc:mysql://localhost/sekkei";
		//ID
		String id = "root";
		//PASSWORD
		String pw = "password";

		//DBに接続する際に使う
		Connection cnct = null;
		//SQLを実行するときに使う
		Statement st = null;
		//問い合わせの結果に行単位でアクセスするためのコンテナオブジェクト
		//SQLを実行結果を格納する
		ResultSet rs = null;

		try {
			//ドライバのロードとインスタンス化
			//MYSQLのJDBCドライバを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			//DBMSに接続
			cnct = DriverManager.getConnection(url, id, pw);
			//接続に失敗した場合エラーを投げる
			st = cnct.createStatement();
			//itemのデータベース
			//SQL文の実行,結果をrsに代入
			rs = st.executeQuery("SELECT * from user");
			//rsを1行ずつ(次の行がない場合false)
			while (rs.next()) {
				dbLoginPw = rs.getString("login_pw");
			}
		} //クラスが見つからなかったら
		catch (ClassNotFoundException ex) {
			//エラー表示
			ex.printStackTrace();
		} //SQLExceptionのエラーが出たら
		catch (SQLException ex) {
			//エラー表示
			ex.printStackTrace();
		} finally {
			try {
				//rsがnullでなければ
				if (rs != null)
					//rsを接続を解除
					rs.close();
				//stがnullでなければ
				if (st != null)
					//stを接続を解除
					st.close();
				//cnctがnullでなければ
				if (cnct != null)
					//cnctを接続を解除
					cnct.close();
			} //Exceptionのエラーが出たら
			catch (Exception ex) {
			}
		}
		return dbLoginPw;
	}

	String selectCategory(int num) {
		String dbCategory = "";
		//DBに接続する際に必要な情報を変数に格納
		//URL(jdbc:mysql://ホスト名:ポート番号/データベース名)
		String url = "jdbc:mysql://localhost/sekkei";
		//ID
		String id = "root";
		//PASSWORD
		String pw = "password";

		//DBに接続する際に使う
		Connection cnct = null;
		//SQLを実行するときに使う
		Statement st = null;
		//問い合わせの結果に行単位でアクセスするためのコンテナオブジェクト
		//SQLを実行結果を格納する
		ResultSet rs = null;

		try {
			//ドライバのロードとインスタンス化
			//MYSQLのJDBCドライバを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			//DBMSに接続
			cnct = DriverManager.getConnection(url, id, pw);
			//接続に失敗した場合エラーを投げる
			st = cnct.createStatement();
			//itemのデータベース
			//SQL文の実行,結果をrsに代入
			rs = st.executeQuery("SELECT * from category where cat_id = " + num);
			//rsを1行ずつ(次の行がない場合false)
			while (rs.next()) {
				dbCategory = rs.getString("cat_name");
			}
		} //クラスが見つからなかったら
		catch (ClassNotFoundException ex) {
			//エラー表示
			ex.printStackTrace();
		} //SQLExceptionのエラーが出たら
		catch (SQLException ex) {
			//エラー表示
			ex.printStackTrace();
		} finally {
			try {
				//rsがnullでなければ
				if (rs != null)
					//rsを接続を解除
					rs.close();
				//stがnullでなければ
				if (st != null)
					//stを接続を解除
					st.close();
				//cnctがnullでなければ
				if (cnct != null)
					//cnctを接続を解除
					cnct.close();
			} //Exceptionのエラーが出たら
			catch (Exception ex) {
			}
		}
		return dbCategory;
	}

	int selectUserID(String name, String pass) {
		int userID = 0;
		//DBに接続する際に必要な情報を変数に格納
		//URL(jdbc:mysql://ホスト名:ポート番号/データベース名)
		String url = "jdbc:mysql://localhost/sekkei";
		//ID
		String id = "root";
		//PASSWORD
		String pw = "password";

		//DBに接続する際に使う
		Connection cnct = null;
		//SQLを実行するときに使う
		Statement st = null;
		//問い合わせの結果に行単位でアクセスするためのコンテナオブジェクト
		//SQLを実行結果を格納する
		ResultSet rs = null;

		try {
			//ドライバのロードとインスタンス化
			//MYSQLのJDBCドライバを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			//DBMSに接続
			cnct = DriverManager.getConnection(url, id, pw);
			//接続に失敗した場合エラーを投げる
			st = cnct.createStatement();
			//itemのデータベース
			//SQL文の実行,結果をrsに代入
			rs = st.executeQuery("select * from user where user_name = '" + name + "'and login_pw ='" + pass + "'");
			//rsを1行ずつ(次の行がない場合false)
			while (rs.next()) {
				userID = rs.getInt("user_id");
			}
		} //クラスが見つからなかったら
		catch (ClassNotFoundException ex) {
			//エラー表示
			ex.printStackTrace();
		} //SQLExceptionのエラーが出たら
		catch (SQLException ex) {
			//エラー表示
			ex.printStackTrace();
		} finally {
			try {
				//rsがnullでなければ
				if (rs != null)
					//rsを接続を解除
					rs.close();
				//stがnullでなければ
				if (st != null)
					//stを接続を解除
					st.close();
				//cnctがnullでなければ
				if (cnct != null)
					//cnctを接続を解除
					cnct.close();
			} //Exceptionのエラーが出たら
			catch (Exception ex) {
			}
		}
		return userID;
	}
}
