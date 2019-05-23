package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FinDAO {

	//update文記述
	public void Update(ArrayList<String> idlist, ArrayList<String> kosulist) throws SQLException {
		//url id pw を設定
				String url = "jdbc:mysql://localhost/lesson20xx";
				String id = "root";
				String pw = "password";
				//DBに接続する際のつかうやつ
				Connection cnct = null;
				//SQL実行結果を格納するやつ
				Statement st = null;
				//SQLを実行するのに使うやつ
				ResultSet rs = null;

				PreparedStatement pst = null;


				try {
					//MYSQLのJDBCドライバを使うよって定義
					Class.forName("com.mysql.jdbc.Driver");//MYSQLにアクセス
					//DBに接続する
					cnct = DriverManager.getConnection(url,id,pw);

					//接続に失敗したらSQLExceptionを投げる
					//失敗した場合の布石
					//st = cnct.createStatement();

					//自動コミット解除
					cnct.setAutoCommit(false);





					//rs = st.executeQuery(sql);



					st = cnct.createStatement();
//					pst = cnct.prepareStatement(sql);
					for(int i = 0; i < idlist.size();i++) {
						DetailDAO  dd = new DetailDAO();
						int zaiko = dd.setZaiko2(Integer.parseInt(idlist.get(i)));
						System.out.println("現在の在庫数:" + zaiko);
						System.out.println("購入個数 :"+kosulist.get(i));
						zaiko = zaiko - Integer.parseInt(kosulist.get(i));
						System.out.println("在庫 :" + zaiko);
						String sql = "update product set stock_no = "+ zaiko+" where pro_cd = " +idlist.get(i);
//						pst.setInt(1, zaiko);
						System.out.println("next");
						System.out.println(sql);
//						pst.setString(2, idlist.get(i));

						st.executeUpdate(sql);
						cnct.commit();


						//System.out.println("現在のsql : "+sql);
					}


					System.out.println("こみっとした");

				}catch(ClassNotFoundException ex) {//ClassNotfoundがでたらここ
					ex.printStackTrace();
				}catch(SQLException ex) {//SQLExceptionがでたらここ
					ex.printStackTrace();
					cnct.rollback();
					System.out.println("ロールバック");
				} finally {//ここは絶対に実行
					try {
						//接続を解除
						if (rs!=null) rs.close();
						if (st!=null) st.close();
						if (cnct!=null) cnct.close();
					}catch(Exception ex) {}
				}
	}

}
