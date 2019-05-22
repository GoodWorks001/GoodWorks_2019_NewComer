package web;

import java.io.Serializable;

public class LogicBean implements Serializable{

 public ResultBean excute(String name,int year,int month,int date) {

	 //配列に格納
	 String [] star ={"","★","★★","★★★","★★★★","★★★★★"};


	 //引数nameの文字数を取得し、変数に格納する
	 int len = name.length();
	 //変数に式の答えを代入している
	 int mo = len * year * month * date%5+1;
	 int lo =  (len + year) * month * date%5+1;
	 int wo= (len + year + month) * date%5+1;
     int he= (len + year + month + date)%5+1;
     int to = (int)(mo + lo + wo + he)/4;

     //確認用
     System.out.println(mo);
     System.out.println(lo);
     System.out.println(wo);
     System.out.println(he);
     System.out.println(to);


    //インスタンス化
	 ResultBean result = new ResultBean();


	 result.setMoney(star[mo]);
	 result.setLove(star[lo]);
     result.setWork(star[wo]);
     result.setHealth(star[he]);
     result.setTotal(star[to]);



	 return result;




 }



}
