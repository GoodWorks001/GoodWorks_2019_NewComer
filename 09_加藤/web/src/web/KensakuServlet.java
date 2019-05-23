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
		System.out.println("開始");

		//送信されてくるパラメータのエンコーディング指定
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String text = req.getParameter("text");
		System.out.println("テキストボックスの値は"+text);
		String category = req.getParameter("category");
		System.out.println("セレクトボックスの値は"+category);

		//daoインスタンス作成
		DAO dao = new DAO();

		//ArrayListをインスタンス化
		ArrayList<ProductBean> alist = new ArrayList<ProductBean>();

		System.out.println("開始1");

		//テキストボックスに文字が入っていない
		//もしくはカテゴリーが選択されていない場合のロジック
		if(text == "" & category == "") {
			//遷移先指定
			RequestDispatcher rd = req.getRequestDispatcher("/kensaku_no_ec.jsp");
			rd.forward(req, resp);
		//テキスト入力のみがされている場合のロジック
		} else if(text != "" & category == ""){
			//DAOクラスのメソッドの呼び出し
			alist = dao.Pro_gets(text);
			//セッション作成
			HttpSession session = req.getSession(true);
			//セッションにアレイリストを登録
			session.setAttribute("list", alist);
			//遷移先指定
			RequestDispatcher rd = req.getRequestDispatcher("/kensakukekka.jsp");
			rd.forward(req, resp);
		} else if(category != "" & text == "") {
			//DAOクラスのメソッドの呼び出し
			alist = dao.Pro_Gets(category);
			//セッション作成
			HttpSession session = req.getSession(true);
			//セッションにアレイリストを登録
			session.setAttribute("list", alist);
			//遷移先指定
			RequestDispatcher rd = req.getRequestDispatcher("/kensakukekka.jsp");
			rd.forward(req, resp);
		} else {
			System.out.println("DAO3実行");
			//DAOクラスのメソッドの呼び出し
			alist = dao.Pro_gets(text);
			//DAOクラスのメソッドの呼び出し
			alist = dao.Pro_Gets(category);
			//セッション作成
			HttpSession session = req.getSession(true);
			//セッションにアレイリストを登録
			session.setAttribute("list", alist);
			//遷移先指定
			RequestDispatcher rd = req.getRequestDispatcher("/kensakukekka.jsp");
			rd.forward(req, resp);
		}
	}
}
