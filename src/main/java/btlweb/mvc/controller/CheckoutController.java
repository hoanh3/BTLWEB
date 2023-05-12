package btlweb.mvc.controller;

import java.io.IOException;

import btlweb.mvc.service.OrderService;
import btlweb.mvc.service.impl.OrderServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckoutController extends HttpServlet{
	private OrderService _orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/checkout.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first-name");
		String lastName = req.getParameter("last-name");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phone-number");
		String city = req.getParameter("city");
		String district = req.getParameter("district");
		String streetAddress = req.getParameter("street-address");
		String note = req.getParameter("note");
		String userId = req.getParameter("user-id");
		
		try {
			_orderService.addOrder(firstName, lastName, email, phoneNumber, city, district, streetAddress, note, Integer.parseInt(userId));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
