package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ECDAO {

  //JDBCへの接続と処理を行うメソッド
 public String[] Access(String name) {

		 String[] logins = new String[3];


		 String login_name = null;
		 String user_id = null;
		 String login_pw = null;



		//DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";



		//CBに接続する際に使うやつ
		Connection cnct = null;

		PreparedStatement pst = null;


		//SQLを実行するときに使うやつ
		Statement st = null;


		//SQL実行結果を格納するやつ
		ResultSet rs = null;




		try {
			//MySqlのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");

			//DBに実際に接続する
			 cnct = DriverManager.getConnection(url,id,pw);


			 String query = "SELECT*from user where user_name = ?";


			 //プリコンパイルの使用準備が完了
			 pst = cnct.prepareStatement(query);



			 //?に値を代入
			 pst.setString(1, name);
			 System.out.println(pst);


			 //SQLの実行を行い、結果をrsに代入
			 rs = pst.executeQuery();

			 user_id = null;
			 login_pw = null;



			 //rsに格納されているテーブル内の全要素を表示するまで繰り返す
			 //.next()で行を移動させる
			 while(rs.next()) {
				 login_name = rs.getString("user_name");
				 user_id = rs.getString("user_id");
				 login_pw = rs.getString("login_pw");
			 }




			 //値を代入
           logins[0] = user_id;
           logins[1] = login_pw;
           logins[2] = login_name;




			//クラスが見つからなかった場合、この内容を表示
		}catch(ClassNotFoundException ex){
			 ex.printStackTrace();



			 //DBにアクセスする際、不具合があった場合、この内容を表示
		} catch(SQLException ex) {
			  ex.printStackTrace();



		} finally {

			//DBの接続を解除する
			 try {
		     if (rs !=null) rs.close();
		     if (st !=null) st.close();
			 if (cnct !=null) cnct.close();

			 } catch(Exception ex) { }

		}


		return logins;

 }

}



