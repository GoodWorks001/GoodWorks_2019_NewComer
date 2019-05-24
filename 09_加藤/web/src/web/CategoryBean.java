package web;

import java.io.Serializable;

public class CategoryBean implements Serializable{

	private String catename;	//カテゴリ名
	private int cateid;		//カテゴリ番号


	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
}
