package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class syousaiServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println("syousaiサーブレットを開始しました。");


		//
		String pro_name =req.getParameter("p_name");
		String cat_id =req.getParameter("category");

		//インスタンス化
		kensakuDAO ken = new kensakuDAO();

		ArrayList<String> alllist=new ArrayList<String>();


		if(cat_id =="") {

			if(pro_name =="") {
				//どちらも入力されてない

			}else {
				//名前の値は取得している
				//インスタンスしたやつのメソッド呼び出し！
				alllist = ken.kenname(pro_name);

			}

		}else {
			//カテゴリーの値は取得された

			if(pro_name =="") {
				//カテゴリーだけ値を取得
				alllist = ken.kencate(cat_id);

			}else {
				//どちらも入力されている
				alllist = ken.kencate(cat_id);
			}
		}
		//セッションを指定
		HttpSession session = req.getSession();

		//セッションにlistとゆうalllistの値を入れてる
		session.setAttribute("list",alllist);
		session.setAttribute("flg","false");


		RequestDispatcher rd = req.getRequestDispatcher("kensaku.jsp");
		rd.forward(req,resp);

	}

}
