package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class resultServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		//HttpSession session = req.getSession(true);

		int pro_id =Integer.parseInt(req.getParameter("id")) ;

		resultDAO result = new resultDAO();

		ProductBean pb =result.result(pro_id);

		HttpSession ses = req.getSession(false);


		ses.setAttribute("syousai", pb);

		RequestDispatcher rd = req.getRequestDispatcher("/syousai.jsp");
		rd.forward(req, resp);





	}





}
