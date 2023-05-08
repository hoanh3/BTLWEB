package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

import btlweb.mvc.dao.ProductSizeAvaliabitityDao;
import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Item;

public class ProductSizeAvailiabilityDaoImpl implements ProductSizeAvaliabitityDao{
	Connection _connection = null;
    PreparedStatement _pStatement = null;
    ResultSet _resultSet = null;

	@Override
	public void updateProductAvailiability(List<Item> items) {
		// TODO Auto-generated method stub
		String query = "UPDATE `btl`.`product_size`"
				+ "SET"
				+ "`size_availability` = ?"
				+ "WHERE `product_id` = ? AND `size_id` = ?;";
		try {
			_connection = MySQLConnect.getConnection();
			_pStatement = _connection.prepareStatement(query);
			_connection.setAutoCommit(false);
			for(Item item : items) {
				_pStatement.setInt(1, item.getNum());
				_pStatement.setInt(2, item.getProductId());
				_pStatement.setInt(3, item.getSize());
				_pStatement.addBatch();
			}
			_pStatement.executeBatch();
			_connection.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public int getSizeAvaiability(int productId, int sizeId) {
		// TODO Auto-generated method stub
		int sizeAvai = 0;
		String query = "SELECT * FROM `product_size`"
				+ "WHERE `product_id` = ? AND `size_id` = ?;";
		try {
			_connection = MySQLConnect.getConnection();
			_pStatement = _connection.prepareStatement(query);
			_pStatement.setInt(1, productId);
			_pStatement.setInt(2, sizeId);
			_resultSet = _pStatement.executeQuery();
			while(_resultSet.next()) {
				sizeAvai = _resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sizeAvai;
	}

}
