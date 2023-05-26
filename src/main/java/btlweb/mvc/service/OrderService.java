package btlweb.mvc.service;

import java.sql.Date;
import java.util.List;

import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;
import btlweb.mvc.model.dto.TopCate;

public interface OrderService {
	public void addOrder(String firstName, String lastName, String email, String phoneNumber, String city, String district, String streetAddress, String note, int useID, int totalMoney);
	public List<Order> getAll();
	
	void updateStatus(int oid, int status);
	void delete(int oid);
	int getRevenueInWeek();
	int getNumberOfOrderInWeek();
	List<TopCate> getBestCategoryInWeek();
}
