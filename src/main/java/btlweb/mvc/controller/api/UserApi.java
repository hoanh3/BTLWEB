package btlweb.mvc.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import btlweb.mvc.model.Category;
import btlweb.mvc.model.User;
import btlweb.mvc.service.UserService;
import btlweb.mvc.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserApi extends HttpServlet{
	
	private UserService _userService = new UserServiceImpl();
	private Gson _gson = new Gson();
	
	private void sendAsJson(HttpServletResponse response, Object object) throws IOException {
		response.setContentType("application/json");
		
		String res = _gson.toJson(object);
		
		PrintWriter pW = response.getWriter();
		
		response.setStatus(200);
		pW.print(res);
		pW.flush();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			String pageId = req.getParameter("pageId");
			if(pageId != null) {
				List<User> users = _userService.getUserInPage(Integer.parseInt(pageId));
				sendAsJson(resp, users);
				return ;
			}
			List<User> users = _userService.getAll();
			sendAsJson(resp, users);
			return ;
		}
		
		String[] args = pathInfo.split("/");
		if(args.length > 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return ;
		}
		
		int userId = Integer.parseInt(args[1]);
		User user = _userService.findUserById(userId);
		if(user == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return ;
		}
		sendAsJson(resp, user);
		return ;
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

		if(pathInfo == null || pathInfo.equals("/")){
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		int userId = Integer.parseInt(splits[1]);
		
		if(_userService.findUserById(userId) == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		
		String line = "";
		while((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		
		String payload = buffer.toString();
		User user = _gson.fromJson(payload, User.class);
		
		int status = _userService.update(user);
		
		if(status != 0) {
			sendAsJson(resp, user);
			return;
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			System.out.println("cap nhat category khong thanh cong");
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

		if(pathInfo == null || pathInfo.equals("/")){
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		int userId = Integer.parseInt(splits[1]);
		
		
		User user = _userService.findUserById(userId);
		
		if(user == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		int status = _userService.delete(userId);
		if(status == 0) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		} else {
			sendAsJson(resp, user);
		}
		return;
	}
}
