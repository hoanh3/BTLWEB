package btlweb.mvc.dao;

import java.sql.Date;
import java.util.List;

import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;
import btlweb.mvc.model.dto.TopCate;

public interface OrderDao {
	public int addOrder(Order order);
	public List<Order> getAll();
	void updateStatus(int status, int oid);
	void delete(int oid);
	
	int getRevenueInWeek(Date date);
	int getNumberOfOrderInWeek(Date date);
	List<TopCate> getBestCategoryInWeek(Date date);
}