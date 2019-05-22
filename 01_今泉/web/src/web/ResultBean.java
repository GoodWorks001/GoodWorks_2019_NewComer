package web;

import java.io.Serializable;

public class ResultBean implements Serializable{

	//カプセル化
	private String money ="";
	private String love ="";
	private String work ="";
	private String health="";
	private String total ="";

	//渡した値を取得している
	public String getMoney() {
		return money;
	}

	//引数として受け取った値をカプセル化した値に代入している
	public void setMoney(String money) {
		this.money = money;
	}

	//渡した値を取得している
	public String getLove() {
		return love;
	}

	//引数として受け取った値をカプセル化した値に代入している
	public void setLove(String love) {
		this.love = love;
	}

	//渡した値を取得している
	public String getWork() {
		return work;
	}

	//引数として受け取った値をカプセル化した値に代入している
	public void setWork(String work) {
		this.work = work;
	}

	//渡した値を取得している
	public String getHealth() {
		return health;
	}

	//引数として受け取った値をカプセル化した値に代入している
	public void setHealth(String health) {
		this.health = health;
	}

	//渡した値を取得している
	public String getTotal() {
		return total;
	}

	//引数として受け取った値をカプセル化した値に代入している
	public void setTotal(String total) {
		this.total = total;
	}






}
