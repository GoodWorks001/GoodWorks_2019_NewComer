package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SearchServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.setCharacterEncoding("UTF-8");

		String search = req.getParameter("search");
		String category = req.getParameter("category");
		int cate = Integer.parseInt(category);
		System.out.println("search :" + search);
		System.out.println("cate :" + cate);
		//セッションの継続
		HttpSession session = req.getSession(false);
		if(session != null) {
		}else {}

		//DAOのオブジェクト生成
		SearchDAO sd = new SearchDAO();
		ArrayList<String> alist = new ArrayList<String>();
		if(cate == 0 && sd.boolKeyword(search)) {
			System.out.println("search開始");
			//リストを取得
			alist = sd.checkKeyword(search);

			///name"search"でalistをsessionに渡す
			session.setAttribute("search", alist);

			//飛ぶ
			RequestDispatcher rd = req.getRequestDispatcher("/searchResult.jsp");
			rd.forward(req, resp);
		}else if(cate != 0){
			System.out.println("cate開始");
			//リストを取得
			alist = sd.checkCategory(category);

			//name"search"でalistをsessionに渡す
			session.setAttribute("search", alist);

			//飛ぶ
			RequestDispatcher rd = req.getRequestDispatcher("/searchResult.jsp");
			rd.forward(req, resp);
		}else if(!(sd.boolKeyword(search))) {
			System.out.println("何もないよ");
			//飛ぶ
			RequestDispatcher rd = req.getRequestDispatcher("/notItemSearch.jsp");
			rd.forward(req, resp);
		}

//		//name"search"でalistをsessionに渡す
//		session.setAttribute("search", alist);
//
//		//飛ぶ
//		RequestDispatcher rd = req.getRequestDispatcher("/searchResult.jsp");
//		rd.forward(req, resp);


	}

}
