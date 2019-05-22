package web;

import java.io.Serializable;

public class SampleBean implements Serializable{


	//プロパティに対応するフィールドを定義しておく
	private int salary = 0;

	//これを定義したら右クリック→ソース→getter,setterメソッドを押す
	//押したらアクセサメソッドが自動で出てくる


	//↓アクセサメソッド


	//メソッド名は「get+プロパティ名」
	//プロパティの先頭は大文字で記述
	//引数は指定しなくて良い
	//戻り値はプロパティのデータ型
	public int getSalary() {      //getメソッド
		return salary;
	}



	//メソッド名は「set+プロパティ名」
	//プロパティ名の先頭は大文字で記述
	//引数はプロパティのデータ型
	//戻り値はvoid型
	public void setSalary(int salary) {    //setメソッド
		this.salary = salary;
	}


}
