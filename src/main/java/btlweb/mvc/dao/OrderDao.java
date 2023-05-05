package btlweb.mvc.dao;

import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;

public interface OrderDao {
	public void addOrder(Order order);
	public int getLastOrderId();
}