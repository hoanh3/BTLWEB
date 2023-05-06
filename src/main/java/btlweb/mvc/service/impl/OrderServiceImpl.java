package btlweb.mvc.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.ietf.jgss.Oid;

import btlweb.mvc.dao.OrderDao;
import btlweb.mvc.dao.impl.OrderDaoImpl;
import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;
import btlweb.mvc.service.CartItemService;
import btlweb.mvc.service.OrderDetailService;
import btlweb.mvc.service.OrderService;

public class OrderServiceImpl implements OrderService{
	private OrderDao _orderDao = new OrderDaoImpl();
	private OrderDetailService _orderDetailService = new OrderDetailServiceImpl();
	private CartItemService _cartItemService = new CartItemServiceImpl();

	@Override
	public void addOrder(String firstName, String lastName, String email, String phoneNumber, String city, String district, String streetAddress, String note, int userID) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		date = new java.sql.Date(calendar.getTimeInMillis());
		Order order = new Order(0, firstName, lastName, email, phoneNumber, city, district, streetAddress, note, date, 0, _cartItemService.getTotalMoney(userID), userID);
		int oid = _orderDao.addOrder(order);
		_orderDetailService.addOrderLine(_cartItemService.getCart(userID), oid);
		_cartItemService.checkOutComplete(userID);
		return;
	}
	
	public static void main(String[] args) {
		OrderService orderService = new OrderServiceImpl();
		orderService.addOrder("test", "test", "test", "test", "test", "test", "test", "test", 2);
	}
}
