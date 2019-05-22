package web;

public class EmpBean {

	//従業員の氏名、年齢を格納するjavabeansの例

	private String name = null;
	private int age = 0;


	public String getName() {
		return name;
	}

	//受け取った値をnameに代入している
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}




}
