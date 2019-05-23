package web1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ECpack.DAO_S;

public class MeisaiServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("明細サーブレット開始してるよ！！！");

		req.setCharacterEncoding("UTF-8");
		HttpSession ses = req.getSession(true);
		String user_id =(String) ses.getAttribute("user");
		System.out.println("user_id"+user_id);

		ArrayList<MeisaiBean> meisai = (ArrayList<MeisaiBean>)ses.getAttribute("meisai");

		DAO_S odas = new DAO_S();

		odas.Meisai(meisai, user_id);
		ses.setAttribute("cart",null);

		RequestDispatcher rd = req.getRequestDispatcher("/Complete.jsp");
		rd.forward(req, resp);

		System.out.println("明細サーブレット終了だよ！！！");
	}

}
