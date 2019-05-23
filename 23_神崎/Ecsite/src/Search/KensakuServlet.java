package Search;

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

		req.setCharacterEncoding("UTF-8");
		//検索
		HttpSession session = req.getSession(false);

		String kensaku = req.getParameter("kensaku");

		String cat = req.getParameter("cat");

		JDBC jd = new JDBC();
		//アレイリストインスタンス化
		ArrayList<ProductBean> prolist = new ArrayList<ProductBean>();


		if (cat.equals("")&& !kensaku.equals("")){
			System.out.println("入力検索実行");
			prolist = jd.Pro_gets(kensaku);
			HttpSession ses = req.getSession(true);
			ses.setAttribute("PROLIST", prolist);
		} else if((!cat.equals("") && kensaku.equals("")) || (!cat.equals("") && !kensaku.equals(""))){
			System.out.println("カテゴリー検索実行");
			prolist = jd.cat_gets(cat);
			HttpSession ses = req.getSession(true);
			ses.setAttribute("PROLIST", prolist);
		}else {
			HttpSession ses = req.getSession(true);
			ses.setAttribute("PROLIST", prolist);
		}
		//遷移先に移動
		RequestDispatcher rd = req.getRequestDispatcher("/Search.jsp");
		rd.forward(req, resp);
		System.out.println("検索servlet終了");

	}

}
