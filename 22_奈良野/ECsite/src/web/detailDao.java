package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class detailDao {

	public detailBean detail(int pcd) {

		//detailBeanのインスタンス化
		detailBean db = new detailBean();

		//DB接続のやつ
		Connection conn = null;
		ResultSet rs = null;
		Statement st= null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/ecsite";
			String id = "root";
			String pwd = "password";

			conn = DriverManager.getConnection(url,id,pwd);

			st = conn.createStatement();
			//独自テーブル作成後、その中でpcdを検索
			rs = st.executeQuery("select pro_name,pro_cd,stock_no,pro_price,cat_name,pro_msg,pro_img "
					+ "from product inner join category on product.cat_id = category.cat_id where pro_cd ="+pcd);

			while(rs.next()){
				//変数に上記検索結果内のデータを格納
				int pc= rs.getInt("pro_cd");
				String pn = rs.getString("pro_name");
				int sto =rs.getInt("stock_no");
				int pri = rs.getInt("pro_price");
				String cname = rs.getString("cat_name");
				String pi = rs.getString("pro_img");
				String pm = rs.getString("pro_msg");

				//dbインスタンスのsetメソッドで定義した変数を格納
				db.setP_cd(pc);
				db.setP_name(pn);
				db.setStock(sto);
				db.setPrice(pri);
				db.setCat_name(cname);
				db.setP_img(pi);
				db.setP_msg(pm);

				//戻り値返す
				return db;

			}

			//いつものエラー処理
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
			//戻り値返す
			return db;
		} catch (SQLException ex) {
			ex.printStackTrace();
			//戻り値返す
			return db;
		}
		finally{
			try{
				if(conn != null){
					conn.close();
				}
				if(st != null){
					st.close();
				}
				if(rs != null){
					rs.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return db;
	}

}