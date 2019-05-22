package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class kounyuuServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ


		HttpSession ses = req.getSession(false);

		ArrayList<ProductBean> array = (ArrayList<ProductBean>)ses.getAttribute("cart");

		//web上の表示設定をUTF-8に設定
		req.setCharacterEncoding("UTF-8");

		kounyuuDAO DAO =new kounyuuDAO();

		userBean u = (userBean)ses.getAttribute("login_cd");
		int user_id = u.getId();

		for(int i=0;i<array.size();i++) {
			//カートのリストから商品情報を取り出す
			ProductBean pb = array.get(i);//何番目のやつを取り出す
			int pro_id = pb.getCd();//商品コード持ってくる
			int price =pb.getPrice();//単価を持ってくる
			int kosuu = pb.getBuy();//買った数を持ってくる


			DAO.insert(pro_id, user_id, kosuu, price);//インサート

			DAO.update(kosuu, pro_id);//在庫のアップデート

		}

		ses.removeAttribute("cart");//カーとのセッションを破棄する

		RequestDispatcher rd = req.getRequestDispatcher("/kanryou.jsp");
		rd.forward(req, resp);
	}

}
