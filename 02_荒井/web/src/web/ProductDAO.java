package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {

	public ArrayList<String> getproduct(String search){


		//ArrayList<String>をインスタンスする
		ArrayList<String> pro = new ArrayList<String>();


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

					 //stに格納
					 st = cnct.createStatement();



					 search = "\"" + search + "\"";

					 //select文の結果をsqlに格納
                     String sql = "select*from product where pro_name=" + search;

                     //sqlの中に何が入っているか確認するために表示させる
                     System.out.println(sql);

                     //rsに格納する
                     rs = st.executeQuery(sql);


					 while(rs.next()){
						 //DBの中のカラムの値の中をproに格納
						 pro.add(rs.getString("pro_name"));
						 pro.add(rs.getString("pro_price"));
						 pro.add(rs.getString("pro_cd"));

						 return pro;

						}


				}catch(ClassNotFoundException ex){

					return pro;


				}catch(SQLException e){

					return pro;

				}


		return pro;



	}







	public ArrayList<String> getcat(String category){


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

					 category = "\"" + category + "\"";

                     String sql = "select*from product where cat_id=" + category;

                     System.out.println(sql);

                     rs = st.executeQuery(sql);


					 while(rs.next()){
						 //DBの中のカラムの値の中をproに格納
						 cat.add(rs.getString("pro_name"));
						 cat.add(rs.getString("pro_price"));
						 cat.add(rs.getString("pro_cd"));

						 return cat;

						}


				}catch(ClassNotFoundException ex){

					return cat;


				}catch(SQLException e){

					return cat;

				}


				return cat;



	}


}
