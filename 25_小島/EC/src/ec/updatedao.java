package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class updatedao {

	public void update(ArrayList<ItemBean> list) throws SQLException {
		Connection cn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ItemBean cb = new ItemBean();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/EC", "root", "password");

			cn.setAutoCommit(false);

			String qu="update product set stock_no = ? where pro_cd = ?";

			ps=cn.prepareStatement(qu);

			for(int i=0; i<list.size(); i++) {
				//新しい在庫数取得
				int stock = list.get(i).getStock();
				int cd =  list.get(i).getCd()+1;
				System.out.println(cd);

				//?に数字を入れる
				ps.setInt(1,stock);
				ps.setInt(2,cd);

				System.out.println("実行された：" + ps);

				//updateする
				ps.executeUpdate();


			}
			//コミットしました
			cn.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			//ロールバック
			cn.rollback();
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) rs.close();

			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}


