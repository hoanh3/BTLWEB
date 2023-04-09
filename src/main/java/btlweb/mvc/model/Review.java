package btlweb.mvc.model;

public class Review {
	private int id;
	private float rate;
	private String content;
	private int userId;
	private int productId;
	
	public Review() {
		super();
	}

	public Review(int id, float rate, String content, int userId, int productId) {
		super();
		this.id = id;
		this.rate = rate;
		this.content = content;
		this.userId = userId;
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rate=" + rate + ", content=" + content + ", userId=" + userId + ", productId="
				+ productId + "]";
	}
}
