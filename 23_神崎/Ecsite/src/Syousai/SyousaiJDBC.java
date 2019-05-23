package Syousai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Search.ProductBean;

public class SyousaiJDBC {
	public ProductBean ProductSyousai(String pro_cd) {
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

			ProductBean pro = new ProductBean();

			String sql ="" ;


			try {

				Class.forName("com.mysql.jdbc.Driver");
				cnct = DriverManager.getConnection(url,id,pw);
				st = cnct.createStatement();

				rs = st.executeQuery("select * from product inner join category on product.cat_id =category.cat_id"
						+" where pro_cd ="+pro_cd);
				while (rs.next()) {



					pro.setPro_id(rs.getInt("pro_cd"));
					pro.setPro_name(rs.getString("pro_name"));
					pro.setStock_no(rs.getInt("stock_no"));
					pro.setPro_price(rs.getInt("pro_price"));
					pro.setCat_id(rs.getInt("cat_id"));
					pro.setPro_img(rs.getString("pro_img"));
					pro.setPro_msg(rs.getString("pro_msg"));
					pro.setCat_name(rs.getString("cat_name"));



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
			return pro;
		}
	}


