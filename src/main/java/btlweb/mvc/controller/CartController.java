package btlweb.mvc.controller;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;

import btlweb.mvc.model.Cart;
import btlweb.mvc.model.Item;
import btlweb.mvc.model.Product;
import btlweb.mvc.service.ProductService;
import btlweb.mvc.service.impl.ProductServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartController extends HttpServlet{
	private ProductService _productService = new ProductServiceImpl();
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getContextPath() + "/view/client/assets/images/products/";
		String galeryPath = req.getContextPath() + "/view/client/assets/images/galery/";
		
		HttpSession session = req.getSession(true);
		Cart cart = null;
		Object object = session.getAttribute("cart");
		if(object != null) {
			cart = (Cart) object;
		} else {
			cart = new Cart();
		}
		String num = req.getParameter("num");
		String pid = req.getParameter("pid");
		try {
			Product product = _productService.getProductById(Integer.parseInt(pid), path, galeryPath);
			Item item = new Item(product, Integer.parseInt(num), product.getDiscount());
			cart.addItem(item);
		} catch (Exception e) {
			num = "1";
		}
		List<Item> listItem = cart.getItems();
		req.setAttribute("listItem", listItem);
		session.setAttribute("cart", cart);
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/shop-cart.jsp");
//		dispatcher.forward(req, resp);
	}
}
