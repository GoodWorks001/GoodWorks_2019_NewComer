package EC;

import java.io.Serializable;

public class SyouhinBean implements Serializable {

	private int stock;
	private int price;
	private String msg = "";
	private String img = "";
	private String name = "";
	private int cat_id;
	private String cat_name = "";
	private int pro_cd;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCat_id() {
		return cat_id;
	}


	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}


	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public int getPro_cd() {
		return pro_cd;
	}


	public void setPro_cd(int pro_cd) {
		this.pro_cd = pro_cd;
	}
}
