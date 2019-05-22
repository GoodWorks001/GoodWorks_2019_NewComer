package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FortuneServlet extends HttpServlet {


	//dopost()メソッドをオーバーライド
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	//リクエストパラメータ[name][year][month][date]
	//をそれぞれ取り出して変数に格納しておく
	req.setCharacterEncoding("UTF-8");    //文字化け防止
    String name = req.getParameter("name");
    int year = Integer.parseInt(req.getParameter("year"));     //Integer.parseInt()メソッドを使って整数に変換
    int month = Integer.parseInt(req.getParameter("month"));   //Integer.parseInt()メソッドを使って整数に変換
    int date = Integer.parseInt(req.getParameter("date"));     //Integer.parseInt()メソッドを使って整数に変換


    //LogicBeanクラスをインスタンス化
    LogicBean logic = new LogicBean();


    //インスタンスに対してexecute()メソッドを実行
    ResultBean res = logic.execute(name,year,month,date);

    //リクエストオブジェクトにぶち込んでいる
    //(keyがresultでvalueがres)
    req.setAttribute("result",res);


	//RequestDispatcherを用いて、遷移先を指定している
	RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
	 System.out.println(1);


	//RequestDispatcherを用いて吹っ飛ばしている(useBean.jsp)に
	rd.forward(req, resp);


	}

}
