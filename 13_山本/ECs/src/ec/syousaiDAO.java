package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class syousaiDAO {

	//詳細
		public ArrayList<String> syousai(String syoid) {
			ArrayList<String> ItemList = new ArrayList<String>();
			System.out.println("しょうさいDAO スタート！！！！");

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
				rs = st.executeQuery("select*from product where pro_id="+ syoid +";");

				while (rs.next()) {

					//アレイリストに
					ItemList.add(rs.getString("pro_id"));
					ItemList.add(rs.getString("pro_name"));
					ItemList.add(rs.getString("stock_no"));
					ItemList.add(rs.getString("pro_price"));
					ItemList.add(rs.getString("cat_id"));
					ItemList.add(rs.getString("pro_img"));
					ItemList.add(rs.getString("pro_msg"));

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
