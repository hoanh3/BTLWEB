package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dao.OrderDao;
import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;

public class OrderDaoImpl implements OrderDao{

	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		int oid = 0;
		String query = "INSERT INTO `orders`\r\n"
				+ "(`first_name`,`last_name`,`email`,`phonenumber`,`city`,`district`,`street_address`,`note`,`order_date`,`status`,`total_money`,`user_id`)\r\n"
				+ "VALUES\r\n"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pStatement.setString(1, order.getFirstName());
			pStatement.setString(2, order.getLastName());
			pStatement.setString(3, order.getEmail());
			pStatement.setString(4, order.getPhoneNumber());
			pStatement.setString(5, order.getCity());
			pStatement.setString(6, order.getDistrict());
			pStatement.setString(7, order.getStreetAddress());
			pStatement.setString(8, order.getNote());
			pStatement.setDate(9, (Date) order.getOrderDate());
			pStatement.setLong(10, order.getStatus());
			pStatement.setLong(11, order.getTotalMoney());
			pStatement.setInt(12, order.getUserId());
			
			pStatement.execute();
			
			ResultSet resultSet = pStatement.getGeneratedKeys();
			while(resultSet.next()) {
				oid = resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi orderDao");
		}
		return oid;
	}

	public static void main(String[] args) {
		OrderDao orderDao = new OrderDaoImpl();
		System.out.println(orderDao.getAll());
	}

	@Override
	public List<Order> getAll() {
		List<Order> orders = new ArrayList<>();
		
		String query = "SELECT * FROM orders;";
		
		try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				String email = resultSet.getString(4);
				String phoneNumber = resultSet.getString(5);
				String city = resultSet.getString(6);
				String district = resultSet.getString(7);
				String streetAddress = resultSet.getString(8);
				String note = resultSet.getString(9);
				java.util.Date orderDate = resultSet.getDate(10);
				int status = resultSet.getInt(11);
				int totalMoney = resultSet.getInt(12);
				orders.add(new Order(id, firstName, lastName, email, phoneNumber, city, district, streetAddress, note, orderDate, status, totalMoney, id) );
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi get order");
		}
		
		return orders;
	}
}
