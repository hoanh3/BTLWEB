package btlweb.mvc.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

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

public class AdminLoginController extends HttpServlet{
	private UserService _userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			User user = _userService.adminFindUserByEmail(username);
			if(user != null && BCrypt.checkpw(password, user.getPassword())) {
				HttpSession session = req.getSession();
				
				session.setAttribute("admin", user);
				
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else {
				PrintWriter printWriter = resp.getWriter();
				
				printWriter.println("Đăng nhập không thành công");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/login.jsp");
				dispatcher.include(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Loi admin login");
		}
	}
}
