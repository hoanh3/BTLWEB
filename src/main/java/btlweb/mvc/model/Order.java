package btlweb.mvc.model;

import java.util.Date;

public class Order {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String city;
	private String district;
	private String streetAddress;
	private String note;
	private Date orderDate;
	private int status;
	private int totalMoney;
	private int userId;
	
	public Order() {
		super();
	}

	public Order(int id, String firstName, String lastName, String email, String phoneNumber, String city,
			String district, String streetAddress, String note, Date orderDate, int status, int totalMoney,
			int userId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.district = district;
		this.streetAddress = streetAddress;
		this.note = note;
		this.orderDate = orderDate;
		this.status = status;
		this.totalMoney = totalMoney;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", city=" + city + ", district=" + district + ", streetAddress="
				+ streetAddress + ", note=" + note + ", orderDate=" + orderDate + ", status=" + status + ", totalMoney="
				+ totalMoney + ", userId=" + userId + "]";
	}
}
