package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LastServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");


		// セッションの継続
		HttpSession session = req.getSession(false);

		//インスタンス化
		LastDAO ldao = new LastDAO();


		ArrayList<ProductBean> cList = (ArrayList<ProductBean>)session.getAttribute("scart");

		//ログインID（=ユーザーID）を受け取る
		//String型の変数にlogin_idの値を格納する
		String a =(String)session.getAttribute("login_id");
        //aをint型にして格納する
		int id = Integer.parseInt(a);

		//カートのリストから商品情報を取り出す
		for(int i=0; i<cList.size();i++) {
			ProductBean pbean = cList.get(i); //i番目の値を取り出す
			int pro_cd = pbean.getPro_cd();
			int price = pbean.getPro_price();
			int buy = pbean.getBuy();

			//インサート
			ldao.insert(pro_cd, id, price ,buy);

			//アップデート
			ldao.update(buy, pro_cd);
		}

		   //カートのセッション変数を破棄する
            session.removeAttribute("scart");

          //遷移先指定
		RequestDispatcher rd = req.getRequestDispatcher("kanryou.jsp");
		rd.forward(req, resp);

	}

}
