package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class shoukaidao {



	public productbean search(String name, String msg) {

		 productbean pro = new productbean();


		// DBにアクセスする情報変数
		System.out.println("daoきた");

		String url = "jdbc:mysql://localhost/EC";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// ログインコード・パス
	//		rs = st.executeQuery("SELECT * FROM product;");
			rs = st.executeQuery(" select pro_name,stock_no,pro_price,cat_name,pro_msg from product inner join category on product.cat_id = category.cat_id;");

			System.out.println("try");

			while (rs.next()) {
				int sPrice = rs.getInt("pro_price");
				String sName = rs.getString("pro_name");
				String sMsg = rs.getString("pro_msg");
				int sStock = rs.getInt("stock_no");
				String sCategory = rs.getString("cat_name");

				System.out.println("while文");
					pro.setStock(sStock);
					pro.setName(sName);
					pro.setMsg(sMsg);
				    pro.setCategory(sCategory);
					pro.setPrice(sPrice);
			}





		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

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



