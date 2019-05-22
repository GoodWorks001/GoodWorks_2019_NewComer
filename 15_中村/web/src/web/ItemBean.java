package web;

import java.io.Serializable;

public class ItemBean implements Serializable {
/*
	private int pro_cd=0;
    private String pro_name=null;
    private int stock_no=0;
    private int pro_price=0;
    private int cat_id=0;
    private String pro_img=null;
    private String pro_msg=null;
*/
	    static final long serialVersionUID = 2L;
	    private int pro_cd;
	    private String pro_name;
	    private int stock_no;
	    private int pro_price;
	    private int cat_id;
	    private String pro_img;
	    private String pro_msg;
	    private String category;

	    public ItemBean() {/*
	    	this.pro_cd = 0;
	        this.pro_name= "";
	        this.stock_no = 0;
	        this.pro_price = 0;
	        this.cat_id = 0;
	        this.pro_img = "";
	        this.pro_msg = "";
	    */}

	    public ItemBean(int pro_cd,String pro_name, int stock_no, int pro_price, int cat_id, String pro_img, String pro_msg, String category ) {

	    	setpro_cd(pro_cd);
	    	setpro_name(pro_name);
	    	setstock_no(stock_no);
	    	setpro_price(pro_price);
	    	setcat_id(cat_id);
	    	setpro_img(pro_img);
	    	setpro_msg(pro_msg);
	    	setCategory(category);
	    }
	    public int getpro_cd() {
	        return pro_cd;
	    }

	    public void setpro_cd(int pro_cd) {
	    	this.pro_cd= pro_cd;
	    }

	    public String getpro_name() {
	        return pro_name;
	    }

	    public void setpro_name(String pro_name) {
	    	this.pro_name = pro_name;
	    }

	    public int getstock_no() {
	        return stock_no;
	    }


	    public void setstock_no(int stock_no) {
	    	this.stock_no = stock_no;
	    }

	    public int getpro_price() {
	        return pro_price;
	    }

	    public void setpro_price(int pro_price) {
	        this.pro_price= pro_price;
	    }

	    public int getcat_id() {
	        return cat_id;
	    }

	    public void setcat_id(int cat_id) {
	        this.cat_id= cat_id;
	    }

	    public String getpro_img() {
	        return pro_img;
	    }

	    public void setpro_img(String pro_img) {
	        this.pro_img= pro_img;
	    }

	    public String getpro_msg() {
	        return pro_msg;
	    }

	    public void setpro_msg(String pro_msg) {
	        this.pro_msg= pro_msg;
	    }


		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
	}




