package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Cat_DAO {
	public ArrayList<CartBean> cat_gets(){
		//DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/sekkei";
		String id = "root";
		String pw = "password";
		//DBに接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQLを実行するときに使うやつ
		ResultSet rs = null;
		//CatBean型アレイリスト
		ArrayList<CartBean> catlist = new ArrayList<CartBean>();

		try {
			//↓Class.forNameメソッドを使用し
			//ドライバのロードとインスタンス化を行う
			Class.forName("com.mysql.jdbc.Driver");
			//↓DBに実際に接続する
			cnct = DriverManager.getConnection(url, id, pw);
			//↓接続に失敗した場合SQlexceptionを投げる
			st = cnct.createStatement();
			//↓SQL文の実行を行っています
			//実行結果をrsに代入している
			rs = st.executeQuery("SELECT * FROM product");
			//↓ここのwhire文でrsに格納されている
			//値を一行一行取り出して出力している。
			while (rs.next()) {
				//CatBeansインスタンス化
				CartBean cb = new CartBean();
				//setterを使用し、インスタンス格納(rs.getなんちゃら)
				cb.setName(rs.getString("pro_name"));
				cb.setKakaku(rs.getInt("pro_price"));
				//catBean.setCat_id(rs.getInt("cat_id"));
				//catBean.setCat_name(rs.getString("cat_name"));

				//そのインスタンスをアレイリストに格納
				catlist.add(cb);
			}

			//
			return catlist;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return catlist;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return catlist;
		} finally {
			try {
				//↓各クラス・インターフェースにある
				//close()メソッドで接続を解除する
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
