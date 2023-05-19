package btlweb.mvc.controller;

import java.io.IOException;

import btlweb.mvc.hashalgorithm.BCrypt;
import btlweb.mvc.model.User;
import btlweb.mvc.service.UserService;
import btlweb.mvc.service.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController extends HttpServlet{
	private UserService _userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			User user = _userService.findUserByEmail(username);
			if(user != null && BCrypt.checkpw(password, user.getPassword())) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);

				resp.sendRedirect(req.getContextPath() + "/home");
			} else {
				System.out.println("dang nhap that bai");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/login.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
