package btlweb.mvc.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.ietf.jgss.Oid;

import btlweb.mvc.dao.OrderDao;
import btlweb.mvc.dao.impl.OrderDaoImpl;
import btlweb.mvc.model.Item;
import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;
import btlweb.mvc.service.CartItemService;
import btlweb.mvc.service.OrderDetailService;
import btlweb.mvc.service.OrderService;
import btlweb.mvc.service.ProductAvaiService;

public class OrderServiceImpl implements OrderService{
	private OrderDao _orderDao = new OrderDaoImpl();
	private OrderDetailService _orderDetailService = new OrderDetailServiceImpl();
	private CartItemService _cartItemService = new CartItemServiceImpl();
	private ProductAvaiService _productAvaiService = new ProductAvaiServiceImpl();

	@Override
	public void addOrder(String firstName, String lastName, String email, String phoneNumber, String city, String district, String streetAddress, String note, int userID, int totalMoney) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		date = new java.sql.Date(calendar.getTimeInMillis());
		Order order = new Order(0, firstName, lastName, email, phoneNumber, city, district, streetAddress, note, date, 0, totalMoney, userID);
		int oid = _orderDao.addOrder(order);
		List<Item> items = _cartItemService.getCart(userID);
		_orderDetailService.addOrderLine(items, oid);
		_cartItemService.checkOutComplete(userID);
		_productAvaiService.updateProductAvailiability(items);
		return;
	}
	
	public static void main(String[] args) {
		OrderService orderService = new OrderServiceImpl();
//		orderService.addOrder("test", "test", "test", "test", "test", "test", "test", "test", 2);
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return _orderDao.getAll();
	}

	@Override
	public void updateStatus(int oid, int status) {
		// TODO Auto-generated method stub
		_orderDao.updateStatus(status, oid);
		return;
	}

	@Override
	public void delete(int oid) {
		// TODO Auto-generated method stub
		_orderDetailService.deleteByOrderId(oid);
		_orderDao.delete(oid);
		return;
	}
}
