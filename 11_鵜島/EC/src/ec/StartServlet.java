package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		LoginDAO ld = new LoginDAO();

		session.setAttribute("namelist", null);
		//session.setAttribute("mei", null);
		System.out.println(session.getAttribute("mei"));


		if(session.getAttribute("mei") == null)
		{	System.out.println("セッションにmei_idはないです");
			boolean flag = ld.meisaiNo();
			if(flag) {
				int mei = ld.getNo();
				mei += 1;
				session.setAttribute("mei", mei);
			}else {
				session.setAttribute("mei", 1);
			}
		}else {
			int meisai = (Integer)session.getAttribute("mei");
			session.setAttribute("mei", meisai);
		}


		//飛ぶ先を指定
		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		//飛ばす
		rd.forward(req, resp);
	}

}
