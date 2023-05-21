package btlweb.mvc.controller;

import java.io.IOException;

import btlweb.mvc.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddressController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Object user = session.getAttribute("user");
		if(user == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/address.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
