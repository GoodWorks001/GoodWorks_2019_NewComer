package Syousai;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Search.ProductBean;

public class SyousaiServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("詳細開始");
		req.setCharacterEncoding("UTF-8");
		String pro_cd = req.getParameter("pro_cd");
		System.out.println(pro_cd);
		SyousaiJDBC sjd = new SyousaiJDBC();
		ProductBean pb = new ProductBean();

		pb = sjd.ProductSyousai(pro_cd);
		HttpSession ses = req.getSession(true);
		ses.setAttribute("PRO", pb);
		RequestDispatcher rd = req.getRequestDispatcher("/Adverb.jsp");
		rd.forward(req, resp);

		System.out.println("詳細終了");
	}

}
