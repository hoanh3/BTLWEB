package btlweb.mvc.model.dto;

import btlweb.mvc.model.Product;

public class CartSN {
	private int id;
	private int userId;
	private Product product;
	private String size;
	private int num;
	private int price;
	
	public CartSN() {
		super();
	}

	public CartSN(int id, int userId, Product product, String size, int num, int price) {
		super();
		this.id = id;
		this.userId = userId;
		this.product = product;
		this.size = size;
		this.num = num;
		this.price = price;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", userId=" + userId + ", product=" + product + ", size=" + size + ", num=" + num
				+ ", price=" + price + "]";
	}
	
	
}
