package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DispatchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//データの取り出し getAttriute()メソッド
		HttpSession session = req.getSession(true);

        //データの格納 setAttribute()メソッド
		//格納できるデータはクラス型のインスタンスのみ
		//基本データ型は直接格納できない
		session.setAttribute("name", "Takao");
		req.setAttribute("age", "20");


		//同一コンテクストのtest.jspへ転送する
		//ServletからJSPを呼び出す
		RequestDispatcher rd = req.getRequestDispatcher("/test.jsp");

		//forward()でリクエスト・レスポンスを指定されたリソースへ転送(ディスパッチ)
		rd.forward(req, resp);

	}
}
