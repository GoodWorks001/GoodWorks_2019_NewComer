package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	System.out.println("Cartサーブレットにきたよ");
	HttpSession session = req.getSession(true);

    //商品名を持ってくる
	String name=(String) session.getAttribute("NAME1");
	System.out.println(name);

	//を持ってくる
	int price=(int) session.getAttribute("PRICE");
	System.out.println(price);

	//在庫を持ってくる
	int zaiko=(int) session.getAttribute("ZAIKO");

	//商品コードを持ってくる
    int cd=(int) session.getAttribute("CD");

    //カテゴリーを持ってくる
	String ko=req.getParameter("category");
	int ko1=Integer.parseInt(ko);
	System.out.println(ko1);

//array list 作成
	ArrayList<String> Nlist =new ArrayList<String> ();
	ArrayList<Integer> Klist =new ArrayList<Integer>();
	ArrayList<Integer> KOlist =new ArrayList<Integer>();
	ArrayList<Integer> ZAlist =new ArrayList<Integer>();
	ArrayList<Integer> CDlist =new ArrayList<Integer>();

//セッションがnullな場合なにもしない
if(session.getAttribute("cart")==null) {

}else {
	Nlist=(ArrayList<String>)session.getAttribute("cart");
	Klist=(ArrayList<Integer>)session.getAttribute("cart1");
	KOlist=(ArrayList<Integer>)session.getAttribute("cart2");
	ZAlist=(ArrayList<Integer>)session.getAttribute("cart3");
	CDlist=(ArrayList<Integer>)session.getAttribute("cart4");
}
//リストに追加
ZAlist.add(zaiko);
CDlist.add(cd);
Nlist.add(name);
Klist.add(price);
KOlist.add(ko1);
////確認用
System.out.println("さいずコード"+CDlist.size());
System.out.println("さいずなまえ"+Nlist.size());
System.out.println("さいず価格"+Klist.size());
System.out.println("さいず在庫"+ZAlist.size());
System.out.println("さいず個数"+KOlist.size());
//確認用
for(int i=0;i<Nlist.size();i++) {
	System.out.println("ＣＤネーム"+CDlist.get(i));
	System.out.println("商品名"+Nlist.get(i));
	System.out.println("価格"+Klist.get(i));
	System.out.println("個数"+KOlist.get(i));
	System.out.println("在庫"+ZAlist.get(i));

}


//セッションにそれぞれセット
session.setAttribute("cart", Nlist);
session.setAttribute("cart1", Klist);
session.setAttribute("cart2", KOlist);
session.setAttribute("cart3", ZAlist);
session.setAttribute("cart4", CDlist);

//遷移先指定
RequestDispatcher dis=req.getRequestDispatcher("/Cart.jsp");
dis.forward(req, resp);

}
}
