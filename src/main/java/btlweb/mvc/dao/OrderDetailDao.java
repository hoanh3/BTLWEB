package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.Item;

public interface OrderDetailDao {
	public void addOrderLine(List<Item> items, int oid);

}
