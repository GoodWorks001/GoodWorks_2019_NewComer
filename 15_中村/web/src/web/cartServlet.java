package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class cartServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		//mineタイプを指定、文字エンコーディングを設定
		resp.setContentType("text/html;charset = UTF-8");
		//セッションの開始
		HttpSession session = req.getSession(true);

//		String name = req.getParameter("name");
//		String p = req.getParameter("price");
//		int price =Integer.parseInt(p);
//		int zaiko = Integer.parseInt(req.getParameter("zaiko"));
//
		ProductBean bean= (ProductBean) session.getAttribute("pro");
		
	    //商品名格納用配列の宣言
		ArrayList<ProductBean> list=new ArrayList<ProductBean>();
		System.out.println("購入個数をint型にしますよ");
		
		//購入数獲得
		String kosu = req.getParameter("zaiko");
		int kosuu = Integer.parseInt(kosu);
		
		System.out.println("購入個数をint型にしましたよ");

		if(session.getAttribute("cart") == null) {

		}else {//2度目以降の商品選択の場合、過去に選択された商品情報の取得
			list=(ArrayList)session.getAttribute("cart");
		}
		
		bean.setKosuu(kosuu);
		//リストに商品情報を格納
		list.add(bean);

		//リストをセッションに保存
		session.setAttribute("cart", list);
		
        //遷移するためのテンプレ
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		//遷移
		rd.forward(req, resp);

  }
}