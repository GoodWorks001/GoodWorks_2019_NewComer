package ec;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class meiDAO {
	public String meisai(String setname) {
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
		String query = "select * from product where pro_name = ?" ;

		//プリコンパイルの使用準備が完了
		pst = cnct.prepareStatement(query);
		//?に値を代入
		pst.setString(1, setname);
		System.out.println("pst:" + pst);

		rs = pst.executeQuery();
		//ここのwhile文でrsに格納されている。
		//値を一行一行取り出して出力している。
			while(rs.next()) {
				//商品コードを格納
			result =rs.getString("pro_cd");
			}

		} catch (Exception e) {
		}
		return result;
		}

	public String zaiko(String setname) {
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
		String query = "select * from product where pro_name = ?" ;

		//プリコンパイルの使用準備が完了
		pst = cnct.prepareStatement(query);
		//?に値を代入
		pst.setString(1, setname);
		System.out.println("pst:" + pst);

		rs = pst.executeQuery();
		//ここのwhile文でrsに格納されている。
		//値を一行一行取り出して出力している。
			while(rs.next()) {
				//商品コードを格納
			result =rs.getString("stock_no");
			}

		} catch (Exception e) {
		}
		return result;
		}

	public int getId() {
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
		 int mei_id= 0;


		try {
		//MYSQLのJDBCドライバを使うための定義
		Class.forName("com.mysql.jdbc.Driver");
		//DBに実際に接続する
		cnct = DriverManager.getConnection(url,id,pw);
		//実行結果をqueryに代入している
		String query = "select * from meisai where mei_id = (select max(mei_id) from meisai)" ;

		//プリコンパイルの使用準備が完了
		pst = cnct.prepareStatement(query);
		System.out.println("pst:" + pst);

		rs = pst.executeQuery();
		//ここのwhile文でrsに格納されている。
		//値を一行一行取り出して出力している。
			while(rs.next()) {
				//商品コードを格納
			mei_id = rs.getInt("mei_id");
			}

		} catch (Exception e) {
		}
		return mei_id;
		}

	public void InsertMeisai(int mei_id,String user_id,int pro_cd,Date ko_date,int mei_price) {
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
		String query = "Insert into meisai values(?,?,?,?,?)" ;

		//プリコンパイルの使用準備が完了
		pst = cnct.prepareStatement(query);
		//?に値を代入
		pst.setInt(1, mei_id);
		pst.setInt(2, Integer.parseInt(user_id));
		pst.setInt(3, pro_cd);
		pst.setDate(4, ko_date);
		pst.setInt(5, mei_price);

		System.out.println("pst:" + pst);

		pst.executeUpdate();
		System.out.println("Insert適応しました。");

		} catch (Exception e) {
		}
		}

	public void setZaiko(int pro_id,int newStock) {
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
		String query = "update product set stock_no = ? where pro_cd = ?";

		//プリコンパイルの使用準備が完了
		pst = cnct.prepareStatement(query);
		//?に値を代入
		pst.setInt(1, newStock);
		pst.setInt(2, pro_id);

		System.out.println("pst:" + pst);

		pst.executeUpdate();
		System.out.println("Zaiko適応しました。");

		} catch (Exception e) {
		}
		}

}
