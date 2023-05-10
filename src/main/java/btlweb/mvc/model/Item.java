package btlweb.mvc.model;


public class Item {
	private int id;
	private int userId;
	private Product product;
	private int size;
	private int num;
	private int price;
	
	public Item() {
		super();
	}

	public Item(int id, int userId, Product product, int size, int num, int price) {
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
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
	
	
}
