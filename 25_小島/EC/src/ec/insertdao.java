package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class insertdao {

	public void insert(int user, int all, int pro ) throws SQLException {
		Connection cn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ItemBean cb = new ItemBean();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/EC", "root", "password");

			cn.setAutoCommit(false);

			//日付取得
			Calendar cl = Calendar.getInstance();
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdf.format(cl.getTime()));
			pro +=1;

			//明細テーブルに追加するためのinsert文
			String qu="insert into meisai(user_id,pro_cd,ko_date,mei_price) values ("+user+","+pro+",\""+sdf.format(cl.getTime())+"\","+all+")";

			ps=cn.prepareStatement(qu);




				System.out.println("実行された：" + ps);

				ps.executeUpdate();



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




