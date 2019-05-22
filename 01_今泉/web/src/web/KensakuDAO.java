package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KensakuDAO {

	public ProductBean isItem(int num){


		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;


		ProductBean pbean = new ProductBean();

			// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();


			String query =( "SELECT * FROM product where pro_cd='"+num+"'");
			System.out.println(query);
			rs = st.executeQuery(query);

			rs.next();



				pbean.setPro_name(rs.getString("pro_name"));
				pbean.setPro_price(rs.getInt("pro_price"));
				pbean.setStock_no(rs.getInt("stock_no"));
				pbean.setCat_id(rs.getInt("cat_id"));
				pbean.setPro_cd(rs.getInt("pro_cd"));
				pbean.setPro_img(rs.getString("pro_img"));
				pbean.setPro_msg(rs.getString("pro_msg"));





			return pbean;
			} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return pbean;

		} catch (SQLException e) {
			e.printStackTrace();
			return pbean;

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				return pbean;
			} catch (Exception ex) {
			}
		}

	}


}
