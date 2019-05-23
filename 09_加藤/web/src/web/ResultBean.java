package web;

import java.io.Serializable;

public class ResultBean implements Serializable{

	//カプセル化
	//変数の初期値設定
	private String money = "";
	private String love = "";
	private String work = "";
	private String health = "";
	private String total = "";

	//カプセル化した変数を返す
	public String getMoney() {
		return money;
	}
	//引数として受けとった値をカプセル化した変数に代入する
	public void setMoney(String money) {
		this.money = money;
	}
	//カプセル化した変数を返す
	public String getLove() {
		return love;
	}
	//引数として受けとった値をカプセル化した変数に代入する
	public void setLove(String love) {
		this.love = love;
	}
	//カプセル化した変数を返す
	public String getWork() {
		return work;
	}
	//引数として受けとった値をカプセル化した変数に代入する
	public void setWork(String work) {
		this.work = work;
	}
	//カプセル化した変数を返す
	public String getHealth() {
		return health;
	}
	//引数として受けとった値をカプセル化した変数に代入する
	public void setHealth(String health) {
		this.health = health;
	}
	//カプセル化した変数を返す
	public String getTotal() {
		return total;
	}
	//引数として受けとった値をカプセル化した変数に代入する
	public void setTotal(String total) {
		this.total = total;
	}
}
