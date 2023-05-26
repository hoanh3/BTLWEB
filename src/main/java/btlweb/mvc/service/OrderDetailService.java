package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Item;
import btlweb.mvc.model.dto.OrderDetailDto;

public interface OrderDetailService {
	public void addOrderLine(List<Item> items, int oid);

	List<OrderDetailDto> getOrderDetailInOrder(int oid);
	
	void deleteByOrderId(int oid);
}
