package web1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ECpack.DAO;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String id = req.getParameter("log");
		   System.out.println("log" + id);
		String pass = req.getParameter("pas");
		   System.out.println("pas" + pass);


		ArrayList<CatBean> cat = new ArrayList<CatBean>();
		//CatBeanをアレイリストにしました↑
		 DAO oda = new DAO();
		 //DAOのインスタンス化しました↑
	       cat = oda.cats();


		Boolean x = oda.log(id, pass);

		if (x == true) {
			HttpSession session = req.getSession(true);
			//セッションに登録してます↑
			session.setAttribute("catlist",cat);
			//セッションにセット
			   System.out.println("ログインできてるよキミ！！");
			   session.setAttribute("user",id);
			RequestDispatcher rd = req.getRequestDispatcher("/Search.jsp");
			//遷移先を選定しています↑
			rd.forward(req, resp);


		} else if(id.equals("")||pass.equals("")) {
			//何も入力されてない場合の処理です↑
				req.setAttribute("err1","名前またはパスワードを入力してください。");
				RequestDispatcher rd = req.getRequestDispatcher("/LOGIN.jsp");
				rd.forward(req, resp);
			}else {
				req.setAttribute("err2","名前またはパスワードが違います。");
				//間違えてる場合の表示です↑  処理はLOGIN.jspにあります。
			   System.out.println("まちがえてるで");
			RequestDispatcher rd = req.getRequestDispatcher("/LOGIN.jsp");
			rd.forward(req, resp);
		}
}

}