package web;

import java.io.Serializable;

public class SampleBean implements Serializable{

	//初期値代入
	//カプセル化
	private int salary = 0;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
