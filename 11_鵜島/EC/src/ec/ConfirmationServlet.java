package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmationServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		//セッションの継続
		HttpSession session = req.getSession(false);

		//値段のリスト
		ArrayList<String> ppp = new ArrayList<String>();
		//個数のリスト
		ArrayList<String> sss = new ArrayList<String>();
		//idのリスト
		ArrayList<String> idlist = new ArrayList<String>();

		ArrayList<Integer> sumlist = new ArrayList<Integer>();

		ppp = (ArrayList<String>)(session.getAttribute("pricelist"));

		sss = (ArrayList<String>)(session.getAttribute("stocklist"));






		int sum = 0;
		for(int i = 0; i < ppp.size(); i++) {
			sum += ((Integer.parseInt(ppp.get(i))) * Integer.parseInt(sss.get(i)));
		}

		double sum2 = sum * 0.08;
		int syouhizei = (int)sum2;
		int goukei = sum + syouhizei;

		session.setAttribute("tax", syouhizei);
		session.setAttribute("goukei", goukei);



		//飛ぶ先を指定
		RequestDispatcher rd = req.getRequestDispatcher("/confirmation.jsp");
		//飛ばす
		rd.forward(req, resp);
	}



}
