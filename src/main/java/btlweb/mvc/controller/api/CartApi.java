package btlweb.mvc.controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.CollationKey;

import com.google.gson.Gson;

import btlweb.mvc.model.Cart;
import btlweb.mvc.model.Item;
import btlweb.mvc.model.Product;
import btlweb.mvc.service.ProductService;
import btlweb.mvc.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartApi extends HttpServlet{
	
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
			String cartData = null;
			Cookie[] cookies = req.getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("cart")) {
						cartData = cookie.getValue();
						break;
					}
				}
			}
			Cart cart = null;
			if(cartData == null) {
				cart = new Cart();
			} else {
				cart = _gson.fromJson(cartData, Cart.class);				
			}				
			Cookie cookie = new Cookie("cart", _gson.toJson(cart));
			resp.addCookie(cookie);
			sendAsJson(resp, cart);
			return;
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String path = req.getContextPath() + "/view/client/assets/images/products/";
		String galeryPath = req.getContextPath() + "/view/client/assets/images/galery/";
		
		if(pathInfo == null || pathInfo.equals("/")) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		try {
			String pSize = req.getParameter("size");
			String pNum = req.getParameter("num");
			String[] splits = pathInfo.split("/");
			
			int size = Integer.parseInt(pSize);
			int num = Integer.parseInt(pNum);
			int pid = Integer.parseInt(splits[1]);
			
			Product product = _productService.getProductById(pid, path, galeryPath);
			
			Item item = new Item(product, num, product.getPrice(), size);
			
			Cookie[] cookies = req.getCookies();
			String cartData = null;
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("cart")) {
					cartData = cookie.getValue();
					break;
				}
			}
			Cart cart = null;
			if(cartData == null) {
				cart = new Cart();
			} else {
				cart = _gson.fromJson(cartData, Cart.class);				
			}
			cart.addItem(item);
			Cookie cookie = new Cookie("cart", _gson.toJson(cart));
			resp.addCookie(cookie);
			System.out.println(cart);
			sendAsJson(resp, cart);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi post cart");
		}
		
		return;
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
			
			int pid = Integer.parseInt(splits[1]);
			
			Cookie[] cookies = req.getCookies();
			String cartData = null;
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("cart")) {
					cartData = cookie.getValue();
					break;
				}
			}
			Cart cart = null;
			if(cartData == null) {
				cart = new Cart();
			} else {
				cart = _gson.fromJson(cartData, Cart.class);				
			}
			cart.removeItem(pid);
			Cookie cookie = new Cookie("cart", _gson.toJson(cart));
			resp.addCookie(cookie);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi delete cart");
		}
		
		return;
	}
}
