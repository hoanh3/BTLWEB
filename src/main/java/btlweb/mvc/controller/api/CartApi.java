package btlweb.mvc.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.CollationKey;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import btlweb.mvc.model.Item;
import btlweb.mvc.model.Product;
import btlweb.mvc.model.dto.CartSN;
import btlweb.mvc.model.dto.ItemDto;
import btlweb.mvc.service.CartItemService;
import btlweb.mvc.service.ProductService;
import btlweb.mvc.service.SizeService;
import btlweb.mvc.service.impl.CartItemServiceImpl;
import btlweb.mvc.service.impl.ProductServiceImpl;
import btlweb.mvc.service.impl.SizeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartApi extends HttpServlet{
	private CartItemService _cartItemService = new CartItemServiceImpl();
	private ProductService _productService = new ProductServiceImpl();
	private SizeService _sizeService = new SizeServiceImpl();
	
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
				List<CartSN> cartItems = new ArrayList<>();
				for(Item item : items) {
					cartItems.add(new CartSN(item.getId(), item.getUserId(), item.getProduct(), 
							_sizeService.getSizeName(item.getSize()), item.getNum(), item.getPrice()));
				}
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
		
		try {

			
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			String line;
			while((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			String payload = buffer.toString();
			
			ItemDto itemDto = _gson.fromJson(payload, ItemDto.class);
			if(itemDto.getUid() == 0) {
				System.out.println(req.getLocalPort());
				resp.sendRedirect(req.getContextPath() + "/login");
			}
			
			Product product = _productService.getProductById(itemDto.getPid());
			
			Item item = new Item(0, itemDto.getUid(), product, itemDto.getSize(), itemDto.getNum(), product.getDiscount());
			
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
		
		try {

			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			
			String line = "";
			while((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			
			String payload = buffer.toString();
			ItemDto itemDto = _gson.fromJson(payload, ItemDto.class);
			
			Product product = _productService.getProductById(itemDto.getPid());
			
			Item item = new Item(0, itemDto.getUid(), product, itemDto.getSize(), itemDto.getNum(), product.getDiscount());
			_cartItemService.updateItem(item);
			
			sendAsJson(resp, item);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("loi put cart");
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
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
