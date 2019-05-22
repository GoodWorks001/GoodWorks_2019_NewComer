package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SyosaiServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ShyosaiServlet開始");
		req.setCharacterEncoding("UTF-8");

		//送信されたパラメータの取得
		String cart = req.getParameter("cart");
		String back = req.getParameter("back");
		String kosuu =null;

		//配列を作成
		ArrayList<String> names = null;
		ArrayList<String> prices = null;
		ArrayList<Integer> kosuus = null;
		ArrayList<Integer> stocks = null;

		//セッションが開始されてるか確認、されてなかったらnullを出す。
		HttpSession session = req.getSession(false);

		//セッションのnameがヌルだった場合
		if(session.getAttribute("names") ==null) {
			names =new ArrayList<String>();
			prices =new ArrayList<String>();
			kosuus =new ArrayList<Integer>();
			stocks =new ArrayList<Integer>();
		}else {
			names = (ArrayList<String>) session.getAttribute("names");
			prices = (ArrayList<String>) session.getAttribute("prices");
			kosuus = (ArrayList<Integer>) session.getAttribute("kosuus");
			stocks = (ArrayList<Integer>) session.getAttribute("stocks");
		}

		//オブジェクト方のobj変数にitemBeanを格納
		//itemBean型にキャストしている。
		Object obj =session.getAttribute("itemBean");
		itemBean itemBean = (itemBean) obj;

		if(cart != null) {

			names.add(itemBean.getName());
			prices.add(itemBean.getPrice());
			stocks.add(Integer.parseInt(itemBean.getStock()));

			kosuu = req.getParameter("kosuu");
			kosuus.add(Integer.parseInt(kosuu));

			session.setAttribute("names", names);
			session.setAttribute("prices", prices);
			session.setAttribute("kosuus", kosuus);
			session.setAttribute("stocks", stocks);

			//RequestDispatcherを用いて、遷移先を指定している。
			RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
			//RequestDispathaerを用いてふっ飛ばしてる。
			rd.forward(req, resp);
		}else if(back != null) {
			//RequestDispatcherを用いて、遷移先を指定している。
			RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
			//RequestDispathaerを用いてふっ飛ばしてる。
			rd.forward(req, resp);
		}








		System.out.println("ShyosaiServlet終了");
		 }
}
