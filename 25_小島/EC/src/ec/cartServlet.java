package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class cartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("カートサーブレット開始");
    	//送信されてくるパラメータのエンコーディングの指定
    	req.setCharacterEncoding("UTF-8");






		RequestDispatcher rd = req.getRequestDispatcher("kakunin.jsp");
		rd.forward(req, resp);


	}

}
