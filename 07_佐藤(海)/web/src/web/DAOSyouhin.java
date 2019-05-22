package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOSyouhin {
	int pro_cdSUI () {
		int dbprocdSUI=0;
		//入るデータベース
		String url = "jdbc:mysql://localhost/sekkei";
		//ログインするときのユーザー名
		String id = "root";
		//ログインするときのパスワード
		String pw = "password";
		//DBに接続する際に使うやつ
		Connection cnct = null;
		//SQLを実行するときにつかうやつ
		Statement st = null;
		//SQL実行結果を格納するやつ
		ResultSet rs = null;
		try {
		//JDBCドライバのロードとインスタンス化
		Class.forName("com.mysql.jdbc.Driver");
		                          //DBMSに接続
		/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
	                             //接続に失敗した場合エラーを投げる
		/*Statement*/ st = cnct.createStatement();
		//検索する条件を書く
		//実行結果を変数に代入
		/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=100");
		//レコードが後ろに存在すればtrue
		while(rs.next()){
		//レコードのカラム値を取り出す
			//int dbuserid=rs.getInt("user_id");
			//System.out.println(dbuserid);
		  dbprocdSUI=rs.getInt("pro_cd");
		System.out.println(dbprocdSUI);
		//String dblogin_cd=rs.getString("login_cd");
		//System.out.println(dblogin_cd);
		//String dbpass=rs.getString("login_pw");
		//System.out.println(dbpass);


		}

		} catch(ClassNotFoundException ex){
		ex.printStackTrace();
		} catch(SQLException ex) {
		ex.printStackTrace();
		//下記行でDBの接続を解除している
		} finally {
		try {
		if (rs!=null) rs.close();
		if (st!=null) st.close();
		if (cnct!=null) cnct.close();
		} catch(Exception ex) { }
		}
return  dbprocdSUI;
	}

	int pro_cdGOD () {
		int dbprocdGOD=0;
		//入るデータベース
		String url = "jdbc:mysql://localhost/sekkei";
		//ログインするときのユーザー名
		String id = "root";
		//ログインするときのパスワード
		String pw = "password";
		//DBに接続する際に使うやつ
		Connection cnct = null;
		//SQLを実行するときにつかうやつ
		Statement st = null;
		//SQL実行結果を格納するやつ
		ResultSet rs = null;
		try {
		//JDBCドライバのロードとインスタンス化
		Class.forName("com.mysql.jdbc.Driver");
		                          //DBMSに接続
		/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
	                             //接続に失敗した場合エラーを投げる
		/*Statement*/ st = cnct.createStatement();
		//検索する条件を書く
		//実行結果を変数に代入
		/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=200");
		//レコードが後ろに存在すればtrue
		while(rs.next()){
		//レコードのカラム値を取り出す
			//int dbuserid=rs.getInt("user_id");
			//System.out.println(dbuserid);
		  dbprocdGOD=rs.getInt("pro_cd");
		System.out.println(dbprocdGOD);
		//String dblogin_cd=rs.getString("login_cd");
		//System.out.println(dblogin_cd);
		//String dbpass=rs.getString("login_pw");
		//System.out.println(dbpass);


		}

		} catch(ClassNotFoundException ex){
		ex.printStackTrace();
		} catch(SQLException ex) {
		ex.printStackTrace();
		//下記行でDBの接続を解除している
		} finally {
		try {
		if (rs!=null) rs.close();
		if (st!=null) st.close();
		if (cnct!=null) cnct.close();
		} catch(Exception ex) { }
		}
return  dbprocdGOD;
	}


	int pro_cdPC () {
		int dbprocdPC=0;
		//入るデータベース
		String url = "jdbc:mysql://localhost/sekkei";
		//ログインするときのユーザー名
		String id = "root";
		//ログインするときのパスワード
		String pw = "password";
		//DBに接続する際に使うやつ
		Connection cnct = null;
		//SQLを実行するときにつかうやつ
		Statement st = null;
		//SQL実行結果を格納するやつ
		ResultSet rs = null;
		try {
		//JDBCドライバのロードとインスタンス化
		Class.forName("com.mysql.jdbc.Driver");
		                          //DBMSに接続
		/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
	                             //接続に失敗した場合エラーを投げる
		/*Statement*/ st = cnct.createStatement();
		//検索する条件を書く
		//実行結果を変数に代入
		/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=300");
		//レコードが後ろに存在すればtrue
		while(rs.next()){
		//レコードのカラム値を取り出す
			//int dbuserid=rs.getInt("user_id");
			//System.out.println(dbuserid);
		  dbprocdPC=rs.getInt("pro_cd");
		System.out.println(dbprocdPC);
		//String dblogin_cd=rs.getString("login_cd");
		//System.out.println(dblogin_cd);
		//String dbpass=rs.getString("login_pw");
		//System.out.println(dbpass);


		}

		} catch(ClassNotFoundException ex){
		ex.printStackTrace();
		} catch(SQLException ex) {
		ex.printStackTrace();
		//下記行でDBの接続を解除している
		} finally {
		try {
		if (rs!=null) rs.close();
		if (st!=null) st.close();
		if (cnct!=null) cnct.close();
		} catch(Exception ex) { }
		}
return  dbprocdPC;
	}

	//データベースからユーザー情報を持ってくるＤＡＯ
		String selectpronameSUI () {
			String dbproname="";
			//入るデータベース
			String url = "jdbc:mysql://localhost/sekkei";
			//ログインするときのユーザー名
			String id = "root";
			//ログインするときのパスワード
			String pw = "password";
			//DBに接続する際に使うやつ
			Connection cnct = null;
			//SQLを実行するときにつかうやつ
			Statement st = null;
			//SQL実行結果を格納するやつ
			ResultSet rs = null;
			try {
			//JDBCドライバのロードとインスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			                          //DBMSに接続
			/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
		                             //接続に失敗した場合エラーを投げる
			/*Statement*/ st = cnct.createStatement();
			//検索する条件を書く
			//実行結果を変数に代入
			/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=100");
			//レコードが後ろに存在すればtrue
			while(rs.next()){
			//レコードのカラム値を取り出す
				//int dbuserid=rs.getInt("user_id");
				//System.out.println(dbuserid);
			 dbproname=rs.getString("pro_name");
			System.out.println(dbproname);
			//String dblogin_cd=rs.getString("login_cd");
			//System.out.println(dblogin_cd);
			//String dbpass=rs.getString("login_pw");
			//System.out.println(dbpass);


			}

			} catch(ClassNotFoundException ex){
			ex.printStackTrace();
			} catch(SQLException ex) {
			ex.printStackTrace();
			//下記行でDBの接続を解除している
			} finally {
			try {
			if (rs!=null) rs.close();
			if (st!=null) st.close();
			if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
			}
	return  dbproname;
		}

		//データベースからユーザー情報を持ってくるＤＡＯ
		int selectpropriceSUI () {
			int dbproprice=0;
			//入るデータベース
			String url = "jdbc:mysql://localhost/sekkei";
			//ログインするときのユーザー名
			String id = "root";
			//ログインするときのパスワード
			String pw = "password";
			//DBに接続する際に使うやつ
			Connection cnct = null;
			//SQLを実行するときにつかうやつ
			Statement st = null;
			//SQL実行結果を格納するやつ
			ResultSet rs = null;
			try {
			//JDBCドライバのロードとインスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			                          //DBMSに接続
			/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
		                             //接続に失敗した場合エラーを投げる
			/*Statement*/ st = cnct.createStatement();
			//検索する条件を書く
			//実行結果を変数に代入
			/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=100");
			//レコードが後ろに存在すればtrue
			while(rs.next()){
			//レコードのカラム値を取り出す
				//int dbuserid=rs.getInt("user_id");
				//System.out.println(dbuserid);
				dbproprice=rs.getInt("pro_price");
			System.out.println(dbproprice);
			//String dblogin_cd=rs.getString("login_cd");
			//System.out.println(dblogin_cd);
			//String dbpass=rs.getString("login_pw");
			//System.out.println(dbpass);


			}

			} catch(ClassNotFoundException ex){
			ex.printStackTrace();
			} catch(SQLException ex) {
			ex.printStackTrace();
			//下記行でDBの接続を解除している
			} finally {
			try {
			if (rs!=null) rs.close();
			if (st!=null) st.close();
			if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
			}
	return  dbproprice;
		}

		//データベースからユーザー情報を持ってくるＤＡＯ
		String selectcatnameSUI () {
			String dbcatname="";
			//入るデータベース
			String url = "jdbc:mysql://localhost/sekkei";
			//ログインするときのユーザー名
			String id = "root";
			//ログインするときのパスワード
			String pw = "password";
			//DBに接続する際に使うやつ
			Connection cnct = null;
			//SQLを実行するときにつかうやつ
			Statement st = null;
			//SQL実行結果を格納するやつ
			ResultSet rs = null;
			try {
			//JDBCドライバのロードとインスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			                          //DBMSに接続
			/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
		                             //接続に失敗した場合エラーを投げる
			/*Statement*/ st = cnct.createStatement();
			//検索する条件を書く
			//実行結果を変数に代入
			/*ResultSet*/rs = st.executeQuery("select*from category where cat_id=1000");
			//レコードが後ろに存在すればtrue
			while(rs.next()){
			//レコードのカラム値を取り出す
				//int dbuserid=rs.getInt("user_id");
				//System.out.println(dbuserid);
			 dbcatname=rs.getString("cat_name");
			System.out.println(dbcatname);
			//String dblogin_cd=rs.getString("login_cd");
			//System.out.println(dblogin_cd);
			//String dbpass=rs.getString("login_pw");
			//System.out.println(dbpass);


			}

			} catch(ClassNotFoundException ex){
			ex.printStackTrace();
			} catch(SQLException ex) {
			ex.printStackTrace();
			//下記行でDBの接続を解除している
			} finally {
			try {
			if (rs!=null) rs.close();
			if (st!=null) st.close();
			if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
			}
	return  dbcatname;
		}

		int ZaikoSUI () {
			int dbzaiko=0;
			//入るデータベース
			String url = "jdbc:mysql://localhost/sekkei";
			//ログインするときのユーザー名
			String id = "root";
			//ログインするときのパスワード
			String pw = "password";
			//DBに接続する際に使うやつ
			Connection cnct = null;
			//SQLを実行するときにつかうやつ
			Statement st = null;
			//SQL実行結果を格納するやつ
			ResultSet rs = null;
			try {
			//JDBCドライバのロードとインスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			                          //DBMSに接続
			/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
		                             //接続に失敗した場合エラーを投げる
			/*Statement*/ st = cnct.createStatement();
			//検索する条件を書く
			//実行結果を変数に代入
			/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=100");
			//レコードが後ろに存在すればtrue
			while(rs.next()){
			//レコードのカラム値を取り出す
				//int dbuserid=rs.getInt("user_id");
				//System.out.println(dbuserid);
			 dbzaiko=rs.getInt("stock_no");
			System.out.println(dbzaiko);
			//String dblogin_cd=rs.getString("login_cd");
			//System.out.println(dblogin_cd);
			//String dbpass=rs.getString("login_pw");
			//System.out.println(dbpass);


			}

			} catch(ClassNotFoundException ex){
			ex.printStackTrace();
			} catch(SQLException ex) {
			ex.printStackTrace();
			//下記行でDBの接続を解除している
			} finally {
			try {
			if (rs!=null) rs.close();
			if (st!=null) st.close();
			if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
			}
	return  dbzaiko;
		}

		String syoukaiSUI () {
			String dbsyoukai="";
			//入るデータベース
			String url = "jdbc:mysql://localhost/sekkei";
			//ログインするときのユーザー名
			String id = "root";
			//ログインするときのパスワード
			String pw = "password";
			//DBに接続する際に使うやつ
			Connection cnct = null;
			//SQLを実行するときにつかうやつ
			Statement st = null;
			//SQL実行結果を格納するやつ
			ResultSet rs = null;
			try {
			//JDBCドライバのロードとインスタンス化
			Class.forName("com.mysql.jdbc.Driver");
			                          //DBMSに接続
			/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
		                             //接続に失敗した場合エラーを投げる
			/*Statement*/ st = cnct.createStatement();
			//検索する条件を書く
			//実行結果を変数に代入
			/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=100");
			//レコードが後ろに存在すればtrue
			while(rs.next()){
			//レコードのカラム値を取り出す
				//int dbuserid=rs.getInt("user_id");
				//System.out.println(dbuserid);
			 dbsyoukai=rs.getString("pro_msg");
			System.out.println(dbsyoukai);
			//String dblogin_cd=rs.getString("login_cd");
			//System.out.println(dblogin_cd);
			//String dbpass=rs.getString("login_pw");
			//System.out.println(dbpass);


			}

			} catch(ClassNotFoundException ex){
			ex.printStackTrace();
			} catch(SQLException ex) {
			ex.printStackTrace();
			//下記行でDBの接続を解除している
			} finally {
			try {
			if (rs!=null) rs.close();
			if (st!=null) st.close();
			if (cnct!=null) cnct.close();
			} catch(Exception ex) { }
			}
	return  dbsyoukai;
		}

//ここまで炊飯器の名前、価格、カテゴリー名

		//データベースからユーザー情報を持ってくるＤＡＯ
				String selectpronameGOD () {
					String dbproname="";
					//入るデータベース
					String url = "jdbc:mysql://localhost/sekkei";
					//ログインするときのユーザー名
					String id = "root";
					//ログインするときのパスワード
					String pw = "password";
					//DBに接続する際に使うやつ
					Connection cnct = null;
					//SQLを実行するときにつかうやつ
					Statement st = null;
					//SQL実行結果を格納するやつ
					ResultSet rs = null;
					try {
					//JDBCドライバのロードとインスタンス化
					Class.forName("com.mysql.jdbc.Driver");
					                          //DBMSに接続
					/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
				                             //接続に失敗した場合エラーを投げる
					/*Statement*/ st = cnct.createStatement();
					//検索する条件を書く
					//実行結果を変数に代入
					/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=200");
					//レコードが後ろに存在すればtrue
					while(rs.next()){
					//レコードのカラム値を取り出す
						//int dbuserid=rs.getInt("user_id");
						//System.out.println(dbuserid);
					 dbproname=rs.getString("pro_name");
					System.out.println(dbproname);
					//String dblogin_cd=rs.getString("login_cd");
					//System.out.println(dblogin_cd);
					//String dbpass=rs.getString("login_pw");
					//System.out.println(dbpass);


					}

					} catch(ClassNotFoundException ex){
					ex.printStackTrace();
					} catch(SQLException ex) {
					ex.printStackTrace();
					//下記行でDBの接続を解除している
					} finally {
					try {
					if (rs!=null) rs.close();
					if (st!=null) st.close();
					if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
					}
			return  dbproname;
				}



				//データベースからユーザー情報を持ってくるＤＡＯ
				int selectpropriceGOD () {
					int dbproprice=0;
					//入るデータベース
					String url = "jdbc:mysql://localhost/sekkei";
					//ログインするときのユーザー名
					String id = "root";
					//ログインするときのパスワード
					String pw = "password";
					//DBに接続する際に使うやつ
					Connection cnct = null;
					//SQLを実行するときにつかうやつ
					Statement st = null;
					//SQL実行結果を格納するやつ
					ResultSet rs = null;
					try {
					//JDBCドライバのロードとインスタンス化
					Class.forName("com.mysql.jdbc.Driver");
					                          //DBMSに接続
					/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
				                             //接続に失敗した場合エラーを投げる
					/*Statement*/ st = cnct.createStatement();
					//検索する条件を書く
					//実行結果を変数に代入
					/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=200");
					//レコードが後ろに存在すればtrue
					while(rs.next()){
					//レコードのカラム値を取り出す
						//int dbuserid=rs.getInt("user_id");
						//System.out.println(dbuserid);
						dbproprice=rs.getInt("pro_price");
					System.out.println(dbproprice);
					//String dblogin_cd=rs.getString("login_cd");
					//System.out.println(dblogin_cd);
					//String dbpass=rs.getString("login_pw");
					//System.out.println(dbpass);


					}

					} catch(ClassNotFoundException ex){
					ex.printStackTrace();
					} catch(SQLException ex) {
					ex.printStackTrace();
					//下記行でDBの接続を解除している
					} finally {
					try {
					if (rs!=null) rs.close();
					if (st!=null) st.close();
					if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
					}
			return  dbproprice;
				}

				//データベースからユーザー情報を持ってくるＤＡＯ
				String selectcatnameGOD () {
					String dbcatname="";
					//入るデータベース
					String url = "jdbc:mysql://localhost/sekkei";
					//ログインするときのユーザー名
					String id = "root";
					//ログインするときのパスワード
					String pw = "password";
					//DBに接続する際に使うやつ
					Connection cnct = null;
					//SQLを実行するときにつかうやつ
					Statement st = null;
					//SQL実行結果を格納するやつ
					ResultSet rs = null;
					try {
					//JDBCドライバのロードとインスタンス化
					Class.forName("com.mysql.jdbc.Driver");
					                          //DBMSに接続
					/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
				                             //接続に失敗した場合エラーを投げる
					/*Statement*/ st = cnct.createStatement();
					//検索する条件を書く
					//実行結果を変数に代入
					/*ResultSet*/rs = st.executeQuery("select*from category where cat_id=2000");
					//レコードが後ろに存在すればtrue
					while(rs.next()){
					//レコードのカラム値を取り出す
						//int dbuserid=rs.getInt("user_id");
						//System.out.println(dbuserid);
					 dbcatname=rs.getString("cat_name");
					System.out.println(dbcatname);
					//String dblogin_cd=rs.getString("login_cd");
					//System.out.println(dblogin_cd);
					//String dbpass=rs.getString("login_pw");
					//System.out.println(dbpass);


					}

					} catch(ClassNotFoundException ex){
					ex.printStackTrace();
					} catch(SQLException ex) {
					ex.printStackTrace();
					//下記行でDBの接続を解除している
					} finally {
					try {
					if (rs!=null) rs.close();
					if (st!=null) st.close();
					if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
					}
			return  dbcatname;
				}

				int ZaikoGOD () {
					int dbzaiko=0;
					//入るデータベース
					String url = "jdbc:mysql://localhost/sekkei";
					//ログインするときのユーザー名
					String id = "root";
					//ログインするときのパスワード
					String pw = "password";
					//DBに接続する際に使うやつ
					Connection cnct = null;
					//SQLを実行するときにつかうやつ
					Statement st = null;
					//SQL実行結果を格納するやつ
					ResultSet rs = null;
					try {
					//JDBCドライバのロードとインスタンス化
					Class.forName("com.mysql.jdbc.Driver");
					                          //DBMSに接続
					/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
				                             //接続に失敗した場合エラーを投げる
					/*Statement*/ st = cnct.createStatement();
					//検索する条件を書く
					//実行結果を変数に代入
					/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=200");
					//レコードが後ろに存在すればtrue
					while(rs.next()){
					//レコードのカラム値を取り出す
						//int dbuserid=rs.getInt("user_id");
						//System.out.println(dbuserid);
					 dbzaiko=rs.getInt("stock_no");
					System.out.println(dbzaiko);
					//String dblogin_cd=rs.getString("login_cd");
					//System.out.println(dblogin_cd);
					//String dbpass=rs.getString("login_pw");
					//System.out.println(dbpass);


					}

					} catch(ClassNotFoundException ex){
					ex.printStackTrace();
					} catch(SQLException ex) {
					ex.printStackTrace();
					//下記行でDBの接続を解除している
					} finally {
					try {
					if (rs!=null) rs.close();
					if (st!=null) st.close();
					if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
					}
			return  dbzaiko;
				}

				String syoukaiGOD () {
					String dbsyoukai="";
					//入るデータベース
					String url = "jdbc:mysql://localhost/sekkei";
					//ログインするときのユーザー名
					String id = "root";
					//ログインするときのパスワード
					String pw = "password";
					//DBに接続する際に使うやつ
					Connection cnct = null;
					//SQLを実行するときにつかうやつ
					Statement st = null;
					//SQL実行結果を格納するやつ
					ResultSet rs = null;
					try {
					//JDBCドライバのロードとインスタンス化
					Class.forName("com.mysql.jdbc.Driver");
					                          //DBMSに接続
					/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
				                             //接続に失敗した場合エラーを投げる
					/*Statement*/ st = cnct.createStatement();
					//検索する条件を書く
					//実行結果を変数に代入
					/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=200");
					//レコードが後ろに存在すればtrue
					while(rs.next()){
					//レコードのカラム値を取り出す
						//int dbuserid=rs.getInt("user_id");
						//System.out.println(dbuserid);
					 dbsyoukai=rs.getString("pro_msg");
					System.out.println(dbsyoukai);
					//String dblogin_cd=rs.getString("login_cd");
					//System.out.println(dblogin_cd);
					//String dbpass=rs.getString("login_pw");
					//System.out.println(dbpass);


					}

					} catch(ClassNotFoundException ex){
					ex.printStackTrace();
					} catch(SQLException ex) {
					ex.printStackTrace();
					//下記行でDBの接続を解除している
					} finally {
					try {
					if (rs!=null) rs.close();
					if (st!=null) st.close();
					if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
					}
			return  dbsyoukai;
				}

				//ここまでGODの名前、価格、カテゴリー名

				//データベースからユーザー情報を持ってくるＤＡＯ
				String selectpronamePC () {
					String dbproname="";
					//入るデータベース
					String url = "jdbc:mysql://localhost/sekkei";
					//ログインするときのユーザー名
					String id = "root";
					//ログインするときのパスワード
					String pw = "password";
					//DBに接続する際に使うやつ
					Connection cnct = null;
					//SQLを実行するときにつかうやつ
					Statement st = null;
					//SQL実行結果を格納するやつ
					ResultSet rs = null;
					try {
					//JDBCドライバのロードとインスタンス化
					Class.forName("com.mysql.jdbc.Driver");
					                          //DBMSに接続
					/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
				                             //接続に失敗した場合エラーを投げる
					/*Statement*/ st = cnct.createStatement();
					//検索する条件を書く
					//実行結果を変数に代入
					/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=300");
					//レコードが後ろに存在すればtrue
					while(rs.next()){
					//レコードのカラム値を取り出す
						//int dbuserid=rs.getInt("user_id");
						//System.out.println(dbuserid);
					 dbproname=rs.getString("pro_name");
					System.out.println(dbproname);
					//String dblogin_cd=rs.getString("login_cd");
					//System.out.println(dblogin_cd);
					//String dbpass=rs.getString("login_pw");
					//System.out.println(dbpass);


					}

					} catch(ClassNotFoundException ex){
					ex.printStackTrace();
					} catch(SQLException ex) {
					ex.printStackTrace();
					//下記行でDBの接続を解除している
					} finally {
					try {
					if (rs!=null) rs.close();
					if (st!=null) st.close();
					if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
					}
			return  dbproname;
				}

				//データベースからユーザー情報を持ってくるＤＡＯ
				int selectpropricePC () {
					int dbproprice=0;
					//入るデータベース
					String url = "jdbc:mysql://localhost/sekkei";
					//ログインするときのユーザー名
					String id = "root";
					//ログインするときのパスワード
					String pw = "password";
					//DBに接続する際に使うやつ
					Connection cnct = null;
					//SQLを実行するときにつかうやつ
					Statement st = null;
					//SQL実行結果を格納するやつ
					ResultSet rs = null;
					try {
					//JDBCドライバのロードとインスタンス化
					Class.forName("com.mysql.jdbc.Driver");
					                          //DBMSに接続
					/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
				                             //接続に失敗した場合エラーを投げる
					/*Statement*/ st = cnct.createStatement();
					//検索する条件を書く
					//実行結果を変数に代入
					/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=300");
					//レコードが後ろに存在すればtrue
					while(rs.next()){
					//レコードのカラム値を取り出す
						//int dbuserid=rs.getInt("user_id");
						//System.out.println(dbuserid);
						dbproprice=rs.getInt("pro_price");
					System.out.println(dbproprice);
					//String dblogin_cd=rs.getString("login_cd");
					//System.out.println(dblogin_cd);
					//String dbpass=rs.getString("login_pw");
					//System.out.println(dbpass);


					}

					} catch(ClassNotFoundException ex){
					ex.printStackTrace();
					} catch(SQLException ex) {
					ex.printStackTrace();
					//下記行でDBの接続を解除している
					} finally {
					try {
					if (rs!=null) rs.close();
					if (st!=null) st.close();
					if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
					}
			return  dbproprice;
				}

				//データベースからユーザー情報を持ってくるＤＡＯ
				String selectcatnamePC () {
					String dbcatname="";
					//入るデータベース
					String url = "jdbc:mysql://localhost/sekkei";
					//ログインするときのユーザー名
					String id = "root";
					//ログインするときのパスワード
					String pw = "password";
					//DBに接続する際に使うやつ
					Connection cnct = null;
					//SQLを実行するときにつかうやつ
					Statement st = null;
					//SQL実行結果を格納するやつ
					ResultSet rs = null;
					try {
					//JDBCドライバのロードとインスタンス化
					Class.forName("com.mysql.jdbc.Driver");
					                          //DBMSに接続
					/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
				                             //接続に失敗した場合エラーを投げる
					/*Statement*/ st = cnct.createStatement();
					//検索する条件を書く
					//実行結果を変数に代入
					/*ResultSet*/rs = st.executeQuery("select*from category where cat_id=3000");
					//レコードが後ろに存在すればtrue
					while(rs.next()){
					//レコードのカラム値を取り出す
						//int dbuserid=rs.getInt("user_id");
						//System.out.println(dbuserid);
					 dbcatname=rs.getString("cat_name");
					System.out.println(dbcatname);
					//String dblogin_cd=rs.getString("login_cd");
					//System.out.println(dblogin_cd);
					//String dbpass=rs.getString("login_pw");
					//System.out.println(dbpass);


					}

					} catch(ClassNotFoundException ex){
					ex.printStackTrace();
					} catch(SQLException ex) {
					ex.printStackTrace();
					//下記行でDBの接続を解除している
					} finally {
					try {
					if (rs!=null) rs.close();
					if (st!=null) st.close();
					if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
					}
			return  dbcatname;
				}

				int ZaikoPC () {
					int dbzaiko=0;
					//入るデータベース
					String url = "jdbc:mysql://localhost/sekkei";
					//ログインするときのユーザー名
					String id = "root";
					//ログインするときのパスワード
					String pw = "password";
					//DBに接続する際に使うやつ
					Connection cnct = null;
					//SQLを実行するときにつかうやつ
					Statement st = null;
					//SQL実行結果を格納するやつ
					ResultSet rs = null;
					try {
					//JDBCドライバのロードとインスタンス化
					Class.forName("com.mysql.jdbc.Driver");
					                          //DBMSに接続
					/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
				                             //接続に失敗した場合エラーを投げる
					/*Statement*/ st = cnct.createStatement();
					//検索する条件を書く
					//実行結果を変数に代入
					/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=300");
					//レコードが後ろに存在すればtrue
					while(rs.next()){
					//レコードのカラム値を取り出す
						//int dbuserid=rs.getInt("user_id");
						//System.out.println(dbuserid);
					 dbzaiko=rs.getInt("stock_no");
					System.out.println(dbzaiko);
					//String dblogin_cd=rs.getString("login_cd");
					//System.out.println(dblogin_cd);
					//String dbpass=rs.getString("login_pw");
					//System.out.println(dbpass);


					}

					} catch(ClassNotFoundException ex){
					ex.printStackTrace();
					} catch(SQLException ex) {
					ex.printStackTrace();
					//下記行でDBの接続を解除している
					} finally {
					try {
					if (rs!=null) rs.close();
					if (st!=null) st.close();
					if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
					}
			return  dbzaiko;
				}

				String syoukaiPC () {
					String dbsyoukai="";
					//入るデータベース
					String url = "jdbc:mysql://localhost/sekkei";
					//ログインするときのユーザー名
					String id = "root";
					//ログインするときのパスワード
					String pw = "password";
					//DBに接続する際に使うやつ
					Connection cnct = null;
					//SQLを実行するときにつかうやつ
					Statement st = null;
					//SQL実行結果を格納するやつ
					ResultSet rs = null;
					try {
					//JDBCドライバのロードとインスタンス化
					Class.forName("com.mysql.jdbc.Driver");
					                          //DBMSに接続
					/*Connection*/ cnct = DriverManager.getConnection(url,id,pw);
				                             //接続に失敗した場合エラーを投げる
					/*Statement*/ st = cnct.createStatement();
					//検索する条件を書く
					//実行結果を変数に代入
					/*ResultSet*/rs = st.executeQuery("select*from product where pro_cd=300");
					//レコードが後ろに存在すればtrue
					while(rs.next()){
					//レコードのカラム値を取り出す
						//int dbuserid=rs.getInt("user_id");
						//System.out.println(dbuserid);
					 dbsyoukai=rs.getString("pro_msg");
					System.out.println(dbsyoukai);
					//String dblogin_cd=rs.getString("login_cd");
					//System.out.println(dblogin_cd);
					//String dbpass=rs.getString("login_pw");
					//System.out.println(dbpass);


					}

					} catch(ClassNotFoundException ex){
					ex.printStackTrace();
					} catch(SQLException ex) {
					ex.printStackTrace();
					//下記行でDBの接続を解除している
					} finally {
					try {
					if (rs!=null) rs.close();
					if (st!=null) st.close();
					if (cnct!=null) cnct.close();
					} catch(Exception ex) { }
					}
			return  dbsyoukai;
				}

				//ここまでPCの名前、価格、カテゴリー名


}
