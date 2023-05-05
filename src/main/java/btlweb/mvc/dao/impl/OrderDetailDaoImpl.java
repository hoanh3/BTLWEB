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
	private Connection _connection = null;
	private PreparedStatement _pStatement = null;
	private ResultSet _resultSet = null;

	@Override
	public void addOrderLine(List<Item> items, int oid) {
		String query = "INSERT INTO `order_details`\r\n"
				+ "(`order_id`,`product_id`,`product_size_id`,`price`,`num`)\r\n"
				+ "VALUES\r\n"
				+ "(?, ?, ?, ?, ?);";
		try {
			_connection = MySQLConnect.getConnection();
			_pStatement = _connection.prepareStatement(query);
			_connection.setAutoCommit(false);
			for(Item item : items) {
				_pStatement.setInt(1, oid);
				_pStatement.setInt(2, item.getProduct().getId());
				_pStatement.setInt(3, item.getSize());
				_pStatement.setInt(4, item.getPrice());
				_pStatement.setInt(5, item.getNum());
				_pStatement.addBatch();
			}
			_pStatement.executeBatch();
			_connection.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi orderDetailDao");
		}
		return;
	}

}
