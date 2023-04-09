package btlweb.mvc.model;

import java.util.Date;

public class Product {
	private int id;
	private String title;
	private float rate;
	private int size;
	private int price;
	private int discount;
	private String thumbnail;
	private String description;
	private Date createdAt;
	private Date updatedAt;
	private Category category;
	
	public Product() {
		super();
	}

	public Product(int id, String title, float rate, int size, int price, int discount, String thumbnail,
			String description, Date createdAt, Date updatedAt, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.rate = rate;
		this.size = size;
		this.price = price;
		this.discount = discount;
		this.thumbnail = thumbnail;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", rate=" + rate + ", size=" + size + ", price=" + price
				+ ", discount=" + discount + ", thumbnail=" + thumbnail + ", description=" + description
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", category=" + category + "]";
	}
}
