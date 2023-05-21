package btlweb.mvc.model.dto;

import java.util.Date;
import java.util.List;

import btlweb.mvc.model.Category;
import btlweb.mvc.model.Galery;

public class ProductDto {
	private String title;
	private int price;
	private int discount;
	private int size;
	private int avai;
	private String thumbnail;
	private String description;
	private int category;
	public ProductDto(String title, int price, int discount, int size, int avai, String thumbnail, String description,
			int category) {
		super();
		this.title = title;
		this.price = price;
		this.discount = discount;
		this.size = size;
		this.avai = avai;
		this.thumbnail = thumbnail;
		this.description = description;
		this.category = category;
	}
	public ProductDto() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getAvai() {
		return avai;
	}
	public void setAvai(int avai) {
		this.avai = avai;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "ProductDto [title=" + title + ", price=" + price + ", discount=" + discount + ", size=" + size
				+ ", avai=" + avai + ", thumbnail=" + thumbnail + ", description=" + description + ", category="
				+ category + "]";
	}

	
}
