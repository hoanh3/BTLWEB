package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;

public interface OrderDao {
	public int addOrder(Order order);
	public List<Order> getAll();
}