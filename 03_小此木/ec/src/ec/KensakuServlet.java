package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KensakuServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("KensakuServlet実行");
		// 取得パラメーターのエンコーディング設定
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html ; charset = UTF-8");
		//カテゴリー取得
		String category =req.getParameter("category");
		//検索内容取得
		String kensaku = req.getParameter("kensaku");
		//DAOインスタンス化
		DAO dao = new DAO();
		//アレイリスト作成
		ArrayList<Product> plist = new ArrayList<Product>();
		//遷移先url
		if(category=="" && kensaku!="") {
			plist=dao.ProductMain(kensaku);
		}else if(category!="" && kensaku!="") {
			plist=dao.ProductCatMain(kensaku,category);
		}else if(category!="" && kensaku=="") {
			plist = dao.CatMain(category);
		}
		//セッション作成
		System.out.println(plist.size());
		HttpSession ses =req.getSession(false);
		ses.setAttribute("PLISIT",plist);
		//遷移先に移動
		RequestDispatcher rd = req.getRequestDispatcher("kensakus.jsp");
		rd.forward(req, resp);
		System.out.println("KensakuServlet終了");

	}

}
