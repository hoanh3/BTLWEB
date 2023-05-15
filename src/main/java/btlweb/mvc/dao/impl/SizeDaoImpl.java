package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import btlweb.mvc.dao.SizeDao;
import btlweb.mvc.dbconnect.MySQLConnect;

public class SizeDaoImpl implements SizeDao{

	@Override
	public String getSizeName(int sid) {
		String query = "SELECT `size_name` FROM `size` "
				+ "WHERE `id` = ?;";
		String sizeName = "";
		try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, sid);
			ResultSet resultSet = pStatement.executeQuery();
			while(resultSet.next()) {
				sizeName = resultSet.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sizeName;
	}
	
	public static void main(String[] args) {
		SizeDao sizeDao = new SizeDaoImpl();
		System.out.println(sizeDao.getSizeName(1));
	}
}
