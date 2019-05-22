package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShousaiServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("ShousaiServlet実行");
		// 取得パラメーターのエンコーディング設定
		req.setCharacterEncoding("UTF-8");
		//商品コード取得
		String pro_cd =req.getParameter("pro_cd");
		System.out.println(pro_cd);
		//DAOインスタンス化
		DAO dao = new DAO();
		//インスタンス作成
		Product pro = new Product();
		pro=dao.ProductSyousai(pro_cd);
		//セッション作成
		HttpSession ses =req.getSession(false);
		ses.setAttribute("PRO",pro);
		//遷移先に移動
		RequestDispatcher rd = req.getRequestDispatcher("shousai.jsp");
		rd.forward(req, resp);
		System.out.println("ShousaiServlet終了");

	}

}
