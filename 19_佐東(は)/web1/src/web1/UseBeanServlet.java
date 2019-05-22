package web1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UseBeanServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

    // インスタンス化します。
	EmpBean rx = new EmpBean();
		   //NameにNewtypeっていう値をセットします。
		   rx.setName("NewType");
		    //値をセットします。Ageに20
		    rx.setAge(000);
		      //リクエストオブジェクトに中に入れています。keyがemp valueがrx(EmpBeanクラスの中身)
		      req.setAttribute("emp", rx);
		//RequestDispatcherを用いて、遷移先を指定しています。どこに飛ばすのか、予定先の選定
		RequestDispatcher dd = req.getRequestDispatcher("/useBean.jsp");
		//RequestDispatcherを用いて、飛ばしている。選定の結果先
		dd.forward(req, resp);
	}

}
