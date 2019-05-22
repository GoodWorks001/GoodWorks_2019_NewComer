package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ConfDAO {

	public int Insert(int count, int user_id, ArrayList<Integer> all, ArrayList<String> pro_id) throws SQLException {
		//url id pw を設定
		String url = "jdbc:mysql://localhost/ECsite";
		String id = "root";
		String pw = "password";

		//DBに接続する際のつかうやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQLを実行するのに使うやつ
		ResultSet rs = null;

		PreparedStatement pst = null;
		int q =0;


		try {
			//MYSQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
			//DBに接続する
			cnct = DriverManager.getConnection(url,id,pw);

			//接続に失敗したらSQLExceptionを投げる
			//失敗した場合の布石
			st = cnct.createStatement();

			cnct.setAutoCommit(false);

			//Calenderクラスのオブジェクト生成
			Calendar cl = Calendar.getInstance();
			//SimpleDateFormatでフォーマットパターンを設定する
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdf.format(cl.getTime()));

			for(int i = 0; i < all.size(); i++) {
				String sql = "insert into meisai values (" + (count + i)+ ","+user_id+","+pro_id.get(i)+",'"+sdf.format(cl.getTime())+"',"+all.get(i)+")";
				System.out.println(sql);
				pst = cnct.prepareStatement(sql);
				System.out.println("-----");
				System.out.println(sql);
				q = count+ i;
			}

			//sql文の実行
			pst.executeUpdate();

			//コミット
			cnct.commit();
			System.out.println("コミット完了");
			return q;
		}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
			ex.printStackTrace();
			return q;

		}catch(SQLException ex) {//SQLExceptionがでたらここ
			ex.printStackTrace();

			cnct.rollback();
			System.out.println("ロールバック");
			return q;

		} finally {//ここは絶対に実行
			try {
				//接続を解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			}catch(Exception ex) {}
		}



	}

}
