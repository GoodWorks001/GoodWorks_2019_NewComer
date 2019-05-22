package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class shoukaiServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("紹介サーブレット開始");
		HttpSession ses = req.getSession();

		//送信されてくるパラメータのエンコーディングの指定
    	req.setCharacterEncoding("UTF-8");
    	String name = req.getParameter("name");


    	//前のjsp(shoukai2)から取ってきた情報をint型でに変換
    	String order = req.getParameter("order");
    	int order1 =Integer.parseInt(order);

    	//商品コード
    	String cd = req.getParameter("cd");
    	System.out.println(cd);
    	int cd1 =Integer.parseInt(cd);
    	String stock = req.getParameter("stock");
    	int stock1 =Integer.parseInt(stock);
    	String price = req.getParameter("price");
    	int prece1 =Integer.parseInt(price);

    	//インスタンス化
    	ItemBean ib =new ItemBean();
    	//取ってきた情報をセット
    	ib.setName(name);
    	ib.setCd(cd1);
    	ib.setStock(stock1);
    	ib.setPrice(prece1);
    	ib.setOrder(order1);
    	ArrayList<ItemBean> list = new ArrayList<>();

    	//カートの中身が空だったら
    	if(ses.getAttribute("cart") == null) {
    		//何もしない
    	}else {
    		//あったらlistの中に入れる
    	     list = (ArrayList<ItemBean>) ses.getAttribute("cart");

    	}

    	//listの中に加える
    	list.add(ib);
    	//listの中身をカートのなかに入れる
    	ses.setAttribute("cart", list);


    	//カート画面に遷移
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		rd.forward(req, resp);


	}
	}


