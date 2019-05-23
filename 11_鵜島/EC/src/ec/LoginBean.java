package ec;

import java.io.Serializable;

public class LoginBean implements Serializable{
	private boolean cheak;

	private String cat_name;

	private String userID;
	private String userName;
	private String userCode;
	private String loginPassword;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public boolean isCheak() {
		return cheak;
	}

	public void setCheak(boolean cheak) {
		this.cheak = cheak;
	}

}
