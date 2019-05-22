package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchArraysDao {

	//JDBCへの接続と処理を行うメソッド
	//商品の検索を行う物のうち、ArrayList型で返すものをここに書く

	//命令と検索する単語、検索するカラムと取り出す値のカラムを設定する場合
	public ArrayList<String> Access(String qe, String column, String searchPass, String getObj) {

		//DBから値を受け取る為のリスト群
		ArrayList<String> list = new ArrayList<String>();

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

			String query = "SELECT * " + qe + column + "?";

			//プリコンパイルの使用準備が完了
			pst = cnct.prepareStatement(query);

			//？に値を代入
			pst.setString(1, searchPass);
			System.out.println(pst);

			//SQLの実行を行い、結果をrsに代入
			rs = pst.executeQuery();

			//rsに格納されているテーブル内の全要素を表示するまで繰り返す
			//.next()で行を移動させる（もうレコードがない場合はfalseになる）
			while (rs.next()) {

				//getStringメソッドで指定した文字列と
				//同じ名前のカラムに入っているレコードを呼び出す
				list.add(rs.getString(getObj));

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

		return list;

	}

	//命令と検索するカラム、取り出す値のカラムを設定する場合
	public ArrayList<String> Access(String qe, String column, String getObj) {

		//DBから値を受け取る為のリスト群
		ArrayList<String> list = new ArrayList<String>();

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

			String query = "SELECT * " + qe + column;

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
				list.add(rs.getString(getObj));

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

		return list;

	}

}
