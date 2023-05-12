package btlweb.mvc.controller;

import java.io.IOException;

import btlweb.mvc.service.ProductService;
import btlweb.mvc.service.impl.ProductServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CartController extends HttpServlet{
	private ProductService _productService = new ProductServiceImpl();
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/cart.jsp");
		dispatcher.forward(req, resp);
	}
}
