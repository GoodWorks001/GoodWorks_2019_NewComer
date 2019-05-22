package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class kounyuuDAO {

	public void insert(int pro_id, int user_id, int count, int money) {

		// kensakuDAOのkennsakuメソッドの開始の確認
		System.out.println("resultDAOを開始しました");

		// DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/ecdb01";// DBの位置を特定
		String id = "root";
		String pw = "password";

		// DBに接続する際に使うやつ
		Connection cnct = null;// 接続に失敗した場合,例外を送出する
		// SQL実行結果を格納するやつ
		PreparedStatement pst = null;// プリコンパイルなどをするSQLに使用
		// SQLを実行するときにつかうやつ
		ResultSet rs = null;// レコードごとにデータをアクセス

		ProductBean pb = new ProductBean();

		// try文
		try {

			// MySQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");
			// DBに実際に接続する
			cnct = DriverManager.getConnection(url, id, pw);
			// 結果にコミットがなくなりました
			cnct.setAutoCommit(false);

			pst = cnct.prepareStatement("insert into meisai values(null,?,?,nuw(),?)");

			try {
				int zei = (int) ((money * count) * 1.08);

				// カーとの商品ごとで値を入れてる
				pst.setInt(1, user_id);
				pst.setInt(2, pro_id);
				pst.setInt(3, zei);

				pst.executeUpdate();

				// 結果にコミット
				cnct.commit();

			} catch (SQLException ex1) {

				// 結果をロールバック
				cnct.rollback();

			}

		}

		// 戻り値でArrayListのlistをサーブレットに渡す

		// catch文
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex1) {
			ex1.printStackTrace();
		} finally {
			// 下記
			try {
				// 各クラス・インターフェースにあるclose()メソッドで
				// 接続を解除する
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

	// メソッド二つ目

	// ArrayList String型メソッド（String受け皿付き）
	public void update(int count, int pro_id) {

		// kensakuDAOのkennsakuメソッドの開始の確認
		System.out.println("resultDAOを開始しました");

		// DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/ecdb01";// DBの位置を特定
		String id = "root";
		String pw = "password";

		// DBに接続する際に使うやつ
		Connection cnct = null;// 接続に失敗した場合,例外を送出する
		// SQL実行結果を格納するやつ
		PreparedStatement pst = null;// プリコンパイルなどをするSQLに使用
		// SQLを実行するときにつかうやつ
		ResultSet rs = null;// レコードごとにデータをアクセス

		ProductBean pb = new ProductBean();

		// try文
		try {

			// MySQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");
			// DBに実際に接続する
			cnct = DriverManager.getConnection(url, id, pw);
			// 結果にコミットがなくなりました
			cnct.setAutoCommit(false);

			//stock_noから買った分の個数を引いた結果をstockに代入
			pst = cnct.prepareStatement("update product set stock_no=(stock_no - ?) where pro_id = ?");

			try {


				// カーとの商品ごとで値を入れてる
				pst.setInt(1, count);
				pst.setInt(2, pro_id);

				pst.executeUpdate();

				// 結果にコミット
				cnct.commit();

			} catch (SQLException ex1) {
				ex1.printStackTrace();

				// 結果をロールバック
				cnct.rollback();

			}



		}

		// 戻り値でArrayListのlistをサーブレットに渡す

		// catch文
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex1) {
			ex1.printStackTrace();
		} finally {
			// 下記
			try {
				// 各クラス・インターフェースにあるclose()メソッドで
				// 接続を解除する
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
				ex.printStackTrace();

			}
		}
	}
}
