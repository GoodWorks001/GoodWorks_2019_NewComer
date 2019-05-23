package web;

import java.io.Serializable;

public class LogicBean implements Serializable{

	public ResultBean execute(String name, int year, int month, int date) {
		//文字列型で5段階の★をそれぞれ格納する
		String kekka[] = {"★", "★★", "★★★", "★★★★", "★★★★★"};

		int len = name.length();
		//金運の時の表示結果を代入する
		int kinun = (len*year*month*date)%5;
		//恋愛運の時の表示結果を代入する
		int renaiun = ((len+year)*month*date)%5;
		//仕事運の時の表示結果を代入する
		int sigotoun = ((len+year+month)*date)%5;
		//健康運の時の表示結果を代入する
		int kenkoun = (len+year+month+date)%5;
		//全体運の時の表示結果を代入する
		int zentaiun = (kinun+renaiun+sigotoun+kenkoun)/4;

		//ResultBeanをインスタンス化
		ResultBean rb = new ResultBean();

		//金運の配列をメソッドで呼び出す
		rb.setMoney(kekka[kinun]);
		//恋愛運の配列をメソッドで呼び出す
		rb.setLove(kekka[renaiun]);
		//仕事運の配列をメソッドで呼び出す
		rb.setWork(kekka[sigotoun]);
		//健康運の配列をメソッドで呼び出す
		rb.setHealth(kekka[kenkoun]);
		//全体運の配列をメソッドで呼び出す
		rb.setTotal(kekka[zentaiun]);

		return rb;
	}
}
