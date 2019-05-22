package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateDAO {
	void insert(int a, int b, int c, int d) {

		// 入るデータベース
		String url = "jdbc:mysql://localhost/sekkei";
		// ログインするときのユーザー名
		String id = "root";
		// ログインするときのパスワード
		String pw = "password";
		// DBに接続する際に使うやつ
		Connection cnct = null;
		// SQLを実行するときにつかうやつ
		// Statement st = null;
		// SQL実行結果を格納するやつ
		ResultSet rs = null;
		PreparedStatement pst = null;

		try {
			// JDBCドライバのロードとインスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			// DBMSに接続
			/* Connection */ cnct = DriverManager.getConnection(url, id, pw);
			cnct.setAutoCommit(false);
			// 接続に失敗した場合エラーを投げる
			/* Statement */ pst = cnct.prepareStatement("insert into meisai values (null,?,?,now(),?)");
			try {
				int zeikomi = (int) ((c * d) * 1.08);
				pst.setInt(1, a);
				pst.setInt(2, b);
				pst.setInt(3, zeikomi);
				// 検索する条件を書く
				// 実行結果を変数に代入
				/* ResultSet */pst.executeUpdate();
				cnct.commit();
				// レコードが後ろに存在すればtrue
			} catch (SQLException ex) {
				ex.printStackTrace();
				cnct.rollback();
			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
			// 下記行でDBの接続を解除している
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}

	}

	void zaikoUP(int a, int b) {
		// 入るデータベース
		String url = "jdbc:mysql://localhost/sekkei";
		// ログインするときのユーザー名
		String id = "root";
		// ログインするときのパスワード
		String pw = "password";
		// DBに接続する際に使うやつ
		Connection cnct = null;
		// SQLを実行するときにつかうやつ
		// Statement st = null;
		// SQL実行結果を格納するやつ
		ResultSet rs = null;
		PreparedStatement pst = null;

		try {
			// JDBCドライバのロードとインスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			// DBMSに接続
			/* Connection */ cnct = DriverManager.getConnection(url, id, pw);
			cnct.setAutoCommit(false);
			// 接続に失敗した場合エラーを投げる
			/* Statement */ pst = cnct.prepareStatement("update product set stock_no = (stock_no - ?) where pro_cd=?");
			try {

				pst.setInt(1, a);
				pst.setInt(2, b);
				// 検索する条件を書く
				// 実行結果を変数に代入
				/* ResultSet */pst.executeUpdate();
				cnct.commit();
				// レコードが後ろに存在すればtrue
			} catch (SQLException ex) {
				ex.printStackTrace();
				cnct.rollback();
			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
			// 下記行でDBの接続を解除している
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
	}
}
