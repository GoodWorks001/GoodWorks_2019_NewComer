package ec;

import java.io.Serializable;

public class ItemBean implements Serializable {

	static final long serialVersionUID = 2L;
	private String name;//商品名
	private int stock;//在庫数
	private int price;//単価
	private String img;//画像
	private String msg;//商品説明
	private String category;//カテゴリ名
	private int cd;
	private int order;

	// デフォルトコンストラクタ
	public ItemBean() {
	}

	// 初期化コンストラクタ
	public ItemBean(String name,int stock,int price,
			String img,String msg,String category) {
		setName(name);
		setStock(stock);
		setPrice(price);
		setImg(img);
		setMsg(msg);
		setCategory(category);

	}




	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


