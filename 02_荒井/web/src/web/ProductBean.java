package web;

public class ProductBean {


	private int cd;          //商品コード
	private  String name;     //商品名
	private int stock;        //在庫数
	private int price;       //商品の単価
	private String img;      //商品画像
	private String msg;      //商品説明
	private int id;          //カテゴリのコード
	private String category;     //カテゴリー名
	private int buy;    //購入個数




	public int getBuy() {
		return buy;
	}


	//受け取った値をセットする
	public void setBuy(int buy) {
		this.buy = buy;
	}


	public int getCd() {
		return cd;
	}


	//受け取った値をセットする
	public void setCd(int cd) {
		this.cd = cd;
	}


	public String getName() {
		return name;
	}


	//受け取った値をセットする
	public void setName(String name) {
		this.name = name;
	}


	public int getStock() {
		return stock;
	}


	//受け取った値をセットする
	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getPrice() {
		return price;
	}


	//受け取った値をセットする
	public void setPrice(int price) {
		this.price = price;
	}


	public String getImg() {
		return img;
	}


	//受け取った値をセットする
	public void setImg(String img) {
		this.img = img;
	}


	public String getMsg() {
		return msg;
	}


	//受け取った値をセットする
	public void setMsg(String msg) {
		this.msg = msg;
	}


	public int getId() {
		return id;
	}


	//受け取った値をセットする
	public void setId(int id) {
		this.id = id;
	}


	public String getCategory() {
		return category;
	}


	//受け取った値をセットする
	public void setCategory(String category) {
		this.category = category;
	}

}
