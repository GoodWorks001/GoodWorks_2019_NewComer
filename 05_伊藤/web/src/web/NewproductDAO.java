package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewproductDAO {
	public String proJDBC(String pro ,String getkaramu) {
		// DBMS への接続
		String url = "jdbc:mysql://localhost/lesson20xx";
		// mysqlに接続するための情報をString型変数idに格納
		String id = "root";
		// mysqlに接続するための情報をString型変数pwに格納
		String pw = "password";

		// DBに接続する際に使うやつ
		Connection cnct = null;
		// SQL実行結果を格納するやつ
		Statement st = null;
		// SQLを実行する際に使うやつ
		ResultSet rs = null;

		String result =null;
		//
		PreparedStatement pst = null;


		//DB接続
		try
		{

		// JDBC ドライバの登録、SQLのJDBCを使う定義
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println(1111);
		// DBに実際に接続、url、id、passwordを使って
		cnct = DriverManager.getConnection(url, id, pw);
		//sqlという変数にselect文を入れる
		String sql ="select * from product where pro_cd =? ";
		System.out.println(sql);
		//プリコンパイルする準備
		pst=cnct.prepareStatement(sql);
		//?に代入
		pst.setString(1,pro);
		System.out.println(pst);

		System.out.println(1111111111);
		rs = pst.executeQuery();
		//リストにぶち込む
		while(rs.next()) {
			result=rs.getString(getkaramu);
			System.out.println(result);
		}
		}catch(ClassNotFoundException ex){
		System.out.println("ClassNotFound");
		ex.printStackTrace();


		//SQLに問題があった時
		}catch(Exception ex){
		System.out.println("SQLException");
		ex.printStackTrace();



		// 必ず行う処理
		}finally{

		try {
		// close メソッドでDBとの接続を解除
		// ゲームが終わったら電源切るのと同じ
			if (rs != null)
				rs.close();
			if (st != null)
			st.close();
			if (cnct != null)
				cnct.close();

			} catch (Exception ex) {
			}
		}
		return result;
	}


public String search_cat_id(String cat_id) {
	// DBMS への接続
	String url = "jdbc:mysql://localhost/lesson20xx";
	// mysqlに接続するための情報をString型変数idに格納
	String id = "root";
	// mysqlに接続するための情報をString型変数pwに格納
	String pw = "password";

	// DBに接続する際に使うやつ
	Connection cnct = null;
	// SQL実行結果を格納するやつ
	Statement st = null;
	// SQLを実行する際に使うやつ
	ResultSet rs = null;

	String result =null;
	//
	PreparedStatement pst = null;


	//DB接続
	try
	{

	// JDBC ドライバの登録、SQLのJDBCを使う定義
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println(1111);
	// DBに実際に接続、url、id、passwordを使って
	cnct = DriverManager.getConnection(url, id, pw);
	//sqlという変数にselect文を入れる
	String sql ="select * from category where cat_id =? ";
	System.out.println(sql);
	//プリコンパイルする準備
	pst=cnct.prepareStatement(sql);
	//?に代入
	pst.setString(1,cat_id);
	System.out.println(pst);

	System.out.println(1111111111);
	rs = pst.executeQuery();
	//リストにぶち込む
	while(rs.next()) {
		result=rs.getString("cat_name");
		System.out.println(result);
	}
	}catch(ClassNotFoundException ex){
	System.out.println("ClassNotFound");
	ex.printStackTrace();


	//SQLに問題があった時
	}catch(Exception ex){
	System.out.println("SQLException");
	ex.printStackTrace();



	// 必ず行う処理
	}finally{

	try {
	// close メソッドでDBとの接続を解除
	// ゲームが終わったら電源切るのと同じ
		if (rs != null)
			rs.close();
		if (st != null)
		st.close();
		if (cnct != null)
			cnct.close();

		} catch (Exception ex) {
		}
	}
	return result;
}
}



