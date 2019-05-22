package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class kensakuServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


    	System.out.println("検索サーブレット開始");
    	//送信されてくるパラメータのエンコーディングの指定
    	req.setCharacterEncoding("UTF-8");

    	String name = req.getParameter("name");
    	String msg = req.getParameter("msg");
    //	String category = req.getParameter("category");
   // 	int stock = Integer.parseInt(req.getParameter("stock"));
    //	int preice = Integer.parseInt(req.getParameter("preice"));

    	shoukaidao sd = new shoukaidao();

    	productbean pb = sd.search(name, msg);

    	req.setAttribute("result", pb);



		RequestDispatcher rd = req.getRequestDispatcher("shoukai.jsp");
		rd.forward(req, resp);

	}

}
