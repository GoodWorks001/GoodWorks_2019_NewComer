package web;

public class LogicBean {
	// ResultBeanにexecuteメソッドで定義
	public ResultBean execute(String name, int year, int month, int date) {
		// String型をintに変換
		int len = name.length();
		// 運勢の計算式を格納
		int money = ((len * year * month * date) % 5 + 1);
		int love = ((len + year) * month * date % 5 + 1);
		int work = ((len + year + month) * date % 5 + 1);
		int health = ((len + year + month + date) % 5 + 1);
		int total = ((money + love + work + health) / 4);

		// インスタンス化
		ResultBean bean = new ResultBean();
		// String型の配列で★を格納
		String star[] = { "", "★", "★★", "★★★", "★★★★", "★★★★★" };
		// beanに式の結果を★で格納
		bean.setMoney(star[money]);
		bean.setLove(star[love]);
		bean.setWork(star[work]);
		bean.setHealth(star[health]);
		bean.setTotal(star[total]);
		// beanを返す
		return bean;
	}
}
