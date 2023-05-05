package btlweb.mvc.service;

import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;

public interface OrderService {
	public void addOrder(Order order);
	public int getLastOrderId();
}
