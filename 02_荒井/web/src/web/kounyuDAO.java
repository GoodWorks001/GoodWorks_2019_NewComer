package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class kounyuDAO {

	public void insert(int pro_cd, int user_id, int count, int money) {

		//DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";

		//CBに接続する際に使うやつ
		Connection cnct = null;

		//プリコンパイルする時に必要なやつ
		PreparedStatement pst = null;

		//SQL実行結果を格納するやつ
		ResultSet rs = null;

		try {

			//MySqlのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");

			//DBに実際に接続する
			cnct = DriverManager.getConnection(url, id, pw);

			//自動コミット解除
			cnct.setAutoCommit(false);

			pst = cnct.prepareStatement("INSERT INTO meisai values(null,?,?,now(),?)");

			try {

				int zei = (int) ((money * count) * 1.08);

				//カートの商品ごとで値を入れる
				pst.setInt(1, user_id);
				pst.setInt(2, pro_cd);
				pst.setInt(3, zei);

				//あたらしくデータを入れるからupdate
				//更新するとき
				pst.executeUpdate();

				//コミット実行(結果にコミット)
				cnct.commit();

				System.out.println("tryしました");

			} catch (SQLException e) {

				System.out.println("sql");

				e.printStackTrace();

				//結果にロールバック
				//エラーが起きた時に
				//処理を取り消す
				//更新する前のデータに戻す
				cnct.rollback();


			}

		} catch (ClassNotFoundException ex) {
			System.out.println("not");

			ex.printStackTrace();

		} catch (SQLException e) {

			System.out.println("sql2");

			e.printStackTrace();

		}finally {

			//DBの接続を解除する
			try {

				if (rs !=null) rs.close();
				if (pst !=null) pst.close();
				if (cnct !=null) cnct.close();

			} catch(Exception ex) {

				System.out.println("exception");

				ex.printStackTrace();

			}

		}

	}


	public void update(int count,int pro_cd) {

		//DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";

		//CBに接続する際に使うやつ
		Connection cnct = null;

		//プリコンパイルする時に必要なやつ
		PreparedStatement pst = null;

		//SQL実行結果を格納するやつ
		ResultSet rs = null;

		try {

			//MySqlのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");

			//DBに実際に接続する
			cnct = DriverManager.getConnection(url, id, pw);

			//自動コミット解除
			cnct.setAutoCommit(false);

			//stock_noから買った分の個数を引いた結果を
			//stockにセット
			pst = cnct.prepareStatement("UPDATE product set stock_no = (stock_no-?) where pro_cd = ?");


			try {

				//カートの商品ごとで値を入れる
				pst.setInt(1, count);    //買った数
				pst.setInt(2, pro_cd);   //商品コード

				//あたらしくデータを入れるからupdate
				//更新するとき
				pst.executeUpdate();

				//コミット実行(結果にコミット)
				cnct.commit();



			} catch (SQLException e) {
				e.printStackTrace();

				//結果にロールバック
				//エラーが起きた時に
				//処理を取り消す
				//更新する前のデータに戻す
				cnct.rollback();


			}

		} catch (ClassNotFoundException ex) {

			ex.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}finally {

			//DBの接続を解除する
			try {

				if (rs !=null) rs.close();
				if (pst !=null) pst.close();
				if (cnct !=null) cnct.close();

			} catch(Exception ex) {

				ex.printStackTrace();

			}

		}

	}

}
