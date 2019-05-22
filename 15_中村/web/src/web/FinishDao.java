package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FinishDao {

	public void hh() {
		//url,id,pwの代入
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pw = "password";
		//データベースに接続する部品
		Connection cnct = null;
		//sqlを実行するためのAPI
		//プリコンパイルを必要とするときはPreparedStatement
		PreparedStatement pst = null;
		//sql文を実行した時の結果を格納するやつを定義
		ResultSet rs = null;
		try {
			//●基本的な利用手順
			//●JDBCドライバの登録
			Class.forName("com.mysql.jdbc.Driver");
			//●DBMSへの接続
			cnct = DriverManager.getConnection(url, id, pw);
			//自動コミットの解除
			cnct.setAutoCommit(false);
	}


		while(rs.next()){
            //dbのカラム値をインスタンシュに格納

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