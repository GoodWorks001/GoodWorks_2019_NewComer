package Meisai;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Search.ProductBean;

public class MeisaiServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//エンコード設定
		req.setCharacterEncoding("UTF-8");
		System.out.println("明細開始");
		//セッションの取得
		HttpSession ses = req.getSession(true);

		int user_id = (Integer) ses.getAttribute("user");
		//明細アレイリスト
		ArrayList<MeisaiBean> meisai = (ArrayList<MeisaiBean>) ses.getAttribute("MEISAI");
		//インスタンス化
		MeisaiJDBC MeJd = new MeisaiJDBC();
		MeJd.Meisai(meisai, user_id);
		//アレイリストインスタンス化
		ArrayList<ProductBean> Cart = new ArrayList<ProductBean>();
		ses.setAttribute("CART", Cart);
		//遷移先に移動
		RequestDispatcher rd = req.getRequestDispatcher("/Kanryou.jsp");
		rd.forward(req, resp);

	}

}
