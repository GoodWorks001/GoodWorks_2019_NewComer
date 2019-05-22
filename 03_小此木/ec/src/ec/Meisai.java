package ec;

import java.io.Serializable;

public class Meisai implements Serializable{
	//明細ID
	private int  mei_id ;
	//購入日
	private String date;
	//税込み合計価格
	private int mei_price;
	//ユーザーid
	private int user_id;
	//商品コード
	private int pro_cd;
	//更新個数
	private int pro_stcok;

	public int getPro_stcok() {
		return pro_stcok;
	}
	public void setPro_stcok(int pro_stcok) {
		this.pro_stcok = pro_stcok;
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
	public int getMeiprice() {
		return mei_price;
	}
	public void setMeiprice(int mei_price) {
		this.mei_price = mei_price;
	}


}
