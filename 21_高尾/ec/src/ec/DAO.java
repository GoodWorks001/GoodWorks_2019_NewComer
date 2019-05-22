package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {

	public boolean login(String name , String pass) {
		//mysqlのecsite2019を読み込む
		boolean flg = false;
		String url = "jdbc:mysql://localhost/ecsite2019";
		String id = "root";
		String pw = "password";
		//DBに接続する際に使う
		Connection cnct =null;
		//SQLを実行する際に使う
		Statement st = null;
		//SQL実行結果を格納するやつ
		ResultSet rs =null;

		try {
			//MYSQLのJDBCドライバを使うための定義
			Class.forName("com.mysql.jdbc.Driver");
			//DBに実際に接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//接続に失敗した場合SQLExceptionを投げる
			st = cnct.createStatement();
			//SQL文の実行を行っています。
			name = "\"" + name + "\"";
			pass = "\"" + pass + "\"";
			//実行結果をrsに代入している
			String sql = "select * from user where user_name = " + name + " AND login_pw = " + pass;
			System.out.println(sql);
			rs = st.executeQuery(sql);
			//ここのwhile文でrsに格納されている。
			//値を一行一行取り出して出力している。
			while(rs.next()) {
				flg = true;
			}
			//うぇーい
			return flg;
		} catch (Exception e) {
			return flg;
		}
	}
	//カテゴリ検索
	public ArrayList<String> Catkensaku(String cate) {
		//mysqlのecsite2019を読み込む
		ArrayList<String> list = new ArrayList<String>();
		String url = "jdbc:mysql://localhost/ecsite2019";
		String id = "root";
		String pw = "password";
		//DBに接続する際に使う
		Connection cnct =null;
		//SQLを実行する際に使う
		Statement st = null;
		//SQL実行結果を格納するやつ
		ResultSet rs =null;

		try {
			//MYSQLのJDBCドライバを使うための定義
			Class.forName("com.mysql.jdbc.Driver");
			//DBに実際に接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//接続に失敗した場合SQLExceptionを投げる
			st = cnct.createStatement();
			//nameの前後にダブルコーテーションをつける。
			cate = "\"" + cate + "\"";
			//sql変数にselect文をぶっこむ
			String sql = "select * from product where cat_id =" + cate;
			System.out.println(sql);
			//select文実行
			rs = st.executeQuery(sql);


			//リストに突っ込む
			while(rs.next()) {
			list.add(rs.getString("pro_name"));
			list.add(rs.getString("pro_price"));
			list.add(rs.getString("pro_cd"));
			}

			//うぇーい
			return list;
		} catch (Exception e) {
			return list;
		}

	}
	//name検索
	public ArrayList<String> kensaku(String name) {
		//mysqlのecsite2019を読み込む
		ArrayList<String> list = new ArrayList<String>();
		String url = "jdbc:mysql://localhost/ecsite2019";
		String id = "root";
		String pw = "password";
		//DBに接続する際に使う
		Connection cnct =null;
		//SQLを実行する際に使う
		Statement st = null;
		//SQL実行結果を格納するやつ
		ResultSet rs =null;

		try {
			//MYSQLのJDBCドライバを使うための定義
			Class.forName("com.mysql.jdbc.Driver");
			//DBに実際に接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//接続に失敗した場合SQLExceptionを投げる
			st = cnct.createStatement();
			//nameの前後にダブルコーテーションをつける。
			name = "\"" + name + "\"";
			//sql変数にselect文をぶっこむ
			String sql = "select * from product where pro_name =" + name;
			System.out.println(sql);
			//select文実行
			rs = st.executeQuery(sql);

			//リストに突っ込む
			while(rs.next()) {
			list.add(rs.getString("pro_name"));
			list.add(rs.getString("pro_price"));
			list.add(rs.getString("pro_cd"));
			}

			//うぇーい
			return list;
		} catch (Exception e) {
			return list;
		}
	}

	public String username(String name) {
		//mysqlのecsite2019を読み込む
		String result = null;
		String url = "jdbc:mysql://localhost/ecsite2019";
		String id = "root";
		String pw = "password";
		//DBに接続する際に使う
		Connection cnct =null;
		//SQLを実行する際に使う
		Statement st = null;
		//SQL実行結果を格納するやつ
		ResultSet rs =null;

		try {
			//MYSQLのJDBCドライバを使うための定義
			Class.forName("com.mysql.jdbc.Driver");
			//DBに実際に接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//接続に失敗した場合SQLExceptionを投げる
			st = cnct.createStatement();
			//SQL文の実行を行っています。
			name = "\"" + name + "\"";
			//実行結果をrsに代入している
			String sql = "select * from user where user_name = " + name;
			rs = st.executeQuery(sql);
			//ここのwhile文でrsに格納されている。
			//値を一行一行取り出して出力している。
			while(rs.next()) {
				result = rs.getString("user_id");
			}
			//うぇーい
			return result;
		} catch (Exception e) {
			return result;
		}
	}


}