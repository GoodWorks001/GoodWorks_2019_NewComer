package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CategoryServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//CatBaenアレイリスト作成
		ArrayList<CategoryBean> catlist = new ArrayList<CategoryBean>();

		//daoインスタンス作成
		DAO dao = new DAO();
		//dao.cat_getsメソッドを実行し、戻り値をアレイリストに格納
		catlist =  dao.cat_gets();

		//セッション作成
		HttpSession seisson = req.getSession(true);
		//セッションにアレイリストを登録
		seisson.setAttribute("catlist",catlist);

		//遷移先指定
		RequestDispatcher rd = req.getRequestDispatcher("/kensaku_ec.jsp");
		rd.forward(req, resp);
	}
}

