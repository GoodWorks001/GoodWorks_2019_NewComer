package detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetTable {
	private String url = "jdbc:mysql://localhost/ECsite";
	private String id = "root";
	private String pw = "password";

	public String [] getProductDetail(int pro_cd){

		Connection cnct = null;

		ResultSet rs = null;
		Statement st = null;
		String [] result = new String[6];

		try {

			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,pw);

			st = cnct.createStatement();
			String queryy = "SELECT product.pro_name, product.stock_no, product.pro_price,"
					+ " product.pro_img, product.pro_msg, category.cat_name FROM product"
					+ " INNER JOIN category WHERE (product.cat_id = category.cat_id) AND "
					+ "product.pro_cd = ";
			rs = st.executeQuery(queryy + pro_cd);

			while(rs.next()) {

				result[0] = rs.getString("pro_name");
				result[1] = rs.getString("stock_no");
				result[2] = rs.getString("pro_price");
				result[3] = rs.getString("pro_img");
				result[4] = rs.getString("pro_msg");
				result[5] = rs.getString("cat_name");


			}
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();

				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			} catch(Exception ex) { }

		}

		return result;


	}

}

