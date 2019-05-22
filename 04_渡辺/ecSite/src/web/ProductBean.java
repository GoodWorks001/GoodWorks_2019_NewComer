package web;

public class ProductBean {

	//商品コード
	private int pro_cd = 0;
	//商品名
	private String pro_name = null;
	//在庫数
	private int stock_no = 0;
	//商品単価
	private int pro_price = 0;
	//カテゴリコード
	private int cat_id = 0;
	//カテゴリ名
	private String cat_name = null;
	//商品画像
	private String pro_img = null;
	//商品説明
	private String pro_msg = null;
	//購入個数
	private int count = 0;


	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//商品コードを取得
	public int getPro_cd() {
		return pro_cd;
	}
	//商品コードを設定
	public void setPro_cd(int pro_cd) {
		this.pro_cd = pro_cd;
	}
	//商品名を取得
	public String getPro_name() {
		return pro_name;
	}
	//商品名を設定
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	//在庫数を取得
	public int getStock_no() {
		return stock_no;
	}
	//在庫数を設定
	public void setStock_no(int stock_no) {
		this.stock_no = stock_no;
	}
	//商品単価を取得
	public int getPro_price() {
		return pro_price;
	}
	//商品単価を設定
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	//カテゴリコードを取得
	public int getCat_id() {
		return cat_id;
	}
	//カテゴリコードを設定
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	//商品画像を取得
	public String getPro_img() {
		return pro_img;
	}
	//商品画像を設定
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	//商品説明を取得
	public String getPro_msg() {
		return pro_msg;
	}
	//商品説明を設定
	public void setPro_msg(String pro_msg) {
		this.pro_msg = pro_msg;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

}
