package ec;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FinishServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//セッションの継続
		HttpSession session = req.getSession(false);

		//値段のリスト
		ArrayList<String> prilist = new ArrayList<String>();
		//個数のリスト
		ArrayList<String> kosulist = new ArrayList<String>();
		//個数のリスト
		ArrayList<String> idlist = new ArrayList<String>();

		//ArrayList<Integer> zaikolist = new ArrayList<Integer>();

		//合計値段リスト
		ArrayList<Integer> sumlist = new ArrayList<Integer>();

		prilist = (ArrayList<String>)(session.getAttribute("pricelist"));

		kosulist = (ArrayList<String>)(session.getAttribute("stocklist"));
		idlist = (ArrayList<String>)(session.getAttribute("cdlist"));
		//
		//zaikolist =(ArrayList<Integer>)(session.getAttribute("zaiko"));

		for(int i = 0; i < prilist.size(); i++) {
			System.out.println( "44 :"+prilist.get(i));
			int a = Integer.parseInt(prilist.get(i));
			int b = Integer.parseInt(kosulist.get(i));

			System.out.println("a :" + a +" b :" + b);


			sumlist.add((int)(a * b * 1.08));
		}



		ConfDAO cd = new ConfDAO();

		int count = (Integer)session.getAttribute("mei");

		//LoginBean lb = (LoginBean)session.getAttribute("user");
		//int user_id =Integer.parseInt(lb.getUserID());


		System.out.println(session.getAttribute("user"));
		//int user_id = (Integer)session.getAttribute("user");
		String user_id = (String)session.getAttribute("user");

		Calendar cal = Calendar.getInstance();

		String pro_cd = (String)idlist.get(0);
		//String pro_cd = (String)session.getAttribute("cdlist");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(cal.getTime()));










		System.out.println("aaaaaaaaa:"+kosulist.get(0));
		//System.out.println("cccccccccccc:"+zaikolist.get(0));
		DetailBean db = new DetailBean();
		FinDAO fd = new FinDAO();
		try {
			int  a;
			a=cd.Insert(count, user_id, sumlist, idlist);
			session.setAttribute("mei", a+1);
			fd.Update(idlist, kosulist);
		} catch (SQLException e) {
			e.printStackTrace();
		}


		prilist.clear();
		sumlist.clear();
		session.setAttribute("namelist", null);
		session.setAttribute("pricelist", null);
		session.setAttribute("stocklist", null);
		session.setAttribute("cdlist", null);
		session.setAttribute("zaiko", null);
//		session.setAttribute("pricelist", prilist);
//		session.setAttribute("namelist", prilist);
//		session.setAttribute("pricelist", prilist);



		//飛ぶ先を指定
		RequestDispatcher rd = req.getRequestDispatcher("/finish.jsp");
		//飛ばす
		rd.forward(req, resp);
	}




}
