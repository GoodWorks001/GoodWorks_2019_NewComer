package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FortuneServlet extends HttpServlet {

	//doPostメソッドをオーバーライド
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");

		/*リクエストパラメータ「name」「year」「month」「date」
		をそれぞれ取り出して、変数に格納*/
		String name = req.getParameter("name");
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));
		int date = Integer.parseInt(req.getParameter("date"));

		/*LogicBeanのインスタンスを作成
		LogicBeanのインスタンスに対して、execute()メソッドを実行
		引数は、②で格納した変数を「name」「year」「month」「date」の順に指定
		execute()メソッドの戻り値として受け取ったResultBeanのインスタンスを、
		「result」という名称で、HttpServletRequestにsetAttribute()メソッドで格納*/
		LogicBean lb = new LogicBean();
		ResultBean rb = lb.execute(name, year, month, date);
		req.setAttribute("result", rb);

		//次の画面のJSP(/jsp/result.jsp)を、RequestDispatcherを使って実行
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/result.jsp");
		rd.forward(req, resp);
	}
}
