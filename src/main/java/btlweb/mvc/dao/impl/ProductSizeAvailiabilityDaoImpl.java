package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

import btlweb.mvc.dao.ProductSizeAvaliabitityDao;
import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Item;
import btlweb.mvc.model.ProductSize;
import btlweb.mvc.service.ProductService;
import btlweb.mvc.service.impl.ProductServiceImpl;

public class ProductSizeAvailiabilityDaoImpl implements ProductSizeAvaliabitityDao{

	@Override
	public void updateProductAvailiability(List<Item> items) {
		// TODO Auto-generated method stub
		String query = "UPDATE `btl`.`product_size` "
				+ "SET "
				+ "`size_availability` = ? "
				+ "WHERE `product_id` = ? AND `size_id` = ?;";
		try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			for(Item item : items) {
				pStatement.setInt(1, item.getNum());
				pStatement.setInt(2, item.getProduct().getId());
				pStatement.setInt(3, item.getSize());
				pStatement.addBatch();
			}
			pStatement.executeBatch();
			connection.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi update avai product dao");
			e.printStackTrace();
		}
	}

	@Override
	public int getSizeAvaiability(int productId, int sizeId) {
		// TODO Auto-generated method stub
		int sizeAvai = 0;
		String query = "SELECT `size_availability` FROM `product_size`"
				+ "WHERE `product_id` = ? AND `size_id` = ?;";
		try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, productId);
			pStatement.setInt(2, sizeId);
			ResultSet resultSet = pStatement.executeQuery();
			while(resultSet.next()) {
				sizeAvai = resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sizeAvai;
	}
	
	public static void main(String[] args) {
		ProductSizeAvaliabitityDao productSizeAvaliabitityDao = new ProductSizeAvailiabilityDaoImpl();
		ProductService productService = new ProductServiceImpl();
		List<Item> items = new ArrayList<>();
		items.add(new Item(0, 2, productService.getProductById(1), 1, 9, 59000));
		items.add(new Item(0, 2, productService.getProductById(1), 2, 9, 59000));
		productSizeAvaliabitityDao.updateProductAvailiability(items);
	}

	@Override
	public void addProductAvai(ProductSize productSize) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO `product_size` "
				+ "(`size_id`,`size_availability`,`product_id`) "
				+ "VALUES "
				+ "(?,?,?);";
		try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, productSize.getSizeId());
			pStatement.setInt(2, productSize.getSizeAvailability());
			pStatement.setInt(3, productSize.getProductId());
			pStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi product avai szie dao");
		}
		return ;
	}

	@Override
	public void update(ProductSize productSize) {
		// TODO Auto-generated method stub
	    try {
	        Connection connection = MySQLConnect.getConnection();
	        String sql = "UPDATE `product_size` "
	        		+ "SET "
	        		+ "`size_id` = ?, "
	        		+ "`size_availability` = ?, "
	        		+ "`product_id` = ? "
	        		+ "WHERE `id` = ?;";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setInt(1, productSize.getSizeId());
	        statement.setInt(2, productSize.getSizeAvailability());
	        statement.setInt(3, productSize.getProductId());
	        statement.setInt(4, productSize.getId());
	        statement.execute();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } 
	    return ;
	}

	@Override
	public void deleteByProductId(int pid) {
		String query = "DELETE FROM `product_size` "
				+ "WHERE `product_id` = ?;";
		try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, pid);
			pStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi product avai szie dao");
		}
		return ;
	}
}
