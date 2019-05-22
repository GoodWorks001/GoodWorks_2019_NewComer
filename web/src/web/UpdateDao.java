package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

public class UpdateDao {

	public void update(ArrayList<String> list , ArrayList<Integer> kosulist , ArrayList<Integer> zaikolist ) throws ServletException, IOException, SQLException {
  //  public void update(ArrayList<ProductBean>)


		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		System.out.println("2");
		try {
			//ドライバーに接続する為の定型文、ゲーム開始のボタンのようなもの
			Class.forName("com.mysql.jdbc.Driver");//p26
			//引数としてurl,id,pwをゲットコネクションメソッドに渡している
			cnct = DriverManager.getConnection(url, id , pw);
			//p37、繋げたかどうかの最終確認
			System.out.println("3");

            cnct.setAutoCommit(false);

			String sql="update product set stock_no = ? where pro_cd =  ?";
			st = cnct.prepareStatement(sql);
			System.out.println(sql);

			for(int i=0; i<list.size(); i++) {
				int zaiko = zaikolist.get(i)- kosulist.get(i);
				st.setInt(1, zaiko);
				st.setString(2, list.get(i));
				st.executeUpdate();
			}

			cnct.commit();

			//rs = st.executeQuery(sql);

		}catch(ClassNotFoundException ex) {//JDBCドライバがない、 構文が違う
			ex.printStackTrace();

		}catch(SQLException ex) {//データベースへの接続の失敗時
			ex.printStackTrace();
            cnct.rollback();
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

















	public void Testupdate(ArrayList<ProductBean> list) throws ServletException, IOException, SQLException {


                //接続のためのurl,id,passの設定
				String url = "jdbc:mysql://localhost/ecsite";
				String id = "root";
				String pw = "password";
                
				//DB接続に使う
				Connection cnct = null;
				//sql実行結果を格納
				PreparedStatement st = null;
				//sql実行に使う
				ResultSet rs = null;

				System.out.println("2");
				try {
					//ドライバーに接続する為の定型文、ゲーム開始のボタンのようなもの
					Class.forName("com.mysql.jdbc.Driver");//p26
					//引数としてurl,id,pwをゲットコネクションメソッドに渡している
					cnct = DriverManager.getConnection(url, id , pw);
					//p37、繋げたかどうかの最終確認
					System.out.println("3");

					//自動コミットモードの解除
		            cnct.setAutoCommit(false);

					String sql="update product set stock_no = ? where pro_cd =  ?";
					st = cnct.prepareStatement(sql);
					System.out.println(sql);

					for(int i=0; i<list.size(); i++) {
						
						//在庫数から購入数を減産
						int zaiko = list.get(i).getStock_no() - list.get(i).getKosuu();
						System.out.println("在庫は・・・" + zaiko);
						//updateするために?へ格納
						st.setInt(1, zaiko);
						//listを?に格納
						st.setInt(2, list.get(i).getPro_cd());
						//アップデート開始
						st.executeUpdate();
					}

					cnct.commit();

					//rs = st.executeQuery(sql);

				}catch(ClassNotFoundException ex) {//JDBCドライバがない、 構文が違う
					ex.printStackTrace();

				}catch(SQLException ex) {//データベースへの接続の失敗時
					ex.printStackTrace();
		            cnct.rollback();
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
