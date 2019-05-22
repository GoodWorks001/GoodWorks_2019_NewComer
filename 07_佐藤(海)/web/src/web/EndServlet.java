package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EndServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
req.setCharacterEncoding("UTF-8");
HttpSession ses=req.getSession(false);

if(ses!=null) {
	System.out.println("セッションを破棄");
    ses.invalidate();
}

RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
rd.forward(req, resp);


}
}
