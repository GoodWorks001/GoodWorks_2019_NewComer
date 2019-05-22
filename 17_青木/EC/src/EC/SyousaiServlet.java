package EC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SyousaiServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		HttpSession session = req.getSession(false);
		String category = req.getParameter("syousai");
		String cat_name = null;
		int stock = 0;
		System.out.println(category);

		Syousai_DAO DAO = new Syousai_DAO();
		SyouhinBean bean = new SyouhinBean();
		bean = DAO.jdbc2(category);
		cat_name = DAO.jdbc3(bean.getCat_id());
		bean.setCat_name(cat_name);
		stock = bean.getStock();
		session.setAttribute("Item", bean);
		session.setAttribute("stock", stock);
		//遷移先の指定
		RequestDispatcher rd2 = req.getRequestDispatcher("/syousai.jsp");
		//rdに投げてる
		rd2.forward(req,resp);
	}
}
