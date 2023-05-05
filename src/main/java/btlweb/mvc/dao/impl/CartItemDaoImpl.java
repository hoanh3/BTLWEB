package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dao.CartItemDao;
import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Category;
import btlweb.mvc.model.Item;

public class CartItemDaoImpl implements CartItemDao{
	private Connection _connection = null;
	private PreparedStatement _pStatement = null;
	private ResultSet _resultSet = null;

	@Override
	public List<Item> getCart(int userId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Item> items = new ArrayList<>();
		String query = "SELECT * FROM `cart_item` WHERE `user_id` = ?";

	    try {
	    	_connection = MySQLConnect.getConnection();
			_pStatement = _connection.prepareStatement(query);
			_pStatement.setInt(1, userId);
			_resultSet = _pStatement.executeQuery();

	        while (_resultSet.next()) {
	        	int id = _resultSet.getInt(1);
	        	int nuserId = _resultSet.getInt(2);
	        	int productId = _resultSet.getInt(3);
	        	int size = _resultSet.getInt(4);
	        	int num = _resultSet.getInt(5);
	        	int price = _resultSet.getInt(6);
	        	
	        	items.add(new Item(id, userId, productId, size, num, price));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return items;
	}

	@Override
	public void addItem(Item item) {
		String query = "INSERT INTO `cart_item`\r\n"
				+ "(`user_id`,`product_id`,`size_id`,`num`,`price`)\r\n"
				+ "VALUES\r\n"
				+ "(?, ?, ?, ?, ?);";
		try {
			_connection = MySQLConnect.getConnection();
			_pStatement = _connection.prepareStatement(query);
			_pStatement.setInt(1, item.getUserId());
			_pStatement.setInt(2, item.getProductId());
			_pStatement.setInt(3, item.getSize());
			_pStatement.setInt(4, item.getNum());
			_pStatement.setInt(5, item.getPrice());
			
			_pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi CartItemDao");
		}
		return;
	}

	@Override
	public void removeItem(int id) {
		String query = "DELETE FROM `cart_item`\r\n"
				+ "WHERE `id` = ?;";
		try {
			_connection = MySQLConnect.getConnection();
			_pStatement = _connection.prepareStatement(query);
			_pStatement.setInt(1, id);
			
			_pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi CartItemDao");
		}
		return;
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		String query = "UPDATE `cart_item`"
				+ "SET"
				+ "`num` = ?,"
				+ "WHERE `id` = ?;";
		try {
			_connection = MySQLConnect.getConnection();
			_pStatement = _connection.prepareStatement(query);
			_pStatement.setInt(1, item.getNum());
			_pStatement.setInt(2, item.getId());
			
			_pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi CartItemDao");
		}
		return;
	}

	@Override
	public int getTotalMoney(int userId) {
		int totalMoney = 0;
		String query = "SELECT SUM(`price`) FROM `cart_item`"
				+ "WHERE `user_id` = ?;";
		try {
			_connection = MySQLConnect.getConnection();
			_pStatement = _connection.prepareStatement(query);
			_pStatement.setInt(1, userId);
			
			_resultSet = _pStatement.executeQuery();
			
			while(_resultSet.next()) {
				totalMoney = _resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi CartItemDao");
		}
		return totalMoney;
	}

}
