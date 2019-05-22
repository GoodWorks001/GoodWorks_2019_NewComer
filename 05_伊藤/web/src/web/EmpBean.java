package web;

public class EmpBean {
	//カプセル化
	private String name = null;
	//カプセル化
	private int age = 0;
	//フィールドのageを取得して返す
	public int getAge() {
		return age;
	}
	//フィールドのageを設定
	public void setAge(int age) {
		this.age = age;
	}
	//フィールドのnameを取得して返す
	public String getName() {
		return name;
	}
	//フィールドのnameを設定
	public void setName(String name) {
		this.name = name;
	}
}
