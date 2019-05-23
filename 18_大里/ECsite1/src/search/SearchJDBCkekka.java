package search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchJDBCkekka {
	public ArrayList<String> listnamere = new ArrayList<String>();
	public ArrayList<Integer> listpricere = new ArrayList<Integer>();
	public ArrayList<Integer> listcdre = new ArrayList<Integer>();

	public void getCategory(int value) {

		//DB呼ぶやつ
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
			String query = "";

			if (value == 0) {
				query = "select *  from product";

				rs = st.executeQuery(query);

				while (rs.next()) {
					listpricere.add(rs.getInt("pro_price"));
					listnamere.add(rs.getString("pro_name"));
					listcdre.add(rs.getInt("pro_cd"));
				}
			} else {
				query = "select product.pro_cd,product.pro_name,product.pro_price from product inner join category where (product.cat_id = category.cat_id) and (category.cat_id = ";

				rs = st.executeQuery(query + value + ")");

				while (rs.next()) {
					listpricere.add(rs.getInt("pro_price"));
					listnamere.add(rs.getString("pro_name"));
					listcdre.add(rs.getInt("pro_cd"));
				}
			}

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

	public ArrayList<String> getCategoryName() {

		//DB呼ぶやつ
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<String> category_name = new ArrayList<String>();

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cnct = DriverManager.getConnection(url, id, pw);

			st = cnct.createStatement();

			String query = "select cat_name from category";

			rs = st.executeQuery(query);

			while (rs.next()) {
				category_name.add(rs.getString(1));
			}

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

		return category_name;
	}

	public void getKeyword(String keyword) {

		//DB呼ぶやつ
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";

		listpricere.clear();
		listnamere.clear();
		listcdre.clear();

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cnct = DriverManager.getConnection(url, id, pw);

			//キーワード検索
			String query = "select * from product where pro_name like '%" + keyword + "%'";
			System.out.println(query);

			st = cnct.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				//Arraylistにproを格納
				listpricere.add(rs.getInt("pro_price"));
				listnamere.add(rs.getString("pro_name"));
				listcdre.add(rs.getInt("pro_cd"));
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
