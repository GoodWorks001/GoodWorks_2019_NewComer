package web;

import java.io.Serializable;

public class detailBean implements Serializable{

	private int p_cd = 0;
	private String p_name = null;
	private int stock = 0;
	private int price = 0;
	private String cat_name = null;
	private String p_img = null;
	private String p_msg = null;


	//変数p_cdを返すメソッド
	public int getP_cd() {
		return p_cd;
	}
	//引き数として受け取った値をカプセル化した値に代入
	public void setP_cd(int p_cd) {
		this.p_cd = p_cd;
	}

	//変数p_nameを返すメソッド
	public String getP_name() {
		return p_name;
	}
	//引き数として受け取った値をカプセル化した値に代入
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	//変数stockを返すメソッド
	public int getStock() {
		return stock;
	}
	//引き数として受け取った値をカプセル化した値に代入
	public void setStock(int stock) {
		this.stock = stock;
	}

	//変数stockを返すメソッド
	public int getPrice() {
		return price;
	}
	//引き数として受け取った値をカプセル化した値に代入
	public void setPrice(int price) {
		this.price = price;
	}

	//変数cat_idを返すメソッド
	public String getCat_name() {
		return cat_name;
	}
	//引き数として受け取った値をカプセル化した値に代入
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	//変数p_imgを返すメソッド
	public String getP_img() {
		return p_img;
	}
	//引き数として受け取った値をカプセル化した値に代入
	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	//変数p_imgを返すメソッド
	public String getP_msg() {
		return p_msg;
	}
	//引き数として受け取った値をカプセル化した値に代入
	public void setP_msg(String p_msg) {
		this.p_msg = p_msg;
	}

}
