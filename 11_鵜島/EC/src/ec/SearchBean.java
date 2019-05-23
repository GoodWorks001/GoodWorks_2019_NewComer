package ec;

public class SearchBean {

	//商品名
	private String name;
	//単価
	private int price;
	//在庫
	private int stock;
	//画像
	private String img;
	//カテゴリ名
	private String category;


	public SearchBean(String name,int price,int stock,
			String img, String msg,String category) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.img = img;
		this.msg = msg;
		this.category = category;
	}



	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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
	//商品説明
	private String msg;
	private boolean indicate;


	public boolean isIndicate() {
		return indicate;
	}

	public void setIndicate(boolean indicate) {
		this.indicate = indicate;
	}

	public SearchBean() {
		name = null;
		price = 0;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
