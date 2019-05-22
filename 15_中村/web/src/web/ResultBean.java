package web;

import java.io.Serializable;

public class ResultBean implements Serializable{

	//データを保存する変数を宣言する
	private String money =null;
	private String love =null;
	private String work =null;
	private String health =null;
	private String total =null;
	
	//変数を返すメソッドを宣言<jsp:getproperty>を使い呼び出せる
	public String getMoney() {
		return money;
	}
	//変数を返すメソッドを宣言<jsp:getproperty>を使い呼び出せる
	public String getLove() {
		return love;
	}
	//変数を返すメソッドを宣言<jsp:getproperty>を使い呼び出せる
	public String getWork() {
		return work;
	}
	//変数を返すメソッドを宣言<jsp:getproperty>を使い呼び出せる
	public String getHealth() {
		return health;
	}
	//変数を返すメソッドを宣言<jsp:getproperty>を使い呼び出せる
	public String getTotal() {
		return total;
	}

	//引数として受けとった値moneyをカプセル化した値に代入
	public void setMoney(String money) {
		this.money=money;
	}
	//引数として受けとった値loveをカプセル化した値に代入
	public void setLove(String love) {
		this.love=love;
	}
	//引数として受けとった値workをカプセル化した値に代入
	public void setWork(String work) {
		this.work=work;
	}
	//引数として受けとった値healthをカプセル化した値に代入
	public void setHealth(String health) {
		this.health=health;
	}
	//引数として受けとった値totalをカプセル化した値に代入
	public void setTotal(String total) {
		this.total=total;
	}
}
