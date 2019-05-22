package web1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ECpack.DAO_S;

public class ShousaiServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("詳細サーブレット開始しまーーす！");

		req.setCharacterEncoding("UTF-8");
		String pro_cd = req.getParameter("pro_cd");
		System.out.println(pro_cd);

		DAO_S syousai = new DAO_S();
		ProBean pro = new ProBean();

		pro = syousai.ProductShousai(pro_cd);
		HttpSession ses = req.getSession(true);
		ses.setAttribute("pro", pro);

		RequestDispatcher rd = req.getRequestDispatcher("ProductProfile.jsp");
		rd.forward(req, resp);
		System.out.println("詳細サーブレット終わりーーー！");

	}

}
