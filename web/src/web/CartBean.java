package web;

import java.io.Serializable;
import java.util.HashMap;

public class CartBean implements Serializable{

	//cartオブジェクトインスタンス化
		private HashMap<String,Integer[]>cart = new HashMap<String,Integer[]>();

		// setCartメソッド：引数にて渡された商品名(item)、個数(quantity)、単価(price)をCartに格納
		public void setCart(HashMap<String,Integer[]>cartt, String item, int quantity, int price) {

			// 変数の初期化
			//Integer配列 infoに商品の個数と単価を格納（初期値は双方０とする）
			Integer [] info = {0,0};
			cart = cartt;

			//　初期化処理：ECServletにて初期化したcartの情報を削除（カート画面で余分な情報を出力させない為）
			if(cart.containsKey("init")) {
				cart.remove("init");
			}

			//　cartオブジェクトに引数にて渡されたitem, quantity, priceを格納
			if(quantity > 0) { //quantityが0以上ならば
				if(cart.containsKey(item)) { 										// cartに引数で渡されたitemがすでに入っているのであれば
					Integer [] valueinit = (Integer[])cart.get(item); 	//カートにすでに入っている個数を変数valueinitに格納

					info[0] = valueinit[0] + quantity; 	//配列infoに個数の総数を格納
					info[1] = price; 								//配列infoに単価を格納
					cart.put(item, info); 						//cartオブジェクトにitem, quantity,priceを格納
				} else {
					info[0] = quantity; 		//配列infoに個数の総数を格納
					info[1] = price;         	//配列infoに単価を格納
					cart.put(item, info);  	//cartオブジェクトにitem, quantity,priceを格納
				}
			}
		}

		// getCartメソッド：cartオブジェクトの情報をreturnする
		public HashMap<String, Integer[]> getCart() {
			return this.cart;
		}

		// initCartメソッド：cartオブジェクトを空にし、初期化する
		public HashMap<String, Integer[]> initCart() {
			Integer [] infoinit = {0,0};
			cart.clear();						//cartオブジェクトを空にする
			cart.put("init", infoinit);	//cartオブジェクトに初期値を設定
			return this.cart;
		}
}
