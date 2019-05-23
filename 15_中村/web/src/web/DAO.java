package web;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	public  int access(int number) {

		//MySQLに接続するための情報を変数に格納
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			//MySQLのJDBCドライバを使いますよ！
			Class.forName("com.mysql.jdbc.Driver");
			//引数にurl,id,pwを投げてＤＢにアクセス！
			cnct = DriverManager.getConnection(url,id,pw);

			//下記行で自動コミットモード解除
			cnct.setAutoCommit(false);

			try {
			//queryっていう変数にinsert文を代入している
			 String query = "select * FROM item WHERE id = ?";
			 //SQLを実行する最終チェック的なやつ
			 pst = cnct.prepareStatement(query);
				pst.setInt(1, number);

			rs = 	pst.executeQuery();

			while(rs.next()) {
				String Qid = rs.getString("id");
				String Qname = rs.getString("name");
				String Qprice = rs.getString("price");
				String Qcat_id = rs.getString("cat_id");
				System.out.println("id:"+Qid +"	"+
						"name:"+ Qname+"		"+
						"price:"+ Qprice+"	"+
						"cat_id:"+Qcat_id+"	" );
}

			//コミットしてるよ
			cnct.commit();
			System.out.println("コミットしました。０");

			}catch (SQLException e){
				  cnct.rollback();
				System.out.println("ロールバックしました。");
				e.printStackTrace();

			}

		} catch(Exception ex){
			ex.printStackTrace();


		} finally {
			try {
				System.out.println("a");
				if (pst!=null) pst.close();
				if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
		}
		return number;
}
}
