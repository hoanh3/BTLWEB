package btlweb.mvc.model.dto;

public class ProductSADto {
	private int productId;
	private int sizeId;
	private int avai;
	
	public ProductSADto(int productId, int sizeId, int avai) {
		super();
		this.productId = productId;
		this.sizeId = sizeId;
		this.avai = avai;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public int getAvai() {
		return avai;
	}

	public void setAvai(int avai) {
		this.avai = avai;
	}
	
	
}
