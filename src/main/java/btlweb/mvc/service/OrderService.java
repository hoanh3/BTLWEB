package btlweb.mvc.service;

import btlweb.mvc.model.Cart;
import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;

public interface OrderService {
	public void addOrder(User user, Cart cart, Order order);
	public int getLastOrderId();
}
