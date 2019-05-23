package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO1 {

	UserBeans user (String user_name,String login_pw) {
		String doName = "";
		//DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";

		//インスタンス化
		UserBeans ub = new UserBeans();

		//DBに接続する際に使うやつ
		Connection cnct = null;

		//SQLを実行するときに使うやつ
		Statement st = null;

		//SQL実行結果を格納するやつ
		ResultSet rs = null;


		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");

			//DBに実際に接続する。
			cnct = DriverManager.getConnection(url, id, pw);

			//接続に失敗した場合SQLExceptionを投げる
			st = cnct.createStatement();

			//SQL文を実行して実行結果をrsに代入している
			rs = st.executeQuery("SELECT * from user where user_name = '"+user_name+"'and login_pw='"+login_pw+"'");


			//ここのwhile文でrsに格納されている値を一行一行取り出して出力している。
			while (rs.next()) {
				//itemテーブルのidを取得
				ub.setName(rs.getString("user_name"));
				ub.setName(rs.getString("login_pw"));
				ub.setName(rs.getString("user_id"));

			}

			/*引数に指定されたクラスが見つからなかった場合に、
			例外ClassNotFoundExceptionを送出するための例外処理
			*/
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

			//接続に失敗した場合に、例外java.sql.SQLExceptionを送出するための例外処理
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			try {
				//データベース接続の解除
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();

			} catch (Exception ex) {
			}

		}
		return ub;
	}

	String selectPassword() {
		String doLogpw = "";
		//DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";

		//DBに接続する際に使うやつ
		Connection cnct = null;

		//SQLを実行するときに使うやつ
		Statement st = null;

		//SQL実行結果を格納するやつ
		ResultSet rs = null;

		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");

			//DBに実際に接続する。
			cnct = DriverManager.getConnection(url, id, pw);

			//接続に失敗した場合SQLExceptionを投げる
			st = cnct.createStatement();

			//SQL文を実行して実行結果をrsに代入している
			rs = st.executeQuery("SELECT * from user");

			//ここのwhile文でrsに格納されている値を一行一行取り出して出力している。
			while (rs.next()) {
				//itemテーブルのidを取得
				doLogpw = rs.getString("login_pw");

			}

			/*引数に指定されたクラスが見つからなかった場合に、
			例外ClassNotFoundExceptionを送出するための例外処理
			*/
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

			//接続に失敗した場合に、例外java.sql.SQLExceptionを送出するための例外処理
		} catch (SQLException ex) {
			ex.printStackTrace();

		}

		finally {
			try {
				//データベース接続の解除
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();

			} catch (Exception ex) {
			}

		}
		return doLogpw;
	}

	String selectCategory(int num) {
		String doCate = "";
		//DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";

		//DBに接続する際に使うやつ
		Connection cnct = null;

		//SQLを実行するときに使うやつ
		Statement st = null;

		//SQL実行結果を格納するやつ
		ResultSet rs = null;


		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");

			//DBに実際に接続する。
			cnct = DriverManager.getConnection(url, id, pw);

			//接続に失敗した場合SQLExceptionを投げる
			st = cnct.createStatement();

			//SQL文を実行して実行結果をrsに代入している
			rs = st.executeQuery("SELECT * from category where cat_id="+num);


			//ここのwhile文でrsに格納されている値を一行一行取り出して出力している。
			while (rs.next()) {
				//itemテーブルのidを取得
				doCate=rs.getString("cat_name");



			}

			/*引数に指定されたクラスが見つからなかった場合に、
			例外ClassNotFoundExceptionを送出するための例外処理
			*/
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

			//接続に失敗した場合に、例外java.sql.SQLExceptionを送出するための例外処理
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {
			try {
				//データベース接続の解除
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();

			} catch (Exception ex) {
			}

		}
		return doCate;

}
}
