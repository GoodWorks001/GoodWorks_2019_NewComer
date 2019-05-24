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

		//データの格納を行うメソッド
		//左側が格納するオブジェクトにつける名称
		//右側が格納したいオブジェクト
		HttpSession session = req.getSession(true);
		session.setAttribute("name", "高尾");
		req.setAttribute("age", "20");

		//ServletからJSPを呼び出すためのオブジェクトを使用
		RequestDispatcher rd = req.getRequestDispatcher("/test.jsp");
		//リクエスト・レスポンスを指定されたリソースへ転送する
		rd.forward(req, resp);
	}
}
