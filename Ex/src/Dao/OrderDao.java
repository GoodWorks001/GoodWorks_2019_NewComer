package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDao {

	//明細に情報を書き込むメソッド
	public void InsertMeisai(int mei_id, String user_id, int pro_cd, Date ko_date, int mei_price) {

		//DBを開く為のパスを変数に入れておく
		String url = "jdbc:mysql://localhost/ecSite";
		String id = "root";
		String pw = "password";

		//JDBCの部品群
		//接続したSQLを格納する変数
		Connection cnct = null;

		PreparedStatement pst = null;

		//SQLの実行結果を格納する変数
		Statement st = null;
		//SQLを実行する変数
		ResultSet rs = null;

		try {
			//MySQLのJDBCドライバを使う為の定義（登録）
			Class.forName("com.mysql.jdbc.Driver");
			//DBに接続し、その状態をcnctに代入
			cnct = DriverManager.getConnection(url, id, pw);

			String query = "Insert into meisai value (?,?,?,?,?)";

			//プリコンパイルの使用準備が完了
			pst = cnct.prepareStatement(query);

			//？に値を代入
			pst.setInt(1, mei_id);
			pst.setInt(2, Integer.parseInt(user_id));
			pst.setInt(3, pro_cd);
			pst.setDate(4, ko_date);
			pst.setInt(5, mei_price);

			System.out.println(pst);

			//更新を適応させる
			pst.executeUpdate();
			System.out.println("適応しました");

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
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();

			} catch (Exception ex) {
			}
		}

	}

	//在庫をアップデートするメソッド
	public void setZaiko(int pro_id,int newStock) {

		//DBを開く為のパスを変数に入れておく
		String url = "jdbc:mysql://localhost/ecSite";
		String id = "root";
		String pw = "password";

		//JDBCの部品群
		//接続したSQLを格納する変数
		Connection cnct = null;

		PreparedStatement pst = null;

		//SQLの実行結果を格納する変数
		Statement st = null;
		//SQLを実行する変数
		ResultSet rs = null;

		try {
			//MySQLのJDBCドライバを使う為の定義（登録）
			Class.forName("com.mysql.jdbc.Driver");
			//DBに接続し、その状態をcnctに代入
			cnct = DriverManager.getConnection(url, id, pw);

			String query = "update product set stock_no = ? where pro_cd = ?";

			//プリコンパイルの使用準備が完了
			pst = cnct.prepareStatement(query);

			//？に値を代入
			pst.setInt(1, newStock);
			pst.setInt(2, pro_id);

			System.out.println(pst);

			//更新を適応させる
			pst.executeUpdate();
			System.out.println("適応しました");

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
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();

			} catch (Exception ex) {
			}
		}

	}

	//明細のIDを取り出すメソッド
	public int getId() {

		//DBから値を受け取る為の変数
		int mei_id = 0;

		//DBを開く為のパスを変数に入れておく
		String url = "jdbc:mysql://localhost/ecSite";
		String id = "root";
		String pw = "password";

		//JDBCの部品群
		//接続したSQLを格納する変数
		Connection cnct = null;

		PreparedStatement pst = null;

		//SQLの実行結果を格納する変数
		Statement st = null;
		//SQLを実行する変数
		ResultSet rs = null;

		try {
			//MySQLのJDBCドライバを使う為の定義（登録）
			Class.forName("com.mysql.jdbc.Driver");
			//DBに接続し、その状態をcnctに代入
			cnct = DriverManager.getConnection(url, id, pw);

			String query = "select * from meisai where mei_id =(select max(mei_id) from meisai)";

			//プリコンパイルの使用準備が完了
			pst = cnct.prepareStatement(query);

			System.out.println(pst);

			//SQLの実行を行い、結果をrsに代入
			rs = pst.executeQuery();

			//rsに格納されているテーブル内の全要素を表示するまで繰り返す
			//.next()で行を移動させる（もうレコードがない場合はfalseになる）
			while (rs.next()) {

				//getStringメソッドで指定した文字列と
				//同じ名前のカラムに入っているレコードを呼び出す
				mei_id = rs.getInt("mei_id");

			}

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
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();

			} catch (Exception ex) {
			}
		}

		return mei_id;

	}

}
