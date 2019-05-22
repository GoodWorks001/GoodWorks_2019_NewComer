package web;

public class Main {

	public static void main(String[] args) {

		//インスタンス化
		SampleBean s = new SampleBean();
		//セットメソッド呼び出し値１を渡す
		s.setSalary(1);
		//ゲットメソッドの値を印刷する
		System.out.println(s.getSalary());

	}

}
