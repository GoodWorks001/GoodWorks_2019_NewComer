package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShousaiServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("サーブレット開始");

		//送信されてくるパラメータのエンコーディング指定
		req.setCharacterEncoding("UTF-8");
		//セッションが継続しているため、値はfalse
		HttpSession session = req.getSession(false);
		//詳細ボタンのパラメータ名を取得する
		String shousai = req.getParameter("shousai");

		resp.setContentType("text/html;charset=UTF-8");
		//daoインスタンス作成
		DAO dao = new DAO();

		//ArrayListをインスタンス化
		ArrayList<ProductBean> clist = new ArrayList<ProductBean>();
		//dao.Shousai()メソッドを実行し、戻り値をアレイリストに格納する
		clist = dao.Shousai(shousai);
		//セッションにアレイリストを登録
		session.setAttribute("clist", clist);
		//遷移先を指定
		RequestDispatcher rd = req.getRequestDispatcher("/shoukai.jsp");
		rd.forward(req, resp);

		System.out.println("サーブレット終了");
	}
}
