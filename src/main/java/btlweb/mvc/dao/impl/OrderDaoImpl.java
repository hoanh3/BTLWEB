package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import btlweb.mvc.dao.OrderDao;
import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Cart;
import btlweb.mvc.model.Order;
import btlweb.mvc.model.User;

public class OrderDaoImpl implements OrderDao{
	private Connection _connection = null;
	private PreparedStatement _pStatement = null;
	private ResultSet _resultSet = null;

	@Override
	public void addOrder(User user, Cart cart, Order order) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO `orders`\r\n"
				+ "(`first_name`,`last_name`,`email`,`phonenumber`,`city`,`district`,`street_address`,`note`,`order_date`,`status`,`total_money`,`user_id`)\r\n"
				+ "VALUES\r\n"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			_connection = MySQLConnect.getConnection();
			_pStatement = _connection.prepareStatement(query);
			_pStatement.setString(1, user.getFirstName());
			_pStatement.setString(2, user.getLastName());
			_pStatement.setString(3, user.getEmail());
			_pStatement.setString(4, user.getPhoneNumber());
			_pStatement.setString(5, user.getCity());
			_pStatement.setString(6, user.getDistrict());
			_pStatement.setString(7, user.getStreetAddress());
			_pStatement.setString(8, order.getNote());
			_pStatement.setDate(9, (Date) order.getOrderDate());
			_pStatement.setLong(10, order.getStatus());
			_pStatement.setLong(11, cart.getTotalMoney());
			_pStatement.setInt(12, user.getId());
			
			_pStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi orderDao");
		}
		return;
	}

	@Override
	public int getLastOrderId() {
		// TODO Auto-generated method stub
		int oid = 0;
		String query = "SELECT * FROM orders;";
		try {
			_connection = MySQLConnect.getConnection();
			_pStatement = _connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			_resultSet = _pStatement.getGeneratedKeys();
			while(_resultSet.next()) {
				oid = _resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi orderDao");
		}
		return oid;
	}

	public static void main(String[] args) {
		OrderDao orderDao = new OrderDaoImpl();
		System.out.println(orderDao.getLastOrderId());
	}
}
