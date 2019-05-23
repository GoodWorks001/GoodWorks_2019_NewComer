package Search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("サーチservlet開始");

		req.setCharacterEncoding("UTF-8");

		//JDBCインスタンス化
		JDBC jdc=new JDBC();
		//dao.cat_getsメソッドを実行し、戻り値をアレイリストに格納
		ArrayList<CtBean> catlist = jdc.cat_gets();
		//セッション作成
		HttpSession session = req.getSession(true);
		////セッションにアレイリストを登録
		session.setAttribute("CATLIST",catlist);



		//遷移先指定
		RequestDispatcher rd = req.getRequestDispatcher("/Search.jsp");
		rd.forward(req, resp);
		System.out.println("サーチservlet終了");

		}
}
