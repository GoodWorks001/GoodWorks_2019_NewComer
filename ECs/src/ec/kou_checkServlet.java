package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class kou_checkServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		System.out.println("ボタン押してさーぶれっときたよ");

		// セッションの継続
		HttpSession session = request.getSession(false);

		// 値段のリスト
		ArrayList<String> ppp = new ArrayList<String>();
		// 個数のリスト
		ArrayList<String> sss = new ArrayList<String>();
		// 個数のリスト
		ArrayList<String> idlist = new ArrayList<String>();

		ArrayList<Integer> sumlist = new ArrayList<Integer>();

		ppp = (ArrayList<String>) (session.getAttribute("pricelist"));

		sss = (ArrayList<String>) (session.getAttribute("buylist"));

		System.out.println("セッションから値をpppとsssにぶちこんだよ");

		System.out.println("ppp:"+ppp.size());
		System.out.println("sss:"+sss.size());

		int sum = 0;
		for (int i = 0; i < ppp.size(); i++) {
			sum += ((Integer.parseInt(ppp.get(i))) * Integer.parseInt(sss.get(i)));
		}

		System.out.println("for終わり");

		double zeikeisan = sum * 0.08;
		int zei = (int) zeikeisan;
		int total = sum + zei;

		session.setAttribute("Tax", zei);
		session.setAttribute("total", total);

		System.out.println("set完了");

		// jspフォルダにあるserch.jspを呼び出す
				RequestDispatcher rd = request.getRequestDispatcher("/kou_check.jsp");
				// RequestDispatcherを用いてrequestとresponseの中身をふっ飛ばしてる。
				rd.forward(request, response);
	}

}
