package ECpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import web1.CatBean;

public class DAO {
	public Boolean log(String nam, String pss) {
		//変数宣言をしてます↑
		//DBに接続する際に必要な情報
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";
		//接続用↑
		Connection cnct = null;
		//SQLを実行してます↑
		PreparedStatement roll = null;
		//実行結果を格納してます↑
		ResultSet rs = null;
		//判定です↑

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//クラスのアクセス定義です↑
			cnct = DriverManager.getConnection(url, id, pw);
			//ログイン処理DB接続するやつです↑
			String query = "SELECT * from user where user_id = ? AND login_pw =?";
			roll = cnct.prepareStatement(query);
			//レコードの表示です↑
			roll.setString(1, nam);
			roll.setString(2, pss);
			rs = roll.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return false;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;

		} finally {

			try {
				if (rs != null)
					rs.close();
				if (roll != null)
					roll.close();
				if (cnct != null)
					cnct.close();

			} catch (Exception ex) {
			}
			}
		}
		public ArrayList<CatBean> cats(){

			String url = "jdbc:mysql://localhost/lesson20xx";
			String id = "root";
			String pw = "password";

			Connection cnct = null;
			Statement st = null;
			ResultSet rs = null;

			ArrayList<CatBean> catlist = new ArrayList<CatBean>();
			//アレイリスト作成します↑
			try {

				Class.forName("com.mysql.jdbc.Driver");

				cnct = DriverManager.getConnection(url, id, pw);

				st = cnct.createStatement();

				rs = st.executeQuery("SELECT * FROM category5");

				while (rs.next()) {

					CatBean cat = new CatBean();
					//CatBeanをインスタンス化してます↑
					cat.setCat_id(rs.getInt("cat_id"));
					cat.setCat_name(rs.getString("cat_name"));
					catlist.add(cat);
				}

				return catlist;
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				return catlist;
			} catch (SQLException ex) {
				ex.printStackTrace();
				return catlist;
			} finally {
				try {

					if (rs != null)
						rs.close();
					if (st != null)
						st.close();
					if (cnct != null)
						cnct.close();
					return catlist;
				} catch (Exception ex) {
				}
			}
		}
}
