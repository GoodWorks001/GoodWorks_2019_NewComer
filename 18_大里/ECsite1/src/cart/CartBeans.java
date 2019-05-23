package cart;

import java.io.Serializable;
import java.util.HashMap;

public class CartBeans implements Serializable {

	//HashMap
	private HashMap<String, Integer[]> cart = new HashMap<String, Integer[]>();

	public void setCart(HashMap<String, Integer[]> cartt, String item, int quantity, int price) {

		Integer[] info = { 0, 0 };
		cart = cartt;

		if (cart.containsKey("init")) {
			cart.remove("init");
		}

		if (quantity > 0) {
			if (cart.containsKey(item)) {
				Integer[] valueinit = (Integer[]) cart.get(item);
				info[0] = valueinit[0] + quantity;
				info[1] = price;
				cart.put(item, info);
			} else {
				info[0] = quantity;
				info[1] = price;
				cart.put(item, info);
			}
		}
	}

	public HashMap<String, Integer[]> getCart() {
		return this.cart;
	}

	public HashMap<String, Integer[]> initCart() {
		Integer[] infoinit = { 0, 0 };
		cart.clear();
		cart.put("init", infoinit);
		return this.cart;
	}

}
