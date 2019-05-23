package confirm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

import search.SearchJDBC;

public class Stock {
	public void update(HashMap<String, Integer[]> hm) {

		// DB呼び出すやつ
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			cnct = DriverManager.getConnection(url, id, pw);
			// DB止める
			cnct.setAutoCommit(false);
			try {

				String query = "UPDATE PRODUCT SET stock_no = (?) WHERE pro_name = (?)";
				pst = cnct.prepareStatement(query);
				// インスタンス化
				SearchJDBC sd = new SearchJDBC();
				sd.main();

				Iterator it = hm.keySet().iterator();
				String prodname = "";
				Integer[] info = { 0, 0 };
				int ind, current_stock, current_order;
				while (it.hasNext()) {
					prodname = (String) it.next();
					ind = sd.listname.indexOf(prodname);
					current_stock = sd.liststock.get(ind);
					info = hm.get(prodname);
					current_order = info[0];
					int newzaiko = current_stock - current_order;

					pst.setInt(1, newzaiko);
					pst.setString(2, prodname);

					pst.executeUpdate();
				}

				cnct.commit();
			} catch (SQLException ex) {

				cnct.rollback();
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
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
}
