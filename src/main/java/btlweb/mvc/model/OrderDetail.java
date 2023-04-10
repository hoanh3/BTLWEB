package btlweb.mvc.model;

public class OrderDetail {
	private int id;
	private int orderId;
	private int productId;
	private int price;
	private int num;
	private String productSizeName;
	
	public OrderDetail() {
		super();
	}

	public OrderDetail(int id, int orderId, int productId, int price, int num, String productSizeName) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.price = price;
		this.num = num;
		this.productSizeName = productSizeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getProductSizeName() {
		return productSizeName;
	}

	public void setProductSizeName(String productSizeName) {
		this.productSizeName = productSizeName;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", price=" + price
				+ ", num=" + num + ", productSizeName=" + productSizeName + "]";
	}
	
	
}
