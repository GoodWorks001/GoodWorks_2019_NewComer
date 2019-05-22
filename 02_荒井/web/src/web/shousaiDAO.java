package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class shousaiDAO {

	public ProductBean shousai(int cd) {

		ProductBean bean = new ProductBean();

		//DBに接続する際に必要な情報を変数に格納
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";

		//CBに接続する際に使うやつ
		Connection cnct = null;

		//SQLを実行するときに使うやつ
		Statement st = null;

		//SQL実行結果を格納するやつ
		ResultSet rs = null;

		try {

			//MySqlのJDBCドライバを使うよって定義
			Class.forName("com.mysql.jdbc.Driver");

			//DBに実際に接続する
			cnct = DriverManager.getConnection(url, id, pw);

			st = cnct.createStatement();

			rs = st.executeQuery(
					"SELECT pro_cd,pro_name,cat_name,pro_price,stock_no,pro_img,pro_msg FROM  product left outer join category2 on product.cat_id = category2.cat_id where pro_cd="
							+ cd);
			rs.next();

			//rs.getint
			//インスタンスに結果を入れるだけ
			bean.setName(rs.getString("pro_name"));
			bean.setCategory(rs.getString("cat_name"));
			bean.setPrice(rs.getInt("pro_price"));
			bean.setStock(rs.getInt("stock_no"));
			bean.setImg(rs.getString("pro_img"));
			bean.setMsg(rs.getString("pro_msg"));
			bean.setCd(rs.getInt("pro_cd"));

		} catch (ClassNotFoundException ex) {

		} catch (SQLException e) {

		}

		return bean;

	}

}
