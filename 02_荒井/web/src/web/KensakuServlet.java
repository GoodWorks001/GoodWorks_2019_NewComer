package web;

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

		System.out.println("KensakuServlet実行しました。");


		//インスタンス化
		ProductDAO product = new ProductDAO();


		//送信されてくるパラメーターのエンコード指定
		req.setCharacterEncoding("UTF-8");


		//送信されたパラメーターの取得
		String search = req.getParameter("search");   //キーワード検索
		String category = req.getParameter("category");  //カテゴリ


		System.out.println(search);      //searchの中に何が入っているか確認する
		System.out.println(category);    //categoryの中に何が入っているか確認する


		ArrayList<String> hairetu = new ArrayList<String>();


		if(category == ""){

			if(search == "") {
				//どちらも入力さてていない

			}else {
				//名前入力がされた
				hairetu = product.getproduct(search);
			}


		}else {
			//カテゴリーが入力されたばあい
			if(search == "") {
				//カテゴリーだけ入力されてるとき

				hairetu = product.getcat(category);

			}else {
				//両方とも入力された場合
				hairetu = product.getcat(category);

			}

		}



		 //セッションの指定
		 HttpSession ses = req.getSession(true);



		 //リストをセッションに保存
		 //                暗号   配列名
		 ses.setAttribute("product", hairetu);
		 ses.setAttribute("flg", "false");



		 //kensaku.jspに飛ばす
		 RequestDispatcher rd = req.getRequestDispatcher("/kensaku.jsp");
		 rd.forward(req, resp);

	}
}
