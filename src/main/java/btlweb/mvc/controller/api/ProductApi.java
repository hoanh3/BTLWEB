package btlweb.mvc.controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import btlweb.mvc.model.Category;
import btlweb.mvc.model.Product;
import btlweb.mvc.model.User;
import btlweb.mvc.service.ProductService;
import btlweb.mvc.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductApi extends HttpServlet{
	
	private ProductService _productService = new ProductServiceImpl();
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
				List<Product> products = _productService.getProductInPage(Integer.parseInt(pageId));
				sendAsJson(resp, products);
				return ;
			}
			List<Product> products = _productService.getAll();
			sendAsJson(resp, products);
			return ;
		}
		
		String[] args = pathInfo.split("/");
		if(args.length > 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return ;
		}
		
		int productId = Integer.parseInt(args[1]);
		Product product = _productService.getProductById(productId);
		if(product == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return ;
		}
		sendAsJson(resp, product);
		return ;
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

		int productId = Integer.parseInt(splits[1]);
		
		
		Product product = _productService.getProductById(productId);
		
		if(product == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		int status = _productService.deleteProduct(productId);
		if(status == 0) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		} else {
			sendAsJson(resp, product);
		}
		return;
	}
}