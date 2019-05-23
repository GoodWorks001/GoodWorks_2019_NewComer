package web;

import java.io.Serializable;

public class CartBean implements Serializable{
	private String pname;		//商品名
	private int pzaiko;		//在庫数
	private int pprice;		//価格
	private int kazu;			//個数

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
	private String msg;			//メッセージ

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getKazu() {
		return kazu;
	}
	public void setKazu(int kazu) {
		this.kazu = kazu;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPzaiko() {
		return pzaiko;
	}
	public void setPzaiko(int pzaiko) {
		this.pzaiko = pzaiko;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}


}
