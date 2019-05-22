package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UpDateDao {
	//UPDATEメソッド
		public void update(ArrayList<detailBean> dlist , ArrayList<Integer> kosulist) throws SQLException{
			//接続のためのurlとIDとpassの設定
			String url = "jdbc:mysql://localhost/ecsite";
			String id = "root";
			String pass = "password";
			//ここまで
			//DB接続に接続する際に使う
			Connection cnct = null;
			//SQL実行結果を格納する
			PreparedStatement pst = null;
			//SQL実行するときに使う
			ResultSet rs = null;
			try {

				//ドライバを使用する定義
				Class.forName("com.mysql.jdbc.Driver");

				//ログインのための設定
				cnct = DriverManager.getConnection(url,id,pass);


				//自動コミットモードの解除
				cnct.setAutoCommit(false);

				//SELECT文を実行する

				String sql = "update product set stock_no = ? where pro_cd = ?";
				pst = cnct.prepareStatement(sql);


				for(int i = 0; i < dlist.size();i++){

					//在庫数から購入数を減算
					int zaiko = dlist.get(i).getStock() - kosulist.get(i);

					//updateするために?へ格納
					pst.setInt(1, zaiko);
					//idを?に格納
					pst.setInt(2, dlist.get(i).getP_cd());
					//実行文確認

					//アップデート開始
					pst.executeUpdate();

				}

				//コミットしてるよ
				cnct.commit();

			} catch(ClassNotFoundException ex){
				//↑クラス関連のエラーハンドリング

			} catch(SQLException ex) {
				ex.printStackTrace();
				//↑SQL関連のエラーハンドリング

				cnct.rollback();

				//最後に必ず行う処理
			} finally {
				try {
					//接続解除処理
					if (rs!=null) rs.close();
					if (pst!=null) pst.close();
					if (cnct!=null) cnct.close();

				} catch(Exception ex) { }
			}
		}
}
