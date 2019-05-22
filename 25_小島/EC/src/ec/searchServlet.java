package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class searchServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


/*		System.out.println("サーチサーブレット開始");
    	//送信されてくるパラメータのエンコーディングの指定
    	req.setCharacterEncoding("UTF-8");

    	String name = req.getParameter("name");
    	String msg = req.getParameter("msg");

    	String search = req.getParameter("search");
    	String category = req.getParameter("category");

    	//コンソールで確認
    	System.out.println(search);
    	System.out.println(category);

   // 	int stock = Integer.parseInt(req.getParameter("stock"));
    //	int preice = Integer.parseInt(req.getParameter("preice"));

    	shoukaidao sd = new shoukaidao();

    	productbean pb = sd.search(name, msg);

    	req.setAttribute("result", pb);




    	RequestDispatcher rd = req.getRequestDispatcher("kensakuresult.jsp");
		rd.forward(req, resp);

	}
*/

System.out.println("サーチサーブレット文");
		// 送信されてくるパラメータのエンコーディングの指定
				req.setCharacterEncoding("UTF-8");
				// 送信されてくるパラメータの取得（文字列)
				String search = req.getParameter("search");// 検索キーワード
				String category = req.getParameter("category");// 検索カテゴリ
				// セッションの継続
				HttpSession session = req.getSession(false);
				if (session != null) {
				} else {
				}

				// 検索ロジックのオブジェクトを生成
				SearchLogic logic = new SearchLogic();
				// 検索の実行
				if (logic.isItem(search, category)) {
					/*
					 * 検索結果があった場合 検索された商品をID:Itemとしてリクエストオブジェクトに格納する その後検索結果表示ページに遷移する
					 */
					System.out.println("aa1");
					session.setAttribute("Item", logic.getItemList());
					System.out.println("aa2");
					System.out.println(logic.getItemList().get(0).getName());

					RequestDispatcher rd = req.getRequestDispatcher("searchresult.jsp");
					System.out.println(rd);
					System.out.println("aa3");
/*					System.out.println(req);
					System.out.println("----------------------");
					System.out.println(resp);
					System.out.println("----------------------");
*/

					rd.forward(req, resp);
					System.out.println("aa4");

					return;
				} else {
					/*
					 * 検索結果が無かった場合、検索結果0件のページに遷移する
					 */
					System.out.println("bb1");
					RequestDispatcher rd = req.getRequestDispatcher("NotItemSearchJsp.jsp");
					System.out.println(rd);
					System.out.println("bb2");
					rd.forward(req, resp);
					System.out.println("bb3");
					return;
				}

			}



	}

