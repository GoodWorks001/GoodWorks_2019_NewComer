package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class searchDAO {

	//private ArrayList<String> nameList =new ArrayList<String>();
	//private ArrayList<Integer> priceList =new ArrayList<Integer>();
	//private ArrayList<SearchBean> itemList =new ArrayList<SearchBean>();


	public void JDBC(String name ,String ID) {


	// DBMS への接続
	String url = "jdbc:mysql://localhost/lesson20xx";
	// mysqlに接続するための情報をString型変数idに格納
	String id = "root";
	// mysqlに接続するための情報をString型変数pwに格納
	String pw = "password";

	// DBに接続する際に使うやつ
	Connection cnct = null;
	// SQL実行結果を格納するやつ
	PreparedStatement pst = null;
	// SQLを実行する際に使うやつ
	ResultSet rs = null;

	/*String src = search;
	//srcが空欄またはnullの時
	if(src.equals("") || src ==null) {
		src ="nasi";
	}

	//cgyが空欄またはnullの時
	String cgy =category0;
	if (cgy.equals("") || cgy ==null) {
		cgy="nasi";
	}*/

	//DB接続
	try
	{

		// JDBC ドライバの登録、SQLのJDBCを使う定義
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println(1);
		// DBに実際に接続、url、id、passwordを使って
		cnct = DriverManager.getConnection(url, id, pw);
		System.out.println(2);

		//SQL文の格納
		String query="SELECT * FROM product where pro_name = ? AND cat_id = ?";
			System.out.println(query);
		// 接続に失敗した時にSQLExceptionを投げる
		pst = cnct.prepareStatement(query);
		pst.setString(1,name);
		pst.setString(2,ID);
		//sqlの実行
		rs = pst.executeQuery();

		// while文でrsに格納されている
		// rs.nextで１行１行下に行くのをwhileで繰り返し、一番下まで行くと終わり
		while (rs.next()) {
		//カラム名を指定し、それぞれのデータを取得する
		nameList.add(rs.getString("pro_name"));
		priceList.add(rs.getInt("pro_price"));
		}
	//参照すべきクラスが見つからなかった時
	}catch(ClassNotFoundException ex){
		System.out.println("ClassNotFound");
		ex.printStackTrace();

	//SQLに問題があった時
	}catch(SQLException ex){
		System.out.println("SQLException");
		ex.printStackTrace();


	// 必ず行う処理
	}finally{

		try {
			// close メソッドでDBとの接続を解除
			// ゲームが終わったら電源切るのと同じ
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (cnct != null)
				cnct.close();

		} catch (Exception ex) {
		}
	}
  }
}


