package ec;

import java.io.Serializable;

public class categoryBean implements Serializable {

	String catName;
	int catID;

	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public int getCatID() {
		return catID;
	}
	public void setCatID(int catID) {
		this.catID = catID;
	}

}
