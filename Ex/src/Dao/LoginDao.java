package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	//JDBCへの接続と処理を行うメソッド
	public String[] Access(String name) {

		String[] logins = new String[3];

		String login_name = null;
		String login_id = null;
		String login_pw = null;

		//DBを開く為のパスを変数に入れておく
		String url = "jdbc:mysql://localhost/ecSite";
		String id = "root";
		String pw = "password";

		//JDBCの部品群
		//接続したSQLを格納する変数
		Connection cnct = null;

		PreparedStatement pst = null;
		//SQLを実行する変数
		ResultSet rs = null;

		try {
			//MySQLのJDBCドライバを使う為の定義（登録）
			Class.forName("com.mysql.jdbc.Driver");
			//DBに接続し、その状態をcnctに代入
			cnct = DriverManager.getConnection(url, id, pw);

			String query = "SELECT * from user where user_name = ?";

			//プリコンパイルの使用準備が完了
			pst = cnct.prepareStatement(query);

			//？に値を代入
			pst.setString(1, name);
			System.out.println(pst);

			//SQLの実行を行い、結果をrsに代入
			rs = pst.executeQuery();

			login_id = null;
			login_pw = null;

			//rsに格納されているテーブル内の全要素を表示するまで繰り返す
			//.next()で行を移動させる（もうレコードがない場合はfalseになる）
			while (rs.next()) {

				//getStringメソッドで指定した文字列と
				//同じ名前のカラムに入っているレコードを呼び出す
				login_name=rs.getString("user_name");
				login_id = rs.getString("user_id");
				login_pw = rs.getString("login_pw");

			}

			//値を代入
			logins[0] = login_id;
			logins[1] = login_pw;
			logins[2] = login_name;

			//JDBCドライバがなければcatch
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		//MySQLに接続できなければcatch
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		//全ての処理が終わったら
		//開いていたデータベースや接続を閉じる
		finally {
			try {
				if (rs != null)
					rs.close();
				if (cnct != null)
					cnct.close();

			} catch (Exception ex) {
			}
		}

		return logins;

	}

}
