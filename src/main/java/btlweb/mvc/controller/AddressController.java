package btlweb.mvc.controller;

import java.io.IOException;

import btlweb.mvc.model.User;
import btlweb.mvc.service.UserService;
import btlweb.mvc.service.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddressController extends HttpServlet{
	private UserService _userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("user");
		if(obj == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			User user = (User) obj;
			user = _userService.findUserById(user.getId());
			session.removeAttribute("user");
			session.setAttribute("user", user);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/address.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
