package btlweb.mvc.dao;

import btlweb.mvc.model.Cart;
import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;

public interface OrderDao {
	public void addOrder(User user, Cart cart, Order order);
	public int getLastOrderId();
}