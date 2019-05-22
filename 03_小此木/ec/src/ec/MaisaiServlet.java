package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MaisaiServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("MaisaiServlet実行");
		// 取得パラメーターのエンコーディング設定
		req.setCharacterEncoding("UTF-8");
		//セッション取得
		HttpSession ses  =req.getSession(false);
		String user_id = (String)ses.getAttribute("USER");
		System.out.println("user_id:"+user_id);
		//パラメータ取得
		ArrayList<Meisai> mlist = (ArrayList<Meisai>)ses.getAttribute("MEISAI");
		//インスタンス生成
		DAO dao = new DAO();
		//明細アレイリスト
		ArrayList<Product> cart = dao.Meisai(mlist,user_id);
		//遷移先に移動
		ses.setAttribute("CART",cart);
		RequestDispatcher rd = req.getRequestDispatcher("kanryo.jsp");
		rd.forward(req, resp);
		System.out.println("MaisaiServlet終了");

	}

}
