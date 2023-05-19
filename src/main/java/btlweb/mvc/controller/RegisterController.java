package btlweb.mvc.controller;

import java.io.IOException;

import btlweb.mvc.hashalgorithm.BCrypt;
import btlweb.mvc.service.UserService;
import btlweb.mvc.service.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterController extends HttpServlet{
	private UserService _userService = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first-name");
		String lastName = req.getParameter("last-name");
		
		String username = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			if(_userService.findUserByEmail(username) == null) {
				int status = _userService.insertUser(username, BCrypt.hashpw(password, BCrypt.gensalt(12)), firstName, lastName);
				if(status != 0) {
					System.out.println("thanh cong");
					resp.sendRedirect(req.getContextPath() + "/login?success");
				} else {
					System.out.println("that bai");
					resp.sendRedirect(req.getContextPath() + "/login?error");
				}				
			} else {
				resp.sendRedirect(req.getContextPath() + "/login?error");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
