package web1;

import java.io.Serializable;

public class SeaBean implements Serializable {

	private String pro_name;
	private int stock_no;
	private int pro_price;
	private String pro_img;
	private String pro_msg;
	private String category;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
