package web;

import java.io.Serializable;

public class userBean implements Serializable{

	//変数定義
    private int id = 0;
    private String name = null;
    private String pass = null;

  //変数idを返すメソッド
	public int getId() {
		return id;
	}
	//引き数として受け取った値をカプセル化した値に代入
	public void setId(int id) {
		this.id = id;
	}

  //変数Unameを返すメソッド
    public String getName() {
		return name;

	}
    //引き数として受け取った値をカプセル化した値に代入
	public void setName(String name) {
		this.name = name;
	}
	//変数Upassを返すメソッド
	public String getPass() {
		return pass;
	}
	//引き数として受け取った値をカプセル化した値に代入
	public void setPass(String pass) {
		this.pass = pass;
	}

}