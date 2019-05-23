package Search;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC {
	//商品紹介用
	public ArrayList<ProductBean> Pro_gets(String pro_name) {
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

		ArrayList<ProductBean> prolist = new ArrayList<ProductBean>();

		String sql ="" ;


		try {

			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,pw);
			st = cnct.createStatement();

			rs = st.executeQuery("select * from product where pro_name ='"+pro_name+"'");
			while (rs.next()) {

				ProductBean cy = new ProductBean();

				cy.setPro_id(rs.getInt("pro_cd"));
				cy.setPro_name(rs.getString("pro_name"));
				cy.setStock_no(rs.getInt("stock_no"));
				cy.setPro_price(rs.getInt("pro_price"));
				cy.setCat_id(rs.getInt("cat_id"));
				cy.setPro_img(rs.getString("pro_img"));
				cy.setPro_msg(rs.getString("pro_msg"));

				prolist.add(cy);


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
		return prolist;
	}


	public ArrayList<ProductBean> cat_gets(String cat_id) {
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

		ArrayList<ProductBean> prolist = new ArrayList<ProductBean>();



		try {

			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,pw);
			st = cnct.createStatement();
			rs = st.executeQuery("select * from product where cat_id ="+cat_id+"");
			while (rs.next()) {

				ProductBean cy = new ProductBean();
				cy.setPro_id(rs.getInt("pro_cd"));
				cy.setPro_name(rs.getString("pro_name"));
				cy.setStock_no(rs.getInt("stock_no"));
				cy.setPro_price(rs.getInt("pro_price"));
				cy.setCat_id(rs.getInt("cat_id"));
				cy.setPro_img(rs.getString("pro_img"));
				cy.setPro_msg(rs.getString("pro_msg"));
				prolist.add(cy);

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
		return  prolist;
	}






	//カテゴリー用
	public ArrayList<CtBean> cat_gets() {
		// mysqlに接続するための情報を格納
				String url = "jdbc:mysql://localhost/ecsite";
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
				ArrayList<CtBean> catlist = new ArrayList<CtBean>();

				try {

					Class.forName("com.mysql.jdbc.Driver");
					cnct = DriverManager.getConnection(url,id,pw);
					st = cnct.createStatement();
					rs = st.executeQuery("select * from category");

					while (rs.next()) {

						CtBean ctb= new CtBean();
						ctb.setCat_id(rs.getInt("cat_id"));
						ctb.setCat_name(rs.getString("cat_name"));

						catlist.add(ctb);

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
						//return ctb;
					} catch (Exception ex) {
					}
				}
				return catlist;
			}

	public ProductBean product(String kensaku) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	//ArrayList<String> slist = new ArrayList<String>();

	public ArrayList<String> getKeyword(String keyword,String column) {

		// mysqlに接続するための情報urlをString型変数urlに格納
		String url = "jdbc:mysql://localhost/ECsite";
		// String url = "jdbc:mysql://localhost/renshu?autoReconnect=true&useSSL=false";
		// mysqlに接続するための情報をString型変数idに格納
		String id = "root";
		// mysqlに接続するための情報をString型変数pwに格納
		String pw = "password";


		ArrayList<String> slist = new ArrayList<String>();

		// 以下3つはimport文が必要
		// mysqlにconnectionを接続する。データベースに接続するための部品
		Connection cnct = null;
		// sql実行結果を格納する変数を定義
		Statement st = null;
		// sqlを実行するときに使う変数を定義
		ResultSet rs = null;

		//PreparedStatement pst = null;

		try {
			// ●基本的な利用手順
			// ●JDBCドライバの登録
			// Class.forNameでmysqlのjdbcドライバを使う定義
			Class.forName("com.mysql.jdbc.Driver");
			// ●DBMSへの接続
			// getConnectionメソッドを実行(データベースに接続)
			// 接続に失敗した場合sqlExceptionを投げる
			cnct = DriverManager.getConnection(url, id, pw);
			// ●SQLの発行




			// sql文の実行結果を変数rsに代入 カテゴリIDがカテゴリプルダウンと一致するもの
			String query = "select * from product where pro_name like '%" + keyword + "%'";

			System.out.println(query);
			st = cnct.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				slist.add(rs.getString(column));
			}


			// エラーが起きた場合の処理
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundエラー");
			ex.printStackTrace();
			// エラーが起きた場合の処理//
		} catch (SQLException ex) {
			System.out.println("SQLExceptionエラー");
			ex.printStackTrace();
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
		return slist;
	}

	}



