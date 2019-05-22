package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginDAO {

	public String name;
	public String pass;

	boolean ble = false;
	LoginBean bean = new LoginBean();

	public LoginBean getBean() {
		return bean;
	}

	public void setBean(LoginBean bean) {
		this.bean = bean;
	}

	boolean JDBC(String name, String pass) {
		// DBMS への接続
		// mysqlにログインに必要な id と password を変数に格納
		String url = "jdbc:mysql://localhost/lesson20xx";

		// プロトコル名：JDBCドライバの識別子：DBMSの識別子、アドレス等
		String id = "root";
		String pw = "password";

		// DBに接続する際に使うやつ
		Connection cnct = null;
		// SQL実行結果を格納するやつ
		Statement st = null;
		// SQLを実行する際に使うやつ
		ResultSet rs = null;

		try {

			// JDBC ドライバの登録、SQLのJDBCを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(1);
			// DBに実際に接続、url、id、passwordを使って
			cnct = DriverManager.getConnection(url, id, pw);
			System.out.println(2);
			// 接続に失敗した時にSQLExceptionを投げる
			st = cnct.createStatement();
			System.out.println(3);

			name = "\"" + name + "\"";
			pass = "\"" + pass + "\"";
			// SQL文の実行を行う
			rs = st.executeQuery("SELECT * from user where user_name=" + name + " AND login_pw=" + pass);
			System.out.println(4);

			// while文でrsに格納されている
			// rs.nextで１行１行下に行くのをwhileで繰り返し、一番下まで行くと終わり

			ble = rs.next();
			if (ble == true) {

				System.out.println(100000);
				// レコードのカラム値を取り出すメソッド
				bean.setUser_id(rs.getInt("user_id"));
				bean.setName(rs.getString("user_name"));
				bean.setPw(rs.getString("login_pw"));

			}

			return ble;

		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFound");
			ex.printStackTrace();
			return ble;
		} catch (SQLException ex) {
			System.out.println("SQLException");
			ex.printStackTrace();
			return ble;

			// 必ず行う処理
		} finally {

			try {
				// close メソッドでDBとの接続を解除
				// ゲームが終わったら電源切るのと同じ
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
