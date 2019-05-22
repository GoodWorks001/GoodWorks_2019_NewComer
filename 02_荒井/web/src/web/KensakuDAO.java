package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KensakuDAO {


	private ArrayList<ProductBean> array = new ArrayList<ProductBean>();

	public Boolean item(String search, String category) {

		boolean flag = false;

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


				String xSearch = search;
				if(xSearch.equals("") || xSearch == null) {
					xSearch = "hogehoge";
				}

				String xCategory = category;
				if(xCategory.equals("") || xCategory == null) {
					xCategory = "hogehoge";
				}


				try {
					//MySqlのJDBCドライバを使うよって定義
					Class.forName("com.mysql.jdbc.Driver");

					//DBに実際に接続する
					 cnct = DriverManager.getConnection(url,id,pw);

					 st = cnct.createStatement();
					 String query = "(SELECT * FROM product where pro_name='+ search +');";
					 System.out.println(query);


					 rs = st.executeQuery(query);


						if (!rs.next()) {
							return flag;
						}


						do {
							//インスタンス化
							ProductBean product = new ProductBean();

							String xName = rs.getString("product.pro_name");
							product.setName(xName);

							int xStock = rs.getInt("product.stock_no");
							product.setStock(xStock);

							int xPrice = rs.getInt("product.pro_price");
							product.setStock(xPrice);

							String xcategory = rs.getString("product.cat_id");
							product.setCategory(xcategory);

							String xImg = rs.getString("product.pro_img");
							product.setImg(xImg);

							String xMsg = rs.getString("product.pro_msg");
							product.setMsg(xMsg);

							array.add(product);



						}while(rs.next());
						flag = true;
						return flag;

				}catch(ClassNotFoundException ex) {
					ex.printStackTrace();


				}catch(SQLException e){
					e.printStackTrace();


				}finally {
					try {
						if(rs != null)
							rs.close();
						if(st != null)
							st.close();
						if(cnct != null)
							cnct.close();
					}catch(Exception ex) {


					}


				}

				return flag;

	}

	public ArrayList<ProductBean> getarray(){
		return array;
	}

}

