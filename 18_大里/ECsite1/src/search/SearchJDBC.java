package search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchJDBC {

	//ArrayListを作成
	public ArrayList<String> listname = new ArrayList<String>();
	public ArrayList<Integer> listprice = new ArrayList<Integer>();
	public ArrayList<Integer> listcd = new ArrayList<Integer>();
	public ArrayList<Integer> liststock = new ArrayList<Integer>();

	public void main() {


		String url = "jdbc:mysql://localhost/ECsite";

		String id = "root";

		String pw = "password";

		Connection cnct = null;

		Statement st = null;

		ResultSet rs = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			cnct = DriverManager.getConnection(url, id, pw);

			st = cnct.createStatement();
            //productをDBから検索
			rs = st.executeQuery("select *  from product");

			while (rs.next()) {
				//Arraylistにproの値を格納
				listprice.add(rs.getInt("pro_price"));
				listname.add(rs.getString("pro_name"));
				listcd.add(rs.getInt("pro_cd"));
				liststock.add(rs.getInt("stock_no"));

			}
			//いつもの
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFound");
			ex.printStackTrace();

		} catch (SQLException ex) {
			System.out.println("SQLException");
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
	}
}
