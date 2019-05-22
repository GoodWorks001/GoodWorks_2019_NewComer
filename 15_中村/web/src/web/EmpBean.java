package web;

public class EmpBean {

	private String name = null;
	private int age =0;

	//
	public int getAge() {
		return age;
	}
	//引く数として受け取った値をカプセル化した値に代入
	public void setAge(int age) {
		this.age=age;
	}
	//
	public String getName() {
		return name;
	}
	
	//引く数として受け取った値をカプセル化した値に代入
	public void setName(String name) {
	//	
	this.name = name;
	}
}
