package web;

public class SampleBeanMain {

	public static void main(String[] args) {

		//SampleBeanクラスをインスタンス化
		SampleBean sam = new SampleBean();
		//120000という値をセットする

		sam.setSalary(120000);

		//値の取得
		System.out.println(sam.getSalary());

	}

}
