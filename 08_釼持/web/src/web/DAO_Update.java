package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Update {
	void insert(int a, int b, int c, int d) {
		//DBに接続する際に必要な情報を変数に格納
		//URL(jdbc:mysql://ホスト名:ポート番号/データベース名)
		String url = "jdbc:mysql://localhost/sekkei";
		//ID
		String id = "root";
		//PASSWORD
		String pw = "password";

		//DBに接続する際に使う
		Connection cnct = null;
		//SQLを実行するときに使う
		Statement st = null;
		//問い合わせの結果に行単位でアクセスするためのコンテナオブジェクト
		//SQLを実行結果を格納する
		ResultSet rs = null;

		PreparedStatement pst = null;

		try {
			//ドライバのロードとインスタンス化
			//MYSQLのJDBCドライバを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			//DBMSに接続
			cnct = DriverManager.getConnection(url, id, pw);
			//接続に失敗した場合エラーを投げる
			//st = cnct.createStatement();
			//itemのデータベース
			//SQL文の実行,結果をrsに代入
			//rs = st.executeQuery("SELECT * from product where pro_cd = " + num);
			//rsを1行ずつ(次の行がない場合false)
			cnct.setAutoCommit(false);
			pst = cnct.prepareStatement("insert into meisai values (null,?,?,now(),?)");
			try {
				int zeikomi = (int) ((c * d) * 1.08);
				pst.setInt(1, a);
				pst.setInt(2, b);
				pst.setInt(3, zeikomi);

				pst.executeUpdate();
				cnct.commit();
			} catch (SQLException ex) {
				//エラー表示
				ex.printStackTrace();
				cnct.rollback();
			}
			//クラスが見つからなかったら
		} catch (ClassNotFoundException ex) {
			//エラー表示
			ex.printStackTrace();

		} //SQLExceptionのエラーが出たら

		catch (SQLException ex) {
			//エラー表示
			ex.printStackTrace();
		} finally {
			try {
				//rsがnullでなければ
				if (rs != null)
					//rsを接続を解除
					rs.close();
				//stがnullでなければ
				if (st != null)
					//stを接続を解除
					st.close();
				//cnctがnullでなければ
				if (cnct != null)
					//cnctを接続を解除
					cnct.close();
			} //Exceptionのエラーが出たら
			catch (Exception ex) {
			}
		}
	}

	void zaikoUP(int a, int b) {
		//DBに接続する際に必要な情報を変数に格納
		//URL(jdbc:mysql://ホスト名:ポート番号/データベース名)
		String url = "jdbc:mysql://localhost/sekkei";
		//ID
		String id = "root";
		//PASSWORD
		String pw = "password";

		//DBに接続する際に使う
		Connection cnct = null;
		//SQLを実行するときに使う
		Statement st = null;
		//問い合わせの結果に行単位でアクセスするためのコンテナオブジェクト
		//SQLを実行結果を格納する
		ResultSet rs = null;

		PreparedStatement pst = null;

		try {
			//ドライバのロードとインスタンス化
			//MYSQLのJDBCドライバを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			//DBMSに接続
			cnct = DriverManager.getConnection(url, id, pw);
			//接続に失敗した場合エラーを投げる
			//st = cnct.createStatement();
			//itemのデータベース
			//SQL文の実行,結果をrsに代入
			//rs = st.executeQuery("SELECT * from product where pro_cd = " + num);
			//rsを1行ずつ(次の行がない場合false)
			cnct.setAutoCommit(false);
			pst = cnct.prepareStatement("update product set stock_no = (stock_no - ?) where pro_cd=?");
			try {
				pst.setInt(1, a);
				pst.setInt(2, b);

				pst.executeUpdate();
				cnct.commit();
			} catch (SQLException ex) {
				//エラー表示
				ex.printStackTrace();
				cnct.rollback();
			}
			//クラスが見つからなかったら
		} catch (ClassNotFoundException ex) {
			//エラー表示
			ex.printStackTrace();

		} //SQLExceptionのエラーが出たら

		catch (SQLException ex) {
			//エラー表示
			ex.printStackTrace();
		} finally {
			try {
				//rsがnullでなければ
				if (rs != null)
					//rsを接続を解除
					rs.close();
				//stがnullでなければ
				if (st != null)
					//stを接続を解除
					st.close();
				//cnctがnullでなければ
				if (cnct != null)
					//cnctを接続を解除
					cnct.close();
			} //Exceptionのエラーが出たら
			catch (Exception ex) {
			}
		}
	}
}
