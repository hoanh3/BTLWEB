package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import btlweb.mvc.dao.OrderDao;
import btlweb.mvc.dao.OrderDetailDao;
import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Item;
import btlweb.mvc.model.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDao{

	@Override
	public void addOrderLine(List<Item> items, int oid) {
		String query = "INSERT INTO `order_details`\r\n"
				+ "(`order_id`,`product_id`,`product_size_id`,`price`,`num`)\r\n"
				+ "VALUES\r\n"
				+ "(?, ?, ?, ?, ?);";
		try {
		 	Connection connection  = MySQLConnect.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(query);
			connection.setAutoCommit(false);
			for(Item item : items) {
				pStatement.setInt(1, oid);
				pStatement.setInt(2, item.getProduct().getId());
				pStatement.setInt(3, item.getSize());
				pStatement.setInt(4, item.getPrice());
				pStatement.setInt(5, item.getNum());
				pStatement.addBatch();
			}
			pStatement.executeBatch();
			connection.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("loi orderDetailDao");
		}
		return;
	}

	@Override
	public List<OrderDetail> getOrderDetailInOrder(int oid) {
		List<OrderDetail> orderDetails = new ArrayList<>();
		String query = "SELECT * FROM order_details "
				+ "WHERE order_id = ?;";
		try {
		 	Connection connection  = MySQLConnect.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, oid);
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				int orderId = resultSet.getInt(2);
				int productId = resultSet.getInt(3);
				int price = resultSet.getInt(5);
				int num = resultSet.getInt(6);
				String productSizeName = resultSet.getString(4);
				orderDetails.add(new OrderDetail(id, orderId, productId, price, num, productSizeName));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("loi orderDetailDao");
		}
		return orderDetails;
	}
	
	public static void main(String[] args) {
		OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
		System.out.println(orderDetailDao.getOrderDetailInOrder(8));
	}

}
