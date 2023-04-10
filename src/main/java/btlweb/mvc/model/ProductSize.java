package btlweb.mvc.model;

public class ProductSize {
	private int id;
	private int sizeId;
	private int sizeAvailability;
	private int productId;
	
	public ProductSize() {
		super();
	}

	public ProductSize(int id, int sizeId, int sizeAvailability, int productId) {
		super();
		this.id = id;
		this.sizeId = sizeId;
		this.sizeAvailability = sizeAvailability;
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public int getSizeAvailability() {
		return sizeAvailability;
	}

	public void setSizeAvailability(int sizeAvailability) {
		this.sizeAvailability = sizeAvailability;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductSize [id=" + id + ", sizeId=" + sizeId + ", sizeAvailability=" + sizeAvailability
				+ ", productId=" + productId + "]";
	}
}
