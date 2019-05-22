package ec;

import java.io.Serializable;

public class Product implements Serializable{
	//商品コード
	private int pro_cd;
	//商品名
	private String pro_name;
	//商品数
	private int stock;
	//商品価格
	private int pro_price;
	//商品画像
	private String pro_img;
	//商品内容
	private String pro_msg;
	//カテゴリー名
	private String cat_name;
	//注文数
	private int t_kazu;




	public int getT_kazu() {
		return t_kazu;
	}
	public void setT_kazu(int t_kazu) {
		this.t_kazu = t_kazu;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_id) {
		this.cat_name = cat_id;
	}
	public int getPro_cd() {
		return pro_cd;
	}
	public void setPro_cd(int pro_cd) {
		this.pro_cd = pro_cd;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public String getPro_img() {
		return pro_img;
	}
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	public String getPro_msg() {
		return pro_msg;
	}
	public void setPro_msg(String pro_msg) {
		this.pro_msg = pro_msg;
	}

}
