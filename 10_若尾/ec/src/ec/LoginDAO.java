package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	private userBean ub = new userBean();

	public userBean getUb() {
		return ub;
	}

	public void setUb(userBean ub) {
		this.ub = ub;
	}

	public boolean login(String name , String pass) {
		boolean flg = false;
		System.out.println("DAOjdbcを開始しました");

		// DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/ecdb01";// DBの位置を特定
		String id = "root";
		String pw = "password";

		// DBに接続する際に使うやつ
		Connection cnct = null;// 接続に失敗した場合,例外を送出する
		// SQL実行結果を格納するやつ
		Statement st = null;// プリコンパイルなどをしない単純なSQLに使用
		// SQLを実行するときにつかうやつ
		ResultSet rs = null;// レコードごとにデータをアクセス

		// try文
		try {

			// MySQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");
			// DBに実際に接続する
			cnct = DriverManager.getConnection(url, id, pw);
			// 接続に失敗した際にSQLExceptionを投げる
			st = cnct.createStatement();

			name = "\"" + name + "\"";
			System.out.println(name);
			pass = "\"" + pass + "\"";
			System.out.println(pass);
			// SQL文の実行を行っています
			// 実行結果をrsに代入している
			rs = st.executeQuery("SELECT * from user where user_name=" + name + " AND login_pw=" + pass);

            flg = rs.next();

            if(flg == true) {

            	ub.setId(rs.getInt("user_id"));
            	ub.setName(rs.getString("user_name"));
            	ub.setCd(rs.getString("login_cd"));
            	ub.setPass(rs.getString("login_pw"));
            }


			return flg;

		}
		// catch文
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return flg;
		} catch (SQLException ex1) {
			ex1.printStackTrace();
			return flg;
		} finally {
			// 下記
			try {
				// 各クラス・インターフェースにあるclose()メソッドで
				// 接続を解除する
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

