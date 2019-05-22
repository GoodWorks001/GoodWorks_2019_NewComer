package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@web(name="search",urlPatterns ="/search")
public class kensakuServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//送信されてくるパラメータのコーティングの指定
		req.setCharacterEncoding("UTF-8");

		//商品情報格納用配列の宣言
		ArrayList <String> list = new ArrayList <String>();
        
		//送信されたパラメータの取得
		String search =req.getParameter("search");
		String category =req.getParameter("category");
		
		//Daoクラスのインスタンス化
		ItemDAO item=new ItemDAO();


		if(category == "") {
			if(search == "") {
				//どちらも入力されてない場合
				System.out.println("何もしない");

			}else {
				//名前入力されたとき,名前検索用メソッド呼び出し
				list = item.name(search);
			}
		}else {
			//カテゴリで検索されたとき
			if(search == "") {
				//カテゴリだけ入力されたとき
				list = item.category(category);

			}else {
				//両方入力されたとき

				list = item.category(category);
			}
		}

		//セッションの生成
		HttpSession session = req.getSession(true);
		
		//セッションに配列を格納
		session.setAttribute("list", list);
		session.setAttribute("flg","false");
		
		//login.jspに飛ぶ
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
    }
}

