package web;

public class LoginBean {

	//購入者の氏名、パスワードを格納するjavabeansの例
	private String name = null;
	private String passward = null;


	public String getName() {
		return name;
	}


	//受け取った値をnameに代入している
	public void setName(String name) {
		this.name = name;
	}


	public String getPassward() {
		return passward;
	}


	//受け取った値をpasswardに代入している
	public void setPassward(String passward) {
		this.passward = passward;
	}

}
