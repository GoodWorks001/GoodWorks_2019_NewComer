package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LastDAO {

	public void insert(int pro_cd, int user_id, int count, int money){

		// DBにアクセスする情報変数
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;


		// DBに接続
		try {

			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pw);

			//自動コミットモード解除
			cnct.setAutoCommit(false);

			pst = cnct.prepareStatement("INSERT into meisai values(null,?,?,now(),?)");

			try {
				int zei = (int)((money*count)*1.08);

				//カートの商品ごとで値を入れる
				pst.setInt(1, user_id);
				pst.setInt(2, pro_cd);
				pst.setInt(3, zei);

				//値を入れる（更新）はUPDATE
				pst.executeUpdate();

				//コミット実行
				cnct.commit();


			}catch(SQLException e) {
				//ロールバック(=更新する前のデータに戻す)
				cnct.rollback();
				e.printStackTrace();
			}


		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();


		}catch (SQLException e) {
			e.printStackTrace();


		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (cnct != null)
					cnct.close();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}



	public void update(int count,int pro_cd){

		// DBにアクセスする情報変数
				String url = "jdbc:mysql://localhost/ecsite";
				String id = "root";
				String pw = "password";

				Connection cnct = null;
				PreparedStatement pst = null;
				ResultSet rs = null;


				// DBに接続
				try {

					Class.forName("com.mysql.jdbc.Driver");
					cnct = DriverManager.getConnection(url, id, pw);

					//自動コミットモード解除
					cnct.setAutoCommit(false);

					//在庫－買った個数の結果を在庫にセット
					pst = cnct.prepareStatement("UPDATE product set stock_no = (stock_no-?) where pro_cd =?");

					try {


						//カートの商品ごとで値を入れる
						pst.setInt(1, count); //買った数
						pst.setInt(2, pro_cd); //商品コード


						//値を入れる（更新）はUPDATE
						pst.executeUpdate();

						//コミット実行
						cnct.commit();


					}catch(SQLException e) {
						//ロールバック(=更新する前のデータに戻す)
						cnct.rollback();
						e.printStackTrace();
					}


				}catch (ClassNotFoundException ex) {
					ex.printStackTrace();


				}catch (SQLException e) {
					e.printStackTrace();


				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pst != null)
							pst.close();
						if (cnct != null)
							cnct.close();

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
}