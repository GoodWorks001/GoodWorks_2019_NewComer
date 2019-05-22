package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDAO {
//ワード検索
	public ArrayList<SearchBean> Item(String Search_Item) {
		ArrayList<SearchBean> ItemList = new ArrayList<SearchBean>();
		System.out.println("ワード検索");

		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ECsite"; // データベースを開くためのパス
		String id = "root"; // サーバーのユーザー名
		String pw = "password"; // サーバーのパスワード

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// SQL文の指定
			rs = st.executeQuery("select*from product where pro_name = '"+ Search_Item +"';");

			while (rs.next()) {

				SearchBean searchB = new SearchBean();

				searchB.setId(rs.getInt("pro_id"));
				searchB.setName(rs.getString("pro_name"));
				searchB.setStock(rs.getInt("stock_no"));
				searchB.setPrice(rs.getInt("pro_price"));
				searchB.setCategory(rs.getInt("cat_id"));
				searchB.setImg(rs.getString("pro_img"));
				searchB.setMsg(rs.getString("pro_msg"));
				ItemList.add(searchB);

			}
			if(ItemList!=null) {
				System.out.println("if文実行アイテムリストに値あり");

			    return ItemList; //戻り値でItemListを返す。
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
		return ItemList;
	}

//カテゴリ検索
	public ArrayList<SearchBean> catItem(String Cat_Item) {
		ArrayList<SearchBean> ItemList = new ArrayList<SearchBean>();
		System.out.println("カテゴリ検索");

		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ECsite"; // データベースを開くためのパス
		String id = "root"; // サーバーのユーザー名
		String pw = "password"; // サーバーのパスワード

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		// DBに接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// SQL文の指定
			rs = st.executeQuery("select*from product inner join category ON product.cat_id = category.cat_id where category.cat_id = '"+ Cat_Item +"';");

			while (rs.next()) {

				SearchBean searchB = new SearchBean();

				searchB.setId(rs.getInt("pro_id"));
				searchB.setName(rs.getString("pro_name"));
				searchB.setStock(rs.getInt("stock_no"));
				searchB.setPrice(rs.getInt("pro_price"));
				searchB.setCategory(rs.getInt("cat_id"));
				searchB.setImg(rs.getString("pro_img"));
				searchB.setMsg(rs.getString("pro_msg"));
				ItemList.add(searchB);

			}
			if(ItemList!=null) {
				System.out.println("if文実行アイテムリストにカテゴリ検索結果のアイテム追加");
			return ItemList; //戻り値でItemListを返す。
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
		return ItemList;
	}
}