package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO2 {



	public ArrayList<ProductBean> isItem(String search){

		ArrayList<ProductBean> itemList = new ArrayList<ProductBean>();
		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		String mSearch =search;

		if (mSearch.equals("") || mSearch == null) {
			mSearch = "hogehoge";
		}

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();


			String query =( "SELECT * FROM product where pro_name='"+mSearch+"';");
			System.out.println(query);
			rs = st.executeQuery(query);
			while(rs.next()) {
				ProductBean item = new ProductBean();

				String sName = rs.getString("pro_name");
				item.setPro_name(sName);

				int sStock = rs.getInt("stock_no");
				item.setStock_no(sStock);

				int sPrice = rs.getInt("pro_price");
				item.setPro_price(sPrice);

				int sCategory = rs.getInt("cat_id");
				item.setCat_id(sCategory);

				String sImg = rs.getString("pro_img");
				item.setPro_img(sImg);

				String sMsg = rs.getString("pro_msg");
				item.setPro_msg(sMsg);

				int sCd = rs.getInt("pro_cd");
				item.setPro_cd(sCd);

				itemList.add(item);
			}

			return itemList;
			} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return itemList;

		} catch (SQLException e) {
			e.printStackTrace();
			return itemList;

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				return itemList;
			} catch (Exception ex) {
			}
		}

	}

	public ArrayList<ProductBean> Pro_Cat(String category){

		ArrayList<ProductBean> itemList = new ArrayList<ProductBean>();
		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;


		String mCategory = category;

		if (mCategory.equals("") || mCategory == null) {
			mCategory = "hogehog";
		}

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();


			String query =( "SELECT * FROM product where cat_id='"+mCategory+"';");
			System.out.println(query);
			rs = st.executeQuery(query);
			while(rs.next()) {
				ProductBean item = new ProductBean();

				System.out.println("----------------");

				String sName = rs.getString("pro_name");
				System.out.println(sName);
				item.setPro_name(sName);

				int sStock = rs.getInt("stock_no");
				System.out.println(sStock);
				item.setStock_no(sStock);

				int sPrice = rs.getInt("pro_price");
				System.out.println(sPrice);
				item.setPro_price(sPrice);

				int sCategory = rs.getInt("cat_id");
				System.out.println(sCategory);
				item.setCat_id(sCategory);

				String sImg = rs.getString("pro_img");
				System.out.println(sImg);
				item.setPro_img(sImg);

				String sMsg = rs.getString("pro_msg");
				System.out.println(sMsg);
				item.setPro_msg(sMsg);

				int sCd = rs.getInt("pro_cd");
				item.setPro_cd(sCd);

				System.out.println("DAO2 cd = "+item.getPro_cd());

				itemList.add(item);
				System.out.println(itemList);
			}

			return itemList;
			} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return itemList;

		} catch (SQLException e) {
			e.printStackTrace();
			return itemList;

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				return itemList;
			} catch (Exception ex) {
			}
		}

	}

	}

