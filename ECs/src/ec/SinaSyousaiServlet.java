package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SinaSyousaiServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" SinaSyousaiServlet開始");
		//すでにセッションしているからfalse
		HttpSession session = request.getSession(false);

		response.setContentType("text/html;charset=UTF-8");//エンコーディング

		String btnName = "";

		btnName = request.getParameter("syousai"); //詳細ボタンの値取得
//		SearchBean bean = new SearchBean();
//		categoryBean bean2 = new categoryBean();
		syousaiDAO syoDAO =new syousaiDAO();
		ArrayList<String> syoList = syoDAO.syousai(btnName); //
		session.setAttribute("syousaiList",syoList);


		// jspフォルダにあるserch.jspを呼び出す
		RequestDispatcher rd = request.getRequestDispatcher("/pro_detals.jsp");
		// RequestDispatcherを用いてrequestとresponseの中身をふっ飛ばしてる。
		rd.forward(request, response);
		System.out.println(" SinaSyousaiServlet終了");


	}

}
