 package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DAO {

	public int login(String user_id, String login_pw) {
		// 変数宣言
		// DB接続に必要な情報
		String url = "jdbc:mysql://localhost/ecserver";
		String id = "root";
		String pw = "password";
		// 接続用
		Connection cnct = null;
		// SQL実行用
		Statement st = null;
		// SQL実行結果格納
		ResultSet rs = null;
		// 判定
		int hantei = 0;
		try {
			System.out.println("ログイン処理");
			// クラスにアクセス定義
			String com = "com.mysql.jdbc.Driver";
			Class.forName(com);
			System.out.println("DB接続開始");
			// ログイン処理DB接続
			cnct = DriverManager.getConnection(url, id, pw);
			System.out.println("2");
			st = cnct.createStatement();
			// テーブルの情報取得
			String sql = "select * from user where user_id ='" + user_id + "' and login_pw='" + login_pw + "'";
			System.out.println(sql);
			// レコードの一番下まで表示
			rs = st.executeQuery(sql);
			if (rs.next() == false) {
				hantei = 1;
			} else {

			}
			System.out.println(hantei);
			return hantei;
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return hantei;
		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			System.out.println("Select文エラー");
			return hantei;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				System.out.println("DB接続解除");
				return hantei;
			} catch (Exception ex) {
				// TODO: handle exception
			}
		}

	}

	public void shousai(String category) {
		// 変数宣言
		// DB接続に必要な情報
		String url = "jdbc:mysql://localhost/ecserver";
		String id = "root";
		String pw = "password";
		// 接続用
		Connection cnct = null;
		// SQL実行用
		Statement st = null;
		// SQL実行結果格納
		ResultSet rs = null;
		// 判定
		int hantei = 0;
		try {
			System.out.println("ログイン処理");
			// クラスにアクセス定義
			String com = "com.mysql.jdbc.Driver";
			Class.forName(com);
			System.out.println("DB接続開始");
			// ログイン処理DB接続
			cnct = DriverManager.getConnection(url, id, pw);
			System.out.println("2");
			st = cnct.createStatement();
			// テーブルの情報取得
			String sql = "select * from product where cat_id='" + category + "'";
			System.out.println(sql);
			// レコードの一番下まで表示
			rs = st.executeQuery(sql);

			// アレイリスト作成
			Product pro = new Product();
			ArrayList<Product> prolist = new ArrayList<Product>();
			// flg
			boolean flg = rs.next();
			while (flg) {
				pro.setPro_cd(rs.getInt(""));

				flg = rs.next();
			}

			System.out.println(hantei);
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			System.out.println("Select文エラー");
			;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				System.out.println("DB接続解除");
			} catch (Exception ex) {
				// TODO: handle exception
			}
		}
	}

	public ArrayList<Category> cat() {
		// 変数宣言
		// DB接続に必要な情報
		String url = "jdbc:mysql://localhost/ecserver";
		String id = "root";
		String pw = "password";
		// 接続用
		Connection cnct = null;
		// SQL実行用
		Statement st = null;
		// SQL実行結果格納
		ResultSet rs = null;
		// 判定
		int hantei = 0;
		// アレイリスト作成
		ArrayList<Category> catlist = new ArrayList<Category>();
		try {
			System.out.println("ログイン処理");
			// クラスにアクセス定義
			String com = "com.mysql.jdbc.Driver";
			Class.forName(com);
			System.out.println("DB接続開始");
			// ログイン処理DB接続
			cnct = DriverManager.getConnection(url, id, pw);
			System.out.println("2");
			st = cnct.createStatement();
			// テーブルの情報取得
			String sql = "select * from category";
			System.out.println(sql);
			// レコードの一番下まで表示
			rs = st.executeQuery(sql);

			// flg
			boolean flg = rs.next();
			while (flg) {
				Category cat = new Category();
				cat.setCat_id(rs.getInt("cat_id"));
				cat.setCat_name(rs.getString("cat_name"));
				//
				catlist.add(cat);
				flg = rs.next();
			}
			return catlist;
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return catlist;

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			System.out.println("Select文エラー");
			return catlist;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				System.out.println("DB接続解除");
				return catlist;
			} catch (Exception ex) {
				// TODO: handle exception
			}
		}

	}

	public ArrayList<Product> CatMain(String cat) {
		// 変数宣言
		// DB接続に必要な情報
		String url = "jdbc:mysql://localhost/ecserver";
		String id = "root";
		String pw = "password";
		// 接続用
		Connection cnct = null;
		// SQL実行用
		Statement st = null;
		// SQL実行結果格納
		ResultSet rs = null;
		// アレイリスト作成
		ArrayList<Product> plist = new ArrayList<Product>();
		try {
			System.out.println("ログイン処理");
			// クラスにアクセス定義
			String com = "com.mysql.jdbc.Driver";
			Class.forName(com);
			System.out.println("DB接続開始");
			// ログイン処理DB接続
			cnct = DriverManager.getConnection(url, id, pw);
			System.out.println("2");
			st = cnct.createStatement();
			// テーブルの情報取得
			String sql = "select * from product where cat_id=" + cat + "";
			System.out.println(sql);
			// レコードの一番下まで表示
			rs = st.executeQuery(sql);
			boolean flg = rs.next();
			while (flg) {
				Product pro = new Product();
				pro.setPro_name(rs.getString("pro_name"));
				pro.setPro_price(rs.getInt("pro_price"));
				pro.setPro_cd(rs.getInt("pro_cd"));
				plist.add(pro);
				flg = rs.next();
			}
			return plist;
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return plist;

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			System.out.println("Select文エラー");
			return plist;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				System.out.println("DB接続解除");
				return plist;
			} catch (Exception ex) {
				// TODO: handle exception
			}
		}
	}

	public ArrayList<Product> ProductMain(String product) {
		// 変数宣言
		// DB接続に必要な情報
		String url = "jdbc:mysql://localhost/ecserver";
		String id = "root";
		String pw = "password";
		// 接続用
		Connection cnct = null;
		// SQL実行用
		Statement st = null;
		// SQL実行結果格納
		ResultSet rs = null;
		// アレイリスト作成
		ArrayList<Product> plist = new ArrayList<Product>();
		try {
			System.out.println("ログイン処理");
			// クラスにアクセス定義
			String com = "com.mysql.jdbc.Driver";
			Class.forName(com);
			System.out.println("DB接続開始");
			// ログイン処理DB接続
			cnct = DriverManager.getConnection(url, id, pw);
			System.out.println("2");
			st = cnct.createStatement();
			// テーブルの情報取得
			String sql = "select * from product where pro_name='" + product + "'";
			System.out.println(sql);
			// レコードの一番下まで表示
			rs = st.executeQuery(sql);
			boolean flg = rs.next();
			while (flg) {
				Product pro = new Product();
				pro.setPro_name(rs.getString("pro_name"));
				pro.setPro_price(rs.getInt("pro_price"));
				pro.setPro_cd(rs.getInt("pro_cd"));
				plist.add(pro);
				flg = rs.next();
			}
			return plist;
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return plist;

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			System.out.println("Select文エラー");
			return plist;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				System.out.println("DB接続解除");
				return plist;
			} catch (Exception ex) {
				// TODO: handle exception
			}
		}
	}

	public ArrayList<Product> ProductCatMain(String product, String cat) {
		// 変数宣言
		// DB接続に必要な情報
		String url = "jdbc:mysql://localhost/ecserver";
		String id = "root";
		String pw = "password";
		// 接続用
		Connection cnct = null;
		// SQL実行用
		Statement st = null;
		// SQL実行結果格納
		ResultSet rs = null;
		// アレイリスト作成
		ArrayList<Product> plist = new ArrayList<Product>();
		try {
			System.out.println("ログイン処理");
			// クラスにアクセス定義
			String com = "com.mysql.jdbc.Driver";
			Class.forName(com);
			System.out.println("DB接続開始");
			// ログイン処理DB接続
			cnct = DriverManager.getConnection(url, id, pw);
			System.out.println("2");
			st = cnct.createStatement();
			// テーブルの情報取得
			String sql = "select * from product where pro_name='" + product + "' and cat_id=" + cat + "";
			System.out.println(sql);
			// レコードの一番下まで表示
			rs = st.executeQuery(sql);
			boolean flg = rs.next();
			while (flg) {
				Product pro = new Product();
				pro.setPro_name(rs.getString("pro_name"));
				pro.setPro_price(rs.getInt("pro_price"));
				pro.setPro_cd(rs.getInt("pro_cd"));
				System.out.println(pro.getPro_cd());
				plist.add(pro);
				flg = rs.next();
			}
			return plist;
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return plist;

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			System.out.println("Select文エラー");
			return plist;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				System.out.println("DB接続解除");
				return plist;
			} catch (Exception ex) {
				// TODO: handle exception
			}
		}
	}

	public Product ProductSyousai(String pro_cd) {
		// 変数宣言
		// DB接続に必要な情報
		String url = "jdbc:mysql://localhost/ecserver";
		String id = "root";
		String pw = "password";
		// 接続用
		Connection cnct = null;
		// SQL実行用
		Statement st = null;
		// SQL実行結果格納
		ResultSet rs = null;
		// インスタンス
		Product pro = new Product();
		try {
			System.out.println("ログイン処理");
			// クラスにアクセス定義
			String com = "com.mysql.jdbc.Driver";
			Class.forName(com);
			System.out.println("DB接続開始");
			// ログイン処理DB接続
			cnct = DriverManager.getConnection(url, id, pw);
			System.out.println("2");
			st = cnct.createStatement();
			// テーブルの情報取得
			String sql = "select * from product inner join category on product.cat_id = category.cat_id"
					+ " where pro_cd=" + pro_cd;
			System.out.println(sql);
			// レコードの一番下まで表示
			rs = st.executeQuery(sql);
			rs.next();
			// 情報保存
			pro.setPro_name(rs.getString("pro_name"));
			pro.setPro_price(rs.getInt("pro_price"));
			pro.setPro_cd(rs.getInt("pro_cd"));
			pro.setPro_img(rs.getString("pro_img"));
			pro.setStock(rs.getInt("stock_no"));
			pro.setPro_msg(rs.getString("pro_msg"));
			pro.setCat_name(rs.getString("cat_name"));
			return pro;
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return pro;

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			System.out.println("Select文エラー");
			return pro;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				System.out.println("DB接続解除");
				return pro;
			} catch (Exception ex) {
				// TODO: handle exception
			}
		}
	}

	public ArrayList<Product> Meisai(ArrayList<Meisai> meisai,String user_id) {
		// 変数宣言
		// DB接続に必要な情報
		String url = "jdbc:mysql://localhost/ecserver";
		String id = "root";
		String pw = "password";
		// 接続用
		Connection cnct = null;
		// SQL実行用
		Statement st = null;
		ArrayList<Product> cart = new ArrayList<Product>();

		try {
			System.out.println("ログイン処理");
			// クラスにアクセス定義
			String com = "com.mysql.jdbc.Driver";
			Class.forName(com);
			System.out.println("DB接続開始");
			// ログイン処理DB接続
			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			// テーブルの情報取得
			// 商品数更新
			for (int i = 0; i < meisai.size(); i++) {
				//meisaiインスタン化
				Meisai m= meisai.get(i);
				//キャスト
				int a =zaiko(m.getPro_cd());
				String sql = "update product set  stock_no = "+(a - m.getPro_stcok())+" where pro_cd="+m.getPro_cd()+"";
				System.out.println(sql);
				st.executeUpdate(sql);
			}
			//明細テーブルinsert
			for(int i = 0; i < meisai.size(); i++) {
				//明細インスタン
				Meisai m= meisai.get(i);
				//今日の日付取得
				Date d = new Date();
				//下記の形式にフォーマット
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy-MM-dd-HH");
		        String c2 = d2.format(d);
		        System.out.println(c2);
				String sql = "insert into meisai (user_id,pro_cd,ko_date,mei_price) "
						+ "values("+user_id+","+m.getPro_cd()+",'"+c2+"',"+m.getMei_price()+")";
				System.out.println(sql);
				st.executeUpdate(sql);
			}

			return cart;


		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return cart;

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			System.out.println("Select文エラー");
			return cart;

		} finally {
			try {
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				System.out.println("DB接続解除");
				return cart;
			} catch (Exception ex) {
				// TODO: handle exception
			}
		}
	}

	public int zaiko(int pro_cd) {
		// 変数宣言
		// DB接続に必要な情報
		String url = "jdbc:mysql://localhost/ecserver";
		String id = "root";
		String pw = "password";
		// 接続用
		Connection cnct = null;
		// SQL実行用
		Statement st = null;
		// SQL実行結果格納
		ResultSet rs = null;
		// 変数宣言
		int zaiko = 0;
		try {
			System.out.println("ログイン処理");
			// クラスにアクセス定義
			String com = "com.mysql.jdbc.Driver";
			Class.forName(com);
			System.out.println("DB接続開始");
			// ログイン処理DB接続
			cnct = DriverManager.getConnection(url, id, pw);
			System.out.println("2");
			st = cnct.createStatement();
			// テーブルの情報取得

			String sql = "select * from product  where pro_cd="+pro_cd+"";

			System.out.println(sql);
			// レコードの一番下まで表示
			rs = st.executeQuery(sql);
			rs.next();
			// 情報保存
			zaiko = rs.getInt("stock_no");
			System.out.println("在庫数:"+zaiko);
			return zaiko;
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return zaiko;

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			System.out.println("Select文エラー");
			return zaiko;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				System.out.println("DB接続解除");
				return zaiko;
			} catch (Exception ex) {
				// TODO: handle exception
			}
		}
	}

}
