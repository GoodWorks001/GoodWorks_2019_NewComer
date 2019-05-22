package ec;

import java.io.Serializable;

public class itemBean implements Serializable {

	private String price;
	private String name;
	private String stock;
	private String kosuu;
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getKosuu() {
		return kosuu;
	}
	public void setKosuu(String kosuu) {
		this.kosuu = kosuu;
	}
}
