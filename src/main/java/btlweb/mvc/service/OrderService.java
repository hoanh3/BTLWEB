package btlweb.mvc.service;

import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;

public interface OrderService {
	public void addOrder(String firstName, String lastName, String email, String phoneNumber, String city, String district, String streetAddress, String note, int useID);
}