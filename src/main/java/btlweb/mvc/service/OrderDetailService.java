package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Item;

public interface OrderDetailService {
	public void addOrderLine(List<Item> items, int oid);

}
