package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class cartoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("cartサーブレットを開始しました");

		req.setCharacterEncoding("UTF-8");

		HttpSession ses = req.getSession(false);

		ArrayList<ProductBean> array = (ArrayList<ProductBean>)ses.getAttribute("cart");

		int count = Integer.parseInt(req.getParameter("kosu"));
		System.out.println("個数"+count);

		ProductBean pro = (ProductBean)ses.getAttribute("syousai");

		pro.setBuy(count);

		if(array == null) {
			array = new ArrayList<ProductBean>();
		}

		array.add(pro);

		ses.setAttribute("cart", array);

		RequestDispatcher rd = req.getRequestDispatcher("/ca-to.jsp");
		rd.forward(req, resp);

	}

}
