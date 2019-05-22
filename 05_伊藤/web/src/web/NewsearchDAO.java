package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class NewsearchDAO {
	//name検索

	public ArrayList<String> namekensaku(String name){
		ArrayList<String> list = new ArrayList<String>();
		// DBMS への接続
		String url = "jdbc:mysql://localhost/lesson20xx";
		// mysqlに接続するための情報をString型変数idに格納
		String id = "root";
		// mysqlに接続するための情報をString型変数pwに格納
		String pw = "password";

		// DBに接続する際に使うやつ
		Connection cnct = null;
		// SQL実行結果を格納するやつ
		Statement st = null;
		// SQLを実行する際に使うやつ
		ResultSet rs = null;


		//DB接続
		try
		{

			// JDBC ドライバの登録、SQLのJDBCを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(1111);
			// DBに実際に接続、url、id、passwordを使って
			cnct = DriverManager.getConnection(url, id, pw);

			st=cnct.createStatement();
			//nameの前後に "" を付ける
			name="\"" + name +"\"";
			//sqlという変数にselect文を入れる
			String sql ="select * from product where pro_name = "+name;
			System.out.println(sql);



			rs = st.executeQuery(sql);
			//リストにぶち込む
			while(rs.next()) {
				//商品の名前を取ってくる
				list.add(rs.getString("pro_name"));
				//商品の価格を取ってくる
				list.add(rs.getString("pro_price"));
				//商品の詳細を取ってくる
				list.add(rs.getString("pro_cd"));
			}
			//listを返す
			return list;

		}catch(ClassNotFoundException ex){
			System.out.println("ClassNotFound");
			ex.printStackTrace();
			return list;

			//SQLに問題があった時
		}catch(Exception ex){
			System.out.println("SQLException");
			ex.printStackTrace();
			return list;


			// 必ず行う処理
		}finally{

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

	//category検索

	public ArrayList<String> catkensaku(String cat){
		ArrayList<String> list = new ArrayList<String>();
		// DBMS への接続
		String url = "jdbc:mysql://localhost/lesson20xx";
		// mysqlに接続するための情報をString型変数idに格納
		String id = "root";
		// mysqlに接続するための情報をString型変数pwに格納
		String pw = "password";

		// DBに接続する際に使うやつ
		Connection cnct = null;
		// SQL実行結果を格納するやつ
		Statement st = null;
		// SQLを実行する際に使うやつ
		ResultSet rs = null;


		//DB接続
		try
		{

			// JDBC ドライバの登録、SQLのJDBCを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(12);
			// DBに実際に接続、url、id、passwordを使って
			cnct = DriverManager.getConnection(url, id, pw);

			st=cnct.createStatement();
			//nameの前後に "" を付ける
			cat="\"" + cat +"\"";
			//sqlという変数にselect文を入れる
			String sql ="select * from product where cat_id = "+cat;
			System.out.println(sql);


			//
			rs = st.executeQuery(sql);
			//リストにぶち込む
			while(rs.next()) {
				//商品の名前を取ってくる
				list.add(rs.getString("pro_name"));
				//商品の価格を取ってくる
				list.add(rs.getString("pro_price"));
				//商品の詳細を取ってくる
				list.add(rs.getString("pro_cd"));
			}
			//listを返す
			return list;

		}catch(ClassNotFoundException ex){
			System.out.println("ClassNotFound");
			ex.printStackTrace();
			return list;

			//SQLに問題があった時
		}catch(Exception ex){
			System.out.println("SQLException");
			ex.printStackTrace();
			return list;


			// 必ず行う処理
		}finally{


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
