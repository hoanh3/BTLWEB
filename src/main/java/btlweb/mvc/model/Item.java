package btlweb.mvc.model;


public class Item {
	private int id;
	private int userId;
	private int productId;
	private int size;
	private int num;
	private int price;
	
	public Item() {
		super();
	}

	public Item(int id, int userId, int productId, int size, int num, int price) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
