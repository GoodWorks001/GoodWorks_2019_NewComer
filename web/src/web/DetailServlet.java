package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DetailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		//セッションの開始
		HttpSession session= req.getSession() ;
		//インスタンス化
		syousaiDao dao = new syousaiDao();
		//送信されたパラメータの取得
		String ID = req.getParameter("ID");

		//商品検索メソッドの呼び出し
       ProductBean pro = dao.syouhin(ID);
       
       //在庫数を変数に格納
       int zaiko=pro.getStock_no();

       //セッションに商品情報と在庫を格納
       session.setAttribute("pro", pro);
       session.setAttribute("zaiko", zaiko);
       
       //遷移する
       RequestDispatcher rd = req.getRequestDispatcher("detail.jsp");
       rd.forward(req, resp);
	}
}
