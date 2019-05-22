package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");

		// セッションの継続
		HttpSession session = req.getSession(false);


        //
		ArrayList<ProductBean> cList = (ArrayList<ProductBean>)session.getAttribute("scart");

        //
		int kosuu = Integer.parseInt( req.getParameter("order"));

        //
        ProductBean pbean = (ProductBean) session.getAttribute("Syouhin");

        //
        pbean.setBuy(kosuu);

        //
        if(cList==null) {
        	cList = new ArrayList<ProductBean>();
        }

        //
        cList.add(pbean);

        //
        session.setAttribute("scart", cList);


      //遷移先指定
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		rd.forward(req, resp);
	}

	}

