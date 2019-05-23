package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {

	//ログイン用のDAO
	//LoginBeanクラスをインスタンス化
		LoginBean lb = new LoginBean();

		public String login_name(String name) {
			String naming = "";

			//JDBCサーバを使用する情報を格納する
			String url = "jdbc:mysql://localhost/shopping";
			String id = "root";
			String pw = "password";

			//初期値設定
			Connection cnct = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				//ドライブマネージャーに接続する
				cnct = DriverManager.getConnection(url,id,pw);
				//st = cnct.createStatement();
				//呼び出し先を指定
				//表示したい内容の記述
				String query = "select * from user where login_cd=?";
				pst = cnct.prepareStatement(query);
				pst.setString(1, name);
				rs = pst.executeQuery();

				while(rs.next()){
					//一行ずつ確認しながら表示するロジック
					String login_cd = rs.getString("login_cd");
					naming = login_cd;
					lb.setName(naming);
				}
				//try内でエラーが発生した場合は、ここに飛んでくる
				} catch(ClassNotFoundException ex){
					ex.printStackTrace();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}finally {
					try {
						//結果に満足したらcloseするロジック
						if (rs!=null) rs.close();
						if (pst!=null) pst.close();
						if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
				}
			return lb.getName();
		}

		public String login_pass(String pass) {
			String passing = "";
			//JDBCサーバを使用する情報を格納する
			String url = "jdbc:mysql://localhost/shopping";
			String id = "root";
			String pw = "password";

			//初期値設定
			Connection cnct = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				//ドライブマネージャーに接続する
				cnct = DriverManager.getConnection(url,id,pw);
				//st = cnct.createStatement();
				//呼び出し先を指定
				//表示したい内容の記述
				String query = "select * from user where login_pw=?";
				pst = cnct.prepareStatement(query);
				pst.setString(1, pass);
				rs = pst.executeQuery();

				while(rs.next()){
					//一行ずつ確認しながら表示するロジック
					String login_pw = rs.getString("login_pw");
					passing = login_pw;
					lb.setPassword(passing);
				}
				//try内でエラーが発生した場合は、ここに飛んでくる
				} catch(ClassNotFoundException ex){
					ex.printStackTrace();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}finally {
					try {
						//結果に満足したらcloseするロジック
						if (rs!=null) rs.close();
						if (pst!=null) pst.close();
						if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
				}
			return lb.getPassword();
		}

	public ArrayList<CategoryBean> cat_gets(){
		//JDBCサーバを使用する情報を格納する
		String url = "jdbc:mysql://localhost/shopping";
		String id = "root";
		String pw = "password";

		//初期値設定
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		ArrayList<CategoryBean> catlist = new ArrayList<CategoryBean>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ドライブマネージャーに接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//st = cnct.createStatement();
			//呼び出し先を指定
			//表示したい内容の記述
			st = cnct.createStatement();
			rs = st.executeQuery("select * from category");
			while(rs.next()){
				CategoryBean cb = new CategoryBean();
				cb.setCateid(rs.getInt("cat_id"));
				cb.setCatename(rs.getString("cat_name"));
				catlist.add(cb);
			}
			return catlist;
			//try内でエラーが発生した場合は、ここに飛んでくる
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
			return catlist;
		} catch(SQLException ex) {
			ex.printStackTrace();
			return catlist;
		}finally {
			try {
				//結果に満足したらcloseするロジック
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				return catlist;
			} catch(Exception ex) { }
		}
	}

	//検索ネーム
	public ArrayList<ProductBean> Pro_gets(String kensaku){
		ArrayList<ProductBean> alist = new ArrayList<ProductBean>();
		//JDBCサーバを使用する情報を格納する
		String url = "jdbc:mysql://localhost/shopping";
		String id = "root";
		String pw = "password";

		//初期値設定
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ドライブマネージャーに接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//st = cnct.createStatement();
			//呼び出し先を指定
			//表示したい内容の記述
			st = cnct.createStatement();
			String sql="select * from product where pro_name='"+kensaku+"'";
			rs = st.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()){
				ProductBean pb = new ProductBean();
				pb.setName(rs.getString("pro_name"));
				pb.setMsg(rs.getString("pro_msg"));
				pb.setImg(rs.getString("pro_img"));
				pb.setId(rs.getInt("pro_cd"));
				pb.setPrice(rs.getInt("pro_price"));
				pb.setZaiko(rs.getInt("stock_no"));
				pb.setCategory(rs.getInt("cat_id"));
				alist.add(pb);

			}
			if(alist != null) {

				System.out.println(alist);

				return alist;
			}

			//try内でエラーが発生した場合は、ここに飛んでくる
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				//結果に満足したらcloseするロジック
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
		}
		return alist;
	}

	//カテゴリネーム
	public ArrayList<ProductBean> Pro_Gets(String category){
		ArrayList<ProductBean> blist = new ArrayList<ProductBean>();
		//JDBCサーバを使用する情報を格納する
		String url = "jdbc:mysql://localhost/shopping";
		String id = "root";
		String pw = "password";

		//初期値設定
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ドライブマネージャーに接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//st = cnct.createStatement();
			//呼び出し先を指定
			//表示したい内容の記述
			st = cnct.createStatement();
			String sql="select * from product inner join category ON product.cat_id = category.cat_id where category.cat_id='"+category+"'";
			rs = st.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()){
				ProductBean pb = new ProductBean();
				pb.setName(rs.getString("pro_name"));
				pb.setMsg(rs.getString("pro_msg"));
				pb.setImg(rs.getString("pro_img"));
				pb.setId(rs.getInt("pro_cd"));
				pb.setPrice(rs.getInt("pro_price"));
				pb.setZaiko(rs.getInt("stock_no"));
				pb.setCategory(rs.getInt("cat_id"));

				blist.add(pb);
			}
			if(blist != null) {
				return blist;
			}

			//try内でエラーが発生した場合は、ここに飛んでくる
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				//結果に満足したらcloseするロジック
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
		}
		return blist;
	}

	//カテゴリーテーブル
	public ArrayList<ProductBean> Shousai(String shousai){
		ArrayList<ProductBean> clist = new ArrayList<ProductBean>();
		//JDBCサーバを使用する情報を格納する
		String url = "jdbc:mysql://localhost/shopping";
		String id = "root";
		String pw = "password";

		//初期値設定
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ドライブマネージャーに接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//st = cnct.createStatement();
			//呼び出し先を指定
			//表示したい内容の記述
			st = cnct.createStatement();
			String sql="select * from product inner join category on product.cat_id = category.cat_id where pro_cd='"+shousai+"'";
			rs = st.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()){

				ProductBean pb = new ProductBean();
				pb.setName(rs.getString("pro_name"));
				pb.setMsg(rs.getString("pro_msg"));
				pb.setImg(rs.getString("pro_img"));
				pb.setPrice(rs.getInt("pro_price"));
				pb.setZaiko(rs.getInt("stock_no"));
				pb.setCategory(rs.getInt("cat_id"));
				pb.setCatename(rs.getString("cat_name"));



				System.out.println(pb.getName());
				System.out.println(pb.getMsg());
				System.out.println(pb.getImg());
				System.out.println(pb.getPrice());
				System.out.println(pb.getZaiko());
				System.out.println(pb.getCategory());
				clist.add(pb);
			}
			if(clist != null) {
				return clist;
			}

			//try内でエラーが発生した場合は、ここに飛んでくる
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				//結果に満足したらcloseするロジック
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
		}
		return clist;
	}

	public void meisai(int user_id, int pro_cd, int mei_price) {
		//JDBCサーバを使用する情報を格納する
		String url = "jdbc:mysql://localhost/shopping";
		String id = "root";
		String pw = "password";

		//初期値設定
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ドライブマネージャーに接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//自動コミットモードの解除
			cnct.setAutoCommit(false);

			try {
				String sql="insert into meisai (mei_id, user_id, pro_cd, ko_date, mei_price) values(?,?,?,?,?)";
				pst = cnct.prepareStatement(sql);
				pst.setInt(1, 0);
				pst.setInt(2, user_id);
				pst.setInt(3, pro_cd);
				pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));
				pst.setInt(5, mei_price);
				//コミットしているよ
				pst.executeUpdate();
				cnct.commit();
				System.out.println("コミットしました。");
			} catch(SQLException e){
				cnct.rollback();
				System.out.println("ロールバックしました。");
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//結果に満足したらcloseするロジック
				if (rs!=null) rs.close();
				if (pst!=null) pst.close();
				if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
		}
	}

	public int user_name(String name) {

		int user_id = 0;

		//JDBCサーバを使用する情報を格納する
		String url = "jdbc:mysql://localhost/shopping";
		String id = "root";
		String pw = "password";

		//初期値設定
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ドライブマネージャーに接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//st = cnct.createStatement();
			//呼び出し先を指定
			//表示したい内容の記述
			String query = "select * from user where login_cd=?";
			pst = cnct.prepareStatement(query);
			pst.setString(1, name);
			rs = pst.executeQuery();

			while(rs.next()){
				//一行ずつ確認しながら表示するロジック
				user_id = rs.getInt("user_id");
			}
			//try内でエラーが発生した場合は、ここに飛んでくる
			} catch(ClassNotFoundException ex){
				ex.printStackTrace();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
					//結果に満足したらcloseするロジック
					if (rs!=null) rs.close();
					if (pst!=null) pst.close();
					if (cnct!=null) cnct.close();
				} catch(Exception ex) { }
			}
		return user_id;
	}

	public int pro_cd(String name) {

		int pro_cd = 0;

		//JDBCサーバを使用する情報を格納する
		String url = "jdbc:mysql://localhost/shopping";
		String id = "root";
		String pw = "password";

		//初期値設定
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ドライブマネージャーに接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//st = cnct.createStatement();
			//呼び出し先を指定
			//表示したい内容の記述
			String query = "select * from product where pro_name=?";
			pst = cnct.prepareStatement(query);
			pst.setString(1, name);
			rs = pst.executeQuery();

			while(rs.next()){
				//一行ずつ確認しながら表示するロジック
				pro_cd = rs.getInt("pro_cd");
			}
			//try内でエラーが発生した場合は、ここに飛んでくる
			} catch(ClassNotFoundException ex){
				ex.printStackTrace();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
					//結果に満足したらcloseするロジック
					if (rs!=null) rs.close();
					if (pst!=null) pst.close();
					if (cnct!=null) cnct.close();
				} catch(Exception ex) { }
			}
		return pro_cd;
	}

	public int zaiko(String name) {

		int stock_no = 0;

		//JDBCサーバを使用する情報を格納する
		String url = "jdbc:mysql://localhost/shopping";
		String id = "root";
		String pw = "password";

		//初期値設定
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ドライブマネージャーに接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//st = cnct.createStatement();
			//呼び出し先を指定
			//表示したい内容の記述
			String query = "select * from product where pro_name=?";
			pst = cnct.prepareStatement(query);
			pst.setString(1, name);
			rs = pst.executeQuery();

			while(rs.next()){
				//一行ずつ確認しながら表示するロジック
				stock_no = rs.getInt("stock_no");
			}
			//try内でエラーが発生した場合は、ここに飛んでくる
			} catch(ClassNotFoundException ex){
				ex.printStackTrace();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
					//結果に満足したらcloseするロジック
					if (rs!=null) rs.close();
					if (pst!=null) pst.close();
					if (cnct!=null) cnct.close();
				} catch(Exception ex) { }
			}
		return stock_no;
	}

	public void koshin(int stock, String pro_name) {
		//JDBCサーバを使用する情報を格納する
		String url = "jdbc:mysql://localhost/shopping";
		String id = "root";
		String pw = "password";

		//初期値設定
		Connection cnct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ドライブマネージャーに接続する
			cnct = DriverManager.getConnection(url,id,pw);
			//自動コミットモードの解除
			cnct.setAutoCommit(false);

			try {
				String sql="update product set stock_no=? where pro_name=?;";
				pst = cnct.prepareStatement(sql);
				pst.setInt(1, stock);
				pst.setString(2, pro_name);
				//コミットしているよ
				pst.executeUpdate();
				cnct.commit();
				System.out.println("コミットしました。");
			} catch(SQLException e){
				cnct.rollback();
				System.out.println("ロールバックしました。");
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//結果に満足したらcloseするロジック
				if (rs!=null) rs.close();
				if (pst!=null) pst.close();
				if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
		}
	}
}
