package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CartDAO {

	ItemBean datailbean = new ItemBean();

	public ItemBean cart(int pro_cd) {
	//変数ににデータベースのurl,MySQLにログインする際のid,passwordを代入

			String url = "jdbc:mysql://localhost/ecsite";//データベース名
			String id = "root";
		 	String pw = "password";
		 	//ヌルをいれる変数を定義している、Connection,Statement,ResultSetはデータ型のようなもの
		 	//使うために変数に代入している
		 	Connection cnct = null;
		 	//Statement

		 	PreparedStatement pst = null;
		 	//初期値を入れているnull = 0のようなもの
		 	ResultSet rs = null;

		 	try {
		 //ドライバーに接続する為の定型文、ゲーム開始のボタンのようなもの
		 		Class.forName("com.mysql.jdbc.Driver");//p26
		 		//引数としてurl,id,pwをゲットコネクションメソッドに渡している
		 		cnct = DriverManager.getConnection(url, id , pw);
		 		//p37、繋げたかどうかの最終確認
			 		pst = cnct.prepareStatement("SELECT * FROM product where pro_price=? ");

		 				 		 //ここより上は基本的には定型文、ｐ43select文を格納できるメソッド
			 				pst.setInt(1,pro_cd);
			 				rs = pst.executeQuery();

			 		while(rs.next()) {//resultSetで一行ずつ見ていく文
			 			//select文の入ってるrsで呼び出したnameを変数nameに代入している
			 			String Name = rs.getString("pro_name");
			 			int Stock = rs.getInt("stock_no");
			 			int Price = rs.getInt("pro_price");
			 			int Cat_id = rs.getInt("cat_id");
			 			String Msg = rs.getString("pro_msg");


			 			datailbean.setpro_name(Name);
			 			datailbean.setstock_no(Stock);
			 			datailbean.setpro_price(Price);
			 			datailbean.setcat_id(Cat_id);
			 			datailbean.setpro_msg(Msg);
			 		}

		 	}catch(ClassNotFoundException ex) {//JDBCドライバがない、 構文が違う
		 	 ex.printStackTrace();
		 	}catch(SQLException ex) {//データベースへの接続の失敗時
		 	 ex.printStackTrace();
		 	}finally {//finally = try catch の中で必ずする処理
		 		try {
		 			//必須！各クラス・インターフェイスにあるcloseメソッドで接続を解除する
		 			if(rs != null) rs.close();
		 			if(pst != null) pst.close();
		 			if(cnct!=null) cnct.close();
		 		}   catch(Exception ex) {}//例外を投げる
		     }

			return datailbean;
	}
}

