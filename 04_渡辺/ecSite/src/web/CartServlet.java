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

		System.out.println("開始");

		//文字コードの設定
		req.setCharacterEncoding("UTF-8");

		//セッションの取得
		HttpSession ses = req.getSession(false);

		//セッションが取得されているか判定
		if(ses == null) {
			System.out.println("セッションがありません");
			//セッションがなかったらログイン画面に遷移
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}else {

			//セッションに保存したカートのリストを取得
			ArrayList<ProductBean> cList = (ArrayList<ProductBean>)ses.getAttribute("cart");

			//個数取得
			int count = Integer.parseInt(req.getParameter("count"));

			//セッションから商品の情報を取得
			ProductBean p = (ProductBean)ses.getAttribute("pro");

			//個数を設定
			p.setCount(count);

			//カートのリストを作ってなかったら作る
			if(cList == null) {
				cList = new ArrayList<ProductBean>();
			}

			//商品のインスタンスをリストに追加
			cList.add(p);

			//セッションにリストを再びセット
			ses.setAttribute("cart", cList);


			//遷移先を指定
			RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
			//遷移実行
			rd.forward(req, resp);

		}
	}
}
