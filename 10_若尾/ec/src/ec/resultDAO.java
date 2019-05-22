package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class resultDAO {

	public ProductBean result(int cd) {

		//kensakuDAOのkennsakuメソッドの開始の確認
		System.out.println("resultDAOを開始しました");

		// DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/ecdb01";// DBの位置を特定
		String id = "root";
		String pw = "password";

		// DBに接続する際に使うやつ
		Connection cnct = null;// 接続に失敗した場合,例外を送出する
		// SQL実行結果を格納するやつ
		Statement st = null;// プリコンパイルなどをしない単純なSQLに使用
		// SQLを実行するときにつかうやつ
		ResultSet rs = null;// レコードごとにデータをアクセス

		ProductBean pb = new ProductBean();

		// try文
		try {

			// MySQLのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");
			// DBに実際に接続する
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();

			rs=st.executeQuery("select pro_id,pro_name,cat_name,pro_price,stock_no,pro_msg,pro_img from product left outer join category on product.cat_id=category.cat_id where pro_id="+cd);

			rs.next();


			pb.setName(rs.getString("pro_name"));
			pb.setCategory(rs.getString("cat_name"));
			pb.setPrice(rs.getInt("pro_price"));
			pb.setStock(rs.getInt("stock_no"));
			pb.setMsg(rs.getString("pro_msg"));
			pb.setImg(rs.getString("pro_img"));
			pb.setCd(rs.getInt("pro_id"));

		}

		//戻り値でArrayListのlistをサーブレットに渡す

				// catch文
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex1) {
			ex1.printStackTrace();
		} finally {
			// 下記
			try {
				// 各クラス・インターフェースにあるclose()メソッドで
				// 接続を解除する
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
			} catch (Exception ex) {

			}
		}

		return pb;

	}

	//メソッド二つ目

	//ArrayList String型メソッド（String受け皿付き）
		ArrayList<String> kencate(String catid) {
			ArrayList<String> list=new ArrayList<String>();

			//kensakuDAOのkennsakuメソッドの開始の確認
			System.out.println("kensakuDAOを開始しました");

			//持ってきたcatnameの値の確認
			System.out.println(catid);

			// DBに接続する際に必要な情報を変数に格納
			String url = "jdbc:mysql://localhost/ecdb01";// DBの位置を特定
			String id = "root";
			String pw = "password";

			// DBに接続する際に使うやつ
			Connection cnct = null;// 接続に失敗した場合,例外を送出する
			// SQL実行結果を格納するやつ
			Statement st = null;// プリコンパイルなどをしない単純なSQLに使用
			// SQLを実行するときにつかうやつ
			ResultSet rs = null;// レコードごとにデータをアクセス

			// try文
			try {

				// MySQLのJDBCドライバを使うよって定義
				Class.forName("com.mysql.jdbc.Driver");
				// DBに実際に接続する
				cnct = DriverManager.getConnection(url, id, pw);
				//ドライバと接続
				st = cnct.createStatement();

				//変数の値に””をつけている
				catid = "\""+catid+"\"";

				// SQL文の実行を行っています
				String sql ="select * from product where cat_id="+catid;
				//sqlにDBの値をいれる
				rs = st.executeQuery(sql);

				//DBでもってきた値の確認
				System.out.println(sql);

				// while文でrsに格納されている
				// 値を1行1行取り出して出力している
				while (rs.next()) {

					//DBのなかのカラムにお値をArrayListに入れてる
					list.add(rs.getString("pro_name"));
					list.add(rs.getString("pro_price"));
					list.add(rs.getString("pro_id"));
				}
				//戻り値でArrayListのlistをサーブレットに渡す
				return list;

			}
			// catch文
			catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				return list;
			} catch (SQLException ex1) {
				ex1.printStackTrace();
				return list;
			} finally {
				// 下記
				try {
					// 各クラス・インターフェースにあるclose()メソッドで
					// 接続を解除する
					if (rs != null)
						rs.close();
					if (st != null)
						st.close();
					if (cnct != null)
						cnct.close();
				} catch (Exception ex) {

				}
			}
		}
}

