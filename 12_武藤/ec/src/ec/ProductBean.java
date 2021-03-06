package ec;

import java.io.Serializable;

public class ProductBean implements Serializable{

	//商品コード
	String pro_id;
	//商品名
	String pro_name;
	//在庫数
	int stock_no;
	//価格
	int pro_price;
	//カテゴリID
	String cat_id;
	//画像
	String pro_image;
	//商品説明
	String pro_msg;
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getStock_no() {
		return stock_no;
	}
	public void setStock_no(int stock_no) {
		this.stock_no = stock_no;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public String getCat_id() {
		return cat_id;
	}
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	public String getPro_image() {
		return pro_image;
	}
	public void setPro_image(String pro_image) {
		this.pro_image = pro_image;
	}
	public String getPro_msg() {
		return pro_msg;
	}
	public void setPro_msg(String pro_msg) {
		this.pro_msg = pro_msg;
	}
}
