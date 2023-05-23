package btlweb.mvc.model.dto;

public class OrderDetailDto {
	private String productName;
	private String thumnailProduct;
	private int discount;
	private int price;
	private int num;
	private String sizeName;
	
	
	public OrderDetailDto(String productName, String thumnailProduct, int discount, int price, int num,
			String sizeName) {
		super();
		this.productName = productName;
		this.thumnailProduct = thumnailProduct;
		this.discount = discount;
		this.price = price;
		this.num = num;
		this.sizeName = sizeName;
	}
	
	public String getThumnailProduct() {
		return thumnailProduct;
	}
	public void setThumnailProduct(String thumnailProduct) {
		this.thumnailProduct = thumnailProduct;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
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
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	@Override
	public String toString() {
		return "OrderDetailDto [productName=" + productName + ", discount=" + discount + ", price=" + price + ", num="
				+ num + ", sizeName=" + sizeName + "]";
	}
	
	
}
