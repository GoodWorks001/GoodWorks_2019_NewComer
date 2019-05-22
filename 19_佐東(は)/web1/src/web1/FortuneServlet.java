package web1;
//import文です。
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FortuneServlet extends HttpServlet {

	@Override//doPost形式でオーバーライドの実行を行なっています。
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//文字コードの呼び出しをしています。
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset = UTF-8");

		//引き出した値をint型に格納しています。
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));
		int date = Integer.parseInt(req.getParameter("date"));
		//String型に格納しています。
		String name = req.getParameter("name");

		//LogicBeanをインスタンス化してます。
		LogicBean lb = new LogicBean();

		//ResultBeanをインスタンス化します。
		ResultBean rb = new ResultBean();
		rb = lb.excute(name,year, month, date);
		//リクエストオブジェクトの中に入れています。key"result" value"rb"
		req.setAttribute("result",rb);

		//RequestDispatcherを用いて、遷移先を指定してます。どこに飛ばすのか、予定先の選定です。
		RequestDispatcher rd = req.getRequestDispatcher("/result.jsp");
		//RequestDispatcherを用いて、飛ばしています。予定先の選定です
		rd.forward(req, resp);



	}
}


