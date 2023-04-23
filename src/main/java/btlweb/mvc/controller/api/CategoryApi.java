package btlweb.mvc.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import btlweb.mvc.model.Category;
import btlweb.mvc.model.User;
import btlweb.mvc.service.CategoryService;
import btlweb.mvc.service.impl.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategoryApi extends HttpServlet{
	
	private CategoryService _categoryService = new CategoryServiceImpl();
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
				List<Category> categories = _categoryService.getCategoryInPage(Integer.parseInt(pageId));
				sendAsJson(resp, categories);
				return ;
			}
			List<Category> categories = _categoryService.getAll();
			sendAsJson(resp, categories);
			return ;
		}
		
		String[] args = pathInfo.split("/");
		if(args.length > 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return ;
		}
		
		int categoryId = Integer.parseInt(args[1]);
		Category category = _categoryService.getCategoryById(categoryId);
		if(category == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return ;
		}
		sendAsJson(resp, category);
		return ;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			
			String line = "";
			while((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			
			String payload = buffer.toString();
			Category category = _gson.fromJson(payload, Category.class);
			
			int status = _categoryService.insertCategory(category);
			if(status == 0) {
				System.out.println("luu category khong thanh cong");
			} else {
				sendAsJson(resp, category);
			}
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		return;
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

		int catId = Integer.parseInt(splits[1]);
		
		if(_categoryService.getCategoryById(catId) == null) {
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
		Category category = _gson.fromJson(payload, Category.class);
		
		int status = _categoryService.updateCategory(category);
		
		if(status != 0) {
			sendAsJson(resp, category);
			return;
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			System.out.println("cap nhat category khong thanh cong");
		}
		return;
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
		
		int catId = Integer.parseInt(splits[1]);
		
		Category category = _categoryService.getCategoryById(catId);
		
		if(category == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		int status = _categoryService.deleteCategory(catId);
		if(status == 0) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			System.out.println("xoa category khong thanh cong");
			return;
		} else {
			sendAsJson(resp, category);
		}
		return;
	}
}
