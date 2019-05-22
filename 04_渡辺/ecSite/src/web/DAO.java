package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    //DBに接続する際に必要な情報
    //DBのURLを格納
    private String url = "jdbc:mysql://localhost/ecSite";
    //DBのidを格納
    private String id = "root";
    //DBのパスワードを格納
    private String pw = "password";

    //DBの接続に使う
    private Connection cnct = null;
    //SQL実行時に使う
    private Statement st = null;
    //SQLの実行結果を格納する
    private ResultSet rs = null;
    //プリコンパイル用
    private PreparedStatement pstmt = null;
    //insert文用
    private String query = null;


    //コンストラクタ
    public DAO(){
        try {
            //MySQLのJDBCドライバを登録( 失敗時に ClassNotFoundException を投げる)
            Class.forName("com.mysql.jdbc.Driver");

            //DB接続
            cnct = DriverManager.getConnection(url, id, pw);
            System.out.println("DB接続");

            //自動コミットを削除
            cnct.setAutoCommit(false);



        } catch (ClassNotFoundException ex) {
            //エラーの詳細を出力
            ex.printStackTrace();
            //DB切断
            dbClose();
        }catch (SQLException ex) {
            //エラーの詳細を出力
            ex.printStackTrace();
            //DB切断
            dbClose();
        }
    }

    //ユーザーを検索
    public ResultSet userSelect(String uid,String pw) {
        try {

        	query = "select * from user where login_cd = ? and login_pw = ?";

            //プリコンパイルをセット
        	pstmt = cnct.prepareStatement(query);

        	//入力した値をselect文にセット
        	pstmt.setString(1, uid);
        	pstmt.setString(2, pw);

            //SQL文実行
            rs = pstmt.executeQuery();
            System.out.println("実行したSQL：select * from user where login_cd = '" + uid + "' and login_pw = '"+ pw +"'");

            System.out.println("select文実行");


        } catch (SQLException ex) {
            //エラーの詳細を出力
            ex.printStackTrace();
        }finally {

        }
		return rs;
    }

    //カテゴリを取り出す
    public ResultSet getCat() {

    	try {
            //失敗時に SQLException を投げる
            st = cnct.createStatement();

            //SQL文実行
    		rs = st.executeQuery("select*from category");
    		System.out.println("SQL文実行");


		} catch (SQLException ex) {
			//エラー内容を表示
			System.out.println("getCatでエラー");
			ex.printStackTrace();
		}

    	return rs;
    }


    //商品を検索
    public ResultSet proSelect(String cat,String word) {

    	String query = "";

    	//カテゴリを指定していたらSQL文を追加
    	if(!(cat == null || cat.equals(""))) {
    		query = " cat_id = " + cat + " and ";
    	}


    	try {

            //失敗時に SQLException を投げる
            st = cnct.createStatement();

            //カテゴリ、フリーワード共に入力されていなかったらwhere文の記述がないSQL分を記述
            if((cat == null || cat.equals("")) && (word == null || word.equals(""))) {
            	rs = st.executeQuery("select * from product where stock_no > 0");
            	System.out.println("実行したSQL：select * from product where stock_no > 0");
            }else {
            	 System.out.println("実行したSQL：select * from product where stock_no > 0 and " + query + "pro_name like '%" + word + "%'");
                //SQL文実行
                rs = st.executeQuery("select * from product where stock_no > 0 and "+ query +"pro_name like '%" + word + "%'");

            }

            System.out.println("select文実行");


        } catch (SQLException ex) {
            //エラーの詳細を出力
            ex.printStackTrace();
        }finally {

        }
		return rs;
    }


    //商品を特定
    public ProductBean getPro(String pro_cd) {

    	ProductBean p = new ProductBean();
    	query = "select pro_cd,pro_name,stock_no,pro_price,product.cat_id,cat_name,pro_img,pro_msg from product left outer join category on product.cat_id = category.cat_id where pro_cd = ?";

    	try {

            //プリコンパイルをセット
    		pstmt = cnct.prepareStatement(query);

    		//値をセット
    		pstmt.setString(1, pro_cd);

    		//select文実行
    		rs = pstmt.executeQuery();

    		//カーソル移動
    		rs.next();

    		//インスタンスに値を設定
    		p.setPro_cd(rs.getInt("pro_cd"));
    		p.setPro_name(rs.getString("pro_name"));
    		p.setStock_no(rs.getInt("stock_no"));
    		p.setPro_price(rs.getInt("pro_price"));
    		p.setCat_name(rs.getString("cat_name"));
    		p.setPro_img(rs.getString("pro_img"));
    		p.setPro_msg(rs.getString("pro_msg"));


		} catch (SQLException ex) {
			//エラー内容を表示
		    ex.printStackTrace();

		}

    	return p;
    }


    //meisaiテーブルへ追加
    public void addMeisai(int uId,int sId,int money,int count) {

    	//meisaiテーブルに登録するためのSQL文(now()関数で現在日時を取得)
    	//DBの方で明細IDは連番にしてあるので追加不要
        query = "insert into meisai values(null,?,?,now(),?)";
        try {

        	//プリコンパイをセット
			pstmt = cnct.prepareStatement(query);

			try {

				int zeikomi = (int)((money * count)*1.08);

				//データをセット
				pstmt.setInt(1, uId);//ユーザーID
				pstmt.setInt(2, sId);//商品コード
				pstmt.setInt(3, zeikomi);//総額

				//insert文実行
				int ken = pstmt.executeUpdate();

				System.out.println(ken+"件更新しました。");

				//コミット実行
				cnct.commit();
				System.out.println("コミット実行");

			} catch (SQLException e) {
				//エラー内容表示
				e.printStackTrace();
				//ロールバック実行
				cnct.rollback();
				System.out.println("ロールバック実行");
			}

		} catch (SQLException ex) {
			//エラー内容を表示
			ex.printStackTrace();
		}
    }

    //在庫調整用
    public void updateStock(int count,int pro_id) {

    	//sql文
        query = "update product set stock_no = (stock_no - ?) where pro_cd = ?";

        try {

        	//SQL文をセット
			pstmt = cnct.prepareStatement(query);

			try {
				pstmt.setInt(1, count);
				pstmt.setInt(2, pro_id);

				//update文実行
				int ken = pstmt.executeUpdate();

				System.out.println(ken+"件更新しました。");

				//コミット実行
				cnct.commit();
				System.out.println("コミット実行");

			} catch (SQLException e) {
				//エラー内容表示
				e.printStackTrace();
				//ロールバック実行
				cnct.rollback();
				System.out.println("ロールバック実行");
			}

		} catch (SQLException ex) {
			//エラー内容を表示
			ex.printStackTrace();
		}
    }




    //DBを切断する
    public void dbClose() {
        try {
            //データベースに接続していた場合、接続を切る
            if(rs != null) {rs.close();}
            if(st != null) {st.close();}
            if(cnct != null) {cnct.close();}
            System.out.println("DB切断成功");

        } catch (Exception e) {
            //エラーの詳細を出力
            e.printStackTrace();
        }
    }

}
