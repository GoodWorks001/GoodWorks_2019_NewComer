package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InsertDao {

	public void insert(int count , int user_id , int all , String pro_cd) throws SQLException {
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		PreparedStatement pst = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			System.out.println("C");

			//自動コミットモードの解除
			cnct.setAutoCommit(false);

			//Calendarクラスのオブジェクトを生成する
			Calendar cl = Calendar.getInstance();
			//SimpleDateFormatクラスでフォーマットパターンを設定する
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdf.format(cl.getTime()));

			//明細情報をinsertする
			String sql = "insert into meisai2 values( " + count + ", " + user_id + "," + pro_cd + ",'" + sdf.format(cl.getTime()) + "'," +all + ")";
			//insert文確認
			System.out.println(sql);
			//pstに格納
			pst = cnct.prepareStatement(sql);
			System.out.println("D");
			//もっかい確認
			System.out.println(pst);
			//insert文実行
			pst.executeUpdate();
			//コミットしてるよ
			cnct.commit();
			System.out.println("コミットしました");
			System.out.println("insert文正常に作動しました");
		} catch(ClassNotFoundException ex){
			//↑クラス関連のエラーハンドリング
			System.out.println("クラスでミスってるよ");
		} catch(SQLException ex) {
			ex.printStackTrace();
			//↑SQL関連のエラーハンドリング
			System.out.println("メソッドのSQLミスってるよ");
			cnct.rollback();
			System.out.println("ロールバックしました");
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (pst!=null) pst.close();
				if (cnct!=null) cnct.close();
				System.out.println("insertメソッド完了");
			} catch(Exception ex) { }
		}
	}





	//鵜島追加

	public void Testinsert( int user_id , int all , int pro_cd) throws SQLException {
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		PreparedStatement pst = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			System.out.println("C");

			//自動コミットモードの解除
			cnct.setAutoCommit(false);

			//Calendarクラスのオブジェクトを生成する
			Calendar cl = Calendar.getInstance();
			//SimpleDateFormatクラスでフォーマットパターンを設定する
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdf.format(cl.getTime()));

			//明細情報をinsertする
			String sql = "insert into meisai2 (user_id,pro_cd,ko_date,mei_price) values( " + user_id + "," + pro_cd + ",'" + sdf.format(cl.getTime()) + "'," +all + ")";
			//insert文確認
			System.out.println(sql);
			//pstに格納
			pst = cnct.prepareStatement(sql);
			System.out.println("D");
			//もっかい確認
			System.out.println(pst);
			//insert文実行
			pst.executeUpdate();
			//コミットしてるよ
			cnct.commit();
			System.out.println("コミットしました");
			System.out.println("insert文正常に作動しました");
		} catch(ClassNotFoundException ex){
			//↑クラス関連のエラーハンドリング
			System.out.println("クラスでミスってるよ");
		} catch(SQLException ex) {
			ex.printStackTrace();
			//↑SQL関連のエラーハンドリング
			System.out.println("メソッドのSQLミスってるよ");
			cnct.rollback();
			System.out.println("ロールバックしました");
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (pst!=null) pst.close();
				if (cnct!=null) cnct.close();
				System.out.println("insertメソッド完了");
			} catch(Exception ex) { }
		}
	}








	public boolean meisaiNo() {
		boolean flg = false;
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			st = cnct.createStatement();
			System.out.println("C");
			String sql = "select * from meisai";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			System.out.println("D");
			//内容が取り出せているなら
			while(rs.next()){
				//二回目以降の明細を作ることを伝える
				flg = true;
				System.out.println("E");
			}
			System.out.println("F");
			//trueの結果を返す
			return flg;
			//クラス関連のエラーハンドリング
		} catch(ClassNotFoundException ex){
			System.out.println("JDBCねえよ？");
			return flg;
			//SQL関連のエラーハンドリング
		} catch(SQLException ex) {
			System.out.println("SQLミスってるよ？");
			return flg;
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				System.out.println("初期変数取得メソッド終了");
			} catch(Exception ex) { }
		}
	}
	public int getNo() {
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			st = cnct.createStatement();
			System.out.println("C");
			String sql = "select * from meisai";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			System.out.println("D");
			int num = 0;
			//内容が取り出せているなら
			while(rs.next()){
				//明細主キーの最終番号取得
				num = rs.getInt("mei_id");
			}
			System.out.println("F");
			//明細主キーの最終番号を返す
			return num;
			//クラス関連のエラーハンドリング
		} catch(ClassNotFoundException ex){
			System.out.println("JDBCねえよ？");
			//SQL関連のエラーハンドリング
			int num = 1;
			return num;
		} catch(SQLException ex) {
			System.out.println("SQLミスってるよ？");
			//最後に必ず行う処理
			int num = 1;
			return num;
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				System.out.println("初期変数変更メソッド終了");
			} catch(Exception ex) { }
		}
	}

}
