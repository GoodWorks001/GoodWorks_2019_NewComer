package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class syousaiDao {

	public ProductBean syouhin(String name){
		
		//インスタンス化
		ProductBean bean = new ProductBean();
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


			String sql="select * from product where pro_cd = "+name;
			System.out.println(sql);


			rs = st.executeQuery(sql);


			while(rs.next()){
                 //dbのカラム値をインスタンシュに格納
				bean.setPro_cd(rs.getInt("pro_cd"));
				bean.setPro_name(rs.getString("pro_name"));
				bean.setStock_no(rs.getInt("stock_no"));
				bean.setPro_price(rs.getInt("pro_price"));
				bean.setCat_id(rs.getInt("cat_id"));
				bean.setPro_img(rs.getString("pro_img"));
				bean.setPro_msg(rs.getString("pro_msg"));
			}
            //while文のlistを返す
			return bean;

		}catch(ClassNotFoundException ex) {//JDBCドライバがない、 構文が違う
			ex.printStackTrace();
			return bean;
		}catch(SQLException e) {//データベースへの接続の失敗時
			e.printStackTrace();
			return bean;
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
