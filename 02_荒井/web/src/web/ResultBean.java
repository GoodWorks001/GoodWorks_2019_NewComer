package web;

import java.io.Serializable;

public class ResultBean implements Serializable{

	//カプセル化
	private String money = null;
	private String love = null;
	private String work = null;
	private String health = null;
	private String total = null;


    //値の取得
	public String getMoney() {
		return money;
	}


/*メインメソッドから受け取った値を
 * nullが入っているmoneyに代入
*/
	public void setMoney(String money) {
		this.money = money;
	}


    //値の取得
	public String getLove() {
		return love;
	}


	/*メインメソッドから受け取った値を
	 * nullが入っているloveに代入
	*/
	public void setLove(String love) {
		this.love = love;
	}

    //値の取得
	public String getWork() {
		return work;
	}



	/*メインメソッドから受け取った値を
	 * nullが入っているworkに代入
	*/
	public void setWork(String work) {
		this.work = work;
	}


    //値の取得
	public String getHealth() {
		return health;
	}


	/*メインメソッドから受け取った値を
	 * nullが入っているhelthに代入
	*/
	public void setHealth(String health) {
		this.health = health;
	}


    //値の取得
	public String getTotal() {
		return total;
	}


	/*メインメソッドから受け取った値を
	 * nullが入っているtotalに代入
	*/
	public void setTotal(String total) {
		this.total = total;
	}



}
