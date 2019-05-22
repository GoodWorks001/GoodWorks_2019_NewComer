package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FortuneServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//エンコーディングとMIMEタイプの設定
				req.setCharacterEncoding("UTF-8");


				//nameを持ってきて代入する
				String name = req.getParameter("name");

				//"year"の値をint型にして変数に代入する
				int year = Integer.parseInt(req.getParameter("year"));
				//"month"の値をint型にして変数に代入する
				int month = Integer.parseInt(req.getParameter("month"));
				//"date"の値をint型にして変数に代入する
				int date = Integer.parseInt(req.getParameter("date"));

				//ここにnameを渡せてるかの確認（自分用）
				System.out.println(name);


        //インスタンス化
		LogicBean logic = new LogicBean();

		//resultという変数にextuteメソッドの値をすべて入れている
		ResultBean result = logic.excute(name,year,month,date);

		//resultオブジェクトにresultを代入している
	    req.setAttribute("result",result);

	    //RequestDispatcherを用いて、遷移先を指定している。
		 RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
		 //RequestDispatcherを用いて値を投げている。
		 rd.forward(req, resp);





	}

}
