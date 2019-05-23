package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class getTable {

	private String url = "jdbc:mysql://localhost/ecsite";
	private String id = "root";
	private String pw = "password";

	public String [] getProductDetail(int pro_cd){

		Connection cnct = null;
//		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement st = null;
		String [] result = {"","","","","",""};

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
				//int idd = rs.getInt("ID");
				//String addd = rs.getString(5);
				result[0] = rs.getString("pro_name");
				result[1] = rs.getString("stock_no");
				result[2] = rs.getString("pro_price");
				result[3] = rs.getString("pro_img");
				result[4] = rs.getString("pro_msg");
				result[5] = rs.getString("cat_name");

//				System.out.println("Name:" + namee + "\tTel:" + tel);
			}
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
//				if (pst!=null) pst.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			} catch(Exception ex) { }

		}

		return result;


	}

}
