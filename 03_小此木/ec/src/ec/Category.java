package ec;

import java.io.Serializable;

public class Category implements Serializable{
	//カテゴリーID
	private int cat_id;
	//カテゴリー名
	private String cat_name;

	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}


}
