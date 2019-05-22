package web;

import java.io.Serializable;

public class SearchBean implements Serializable{
	//カプセル化
	private String name;
	private int stock;
	private int price;
	private String img;
	private String msg;
	private String category;

	public SearchBean() {
	}

	public SearchBean(String name,int stock,int price,
			String img,String msg,String category) {
		setName(name);
		setStock(stock);
		setPrice(price);
		setImg(img);
		setMsg(msg);
		setCategory(category);
	}

			// フィールドのnameを取得して返す
			public String getName() {
				return name;
			}

			// フィールドのnameを設定
			public void setName(String name) {
				this.name = name;
			}

			public String getStock() {
				return stock;
			}

			public void setStock(String stock) {
				this.stock = stock;
			}

			public String getPrice() {
				return price;
			}

			public void setPrice(String price) {
				this.price = price;
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

			public String getCategory() {
				return category;
			}

			public void setCategory(String category) {
				this.category = category;
			}





}
