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
	Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
	@Override
	public List<Galery> getGaleryByProductId(int productId) {
		// TODO Auto-generated method stub
		
	    List<Galery> galeryList = new ArrayList<>();

	    try {
	        conn = MySQLConnect.getConnection();
	        stmt = conn.prepareStatement("SELECT * FROM galery WHERE product_id=?");
	        stmt.setInt(1, productId);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	        	Galery galery = new Galery();
	            galery.setId( rs.getInt("id"));
	            galery.setProductId(rs.getInt("product_id"));
	            galery.setThumbnail(rs.getString("thumbnail"));

	            
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
	        conn = MySQLConnect.getConnection();
	        int pageSize = 8; 
		    int offset = (pageId - 1) * pageSize;
	        stmt = conn.prepareStatement("SELECT * FROM galery LIMIT ? OFFSET ?");
	        stmt.setInt(1, pageSize);
	        stmt.setInt(2, offset);
	        rs = stmt.executeQuery();

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
	    Connection conn = MySQLConnect.getConnection();
	    String query = "SELECT COUNT(*) FROM gallery";
	    try {
	    	stmt = conn.prepareStatement(query);
	        rs = stmt.executeQuery();
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
		Connection conn = MySQLConnect.getConnection();
	    int result = 0;
	    try {
	        stmt = conn.prepareStatement("INSERT INTO Galery(product_id, thumbnail) VALUES(?, ?)");
	        stmt.setInt(1, product.getProductId());
	        stmt.setString(2, product.getThumbnail());
	        result = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return result;
	}

	@Override
	public int updateGalery(Galery product) {
		// TODO Auto-generated method stub
		Connection conn = MySQLConnect.getConnection();
		int result = 0;
		try {
			stmt = conn.prepareStatement("UPDATE galery SET product_id = ?, thumbnail = ? WHERE id = ?");
			stmt.setInt(1, product.getProductId());
			stmt.setString(2, product.getThumbnail());
			stmt.setInt(3, product.getId());
			result = stmt.executeUpdate();
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
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "DELETE FROM galery WHERE id = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, id);
	        rows = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return rows;
	}

	@Override
	public Galery getGaleryById(int id) {
		// TODO Auto-generated method stub
		
		Galery galery = null;
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "SELECT * FROM galery WHERE id=?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, id);
	        rs = stmt.executeQuery();

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
