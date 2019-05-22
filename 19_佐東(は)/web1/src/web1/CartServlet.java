package web1;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("カートサーブレット開始しまーーす！");

		req.setCharacterEncoding("UTF-8");
		String stk = req.getParameter("stock");
		System.out.println(stk);
		int t_kazu = Integer.parseInt(stk);
		ProBean pro = new ProBean();
		HttpSession ses = req.getSession(true);
		pro = (ProBean)ses.getAttribute("pro");
		pro.setT_kazu(t_kazu);
		//カートアレイリストの作成および、内容追加
				if(ses.getAttribute("cart") == null) {
					System.out.println("カートアレイリスト作成");
					ArrayList<ProBean> cart = new ArrayList<ProBean>();
					//カートアレイリストにインスタンス追加
					cart.add(pro);
					//セッションにカートアレイリストをセット
					ses.setAttribute("cart",cart);

				}else{
					//カートアレイリストをセッションから取得
					ses.getAttribute("cart");
					//カートアレイリストにインスタンス追加 　左側と同じパターンに変更する　オブジェクト型→ArrayList<ProBean>
					ArrayList<ProBean> cart = (ArrayList<ProBean>)ses.getAttribute("cart");
					cart.add(pro);
					//セッションにカートアレイリストをセット
					ses.setAttribute("cart", cart);
				}

		RequestDispatcher rd = req.getRequestDispatcher("Cart.jsp");
		rd.forward(req, resp);
		System.out.println("カートサーブレット終わりーーー！");


}
}
