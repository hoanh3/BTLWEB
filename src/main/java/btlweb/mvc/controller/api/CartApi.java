package btlweb.mvc.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.CollationKey;
import java.util.List;

import com.google.gson.Gson;

import btlweb.mvc.model.Item;
import btlweb.mvc.model.Product;
import btlweb.mvc.service.CartItemService;
import btlweb.mvc.service.ProductService;
import btlweb.mvc.service.impl.CartItemServiceImpl;
import btlweb.mvc.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartApi extends HttpServlet{
	private CartItemService _cartItemService = new CartItemServiceImpl();
	private ProductService _productService = new ProductServiceImpl();
	
	private Gson _gson = new Gson();
	
	private void sendAsJson(HttpServletResponse response, Object object) throws IOException {
		response.setContentType("application/json");
		
		String res = _gson.toJson(object);
		
		PrintWriter printWriter = response.getWriter();
		printWriter.print(res);
		printWriter.flush();
		response.setStatus(200);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			String uid = req.getParameter("uid");
			if(uid != null) {
				int userId = Integer.parseInt(uid);
				List<Item> items = _cartItemService.getCart(userId);
				sendAsJson(resp, items);
				return;				
			}
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String serverUrl = req.getLocalAddr() + ":" + req.getLocalPort();
		String path = serverUrl + "/" + req.getContextPath() + "/view/client/assets/images/products/";
		String galeryPath = serverUrl + "/" + req.getContextPath() + "/view/client/assets/images/galery/";
		
		if(pathInfo == null || pathInfo.equals("/")) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		try {
			String sid = req.getParameter("size");
			String pNum = req.getParameter("num");
			String uid = req.getParameter("uid");
			String[] splits = pathInfo.split("/");
			
			int size = Integer.parseInt(sid);
			int num = Integer.parseInt(pNum);
			int userId = Integer.parseInt(uid);
			int pid = Integer.parseInt(splits[1]);
			
			Product product = _productService.getProductById(pid, path, galeryPath);
			
			System.out.println(product);
			
			Item item = new Item(0, userId, pid, size, num, product.getPrice());
			
			_cartItemService.addItem(item);
			sendAsJson(resp, item);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi post cart");
		}
		
		return;
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = req.getPathInfo();
		
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		
		String line = "";
		while((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		
		String payload = buffer.toString();
		Item item = _gson.fromJson(payload, Item.class);
		
		_cartItemService.updateItem(item);
		
		sendAsJson(resp, item);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		try {
			String[] splits = pathInfo.split("/");
			
			int id = Integer.parseInt(splits[1]);
			_cartItemService.removeItem(id);
			
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi delete cart");
		}
		
		return;
	}
}
