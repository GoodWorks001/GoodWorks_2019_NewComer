package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KadenServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 送信されてくるパラメータのエンコーディングの指定
				req.setCharacterEncoding("UTF-8");


                //インスタンス化
				KensakuDAO kendao = new KensakuDAO();

                //インスタンス化
				ProductBean itemList =new ProductBean();

				//詳細ボタンのPro_cdを受け取る
				int procd = Integer.parseInt(req.getParameter("itemNum"));

				//itemListにKensakuDAOのisItemメソッドの値を入れる
                itemList = kendao.isItem(procd);


				// セッションの継続
				HttpSession session = req.getSession(true);

				System.out.println("セッション");

				//
				session.setAttribute("Syouhin",itemList);


				//遷移先指定
				RequestDispatcher rd = req.getRequestDispatcher("syoukai.jsp");
				rd.forward(req, resp);


				System.out.println("ここまで");


			}








	}


