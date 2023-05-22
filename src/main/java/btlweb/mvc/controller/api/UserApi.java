package btlweb.mvc.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import btlweb.mvc.model.Category;
import btlweb.mvc.model.User;
import btlweb.mvc.model.dto.AdminDto;
import btlweb.mvc.model.dto.UserDto;
import btlweb.mvc.service.UserService;
import btlweb.mvc.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
//		HttpSession session = req.getSession();
//		
//		Object admin = session.getAttribute("admin");
//		if(admin == null) {
//			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//			return;
//		}
		
		if(pathInfo != null && (pathInfo.equals("/admin") || pathInfo.equals("/admin/"))) {
			List<User> users = _userService.getAdmin();
			List<UserDto> userDtos = new ArrayList<>();
			for(User user : users) {
				userDtos.add(new UserDto(Integer.toString(user.getId()), user.getFirstName(), user.getLastName(), 
						user.getEmail(), user.getPhoneNumber(), user.getCity(), user.getDistrict(), user.getStreetAddress()));
			}
			sendAsJson(resp, userDtos);
			return ;
		}
		
		if(pathInfo == null || pathInfo.equals("/")) {
			String pageId = req.getParameter("pageId");
			if(pageId != null) {
				List<User> users = _userService.getUserInPage(Integer.parseInt(pageId));
				List<UserDto> userDtos = new ArrayList<>();
				for(User user : users) {
					userDtos.add(new UserDto(Integer.toString(user.getId()), user.getFirstName(), user.getLastName(), 
							user.getEmail(), user.getPhoneNumber(), user.getCity(), user.getDistrict(), user.getStreetAddress()));
				}
				sendAsJson(resp, userDtos);
				return ;
			}
			List<User> users = _userService.getAll();
			List<UserDto> userDtos = new ArrayList<>();
			for(User user : users) {
				userDtos.add(new UserDto(Integer.toString(user.getId()), user.getFirstName(), user.getLastName(), 
						user.getEmail(), user.getPhoneNumber(), user.getCity(), user.getDistrict(), user.getStreetAddress()));
			}
			sendAsJson(resp, userDtos);
			return ;
		}
		
		String[] args = pathInfo.split("/");
		if(args.length != 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return ;
		}
		
		int userId = Integer.parseInt(args[1]);
		User user = _userService.findUserById(userId);
		if(user == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return ;
		}
		UserDto userDto = new UserDto(Integer.toString(user.getId()), user.getFirstName(), user.getLastName(), 
				user.getEmail(), user.getPhoneNumber(), user.getCity(), user.getDistrict(), user.getStreetAddress());
		sendAsJson(resp, userDto);
		return ;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = req.getPathInfo();

		if(pathInfo != null && (pathInfo.equals("/admin") || pathInfo.equals("/admin/"))){
//			HttpSession session = req.getSession();
//			
//			Object admin = session.getAttribute("admin");
//			if(admin == null) {
//				resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//				return;
//			}

			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			
			String line = "";
			while((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			
			String payload = buffer.toString();
			AdminDto adminDto = _gson.fromJson(payload, AdminDto.class);
			
			int status = _userService.insertAdmin(adminDto);
			
			sendAsJson(resp, adminDto);
			return;
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pathInfo = req.getPathInfo();
		

		if(pathInfo == null || pathInfo.equals("/")){
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String[] splits = pathInfo.split("/");
		
		if(splits.length == 3 && splits[1].equals("admin")) {
//			HttpSession session = req.getSession();
//			
//			Object admin = session.getAttribute("admin");
//			if(admin == null) {
//				resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//				return;
//			}
			int userId = Integer.parseInt(splits[2]);
			
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
			AdminDto adminDto = _gson.fromJson(payload, AdminDto.class);
			
			UserDto user = new UserDto(adminDto.getId(), adminDto.getFirstName(), adminDto.getLastName(), 
					adminDto.getEmail(), adminDto.getPhoneNumber(), adminDto.getCity(), adminDto.getDistrict(), adminDto.getStreetAddress());
			
			int status = _userService.update(user);
			
			sendAsJson(resp, user);
			return;
			
		}
		
		if(splits.length == 2) {
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
			UserDto user = _gson.fromJson(payload, UserDto.class);
			
			int status = _userService.update(user);
			
			sendAsJson(resp, user);
			return;
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		return;
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
//		HttpSession session = req.getSession();
//		
//		Object admin = session.getAttribute("admin");
//		if(admin == null) {
//			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//			return;
//		}

		if(pathInfo == null || pathInfo.equals("/")){
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String[] splits = pathInfo.split("/");
		
		if(splits.length == 3 && splits[1].equals("admin")) {
			int userId = Integer.parseInt(splits[2]);
			
			User user = _userService.findUserById(userId);
			
			
			if(user == null) {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			int status = _userService.delete(userId);

			UserDto userDto = new UserDto(Integer.toString(user.getId()), user.getFirstName(), user.getLastName(), 
					user.getEmail(), user.getPhoneNumber(), user.getCity(), user.getDistrict(), user.getStreetAddress());
			sendAsJson(resp, userDto);
			return;
			
		}
		
		if(splits.length == 2) {
			int userId = Integer.parseInt(splits[1]);
			
			User user = _userService.findUserById(userId);
			
			
			if(user == null) {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			int status = _userService.delete(userId);

			UserDto userDto = new UserDto(Integer.toString(user.getId()), user.getFirstName(), user.getLastName(), 
					user.getEmail(), user.getPhoneNumber(), user.getCity(), user.getDistrict(), user.getStreetAddress());
			sendAsJson(resp, userDto);
			return;
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		return;
	}
}
