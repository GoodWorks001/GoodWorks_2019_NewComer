package iyada;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//セッションの設定
		HttpSession ses = req.getSession();
		DAO dao = new DAO();
		//後に条件分岐を行うため特定のコードで初期化
		ses.setAttribute("zyouhou", "true");
		ses.setAttribute("syouhin", "null");
		ses.setAttribute("cart", null);
		//明細のprimarykeyが重複しないように分岐
		if(ses.getAttribute("mei") == null) {
			//
			boolean flg = dao.meisaiNo();
			if(flg) {
				//明細の主キーの最終番号取得メソッド呼び出し
				int mei = dao.getNo();
				//最終番号+1を格納しセッションに保存
				mei += 1;
				ses.setAttribute("mei", mei);
			}else {
				//テーブルに何もない場合は1を返す
				ses.setAttribute("mei", 1);
			}
		//サーバーを落としていない場合はこちら
		}else {
			int meisai = (Integer)ses.getAttribute("mei");
			ses.setAttribute("mei", meisai);
		}


		//遷移するためのテンプレ
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
}
