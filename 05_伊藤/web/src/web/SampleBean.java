package web;
import java.io.Serializable;
public class SampleBean implements Serializable{
	//プロパティの値はカプセル化
	//プロパティ名の先頭は小文字
	//カプセル化
	private int salary =0;
	//値の参照、プロパティ名の先頭は大文字
	//データをsalaryから参照
	public int getSalary () {
		return salary;
	}
	//値の更新、プロパティ名の先頭は大文字
	//データをsalaryに格納
	public void setSalary(int salary) {
		this.salary=salary;

	}

}
