package btlweb.mvc.dao.impl;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dao.GaleryDao;
import btlweb.mvc.model.Galery;
import btlweb.mvc.model.Product;
import btlweb.mvc.dbconnect.MySQLConnect;

public class GaleryDaoImpl implements GaleryDao{
	@Override
	public List<Galery> getGaleryByProductId(int productId) {
		// TODO Auto-generated method stub
		
	    List<Galery> galeryList = new ArrayList<>();

	    try {
	        Connection connection = MySQLConnect.getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM galery WHERE product_id=?");
	        preparedStatement.setInt(1, productId);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	        	Galery galery = new Galery();
	            galery.setId( resultSet.getInt("id"));
	            galery.setProductId(resultSet.getInt("product_id"));
	            galery.setThumbnail(resultSet.getString("thumbnail"));

	            
	            galeryList.add(galery);
	        }
	    }  catch (SQLException e) {
	            e.printStackTrace();
	        
	    }

	    return galeryList;
	}

	@Override
	public List<Galery> getGaleryInPage(int pageId) {
		// TODO Auto-generated method stub
		List<Galery> galeryList = new ArrayList<>();
	    

	    try {
	    	Connection connection = MySQLConnect.getConnection();
	        int pageSize = 8; 
		    int offset = (pageId - 1) * pageSize;
		    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM galery LIMIT ? OFFSET ?");
		    preparedStatement.setInt(1, pageSize);
		    preparedStatement.setInt(2, offset);
		    ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	        	Galery galery = new Galery();
	            galery.setId( rs.getInt("id"));
	            galery.setProductId(rs.getInt("product_id"));
	            galery.setThumbnail(rs.getString("thumbnail"));
	            galeryList.add(galery);
	        }
	    } catch (SQLException ex) {
	        System.out.println("Error getting galery in page: " + ex.getMessage());
	    } 

	    return galeryList;
	}

	@Override
	public int getNumOfGalery() {
		// TODO Auto-generated method stub
		int count = 0;
	    String query = "SELECT COUNT(*) FROM gallery";
	    try {
	    	Connection connection = MySQLConnect.getConnection();
	    	PreparedStatement preparedStatement = connection.prepareStatement(query);
	    	ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (SQLException ex) {
	        System.out.println("Error: " + ex.getMessage());
	    } 
	    return count;
	}

	@Override
	public int insertGalery(Galery product) {
		// TODO Auto-generated method stub
	    int result = 0;
	    try {
	    	Connection connection = MySQLConnect.getConnection();
	    	PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Galery(product_id, thumbnail) VALUES(?, ?)");
	        preparedStatement.setInt(1, product.getProductId());
	        preparedStatement.setString(2, product.getThumbnail());
	        result = preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return result;
	}

	@Override
	public int updateGalery(Galery product) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE galery SET product_id = ?, thumbnail = ? WHERE id = ?");
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getThumbnail());
			preparedStatement.setInt(3, product.getId());
			result = preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteGalery(int id) {
		// TODO Auto-generated method stub
		int rows = 0;
		String sql = "DELETE FROM galery WHERE id = ?";
	    try {
	    	Connection connection = MySQLConnect.getConnection();
	    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    	preparedStatement.setInt(1, id);
	        rows = preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return rows;
	}

	@Override
	public Galery getGaleryById(int id) {
		// TODO Auto-generated method stub
		
		Galery galery = null;
		String sql = "SELECT * FROM galery WHERE id=?";
	    try {
	    	Connection connection = MySQLConnect.getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1, id);
	        ResultSet rs = preparedStatement.executeQuery();

	        if (rs.next()) {
	        	galery = new Galery();
	            galery.setId( rs.getInt("id"));
	            galery.setProductId(rs.getInt("product_id"));
	            galery.setThumbnail(rs.getString("thumbnail"));
	            
	        }
	        

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } 

	    return galery;
	}

}
