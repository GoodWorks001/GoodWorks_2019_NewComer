package web;

import java.io.Serializable;

public class CategoryBean implements Serializable {

	/*private int cat_id;
	private String cat_name;

	public int getId() {
		return cat_id;
	}
	public void setId(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getName() {
		return cat_name;
	}
	public void setName(String cat_name) {
		this.cat_name = cat_name;
	}*/

	private int id;
	private String name;

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


}
