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
		System.out.println("SearchServlet開始");
		//文字コードをUTF-8に設定
		req.setCharacterEncoding("UTF-8");

		//前のとこから持ってきて変数に入れてる
		String key = req.getParameter("kensaku");
		String cate = req.getParameter("category");
		String syosaiPass= req.getParameter("syosai");
		System.out.println("詳細中身" + syosaiPass);

		//詳細の中身が空じゃなかったら
		if(syosaiPass != null) {
			syoDAO sdao = new syoDAO();

			//指定した商品の情報を取り出す
			String id =sdao.SearchObj(syosaiPass,"pro_cd");
			String name =sdao.SearchObj(syosaiPass,"pro_name");
			String stock =sdao.SearchObj(syosaiPass,"stock_no");
			String price =sdao.SearchObj(syosaiPass,"pro_price");
			String img =sdao.SearchObj(syosaiPass,"pro_img");
			String msg =sdao.SearchObj(syosaiPass,"pro_msg");
			String cat_id =sdao.SearchObj(syosaiPass,"cat_id");

			//cat_nameにsyoDAOのSearchObjメソッドからcat_idを引数に代入する
			String cat_name = sdao.Catemote(cat_id);

			//リクエストに値をセットする
			req.setAttribute("id", id);
			req.setAttribute("name", name);
			req.setAttribute("stock", stock);
			req.setAttribute("price", price);
			req.setAttribute("cat_name", cat_name);
			req.setAttribute("img", img);
			req.setAttribute("msg", msg);

			//確かめる用
			System.out.println(id);
			System.out.println(name);
			System.out.println(stock);
			System.out.println(price);
			System.out.println(cat_name);
			System.out.println(img);
			System.out.println(msg);

			//itemBeanのインスタンス化
			itemBean ib = new itemBean();


			ib.setName(name);
			ib.setPrice(price);
			ib.setStock(stock);

			//セッションが開始されてるか確認、されてなかったらnullを出す
			HttpSession seisson = req.getSession(false);

			//セッションのitemBeanにibを代入
			seisson.setAttribute("itemBean", ib);

			//RequestDispatcherを用いて、遷移先を指定している。
			RequestDispatcher rd = req.getRequestDispatcher("syosai.jsp");
			//RequestDispathaerを用いてふっ飛ばしてる。
			rd.forward(req, resp);

		}else {

		//セッションの接続
		HttpSession session = req.getSession(true);

		System.out.println(key);
		System.out.println(cate);

		ArrayList<String> list = new ArrayList<String>();

		if(key != "" && cate != "null") {
			//検索記入欄とキーワードが両方とも一致するものを探します
			DAO dao =new DAO();
			list = dao.kensaku(key);
			session.setAttribute("z", "false");

		}else if(key != "") {
			//検索記入欄のキーワードをDB(productテーブルの商品名)から探します
			//(*key*)みたいな？
			DAO dao =new DAO();
			list = dao.kensaku(key);
			session.setAttribute("z", "false");

		}else if(cate != "null") {
			//DBのcategoryテーブルから一致するカテゴリー名を探します
			DAO dao =new DAO();
			list = dao.Catkensaku(cate);
			System.out.println("2");
			session.setAttribute("z", "false");

		}else {
			System.out.println("入力してください");

		}
		session.setAttribute("list", list);

		//RequestDispatcherを用いて、遷移先を指定している。
		RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
		//RequestDispathaerを用いてふっ飛ばしてる。
		rd.forward(req, resp);

		//Daoの宣言

		System.out.println("SearchServlet終了");
	}
	}

}
