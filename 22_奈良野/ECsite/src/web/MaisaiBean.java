package web;

import java.sql.Date;

public class MaisaiBean {

	public class MeisaiBean {

		//明細ID
		int mei_id;
		//ユーザID
		int user_id;
		//商品コード
		int pro_cd;
		//購入日時
		String ko_date;
		//購入総額
		int mei_price;
		Date date;

		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public int getMei_id() {
			return mei_id;
		}
		public void setMei_id(int mei_id) {
			this.mei_id = mei_id;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public int getPro_cd() {
			return pro_cd;
		}
		public void setPro_cd(int pro_cd) {
			this.pro_cd = pro_cd;
		}
		public String getKo_date() {
			return ko_date;
		}
		public void setKo_date(String ko_date) {
			this.ko_date = ko_date;
		}
		public int getMei_price() {
			return mei_price;
		}
		public void setMei_price(int mei_price) {
			this.mei_price = mei_price;
		}

	}
}
