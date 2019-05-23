package web;

import java.io.Serializable;

public class LoginUserBean implements Serializable {

	static final long serialVersionUID =1L;
     private int id;
     private String name=null;
     private String cd=null;
     private String pass=null;


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
 	public String getCd() {
 		return cd;
 	}
 	public void setCd(String cd) {
 		this.cd = cd;
 	}
 	public String getPass() {
 		return pass;
 	}
 	public void setPass(String pass) {
 		this.pass = pass;
 	}

}
