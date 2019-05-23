package web1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ECpack.DAO_S;

public class SearchServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Servlet let's go time!!");
		req.setCharacterEncoding("UTF-8");

		String kensaku = req.getParameter("kensaku");
		System.out.println(kensaku);
		String cat = req.getParameter("cat");

		ArrayList<ProBean> pb = new ArrayList<ProBean>();
		//アレイリストを作成します↑
		DAO_S odas = new DAO_S();
		//DAOをインスタンス化します↑

		if((kensaku !="" && cat != "") || (kensaku != "" && cat =="") ){
			pb=odas.pb(kensaku);
			//検索した際に何々じゃないときに何々のロジック

		}else if(kensaku == "" && cat != ""){
			pb=odas.searchpro(cat);
		}

		if (pb.size() != 0) {
			HttpSession ses = req.getSession(true);
			ses.setAttribute("prolist", pb);
			//セッションに登録しています。
			//セッションにセットしています。パスと変数
			System.out.println("検索結果あってるよキミやったじゃん！！");
			RequestDispatcher rd = req.getRequestDispatcher("/Search2.jsp");
			rd.forward(req, resp);
			//遷移先を選定しています↑

		} else if(pb.size() == 0){
			System.out.println("ミスってるやん。");
			req.setAttribute("err1", "検索件数0件です。他のキーワードを入力して下さい。");
			RequestDispatcher rd = req.getRequestDispatcher("/Search2.jsp");
			rd.forward(req, resp);
			System.out.println("The End.");
		}
	}
}
