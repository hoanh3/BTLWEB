package btlweb.mvc.model;

import java.util.ArrayList;
import java.util.List;


public class Cart {
	List<Item> items;
	
	public Cart() {
		super();
		items = new ArrayList<>();
	}

	public Cart(List<Item> items) {
		super();
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public int getNumItemById(int id) {
		return this.getItemById(id).getNum();
	}
	
	public Item getItemById(int id) {
		for(Item item : items) {
			if(item.getProduct().getId() == id) {
				return item;
			}
		}
		return null;
	}
	
	//them vao cart
	public void addItem(Item newItem) {
		if(this.getItemById(newItem.getProduct().getId()) != null) {
			Item item = this.getItemById(newItem.getProduct().getId());
			item.setNum(item.getNum() + newItem.getNum());
		} else {
			items.add(newItem);
		}
	}
	
	public void changeNumById(int id, int diff) {
		Item it = this.getItemById(id);
		int newNum = it.getNum() + diff;
		if(newNum <= 0) {
			items.remove(it);
		} else {
			it.setNum(newNum);
		}
	}
	
	//xoa item
	public void removeItem(int id) {
		if(this.getItemById(id) != null) {
			items.remove(this.getItemById(id));
		}
	}
	
	public int getTotalMoney() {
		int money = 0;
		for(Item item : items) {
			money += item.getNum() * item.getPrice();
		}
		return money;
	}
	
	public int getCartSize() {
		return items.size();
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}
	
	
}
