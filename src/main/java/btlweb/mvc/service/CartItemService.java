package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Item;

public interface CartItemService {
	List<Item> getCart(int userId, String path, String pathGalery);
	void addItem(Item item);
	void removeItem(int id);
	void updateItem(Item item);
	
	int getTotalMoney(int userId);
	void checkOutComplete(int userId);
}
