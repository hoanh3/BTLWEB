package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
		System.out.println(orderDao.addOrder(new Order(0, "test", "test", "test", "test", "test", "test", "test", "test", new Date(1200000), 0, 10, 2)));
	}
}
