package web;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class meiDAO {
	public String meisai(String maisai) {
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

		String result = null;
		//
		PreparedStatement pst = null;

		// DB接続
		try {

			// JDBC ドライバの登録、SQLのJDBCを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(22222222);
			// DBに実際に接続、url、id、passwordを使って
			cnct = DriverManager.getConnection(url, id, pw);
			// sqlという変数にselect文を入れる
			String sql = "select * from product where pro_name=? ";
			System.out.println(sql);
			// プリコンパイルする準備
			pst = cnct.prepareStatement(sql);
			// ?に代入
			pst.setString(1, maisai);
			System.out.println(pst);

			System.out.println(333333333);
			rs = pst.executeQuery();
			// リストにぶち込む
			while (rs.next()) {
				// 商品コードを格納
				result = rs.getString("pro_cd");
				System.out.println(result);
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFound");
			ex.printStackTrace();

			// SQLに問題があった時
		} catch (Exception ex) {
			System.out.println("SQLException");
			ex.printStackTrace();

			// 必ず行う処理
		} finally {

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
		return result;
	}

	public String zaiko(String zaiko) {
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

		String result = null;
		//
		PreparedStatement pst = null;

		// DB接続
		try {

			// JDBC ドライバの登録、SQLのJDBCを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(22222222);
			// DBに実際に接続、url、id、passwordを使って
			cnct = DriverManager.getConnection(url, id, pw);
			// sqlという変数にselect文を入れる
			String sql = "select * from product where pro_name=? ";
			System.out.println(sql);
			// プリコンパイルする準備
			pst = cnct.prepareStatement(sql);
			// ?に代入
			pst.setString(1, zaiko);
			System.out.println(pst);

			System.out.println(333333333);
			rs = pst.executeQuery();
			// リストにぶち込む
			while (rs.next()) {
				// 商品コードを格納
				result = rs.getString("stock_no");
				System.out.println(result);
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFound");
			ex.printStackTrace();

			// SQLに問題があった時
		} catch (Exception ex) {
			System.out.println("SQLException");
			ex.printStackTrace();

			// 必ず行う処理
		} finally {

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
		return result;
	}

public int getid() {
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

	int mei_id=0;

	PreparedStatement pst = null;

	// DB接続
	try {

		// JDBC ドライバの登録、SQLのJDBCを使う定義
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println(22222222);
		// DBに実際に接続、url、id、passwordを使って
		cnct = DriverManager.getConnection(url, id, pw);
		// sqlという変数にselect文を入れる
		String sql = "select * from meisai where mei_id=(select max(mei_id) from meisai) ";
		System.out.println(sql);
		// プリコンパイルする準備
		pst = cnct.prepareStatement(sql);
		// ?に代入

		System.out.println(pst);

		System.out.println(333333333);
		rs = pst.executeQuery();
		// リストにぶち込む
		while (rs.next()) {
			// 商品コードを格納
			mei_id = rs.getInt("mei_id");
			System.out.println(mei_id);
		}
	} catch (ClassNotFoundException ex) {
		System.out.println("ClassNotFound");
		ex.printStackTrace();

		// SQLに問題があった時
	} catch (Exception ex) {
		System.out.println("SQLException");
		ex.printStackTrace();

		// 必ず行う処理
	} finally {

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
	return mei_id;
}
public void InsertMeisai(int mei_id,int user_id,int pro_cd,Date ko_date,int mei_price){
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



	PreparedStatement pst = null;

	// DB接続
	try {

		// JDBC ドライバの登録、SQLのJDBCを使う定義
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println(22222222);
		// DBに実際に接続、url、id、passwordを使って
		cnct = DriverManager.getConnection(url, id, pw);
		// sqlという変数にselect文を入れる
		String sql = "Insert into meisai values(?,?,?,?,?) ";
		System.out.println(sql);
		// プリコンパイルする準備
		pst = cnct.prepareStatement(sql);
		// ?に代入
		pst.setInt(1,mei_id);
		pst.setInt(2,user_id);
		pst.setInt(3,pro_cd);
		pst.setDate(4,ko_date);
		pst.setInt(5,mei_price);


		System.out.println(pst);

		System.out.println(333333333);
		pst.executeUpdate();
		System.out.println("適応しました");
		// リストにぶち込む

	} catch (ClassNotFoundException ex) {
		System.out.println("ClassNotFound");
		ex.printStackTrace();

		// SQLに問題があった時
	} catch (Exception ex) {
		System.out.println("SQLException");
		ex.printStackTrace();

		// 必ず行う処理
	} finally {

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
public void setZaiko(int pro_id,int newStock){
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



	PreparedStatement pst = null;

	// DB接続
	try {

		// JDBC ドライバの登録、SQLのJDBCを使う定義
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println(22222222);
		// DBに実際に接続、url、id、passwordを使って
		cnct = DriverManager.getConnection(url, id, pw);
		// sqlという変数にselect文を入れる
		String sql = "update product set stock_no = ? where pro_cd = ? ";
		System.out.println(sql);
		// プリコンパイルする準備
		pst = cnct.prepareStatement(sql);
		// ?に代入
		pst.setInt(1,newStock);
		pst.setInt(2,pro_id);

		System.out.println(pst);

		System.out.println(333333333);
		pst.executeUpdate();
		System.out.println("適応しました");


	} catch (ClassNotFoundException ex) {
		System.out.println("ClassNotFound");
		ex.printStackTrace();

		// SQLに問題があった時
	} catch (Exception ex) {
		System.out.println("SQLException");
		ex.printStackTrace();

		// 必ず行う処理
	} finally {

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





