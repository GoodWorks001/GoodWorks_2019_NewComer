package web;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDAO {

	public ArrayList<String> cate(){
		ArrayList<String> array = new ArrayList<>();
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			st = cnct.createStatement();
			System.out.println("C");
			//SELECT文を実行する
			String sql = "select * from category";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			System.out.println("D");
			//内容が取り出せているなら
			while(rs.next()){
				//カテゴリーごとの名前を取得
				array.add(rs.getString("cat_name"));
				System.out.println("E");
			}
			System.out.println("F");
			//カテゴリ名を格納したリストを返す
			return array;
			//クラス関連のエラーハンドリング
		} catch(ClassNotFoundException ex){
			System.out.println("JDBCねえよ？");
			return array;
			//SQL関連のエラーハンドリング
		} catch(SQLException ex) {
			System.out.println("SQLミスってるよ？");
			return array;
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				System.out.println("Loginメソッド終了");
			} catch(Exception ex) { }
		}
	}


	/*
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps= null;

	public ArrayList<CategoryBean> search() {

//		検索結果
		ArrayList<CategoryBean> cat = new ArrayList<CategoryBean>();
			//SQL

			try{
				Class.forName("com.mysql.jdbc.Driver");

				String url = "jdbc:mysql://localhost/ecsample";
				String id = "root";
				String pwd = "password";

				 conn = DriverManager.getConnection(url,id,pwd);
				 String query = "select * from category";
				 ps = conn.prepareStatement(query);

				 rs = ps.executeQuery();


				 while(rs.next()){
					 CategoryBean cb = new CategoryBean();
					 cb.setId(rs.getInt("cat_id"));
					 cb.setName(rs.getString("cat_name"));
					 cat.add(cb);

				 }

			}catch(ClassNotFoundException ex){
				ex.printStackTrace();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			finally{
				try{
					if(conn != null){
						conn.close();
					}
					if(ps != null){
						ps.close();
					}
					if(rs != null){
						rs.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			return cat;

	}


	public CategoryBean search(int code) {
		CategoryBean cb = new CategoryBean();

		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/kadai";
			String id = "root";
			String pwd = "password";

			 conn = DriverManager.getConnection(url,id,pwd);
			 String query = "select cat_name from category where cat_id = ?";
			 ps = conn.prepareStatement(query);
			 ps.setInt(1, code);

			 rs = ps.executeQuery();

			 while(rs.next()){
				 cb.setName(rs.getString("cat_name"));
			 }

		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally{
			try{
				if(conn != null){
					conn.close();
				}
				if(ps != null){
					ps.close();
				}
				if(rs != null){
					rs.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return cb;

	}
*/

}
