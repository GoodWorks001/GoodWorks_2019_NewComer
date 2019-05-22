package web1;
//JavaBeansの内容の時にやりました。
public class BeanSalary {
	//メインメソッドです。
	public static void main(String[] args) {

		//インスタンス化します。
		Bean high = new Bean();
		//呼び出しをします。
		high.setSalary(1000000);

		//結果を表示します。
        System.out.println(high.getSalary());

	}

}
