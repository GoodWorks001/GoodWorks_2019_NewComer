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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" SerchServlet開始");
		response.setContentType("text/html;charset=UTF-8");//エンコーディング
		HttpSession session = request.getSession(false);//session継続中

		String cat_na = "";
		String item_na = "";
		//カテゴリの名前か検索欄に入力された名前を取得
		cat_na = request.getParameter("catkensaku");//カテゴリの取得
		item_na = request.getParameter("kensaku");//検索の取得

		System.out.println(cat_na);

		ItemDAO sea_da = new ItemDAO(); //DAOインスタンス化
//		SearchBean sb = new SearchBean();
//		int search_flg = sb.getId();


		//アレイリストの作成
		ArrayList<SearchBean> ItemList = new ArrayList<SearchBean>();

		System.out.println("Searchの if 実行前です。");

		if(item_na == "" & cat_na == "") {
			System.out.println("Searchのif実行。値なし"); //if実行確認
			session.setAttribute("miss", null);
			RequestDispatcher rd = request.getRequestDispatcher("/serch.jsp");
			// RequestDispatcherを用いてrequestとresponseの中身をふっ飛ばしてる。
			rd.forward(request, response);
			System.out.println(" SerchServlet終了");

		} else if(item_na != "" & cat_na == "") {
			session.setAttribute("miss", "○");
			System.out.println("DAO実行 ワード検索");
			ItemList = sea_da.Item(item_na);
			System.out.println("DAO終了");
			System.out.println("Searchのif実行。"); //elseif実行確認
			session.setAttribute("itemlist", ItemList);
			// jspフォルダにあるserch.jspを呼び出す
			RequestDispatcher rd = request.getRequestDispatcher("/serch.jsp");
			// RequestDispatcherを用いてrequestとresponseの中身をふっ飛ばしてる。
			rd.forward(request, response);
			System.out.println(" SerchServlet終了");

		}
		else if(cat_na != "" & item_na == "") {
			//カテゴリー検索
			session.setAttribute("miss", "○");
			System.out.println("DAO実行 カテゴリ");
			ItemList = sea_da.catItem(cat_na);
			System.out.println("DAO終了");
			System.out.println("Searchのelse if実行。"); //elseif実行確認
			session.setAttribute("itemlist", ItemList);
			// jspフォルダにあるserch.jspを呼び出す
			RequestDispatcher rd = request.getRequestDispatcher("/serch.jsp");
			// RequestDispatcherを用いてrequestとresponseの中身をふっ飛ばしてる。
			rd.forward(request, response);
			System.out.println(" SerchServlet終了");
		} else {
			//カテゴリー検索
			System.out.println("DAO実行　カテゴリ2");
			ItemList = sea_da.catItem(cat_na);
			System.out.println("DAO終了");
			System.out.println("Searchのelse実行。"); //else実行確認
			session.setAttribute("itemlist", ItemList);
			// jspフォルダにあるserch.jspを呼び出す
			RequestDispatcher rd = request.getRequestDispatcher("/serch.jsp");
			// RequestDispatcherを用いてrequestとresponseの中身をふっ飛ばしてる。
			rd.forward(request, response);
			System.out.println(" SerchServlet終了");
		}

			System.out.println("if文終了"); //if実行確認


	}

}
