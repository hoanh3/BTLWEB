package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dao.CartItemDao;
import btlweb.mvc.dao.ProductDao;
import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Category;
import btlweb.mvc.model.Item;
import btlweb.mvc.model.Product;

public class CartItemDaoImpl implements CartItemDao{

	@Override
	public List<Item> getCart(int userId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Item> items = new ArrayList<>();
		String query = "SELECT *  FROM `cart_item`"
				+ "where `user_id` = ?;";

	    try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt(1);
	        	int nuserId = resultSet.getInt(2);
	        	int productId = resultSet.getInt(3);
	        	int size = resultSet.getInt(4);
	        	int num = resultSet.getInt(5);
	        	int price = resultSet.getInt(6);
	        	
	        	items.add(new Item(id, userId, new Product(productId), size, num, price));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return items;
	}

	@Override
	public void addItem(Item item) {
		String query = "INSERT INTO `cart_item` "
				+ "(`user_id`,`product_id`,`size_id`,`num`,`price`) "
				+ "VALUES "
				+ "(?,?,?,?,?);";
		try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, item.getUserId());
			preparedStatement.setInt(2, item.getProduct().getId());
			preparedStatement.setInt(3, item.getSize());
			preparedStatement.setInt(4, item.getNum());
			preparedStatement.setInt(5, item.getPrice());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("loi CartItemDao add");
		}
		return;
	}

	@Override
	public void removeItem(int id) {
		String query = "DELETE FROM `cart_item`\r\n"
				+ "WHERE `id` = ?;";
		try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi CartItemDao");
		}
		return;
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		String query = "UPDATE `btl`.`cart_item`\r\n"
				+ "SET\r\n"
				+ "`num` = ?\r\n"
				+ "WHERE `user_id` = ? AND  `product_id` = ? AND `size_id` = ?;\r\n";
		try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, item.getNum());
			preparedStatement.setInt(2, item.getUserId());
			preparedStatement.setInt(3, item.getProduct().getId());
			preparedStatement.setInt(4, item.getSize());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("loi CartItemDao update");
		}
		return;
	}

	@Override
	public int getTotalMoney(int userId) {
		int totalMoney = 0;
		String query = "SELECT SUM(`price`) FROM `cart_item`"
				+ "WHERE `user_id` = ?;";
		try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				totalMoney = resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi CartItemDao");
		}
		return totalMoney;
	}

	@Override
	public void checkOutComplete(int userId) {
		String query = "DELETE FROM `cart_item`\r\n"
				+ "WHERE `user_id` = ?;";
		try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi CartItemDao");
		}
		return;
	}

	public static void main(String[] args) {
		CartItemDao cartItemDao = new CartItemDaoImpl();
		ProductDao productDao = new ProductDaoImpl();
		cartItemDao.addItem(new Item(0, 3, productDao.getProductById(7), 1, 1, 249000));
	}

	@Override
	public Item getItem(int userId, int productId) {
		Item item = null;
		String query = "SELECT *  FROM `cart_item`"
				+ "where `user_id` = ? and `product_id` = ?;";

	    try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, productId);
			ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt(1);
	        	int nuserId = resultSet.getInt(2);
	        	int nproductId = resultSet.getInt(3);
	        	int size = resultSet.getInt(4);
	        	int num = resultSet.getInt(5);
	        	int price = resultSet.getInt(6);
	        	
	        	item = new Item(0, userId, new Product(productId), size, num, price);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return item;
	}

	@Override
	public void deleteItemByUserId(int userId) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM `cart_item`\r\n"
				+ "WHERE `user_id` = ?;";
		try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi CartItemDao");
		}
		return;
	}
	
}
