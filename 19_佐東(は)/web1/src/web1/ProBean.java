package web1;

import java.io.Serializable;

public class ProBean implements Serializable {

	private String pro_name; //←商品名です
	private int stock_no; //←在庫数です
	private int pro_price; //←商品価格です
	private String pro_img; //←商品画像です
	private String pro_msg; //←商品コメントです
	private String category5;
	private int pro_cd; //←商品コードです
	private String cat_name; //←カテゴリ名です
	private int t_kazu; //←

	public int getT_kazu() {
		return t_kazu;
	}
	public void setT_kazu(int t_kazu) {
		this.t_kazu = t_kazu;
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
	public int getPro_cd() {
		return pro_cd;
	}
	public void setPro_cd(int pro_cd) {
		this.pro_cd = pro_cd;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

}

