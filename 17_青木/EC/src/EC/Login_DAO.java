package EC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Login_DAO {
	public ArrayList<String> catlist = new ArrayList<String>();
	public ArrayList<Integer> cat_idlist = new ArrayList<Integer>();

	public String jdbc(String name, String pass) {
		//参照するパスを変数に格納
		String url = "jdbc:mysql://localhost/ECsite";
		//IDを変数に格納
		String id = "root";
		//パスワードを変数に格納
		String pw = "password";

		String name2 = null;
		//Connectionオブジェクトを生成
		Connection cnct = null;
		//Statementオブジェクトを生成
		PreparedStatement pst = null;
		//ResultSetオブジェクトを生成
		ResultSet rs = null;

		try {
			//JDBCドライバをロード、インスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			//getConnectionメソッドを実行
			//DBとの接続のための処理をDriverManagerクラスに丸投げする
			cnct = DriverManager.getConnection(url, id, pw);
			//createStatementメソッドを実行
			//SQLを入れるための窓口を用意する

			//executeQueryメソッドを実行する
			//実際のSQL文を送信し、結果をrsに代入する
			String query = "SELECT * from user where login_pw = ? AND user_name = ?";
			pst = cnct.prepareStatement(query);
			pst.setString(2, name);
			pst.setString(1, pass);
			rs = pst.executeQuery();
			//全データを取り出すまで繰り返す
			while (rs.next()) {
				//カラム名を指定し、それぞれのデータを取得する
				name2 = rs.getString("user_name");
			}
			//参照すべきクラスが見つからなかった場合の処理
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			//SQLに問題があった場合の処理
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				//rsがnullではないなら処理を終了する
				if (rs != null)
					rs.close();
				//cnctがnullではないなら処理を終了する
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
		return name2;
	}

	public void jdbc2() {
		//参照するパスを変数に格納
		String url = "jdbc:mysql://localhost/ECsite";
		//IDを変数に格納
		String id = "root";
		//パスワードを変数に格納
		String pw = "password";

		//Connectionオブジェクトを生成
		Connection cnct = null;
		//Statementオブジェクトを生成
		Statement st = null;
		//ResultSetオブジェクトを生成
		ResultSet rs = null;

		try {
			//JDBCドライバをロード、インスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			//getConnectionメソッドを実行
			//DBとの接続のための処理をDriverManagerクラスに丸投げする
			cnct = DriverManager.getConnection(url, id, pw);
			//createStatementメソッドを実行
			//SQLを入れるための窓口を用意する

			st = cnct.createStatement();
			rs = st.executeQuery("SELECT * from category ");
			//全データを取り出すまで繰り返す
			while (rs.next()) {
				//カラム名を指定し、それぞれのデータを取得する
				catlist.add(rs.getString("cat_name"));
				cat_idlist.add(rs.getInt("cat_id"));
			}
			//参照すべきクラスが見つからなかった場合の処理
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			//SQLに問題があった場合の処理
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				//rsがnullではないなら処理を終了する
				if (rs != null)
					rs.close();
				//cnctがnullではないなら処理を終了する
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
	}
}
