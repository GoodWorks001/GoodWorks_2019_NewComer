package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DetailDAO {

	public ArrayList<String> checkID(int n) {
		//url id pw を設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";


		//DBに接続する際のつかうやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQLを実行するのに使うやつ
		ResultSet rs = null;



		ArrayList<String> alist = new ArrayList<String>();

		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
			//DBに接続する
			cnct = DriverManager.getConnection(url,id,pw);

			//接続に失敗したらSQLExceptionを投げる
			//失敗した場合の布石
			st = cnct.createStatement();

			String query = null;
			query = "SELECT * FROM product WHERE pro_cd ="+ n;
			System.out.println(query);

			rs = st.executeQuery(query);

			DetailBean db = new DetailBean();
			while(rs.next()) {
				db.setPro_cd(Integer.parseInt(rs.getString("pro_cd")));
				db.setPro_name(rs.getString("pro_name"));
				db.setStock_no(rs.getInt("stock_no"));
				//db.setCat_id();
				db.setPro_img(rs.getString("pro_img"));
				db.setPro_msg(rs.getString("pro_msg"));


				alist.add(rs.getString("pro_name"));
				alist.add(rs.getString("pro_price"));
				alist.add(rs.getString("stock_no"));
				alist.add(rs.getString("pro_msg"));
				alist.add(rs.getString("pro_img"));
				alist.add(rs.getString("cat_id"));
				alist.add(rs.getString("pro_cd"));

			}
			return alist;
		}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
			ex.printStackTrace();
			return null;
		}catch(SQLException ex) {//SQLExceptionがでたらここ
			ex.printStackTrace();
			return null;
		} finally {//ここは絶対に実行
			try {
				//接続を解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			}catch(Exception ex) {}
		}

	}


	//在庫の情報取得
	//こっちを使用
	public int setZaiko2(int n) {

		int zaiko = 0;

		//url id pw を設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";


		//DBに接続する際のつかうやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQLを実行するのに使うやつ
		ResultSet rs = null;



		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
			//DBに接続する
			cnct = DriverManager.getConnection(url,id,pw);

			//接続に失敗したらSQLExceptionを投げる
			//失敗した場合の布石
			st = cnct.createStatement();

			String query = null;
			query = "SELECT * FROM product WHERE pro_cd ="+ n;
			System.out.println(query);

			rs = st.executeQuery(query);


			while(rs.next()) {
				zaiko=rs.getInt("stock_no");

			}
			return zaiko;
		}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
			ex.printStackTrace();
			return zaiko;
		}catch(SQLException ex) {//SQLExceptionがでたらここ
			ex.printStackTrace();
			return zaiko;
		} finally {//ここは絶対に実行
			try {
				//接続を解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			}catch(Exception ex) {}
		}

	}


	//使ってない
	public DetailBean setZaiko(int n) {
		//url id pw を設定
				String url = "jdbc:mysql://localhost/lesson20xx";
				String id = "root";
				String pw = "password";


				//DBに接続する際のつかうやつ
				Connection cnct = null;
				//SQL実行結果を格納するやつ
				Statement st = null;
				//SQLを実行するのに使うやつ
				ResultSet rs = null;



				try {
					//MYSQLのJDBCドライバを使うよって定義
					Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
					//DBに接続する
					cnct = DriverManager.getConnection(url,id,pw);

					//接続に失敗したらSQLExceptionを投げる
					//失敗した場合の布石
					st = cnct.createStatement();

					String query = null;
					query = "SELECT * FROM product WHERE pro_cd ="+ n;
					System.out.println(query);

					rs = st.executeQuery(query);

					DetailBean db = new DetailBean();
					while(rs.next()) {
						db.setStock_no(rs.getInt("stock_no"));

					}
					return db;
				}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
					ex.printStackTrace();
					return null;
				}catch(SQLException ex) {//SQLExceptionがでたらここ
					ex.printStackTrace();
					return null;
				} finally {//ここは絶対に実行
					try {
						//接続を解除
						if (rs!=null) rs.close();
						if (st!=null) st.close();
						if (cnct!=null) cnct.close();
					}catch(Exception ex) {}
				}
	}

}
