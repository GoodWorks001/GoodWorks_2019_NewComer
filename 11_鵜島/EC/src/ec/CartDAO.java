package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CartDAO {


	public ArrayList<String> checkCart(int n) {
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

			while(rs.next()) {

				alist.add(rs.getString("pro_name")); //0
				alist.add(rs.getString("pro_price")); //1
				alist.add(rs.getString("stock_no")); //2
				alist.add(rs.getString("pro_msg")); //3
				alist.add(rs.getString("pro_img")); //4
				alist.add(rs.getString("cat_id")); //5
				alist.add(rs.getString("pro_cd")); //6

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


}
