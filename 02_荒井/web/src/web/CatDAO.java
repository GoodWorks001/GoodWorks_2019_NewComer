package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CatDAO {

	public ArrayList<String> getcatlist() {

		ArrayList<String> cat = new ArrayList<String>();


		//DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";

		//CBに接続する際に使うやつ
		Connection cnct = null;


		//SQLを実行するときに使うやつ
		Statement st = null;

		//SQL実行結果を格納するやつ
		ResultSet rs = null;





		try {

					//MySqlのJDBCドライバを使うよって定義
					Class.forName("com.mysql.jdbc.Driver");

					//DBに実際に接続する
					 cnct = DriverManager.getConnection(url,id,pw);

					 st = cnct.createStatement();


					 rs = st.executeQuery("select*from category2");



		while(rs.next()){
			cat.add(rs.getString("cat_name"));


		}



		}catch(ClassNotFoundException ex){


		}catch(SQLException e){

		}
		return cat;

	}



}
