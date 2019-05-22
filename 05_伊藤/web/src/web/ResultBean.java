package web;

public class ResultBean {
	// カプセル化
	private String money = null;
	private String love = null;
	private String work = null;
	private String health = null;
	private String total = null;

	// フィールドのmoneyを取得して返す
	public String getMoney() {
		return money;
	}

	// フィールドのmoneyを設定
	public void setMoney(String money) {
		this.money = money;
	}

	// フィールドのloveを取得して返す
	public String getLove() {
		return love;
	}

	// フィールドのloveを設定
	public void setLove(String love) {
		this.love = love;
	}

	// フィールドのwoekを取得して返す
	public String getWork() {
		return work;
	}

	// フィールドのworkを設定
	public void setWork(String work) {
		this.work = work;
	}

	// フィールドのhealthを取得して返す
	public String getHealth() {
		return health;
	}

	// フィールドのhealthを設定
	public void setHealth(String health) {
		this.health = health;
	}

	// フィールドのtotalを取得して返す
	public String getTotal() {
		return total;
	}

	// フィールドのtotalを設定
	public void setTotal(String total) {
		this.total = total;
	}

}
