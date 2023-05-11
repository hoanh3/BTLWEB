package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.Item;

public interface CartItemDao {
	List<Item> getCart(int userId);
	
	Item getItem(int userId, int productId);
	
	void addItem(Item item);
	void removeItem(int id);
	void updateItem(Item item);
	
	int getTotalMoney(int userId);
	
	void checkOutComplete(int userId);
}
