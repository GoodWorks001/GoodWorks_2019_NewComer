package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchDAO {

	//DBに接続する際のつかうやつ
	Connection cnct = null;
	//SQL実行結果を格納するやつ
	Statement st = null;
	//SQLを実行するのに使うやつ
	ResultSet rs = null;
	PreparedStatement pst = null;

	public boolean test;

	private  ArrayList<SearchBean> list = new ArrayList<SearchBean>();



	public ArrayList<String> listnamere = new ArrayList<String>();
	public ArrayList<Integer> listpricere = new ArrayList<Integer>();
	public ArrayList<Integer> listcdre = new ArrayList<Integer>();


	//キーワード検索
	public ArrayList<String> checkKeyword(String search){

		//url id pw を設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";

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
			query = "SELECT * FROM product WHERE pro_name ='"+ search + "'";
			System.out.println(query);

			rs = st.executeQuery(query);
			while(rs.next()) {
				alist.add(rs.getString("pro_name"));
				System.out.println(rs.getString("pro_name"));
				alist.add(rs.getString("pro_price"));
				System.out.println(rs.getString("pro_price"));
				alist.add(rs.getString("pro_cd"));
			}
			return alist;
		}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
			ex.printStackTrace();
			return alist;
		}catch(SQLException ex) {//SQLExceptionがでたらここ
			ex.printStackTrace();
			return alist;
		} finally {//ここは絶対に実行
			try {
				//接続を解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			}catch(Exception ex) {}
		}

	}


	//カテゴリー
	public ArrayList<String> checkCategory(String search){

		//url id pw を設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";

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
			query = "SELECT * FROM product WHERE cat_id ="+ search ;
			System.out.println(query);

			rs = st.executeQuery(query);
			while(rs.next()) {
				alist.add(rs.getString("pro_name"));
				alist.add(rs.getString("pro_price"));
				alist.add(rs.getString("pro_cd"));
			}
			return alist;
		}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
			ex.printStackTrace();
			return alist;
		}catch(SQLException ex) {//SQLExceptionがでたらここ
			ex.printStackTrace();
			return alist;
		} finally {//ここは絶対に実行
			try {
				//接続を解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			}catch(Exception ex) {}
		}
	}




	//キーワード検索
		public boolean boolKeyword(String search){

			//url id pw を設定
			String url = "jdbc:mysql://localhost/lesson20xx";
			String id = "root";
			String pw = "password";

			ArrayList<String> alist = new ArrayList<String>();

			boolean flag = false;


			try {
				//MYSQLのJDBCドライバを使うよって定義
				Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
				//DBに接続する
				cnct = DriverManager.getConnection(url,id,pw);

				//接続に失敗したらSQLExceptionを投げる
				//失敗した場合の布石
				st = cnct.createStatement();

				String query = null;
				query = "SELECT * FROM product WHERE pro_name ='"+ search + "'";
				System.out.println(query);

				rs = st.executeQuery(query);
				while(rs.next()) {
					flag = true;

				}
				return flag;
			}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
				ex.printStackTrace();
				return flag;
			}catch(SQLException ex) {//SQLExceptionがでたらここ
				ex.printStackTrace();
				return flag;
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
