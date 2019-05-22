package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ECDAO {

	public String[] Access(String name) {

		String[] logins = new String[3];

		String login_name =null;
		String user_id = null;
		String login_pw =null;

		//DBに接続する際に必要な情報を変数に格納
				String url = "jdbc:mysql://localhost/ecsite";
				String id = "root";
				String pw = "password";

				//DBに接続する際に使うやつ
				Connection cnct = null;

				PreparedStatement pst=null;

				//SQLを実行するときに使うやつ
				Statement st = null;

				//SQL実行結果を格納するやつ
				ResultSet rs = null;

				try {
					//MYSQLのJDBCドライバを使うよって定義
					Class.forName("com.mysql.jdbc.Driver");

					//DBに実際に接続する。
					cnct = DriverManager.getConnection(url, id, pw);

					String query ="SELECT * from user where user_name = ?";

					pst = cnct.prepareStatement(query);


					pst.setString(1, name);
					System.out.println(pst);

					rs = pst.executeQuery();

					user_id = null;
					login_pw = null;

					//ここのwhile文でrsに格納されている値を一行一行取り出して出力している。
					while (rs.next()) {
						//itemテーブルのidを取得
						login_name = rs.getString("user_name");
						user_id = rs.getString("user_id");
						login_pw = rs.getString("login_pw");

					}

					logins[0] = user_id;
					logins[1] = login_pw;
					logins[2] = login_name;

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
				return logins;



	}



//ここから
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
