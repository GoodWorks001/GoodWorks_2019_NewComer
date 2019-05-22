package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class syoDAO {
	public String SearchObj(String pro,String getkaramu) {
	 //mysqlのecsite2019を読み込む
	 String url = "jdbc:mysql://localhost/ecsite2019";
	 String id = "root";
	 String pw = "password";
	 //DBに接続する際に使う
	 Connection cnct =null;
	 //SQLを実行する際に使う
	 PreparedStatement pst = null;
	 //SQL実行結果を格納するやつ
	 ResultSet rs =null;
	 String result = null;


	try {
	//MYSQLのJDBCドライバを使うための定義
	Class.forName("com.mysql.jdbc.Driver");
	//DBに実際に接続する
	cnct = DriverManager.getConnection(url,id,pw);
	//実行結果をqueryに代入している
	String query = "select * from product where pro_cd = ?" ;

	//プリコンパイルの使用準備が完了
	pst = cnct.prepareStatement(query);
	//?に値を代入
	pst.setString(1, pro);
	System.out.println("pst:" + pst);

	rs = pst.executeQuery();
	//ここのwhile文でrsに格納されている。
	//値を一行一行取り出して出力している。
		while(rs.next()) {
		result =rs.getString(getkaramu);
		}

	} catch (Exception e) {
	}
	return result;
	}

	public String Catemote(String cat_id) {
		 //mysqlのecsite2019を読み込む
		 String url = "jdbc:mysql://localhost/ecsite2019";
		 String id = "root";
		 String pw = "password";
		 //DBに接続する際に使う
		 Connection cnct =null;
		 //SQLを実行する際に使う
		 PreparedStatement pst = null;
		 //SQL実行結果を格納するやつ
		 ResultSet rs =null;
		 String result = null;


		try {
		//MYSQLのJDBCドライバを使うための定義
		Class.forName("com.mysql.jdbc.Driver");
		//DBに実際に接続する
		cnct = DriverManager.getConnection(url,id,pw);
		//実行結果をqueryに代入している
		String query = "select * from category where cat_id = ?" ;

		//プリコンパイルの使用準備が完了
		pst = cnct.prepareStatement(query);
		//?に値を代入
		pst.setString(1, cat_id);
		System.out.println("pst:" + pst);

		rs = pst.executeQuery();
		//ここのwhile文でrsに格納されている。
		//値を一行一行取り出して出力している。
			while(rs.next()) {
			result =rs.getString("cat_name");
			}

		} catch (Exception e) {
		}
		return result;
		}
}
