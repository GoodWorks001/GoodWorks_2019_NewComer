package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CatServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		// エンコーディングとMIMEタイプ設定
		resp.setContentType("text/html ; charset = UTF-8");
		System.out.println("CatServlet実行");
		// TODO 自動生成されたメソッド・スタブ
		// 取得パラメーターのエンコーディング設定
		req.setCharacterEncoding("UTF-8");
		//DAOインスタンス化
		DAO dao = new DAO();
		//セッション作成
		HttpSession ses =req.getSession(false);
		//セッションに保存
		ses.setAttribute("CATLIST",dao.cat());
		//遷移先に移動
		String url = "kensaku.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
		System.out.println("CatServlet終了");


	}

}
