package web;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");

		// 送信されてくるパラメータの取得（文字列)

		String search = req.getParameter("name");// 検索キーワード

		System.out.println(search);


		String category = req.getParameter("aaaa");// 検索カテゴリ

		System.out.println(category);

        //インスタンス化
		DAO2 logic = new DAO2();

		//ArrayListの作成
		ArrayList<ProductBean> itemList =new ArrayList<ProductBean>();

        //検索
		if (search!=null&&	!(search.equals(""))) {
			itemList =  logic.isItem(search);

		}else if(category!=null && !(category.equals(""))){
			itemList = logic.Pro_Cat(category);
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("/Category");
		rd.forward(req, resp);
		}




		// セッションの継続
		HttpSession session = req.getSession(true);

		System.out.println("セッション");

		session.setAttribute("Item",itemList);

		System.out.println("Item :"+itemList.get(0));



		RequestDispatcher rd = req.getRequestDispatcher("searchresurt.jsp");
		rd.forward(req, resp);


		System.out.println("ここまで");


	}

}