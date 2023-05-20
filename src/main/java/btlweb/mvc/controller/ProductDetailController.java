package btlweb.mvc.controller;

import java.io.IOException;

import btlweb.mvc.model.Product;
import btlweb.mvc.service.ProductService;
import btlweb.mvc.service.impl.ProductServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductDetailController extends HttpServlet{
	private ProductService _productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getContextPath() + "/view/client/assets/images/products/";
		String galeryPath = req.getContextPath() + "/view/client/assets/images/galery/";
		
		String pid = req.getParameter("pid");
		try {
			int pidI = Integer.parseInt(pid);
			Product product = _productService.getProductById(pidI, path, galeryPath);
			req.setAttribute("product", product);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/product.jsp");
		dispatcher.forward(req, resp);
	}
}
