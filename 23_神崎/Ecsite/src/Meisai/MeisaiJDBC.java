package Meisai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MeisaiJDBC {

	public void Meisai(ArrayList<MeisaiBean> meisai, int user_id) {

		// mysqlに接続するための情報を格納
		String url = "jdbc:mysql://localhost/ecsite";
		// String url = "jdbc:mysql://localhost/renshu?autoReconnect=true&useSSL=false";
		// mysqlに接続するための情報を格納
		String id = "root";
		// mysqlに接続するための情報を格納
		String pw = "password";
		// mysqlにconnectionを接続する
		Connection cnct = null;
		// sql実行結果を格納する変数
		Statement st = null;
		// sqlを実行するときに使う変数
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();

			for (int i = 0; i < meisai.size(); i++) {
				MeisaiBean m = meisai.get(i);
				int nowzaiko = zaiko(m.getPro_cd());
				String sql = "update product set stock_no =" + (nowzaiko - m.getPro_rstock()) + " where pro_cd = "
						+ m.getPro_cd() + "";
				System.out.println(sql);
				st.executeUpdate(sql);
			}

			for (int i = 0; i < meisai.size(); i++) {
				MeisaiBean m = meisai.get(i);
				Date d = new Date();
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy-MM-dd-HH");
				String c2 = d2.format(d);
				System.out.println(c2);
				String sql = "insert into meisai (user_id,pro_cd,ko_date,mei_price)"
						+ "values(" + user_id + "," + m.getPro_cd() + ",'" + c2 + "'," + m.getMei_price() + "" + ")";
				st.executeUpdate(sql);
			}

			// エラーが起きた場合の処理
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundエラー");
			ex.printStackTrace();

			// エラーが起きた場合の処理//
		} catch (SQLException ex) {
			System.out.println("SQLExceptionエラー");
			ex.printStackTrace();

			//接続の解除
		} finally {
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

	public int zaiko(int pro_cd) {

		// mysqlに接続するための情報を格納
		String url = "jdbc:mysql://localhost/ecsite";
		// String url = "jdbc:mysql://localhost/renshu?autoReconnect=true&useSSL=false";
		// mysqlに接続するための情報を格納
		String id = "root";
		// mysqlに接続するための情報を格納
		String pw = "password";
		// mysqlにconnectionを接続する
		Connection cnct = null;
		// sql実行結果を格納する変数
		Statement st = null;
		// sqlを実行するときに使う変数
		ResultSet rs = null;

		int zaiko = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();

			String sql = "select * from product where pro_cd = " + pro_cd + "";

			System.out.println(sql);
			rs = st.executeQuery(sql);
			rs.next();

			zaiko = rs.getInt("stock_no");
			System.out.println("在庫数:" + zaiko);
			return zaiko;

			// エラーが起きた場合の処理
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundエラー");
			ex.printStackTrace();

			// エラーが起きた場合の処理//
		} catch (SQLException ex) {
			System.out.println("SQLExceptionエラー");
			ex.printStackTrace();

			//接続の解除
		} finally {
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
		return zaiko;

	}
}
