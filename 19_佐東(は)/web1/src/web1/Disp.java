package web1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Disp extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession hs = request.getSession(true);
			//セッションリクエストのnameにたかおを設定している。
			hs.setAttribute("name", "たかお");
			//上記のrequestの中のsetAtrributeを使用して設定するのが↓
			request.setAttribute("age",20);
			//DispHttp.jspをrequestDispatcherに飛ばします。 web1コンテントの中にある場合 /の部分は
		RequestDispatcher rd = request.getRequestDispatcher("/DispHttp.jsp");
			rd.forward(request, response);

}
}