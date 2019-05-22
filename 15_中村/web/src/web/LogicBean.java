package web;

import java.io.Serializable;

public class LogicBean implements Serializable{

	
	String[] star= {"","★","★★","★★★","★★★★","★★★★★"};
	
	//name,year,month,dateを使えるようにする
	public ResultBean execute(String name,int year,int month,int date) {
	
	//	
	int len = name.length();
	//moneyを定義
	int money =(len*year*month*date)%5+1;
	//loveを定義
	int love =(len+year)*month*date%5+1;
	//workを定義
	int work= (len+year+month)*date%5+1;
	//healthを定義
	int health=(len+year+month+date)%5+1;
	//totalを定義
	int total = (money+love+work+health)%4;

	//インスタンス化
	ResultBean bean=new ResultBean();
	//対応する配列番号を表す
    bean.setMoney(star[money]);
    bean.setLove(star[love]);
    bean.setWork(star[work]);
    bean.setHealth(star[health]);
    bean.setTotal(star[total]);
    //beanに値を返す
    return bean;
	}
}
