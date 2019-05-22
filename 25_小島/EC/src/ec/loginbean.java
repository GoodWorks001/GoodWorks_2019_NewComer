package ec;

import java.io.Serializable;

public class loginbean implements Serializable {

	private int id;
	private String name = "";
	private String password = "";

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return password;
	}
	public void setPass(String pass) {
		this.password = pass;
	}
}






