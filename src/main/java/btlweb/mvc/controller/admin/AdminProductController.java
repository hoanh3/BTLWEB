package btlweb.mvc.controller.admin;

import java.io.IOException;
import java.util.List;

import btlweb.mvc.model.Category;
import btlweb.mvc.service.CategoryService;
import btlweb.mvc.service.impl.CategoryServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminProductController extends HttpServlet{
	
	private CategoryService _cateogoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> categories = _cateogoryService.getAll();
		
		req.setAttribute("categories", categories);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/productManamegent.jsp");
		dispatcher.forward(req, resp);
	}
}
