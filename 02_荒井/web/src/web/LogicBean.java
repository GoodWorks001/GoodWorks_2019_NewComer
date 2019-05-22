package web;

import java.io.Serializable;

public class LogicBean implements Serializable{

	public  ResultBean execute(String name,int year, int month, int date) {
       int len = name.length();     //名前の文字数取得
       int money = (len * year * month * date) % 5 + 1;    //値をmoneyに代入
       System.out.println(money);
       int love = (len * year )* month * date % 5 + 1;     //値をloveに代入
       System.out.println(love);
       int work = (len * year * month) * date % 5 + 1;     //値をworkに代入
       System.out.println(work);
       int health = len * year * month * date % 5 + 1;      //値をhelthに代入
       System.out.println(len);
       int total = (int)(money * love * work * health) * 4;     //上記4つの平均値を全体運に代入
       System.out.println(total);


      ResultBean res = new ResultBean();   //ResultBeanクラスをインスタンス化


      String star[] = {" ", "★","★★","★★★","★★★★","★★★★★"};      //配列に星を格納
      res.setMoney(star[money]);       //格納された数の★を表示 setMoney()メソッドで格納
      res.setLove(star[love]);         //格納された数の★を表示 setLove()メソッドで格納
      res.setWork(star[work]);         //格納された数の★を表示 setWork()メソッドで格納
      res.setHealth(star[health]);     //格納された数の★を表示 setHealth()メソッドで格納
      res.setTotal(star[total]);       //格納された数の★を表示 setTotal()メソッドで格納



      	System.out.println("executio終了");
         return res;    //インスタンスをreturnで戻り値に指定
	}

}
