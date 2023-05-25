package btlweb.mvc.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import btlweb.mvc.model.Category;
import btlweb.mvc.model.Product;
import btlweb.mvc.model.User;
import btlweb.mvc.model.dto.ProductDto;
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
			String cateId = req.getParameter("cate-id");
			if(cateId != null) {
				List<Product> products = _productService.getProductByCatId(cateId);
				sendAsJson(resp, products);
				return;
			}
			String relateId = req.getParameter("related");
			if(relateId != null) {
				List<Product> products = _productService.getProductByCatId(relateId);
				sendAsJson(resp, products.subList(0, Math.min(6, products.size())));
				return;
			}
			String search = req.getParameter("search");
			if(search != null) {
				List<Product> products = _productService.searchProductByName(search);
				sendAsJson(resp, products);
				return;
			}
			String pageId = req.getParameter("pageId");
			if(pageId != null) {
				List<Product> products = _productService.getProductInPage(Integer.parseInt(pageId));
				sendAsJson(resp, products);
				return ;
			}
			String filter = req.getParameter("filter");
			if(filter != null ) {
				if(filter.equals("topsale")) {
					try {
						List<Product> products = _productService.getTopSale();
						sendAsJson(resp, products);						
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("xung doi ");
					}
					return ;
				} else if(filter.equals("bestseller")) {
					try {
						List<Product> products = _productService.getBestSeller();
//						if(products.size() < 10) {
//							products = _productService.getTopSale(path, galeryPath);
//						}
						sendAsJson(resp, products);						
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("xung doi ");
					}
					return ;
				}				
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = req.getReader();
			String line = "";
			
			while((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			
			String payload = buffer.toString();
			
			ProductDto productDto = _gson.fromJson(payload, ProductDto.class);
//			System.out.println(productDto);
			
			_productService.insertProduct(productDto);
			
			sendAsJson(resp, productDto);
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		return;
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
			
		} else {
			String[] splits = pathInfo.split("/");
			if(splits.length == 2) {
				int pid = Integer.parseInt(splits[1]);
				
				Product product = _productService.getProductById(pid);
				
				if(product == null) {
					resp.sendError(HttpServletResponse.SC_NOT_FOUND);
					return;
				}
				
				StringBuffer buffer = new StringBuffer();
				BufferedReader reader = req.getReader();
				
				String line = "";
				while((line = reader.readLine()) != null) {
					buffer.append(line);
				}
				String payload = buffer.toString();
				
//				System.out.println(payload);
				
				ProductDto productDto = _gson.fromJson(payload, ProductDto.class);
				
				_productService.updateProduct(productDto, pid);
				
				sendAsJson(resp, productDto);
				return;
			}
			
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

		int productId = Integer.parseInt(splits[1]);
		
		
		Product product = _productService.getProductById(productId);
		
		if(product == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		int status = _productService.deleteProduct(productId);
		
		sendAsJson(resp, product);
		return;
	}
}
