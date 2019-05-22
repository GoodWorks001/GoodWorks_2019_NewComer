package web;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ItemDAO {

	public ArrayList<String> name(String name){
		ArrayList<String >list=new ArrayList<String>();

		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		System.out.println("2");
		try {
			//ドライバーに接続する為の定型文、ゲーム開始のボタンのようなもの
			Class.forName("com.mysql.jdbc.Driver");//p26
			//引数としてurl,id,pwをゲットコネクションメソッドに渡している
			cnct = DriverManager.getConnection(url, id , pw);
			//p37、繋げたかどうかの最終確認
			st = cnct.createStatement();
			System.out.println("3");

			name= "\""+name+"\"";
			//セレクト文格納
			String sql="select * from product where pro_name = "+name;
			System.out.println(sql);

            //セレクト文実行
			rs = st.executeQuery(sql);

			//内容が取り出せているなら
			while(rs.next()){
                 //商品情報をarrayリストに格納
                 list.add(rs.getString("pro_name"));
                 list.add(rs.getString("pro_price"));
                 list.add(rs.getString("pro_cd"));

			}
            //while文のlistを返す
			return list;

		}catch(ClassNotFoundException ex) {//JDBCドライバがない、 構文が違う
			ex.printStackTrace();
			return list;
		}catch(SQLException e) {//データベースへの接続の失敗時
			e.printStackTrace();
			return list;
		}finally {//finally = try catch の中で必ずする処理
			try {
				//必須！各クラス・インターフェイスにあるcloseメソッドで接続を解除する
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(cnct!=null) cnct.close();
			}   catch(Exception ex) {

			}
		}
	}


		public ArrayList<String> category(String category){
			ArrayList<String >list=new ArrayList<String>();

			String url = "jdbc:mysql://localhost/ecsite";
			String id = "root";
			String pw = "password";

			Connection cnct = null;
			Statement st = null;
			ResultSet rs = null;

			System.out.println("2");
			try {
				//ドライバーに接続する為の定型文、ゲーム開始のボタンのようなもの
				Class.forName("com.mysql.jdbc.Driver");//p26
				//引数としてurl,id,pwをゲットコネクションメソッドに渡している
				cnct = DriverManager.getConnection(url, id , pw);
				//p37、繋げたかどうかの最終確認
				st = cnct.createStatement();
				System.out.println("3");

				category= "\""+category+"\"";
				String sql="select * from product where cat_id = "+category;
				System.out.println(sql);

                //セレクト文実行
				rs = st.executeQuery(sql);

				while(rs.next()){
	                 //dbのカラム値をarrayリストに
	                 list.add(rs.getString("pro_name"));
	                 list.add(rs.getString("pro_price"));
	                 list.add(rs.getString("pro_cd"));

				}
	            //while文のlistを返す
				return list;

			}catch(ClassNotFoundException ex) {//JDBCドライバがない、 構文が違う
				ex.printStackTrace();
				return list;
			}catch(SQLException e) {//データベースへの接続の失敗時
				e.printStackTrace();
				return list;
			}finally {//finally = try catch の中で必ずする処理
				try {
					//必須！各クラス・インターフェイスにあるcloseメソッドで接続を解除する
					if(rs != null) rs.close();
					if(st != null) st.close();
					if(cnct!=null) cnct.close();
				}   catch(Exception ex) {

				}
			}
	}



	public ArrayList<String> ID(String ID){
			ArrayList<String >list2=new ArrayList<String>();

			String url = "jdbc:mysql://localhost/ecsite";
			String id = "root";
			String pw = "password";

			Connection cnct = null;
			Statement st = null;
			ResultSet rs = null;
			//String [] result= {"","","","",""};


			System.out.println("2");
			try {
				//ドライバーに接続する為の定型文、ゲーム開始のボタンのようなもの
				Class.forName("com.mysql.jdbc.Driver");//p26
				//引数としてurl,id,pwをゲットコネクションメソッドに渡している
				cnct = DriverManager.getConnection(url, id , pw);
				//p37、繋げたかどうかの最終確認
				st = cnct.createStatement();
				System.out.println("3");

				ID= "\""+ID+"\"";
				String sql="select * from product where pro_cd = "+ID;
				/*String sql="SELECT product.pro_name, product.stock_no, product.pro_price,"
						+ " product.pro_img, product.pro_msg, category.cat_name FROM product"
						+ " INNER JOIN category WHERE (product.cat_id = category.cat_id) AND "
						+ "product.pro_cd = ";*/

				System.out.println(sql);


				rs = st.executeQuery(sql);

				while(rs.next()){
	                 //dbのカラム値をarrayリストに

					 list2.add(rs.getString("pro_img"));
	                 list2.add(rs.getString("pro_name"));
	                 list2.add(rs.getString("category"));
	                 list2.add(rs.getString("pro_price"));
	                 list2.add(rs.getString("stock_no"));
	                 list2.add(rs.getString("pro_msg"));


				}
	            //while文のlistを返す
				return list2;

			}catch(ClassNotFoundException ex) {//JDBCドライバがない、 構文が違う
				ex.printStackTrace();
				return list2;
			}catch(SQLException e) {//データベースへの接続の失敗時
				e.printStackTrace();
				return list2;
			}finally {//finally = try catch の中で必ずする処理
				try {
					//必須！各クラス・インターフェイスにあるcloseメソッドで接続を解除する
					if(rs != null) rs.close();
					if(st != null) st.close();
					if(cnct!=null) cnct.close();
				}   catch(Exception ex) {

				}
			}
		}


}





