package btlweb.mvc.controller;

import java.io.IOException;

import btlweb.mvc.service.UserService;
import btlweb.mvc.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UpdateController extends HttpServlet{
	private UserService _userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = req.getPathInfo();
		String[] splits = pathInfo.split("/");
		System.out.println("update");
		if(splits.length == 2) {
			int uid = Integer.parseInt(splits[1]);
			HttpSession session = req.getSession();
			session.removeAttribute("user");
			System.out.println(_userService.findUserById(uid));
			session.setAttribute("user", _userService.findUserById(uid));
			resp.sendRedirect(req.getContextPath() + "/address");
		}
	}
}
