package web;

public class SampleBeanMain {

	public static void main(String[] args) {
		//インスタンス化
		SampleBean sly=new SampleBean();
		//メソッド呼び出し
		sly.setSalary(100);
		System.out.println(sly.getSalary());
	}

}
