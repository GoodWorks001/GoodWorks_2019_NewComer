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


		System.out.println("cartServlet実行しました。");


		//送信されてくるパラメーターのエンコード指定
		req.setCharacterEncoding("UTF-8");


		 //セッションの指定
		 HttpSession ses = req.getSession(false);


		 //カートを取得
		 ArrayList<ProductBean> array = (ArrayList<ProductBean>)ses.getAttribute("cart");


		 //個数を指定
		 int count = Integer.parseInt(req.getParameter("kosu"));
		 System.out.println("個数" + count);



         //shouhinをproに代入
		 ProductBean pro = (ProductBean)ses.getAttribute("shouhin");
		 System.out.println(pro);





		 //個数を指定
		 pro.setBuy(count);



		 //カートのリストを作ってなかったら作る
		 if(array == null) {
			 array = new ArrayList<ProductBean>();
		 }


		 //商品のインスタンスをリストに追加
		 array.add(pro);



		 ses.setAttribute("cart",array);



		 //kensaku.jspに飛ばす
		 RequestDispatcher rd = req.getRequestDispatcher("/cart.jsp");
		 rd.forward(req, resp);

	}

}
