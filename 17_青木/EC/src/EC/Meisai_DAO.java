package EC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Meisai_DAO {
	public void jdbc1(int user_id, int pro_cd, int mei_price) {

		//参照するパスを変数に格納
		String url = "jdbc:mysql://localhost/ECsite";
		//IDを変数に格納
		String id = "root";
		//パスワードを変数に格納
		String pw = "password";

		//Connectionオブジェクトを生成
		Connection cnct = null;
		//Statementオブジェクトを生成
		PreparedStatement pst = null;
		//ResultSetオブジェクトを生成
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);

			//自動コミットモードの解除
			cnct.setAutoCommit(false);

			try {
				String query = "INSERT INTO meisai (mei_id,user_id,pro_cd,ko_date,mei_price) VALUES(?,?,?,?,?)";
				pst = cnct.prepareStatement(query);
				pst.setInt(1, 0);
				pst.setInt(2, user_id);
				pst.setInt(3, pro_cd);
				pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));
				pst.setInt(5, mei_price);
				pst.executeUpdate();
				//コミットしてるよ
				cnct.commit();
				System.out.println("コミットしました。");

			} catch (SQLException e) {
				cnct.rollback();
				System.out.println("ロールバックしました。");
				e.printStackTrace();

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
				if (pst != null)
					pst.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
	}

	public int jdbc2(String name) {
		//参照するパスを変数に格納
		String url = "jdbc:mysql://localhost/ECsite";
		//IDを変数に格納
		String id = "root";
		//パスワードを変数に格納
		String pw = "password";

		int user_id = 0;
		//Connectionオブジェクトを生成
		Connection cnct = null;
		//Statementオブジェクトを生成
		PreparedStatement pst = null;
		//ResultSetオブジェクトを生成
		ResultSet rs = null;

		try {
			//JDBCドライバをロード、インスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			//getConnectionメソッドを実行
			//DBとの接続のための処理をDriverManagerクラスに丸投げする
			cnct = DriverManager.getConnection(url, id, pw);
			//createStatementメソッドを実行
			//SQLを入れるための窓口を用意する

			//executeQueryメソッドを実行する
			//実際のSQL文を送信し、結果をrsに代入する
			String query = "SELECT * from user where user_name = ?";
			pst = cnct.prepareStatement(query);
			pst.setString(1, name);
			rs = pst.executeQuery();
			//全データを取り出すまで繰り返す
			while (rs.next()) {
				//カラム名を指定し、それぞれのデータを取得する
				user_id = rs.getInt("user_id");
			}
			//参照すべきクラスが見つからなかった場合の処理
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			//SQLに問題があった場合の処理
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				//rsがnullではないなら処理を終了する
				if (rs != null)
					rs.close();
				//cnctがnullではないなら処理を終了する
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
		return user_id;
	}

	public int jdbc3(String name) {

		//参照するパスを変数に格納
		String url = "jdbc:mysql://localhost/ECsite";
		//IDを変数に格納
		String id = "root";
		//パスワードを変数に格納
		String pw = "password";

		int pro_cd = 0;

		//Connectionオブジェクトを生成
		Connection cnct = null;
		//Statementオブジェクトを生成
		PreparedStatement pst = null;
		//ResultSetオブジェクトを生成
		ResultSet rs = null;

		try {
			//JDBCドライバをロード、インスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			//getConnectionメソッドを実行
			//DBとの接続のための処理をDriverManagerクラスに丸投げする
			cnct = DriverManager.getConnection(url, id, pw);
			//createStatementメソッドを実行
			//SQLを入れるための窓口を用意する

			//executeQueryメソッドを実行する
			//実際のSQL文を送信し、結果をrsに代入する
			String query = "SELECT * from product where pro_name = ?";
			pst = cnct.prepareStatement(query);
			pst.setString(1, name);
			rs = pst.executeQuery();
			//全データを取り出すまで繰り返す
			while (rs.next()) {
				//カラム名を指定し、それぞれのデータを取得する
				pro_cd = rs.getInt("pro_cd");
			}
			//参照すべきクラスが見つからなかった場合の処理
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			//SQLに問題があった場合の処理
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				//rsがnullではないなら処理を終了する
				if (rs != null)
					rs.close();
				//cnctがnullではないなら処理を終了する
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
		return pro_cd;
	}

	public void jdbc4(int stock, String pro_name) {

		//参照するパスを変数に格納
		String url = "jdbc:mysql://localhost/ECsite";
		//IDを変数に格納
		String id = "root";
		//パスワードを変数に格納
		String pw = "password";

		//Connectionオブジェクトを生成
		Connection cnct = null;
		//Statementオブジェクトを生成
		PreparedStatement pst = null;
		//ResultSetオブジェクトを生成
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);

			//自動コミットモードの解除
			cnct.setAutoCommit(false);

			try {
				String query = "update product set stock_no = ? where pro_name = ?;";
				pst = cnct.prepareStatement(query);
				pst.setInt(1, stock);
				pst.setString(2, pro_name);
				pst.executeUpdate();
				//コミットしてるよ
				cnct.commit();
				System.out.println("コミットしました。");

			} catch (SQLException e) {
				cnct.rollback();
				System.out.println("ロールバックしました。");
				e.printStackTrace();

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
				if (pst != null)
					pst.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
	}

	public int jdbc5(String name) {
		//参照するパスを変数に格納
		String url = "jdbc:mysql://localhost/ECsite";
		//IDを変数に格納
		String id = "root";
		//パスワードを変数に格納
		String pw = "password";

		int stock = 0;
		//Connectionオブジェクトを生成
		Connection cnct = null;
		//Statementオブジェクトを生成
		PreparedStatement pst = null;
		//ResultSetオブジェクトを生成
		ResultSet rs = null;

		try {
			//JDBCドライバをロード、インスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			//getConnectionメソッドを実行
			//DBとの接続のための処理をDriverManagerクラスに丸投げする
			cnct = DriverManager.getConnection(url, id, pw);
			//createStatementメソッドを実行
			//SQLを入れるための窓口を用意する

			//executeQueryメソッドを実行する
			//実際のSQL文を送信し、結果をrsに代入する
			String query = "SELECT * from product where pro_name = ?";
			pst = cnct.prepareStatement(query);
			pst.setString(1, name);
			rs = pst.executeQuery();
			//全データを取り出すまで繰り返す
			while (rs.next()) {
				//カラム名を指定し、それぞれのデータを取得する
				stock = rs.getInt("stock_no");
			}
			//参照すべきクラスが見つからなかった場合の処理
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			//SQLに問題があった場合の処理
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				//rsがnullではないなら処理を終了する
				if (rs != null)
					rs.close();
				//cnctがnullではないなら処理を終了する
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {
			}
		}
		return stock;
	}
}
