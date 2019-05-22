package iyada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DAO {

	public boolean LOGIN(String name ,String pw) {
		boolean flg = false;
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			st = cnct.createStatement();
			System.out.println("C");
			//文字列に''を付ける
			name = "'" + name + "'";
			pw = "'" + pw + "'";
			//確認
			System.out.println(name + ":" + pw);
			//セレクト文格納
			String sql = "select * from user where user_name =" + name + "AND login_pw = " + pw;
			//セレクト文確認
			System.out.println(sql);
			//セレクト文実行
			rs = st.executeQuery(sql);
			//確認
			System.out.println("D");
			//内容が取り出せているなら
			while(rs.next()){
				//ログインできたことを伝える
				flg = true;
				//確認
				System.out.println("E");
			}
			//確認
			System.out.println("F");
			//結果を返す
			return flg;
			//クラス関連のエラーハンドリング
		} catch(ClassNotFoundException ex){
			System.out.println("JDBCねえよ？");
			return flg;
			//SQL関連のエラーハンドリング
		} catch(SQLException ex) {
			System.out.println("SQLミスってるよ？");
			return flg;
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				System.out.println("Loginメソッド終了");
			} catch(Exception ex) { }
		}
	}

	//ユーザ情報セットメソッドですよ
	public UserBean ses(String name ,String pw) {
		UserBean user = new UserBean();
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			System.out.println("C");
			st = cnct.createStatement();
			//文字列に''を付ける
			name = "'" + name + "'";
			pw = "'" + pw + "'";
			//確認
			System.out.println(name + ":" + pw);
			//セレクト文格納
			String sql = "select * from user where user_name =" + name + "AND login_pw = " + pw;
			//セレクト文確認
			System.out.println(sql);
			//セレクト文実行
			rs = st.executeQuery(sql);
			//確認
			System.out.println("D");
			//内容が取り出せているなら
			while(rs.next()){
				//値を変数に格納
				String user_id = rs.getString("user_id");
				String user_name = rs.getString("user_name");
				String login_cd = rs.getString("login_cd");
				String login_pw = rs.getString("login_pw");
				//ユーザ情報を設定
				user.setUser_id(user_id);
				user.setUser_name(user_name);
				user.setLogin_cd(login_cd);
				user.setLogin_pw(login_pw);
			}
			System.out.println("E");
			//設定したユーザ情報を返す
			return user;

		} catch(ClassNotFoundException ex){
			//↑クラス関連のエラーハンドリング
			System.out.println("クラスでミスってるよ");
			return user;

		} catch(SQLException ex) {
			//↑SQL関連のエラーハンドリング
			System.out.println("SQLミスってるよ");
			return user;
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				System.out.println("ユーザ情報格納メソッド完了");
			} catch(Exception ex) { }
		}
	}
	//カテゴリを取得するためのメソッド
	public ArrayList<String> cate(){
		ArrayList<String> array = new ArrayList<>();
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			st = cnct.createStatement();
			System.out.println("C");
			//SELECT文を実行する
			String sql = "select * from category";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			System.out.println("D");
			//内容が取り出せているなら
			while(rs.next()){
				//カテゴリーごとの名前を取得
				array.add(rs.getString("cat_name"));
				System.out.println("E");
			}
			System.out.println("F");
			//カテゴリ名を格納したリストを返す
			return array;
			//クラス関連のエラーハンドリング
		} catch(ClassNotFoundException ex){
			System.out.println("JDBCねえよ？");
			return array;
			//SQL関連のエラーハンドリング
		} catch(SQLException ex) {
			System.out.println("SQLミスってるよ？");
			return array;
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				System.out.println("Loginメソッド終了");
			} catch(Exception ex) { }
		}
	}
	//最終的な結果
	public boolean meisaiNo() {
		boolean flg = false;
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			st = cnct.createStatement();
			System.out.println("C");
			String sql = "select * from meisai";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			System.out.println("D");
			//内容が取り出せているなら
			while(rs.next()){
				//二回目以降の明細を作ることを伝える
				flg = true;
				System.out.println("E");
			}
			System.out.println("F");
			//trueの結果を返す
			return flg;
			//クラス関連のエラーハンドリング
		} catch(ClassNotFoundException ex){
			System.out.println("JDBCねえよ？");
			return flg;
			//SQL関連のエラーハンドリング
		} catch(SQLException ex) {
			System.out.println("SQLミスってるよ？");
			return flg;
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				System.out.println("初期変数取得メソッド終了");
			} catch(Exception ex) { }
		}
	}
	public int getNo() {
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			st = cnct.createStatement();
			System.out.println("C");
			String sql = "select * from meisai";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			System.out.println("D");
			int num = 0;
			//内容が取り出せているなら
			while(rs.next()){
				//明細主キーの最終番号取得
				num = rs.getInt("mei_id");
			}
			System.out.println("F");
			//明細主キーの最終番号を返す
			return num;
			//クラス関連のエラーハンドリング
		} catch(ClassNotFoundException ex){
			System.out.println("JDBCねえよ？");
			//SQL関連のエラーハンドリング
			int num = 1;
			return num;
		} catch(SQLException ex) {
			System.out.println("SQLミスってるよ？");
			//最後に必ず行う処理
			int num = 1;
			return num;
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				System.out.println("初期変数変更メソッド終了");
			} catch(Exception ex) { }
		}
	}
	//検索メソッドですよ
	public ArrayList<String> Kensaku(String cat_id){
		ArrayList<String> list = new ArrayList<>();
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			System.out.println("C");
			st = cnct.createStatement();
			//文字列に''を付ける
			cat_id = "'" + cat_id + "'";
			//セレクト文格納
			String sql = "select * from product where cat_id =" + cat_id;
			//セレクト文確認
			System.out.println(sql);
			//セレクト文実行
			rs = st.executeQuery(sql);
			System.out.println("D");
			//内容が取り出せているなら
			while(rs.next()){
				//商品情報をアレイリストに格納
				list.add(rs.getString("pro_name"));
				list.add(rs.getString("pro_price"));
				list.add(rs.getString("pro_id"));
			}
			System.out.println("E");
			//リストを返す
			return list;
		} catch(ClassNotFoundException ex){
			//↑クラス関連のエラーハンドリング
			System.out.println("クラスでミスってるよ");
			return list;
		} catch(SQLException ex) {
			//↑SQL関連のエラーハンドリング
			System.out.println("SQLミスってるよ");
			return list;
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				System.out.println("商品情報格納メソッド完了");
			} catch(Exception ex) { }
		}
	}


	//あいまい検索機能ですよ
	public ArrayList<String> nameKensaku(String name){
		ArrayList<String> list = new ArrayList<>();
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			System.out.println("C");
			st = cnct.createStatement();
			//文字比較するためにあいまい検索(%)を前後に付ける
			name = "'%" + name + "%'";
			//セレクト文格納
			String sql = "select * from product where pro_name like" + name;
			//セレクト文確認
			System.out.println(sql);
			//セレクト文実行
			rs = st.executeQuery(sql);
			System.out.println("D");
			//内容が取り出せているなら
			while(rs.next()){
				//商品情報をアレイリストに格納
				list.add(rs.getString("pro_name"));
				list.add(rs.getString("pro_price"));
				list.add(rs.getString("pro_id"));
			}
			System.out.println("E");
			//結果のリストを返す
			return list;
		} catch(ClassNotFoundException ex){
			//↑クラス関連のエラーハンドリング
			System.out.println("クラスでミスってるよ");
			return list;
		} catch(SQLException ex) {
			//↑SQL関連のエラーハンドリング
			System.out.println("SQLミスってるよ");
			return list;
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				System.out.println("あいまい検索メソッド完了");
			} catch(Exception ex) { }
		}
	}
	//商品詳細情報呼び出しメソッド
	public ProductBean syouhinKensaku(String name){
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		Statement st = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		ProductBean product = new ProductBean();
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			System.out.println("C");
			st = cnct.createStatement();
			//文字列に''を付ける
			name = "'" + name + "'";
			//セレクト文の格納・確認・実行
			String sql = "select * from product where pro_id =" + name;
			System.out.println(sql);
			rs = st.executeQuery(sql);
			//内容が取り出せているなら
			while(rs.next()){
				System.out.println("ここから検索結果");
				//カテゴリコード
				product.setCat_id(rs.getString("cat_id"));
				System.out.println(product.getCat_id());
				//商品コード
				product.setPro_id(rs.getString("pro_id"));
				System.out.println(product.getPro_id());
				//商品画像
				product.setPro_image(rs.getString("pro_image"));
				System.out.println(product.getPro_image());
				//商品名
				product.setPro_name(rs.getString("pro_name"));
				System.out.println(product.getPro_name());
				//単価
				product.setPro_price(rs.getInt("pro_price"));
				System.out.println(product.getPro_price());
				//在庫数
				product.setStock_no(rs.getInt("stock_no"));
				System.out.println(product.getStock_no());
				//商品説明
				product.setPro_msg(rs.getString("pro_msg"));
				System.out.println(product.getPro_msg());
			}
			System.out.println("E");
			return product;
		} catch(ClassNotFoundException ex){
			//↑クラス関連のエラーハンドリング
			System.out.println("クラスでミスってるよ");
			return product;
		} catch(SQLException ex) {
			ex.printStackTrace();
			//↑SQL関連のエラーハンドリング
			System.out.println("情報格納用メソッドのSQLミスってるよ");
			return product;
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				System.out.println("商品詳細情報メソッド完了");
			} catch(Exception ex) { }
		}
	}
	//UPDATEメソッド
	public void update(ArrayList<ProductBean> beanlist) throws SQLException{
		//接続のためのurlとIDとpassの設定
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pass = "password";
		//ここまで
		//DB接続に接続する際に使うやつ
		Connection cnct = null;
		//SQL実行結果を格納するやつ
		PreparedStatement pst = null;
		//SQL実行するときに使うやつ
		ResultSet rs = null;
		try {
			System.out.println("A");
			//ドライバを使用する定義
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("B");
			//ログインのための設定
			cnct = DriverManager.getConnection(url,id,pass);
			System.out.println("C");

			//自動コミットモードの解除
			cnct.setAutoCommit(false);

			//SELECT文を実行する

			String sql = "update product set stock_no = ? where pro_id = ?";
			pst = cnct.prepareStatement(sql);
			System.out.println("D");

			for(int i = 0; i < beanlist.size();i++){
				System.out.println("E");
				//在庫数から購入数を減算
				int zaiko = beanlist.get(i).getStock_no() - beanlist.get(i).getKosuu();
				//結果の在庫数を確認
				System.out.println("現在庫数は：" + zaiko);
				//updateするために?へ格納
				pst.setInt(1, zaiko);
				//エラー発見用
				System.out.println("G");
				//idを?に格納
				pst.setString(2, beanlist.get(i).getPro_id());
				//実行文確認
				System.out.println("実行SQL文は"+pst);
				//アップデート開始
				pst.executeUpdate();
				System.out.println("H");
			}
			System.out.println("I");
			//コミットしてるよ
			cnct.commit();
			System.out.println("コミットしました");
		} catch(ClassNotFoundException ex){
			//↑クラス関連のエラーハンドリング
			System.out.println("クラスでミスってるよ");
		} catch(SQLException ex) {
			ex.printStackTrace();
			//↑SQL関連のエラーハンドリング
			System.out.println("メソッドのSQLミスってるよ");
			cnct.rollback();
			System.out.println("ロールバックしました");
			//最後に必ず行う処理
		} finally {
			try {
				//接続解除処理
				if (rs!=null) rs.close();
				if (pst!=null) pst.close();
				if (cnct!=null) cnct.close();
				System.out.println("商品詳細情報メソッド完了");
			} catch(Exception ex) { }
		}
	}
	//明細情報格納用メソッド
		public void insert(int user_id , ArrayList<ProductBean> beanlist) throws SQLException {
			//接続のためのurlとIDとpassの設定
			String url = "jdbc:mysql://localhost/lesson20xx";
			String id = "root";
			String pass = "password";
			//ここまで
			//DB接続に接続する際に使うやつ
			Connection cnct = null;
			//SQL実行結果を格納するやつ
			PreparedStatement pst = null;
			//SQL実行するときに使うやつ
			ResultSet rs = null;
			try {
				System.out.println("A");
				//ドライバを使用する定義
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("B");
				//ログインのための設定
				cnct = DriverManager.getConnection(url,id,pass);
				System.out.println("C");

				//自動コミットモードの解除
				cnct.setAutoCommit(false);

				//Calendarクラスのオブジェクトを生成する
				Calendar cl = Calendar.getInstance();
				//SimpleDateFormatクラスでフォーマットパターンを設定する
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println(sdf.format(cl.getTime()));

				for(int i = 0; i<beanlist.size(); i++) {
					//明細情報をinsertする
					String sql= "insert into meisai values( " + beanlist.get(i).getLaststock() + ", " + user_id + "," + beanlist.get(i).getCat_id() + ",'" + sdf.format(cl.getTime()) + "'," + beanlist.get(i).getAll() + ")";
					//insert文確認
					System.out.println(sql);
					//pstに格納
					pst = cnct.prepareStatement(sql);
					System.out.println("D");
					//もっかい確認
					System.out.println(pst);
					//insert文実行
					pst.executeUpdate();
				}

				//コミットしてるよ
				cnct.commit();
				System.out.println("コミットしました");
				System.out.println("insert文正常に作動しました");
			} catch(ClassNotFoundException ex){
				//↑クラス関連のエラーハンドリング
				System.out.println("クラスでミスってるよ");
			} catch(SQLException ex) {
				ex.printStackTrace();
				//↑SQL関連のエラーハンドリング
				System.out.println("メソッドのSQLミスってるよ");
				cnct.rollback();
				System.out.println("ロールバックしました");
				//最後に必ず行う処理
			} finally {
				try {
					//接続解除処理
					if (rs!=null) rs.close();
					if (pst!=null) pst.close();
					if (cnct!=null) cnct.close();
					System.out.println("insertメソッド完了");
				} catch(Exception ex) { }
			}
		}
		public String getcat_name(int cat_id) {
			String cat_name = "";
			//接続のためのurlとIDとpassの設定
			String url = "jdbc:mysql://localhost/lesson20xx";
			String id = "root";
			String pass = "password";
			//ここまで
			//DB接続に接続する際に使うやつ
			Connection cnct = null;
			//SQL実行結果を格納するやつ
			Statement st = null;
			//SQL実行するときに使うやつ
			ResultSet rs = null;
			ProductBean product = new ProductBean();
			try {
				System.out.println("A");
				//ドライバを使用する定義
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("B");
				//ログインのための設定
				cnct = DriverManager.getConnection(url,id,pass);
				System.out.println("C");
				st = cnct.createStatement();
				//セレクト文の格納・確認・実行
				String sql = "select * from category where cat_id =" + cat_id;
				System.out.println(sql);
				rs = st.executeQuery(sql);
				//内容が取り出せているなら
				while(rs.next()){
					System.out.println("ここから検索結果");
					cat_name = rs.getString("cat_name");
				}
				System.out.println("E");
				return cat_name;
			} catch(ClassNotFoundException ex){
				//↑クラス関連のエラーハンドリング
				System.out.println("クラスでミスってるよ");
				return cat_name;
			} catch(SQLException ex) {
				ex.printStackTrace();
				//↑SQL関連のエラーハンドリング
				System.out.println("情報格納用メソッドのSQLミスってるよ");
				return cat_name;
				//最後に必ず行う処理
			} finally {
				try {
					//接続解除処理
					if (rs!=null) rs.close();
					if (st!=null) st.close();
					if (cnct!=null) cnct.close();
					System.out.println("商品詳細情報メソッド完了");
				} catch(Exception ex) { }
			}
		}
}

