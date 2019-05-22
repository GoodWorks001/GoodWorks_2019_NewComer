package EC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Syousai_DAO {
	public ArrayList<String> namelist = new ArrayList<String>();
	public ArrayList<Integer> pricelist = new ArrayList<Integer>();
	public ArrayList<SyouhinBean> itemlist = new ArrayList<SyouhinBean>();

	public String jdbc1(String name, int id2) {

		String key = "";
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

			//JDBCドライバをロード、インスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			//getConnectionメソッドを実行
			//DBとの接続のための処理をDriverManagerクラスに丸投げする
			cnct = DriverManager.getConnection(url, id, pw);
			//createStatementメソッドを実行
			//SQLを入れるための窓口を用意する

			//executeQueryメソッドを実行する
			//実際のSQL文を送信し、結果をrsに代入する
			String query = "SELECT * from product where pro_name = ? AND cat_id = ?";
			pst = cnct.prepareStatement(query);
			pst.setString(1, name);
			pst.setInt(2, id2);
			rs = pst.executeQuery();
			//全データを取り出すまで繰り返す
			while (rs.next()) {
				//カラム名を指定し、それぞれのデータを取得する
				namelist.add(rs.getString("pro_name"));
				pricelist.add(rs.getInt("pro_price"));
				key = rs.getString("pro_name");
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
		return key;
	}

	public String jdbc1_2(int id2) {

		String key = "";
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

			//JDBCドライバをロード、インスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			//getConnectionメソッドを実行
			//DBとの接続のための処理をDriverManagerクラスに丸投げする
			cnct = DriverManager.getConnection(url, id, pw);
			//createStatementメソッドを実行
			//SQLを入れるための窓口を用意する

			//executeQueryメソッドを実行する
			//実際のSQL文を送信し、結果をrsに代入する
			String query = "SELECT * from product where cat_id = ?";
			pst = cnct.prepareStatement(query);
			pst.setInt(1, id2);
			rs = pst.executeQuery();
			while (rs.next()) {
				//カラム名を指定し、それぞれのデータを取得する
				namelist.add(rs.getString("pro_name"));
				pricelist.add(rs.getInt("pro_price"));
				key = rs.getString("pro_name");
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
		return key;
	}

	public String jdbc1_3(String id2) {

		String key = "";
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
			pst.setString(1, id2);
			rs = pst.executeQuery();

			while (rs.next()) {
				//カラム名を指定し、それぞれのデータを取得する
				namelist.add(rs.getString("pro_name"));
				pricelist.add(rs.getInt("pro_price"));
				key = rs.getString("pro_name");
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
		return key;
	}

	public SyouhinBean jdbc2(String id2) {
		SyouhinBean bean = new SyouhinBean();
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
			pst.setString(1, id2);
			rs = pst.executeQuery();
			//全データを取り出すまで繰り返す
			while (rs.next()) {
				//カラム名を指定し、それぞれのデータを取得する
				bean.setName(rs.getString("product.pro_name"));
				bean.setStock(rs.getInt("product.stock_no"));
				bean.setPrice(rs.getInt("product.pro_price"));
				bean.setCat_id(rs.getInt("product.cat_id"));
				bean.setImg(rs.getString("product.pro_img"));
				bean.setMsg(rs.getString("product.pro_msg"));
				bean.setPro_cd(rs.getInt("product.pro_cd"));
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
		return bean;
	}

	public String jdbc3(int id2) {
		//参照するパスを変数に格納
		String cat_id = "";
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

			//JDBCドライバをロード、インスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			//getConnectionメソッドを実行
			//DBとの接続のための処理をDriverManagerクラスに丸投げする
			cnct = DriverManager.getConnection(url, id, pw);
			//createStatementメソッドを実行
			//SQLを入れるための窓口を用意する

			//executeQueryメソッドを実行する
			//実際のSQL文を送信し、結果をrsに代入する
			String query = "SELECT * from category where cat_id = ?";
			pst = cnct.prepareStatement(query);
			pst.setInt(1, id2);
			rs = pst.executeQuery();
			//全データを取り出すまで繰り返す
			while (rs.next()) {
				//カラム名を指定し、それぞれのデータを取得する
				cat_id = rs.getString("cat_name");
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
		return cat_id;
	}
}
