package web;

public class LoginBean {
	// カプセル化
	private int user_id = 0;
	private String name = null;
	private String pw = null;

	// フィールドのnameを取得して返す
	public String getName() {
		return name;
	}

	// フィールドのnameを設定
	public void setName(String name) {
		this.name = name;
	}

	// フィールドのpwを取得して返す
	public String getPw() {
		return pw;
	}

	// フィールドのpwを設定
	public void setPw(String pw) {
		this.pw = pw;
	}
	// フィールドのuser_idを取得して返す
	public int getUser_id() {
		return user_id;
	}
	// フィールドのuser_idを設定
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
