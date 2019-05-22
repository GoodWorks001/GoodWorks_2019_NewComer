package web1;

import java.io.Serializable;

public class MeisaiBean implements Serializable {

	private int mei_id; //←明細IDです
	private String date; //←データです
	private int mei_price; //←明細価格です
	private int user_id; //←ユーザーIDです
	private int pro_cd; //←商品コードです
	private int pro_Rstock; //←更新されるストックです
	public int getMei_id() {
		return mei_id;
	}
	public void setMei_id(int mei_id) {
		this.mei_id = mei_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getMei_price() {
		return mei_price;
	}
	public void setMei_price(int mei_price) {
		this.mei_price = mei_price;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPro_cd() {
		return pro_cd;
	}
	public void setPro_cd(int pro_cd) {
		this.pro_cd = pro_cd;
	}
	public int getPro_Rstock() {
		return pro_Rstock;
	}
	public void setPro_Rstock(int pro_Rstock) {
		this.pro_Rstock = pro_Rstock;
	}

}
