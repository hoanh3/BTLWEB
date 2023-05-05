package btlweb.mvc.model;


public class Item {
	private Product product;
	private int num;
	private int price;
	private int size;
	
	public Item() {
		super();
	}

	public Item(Product product, int num, int price, int size) {
		super();
		this.product = product;
		this.num = num;
		this.price = price;
		this.size = size;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
