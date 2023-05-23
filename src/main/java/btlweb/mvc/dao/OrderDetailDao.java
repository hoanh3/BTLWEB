package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.Item;
import btlweb.mvc.model.OrderDetail;

public interface OrderDetailDao {
	public void addOrderLine(List<Item> items, int oid);
	
	List<OrderDetail> getOrderDetailInOrder(int oid);
}
