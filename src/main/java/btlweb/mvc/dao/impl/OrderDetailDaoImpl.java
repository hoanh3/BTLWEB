package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import btlweb.mvc.dao.OrderDao;
import btlweb.mvc.dao.OrderDetailDao;
import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Item;

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

}
