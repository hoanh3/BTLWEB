package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dao.GaleryDao;
import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Category;
import btlweb.mvc.model.Galery;
import btlweb.mvc.model.Product;

public class GaleryDaoImpl implements GaleryDao{
	Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
	@Override
	public List<Galery> getGaleryByProductId(int productId) {
		// TODO Auto-generated method stub
			List<Galery> galeries = new ArrayList<>();
			String sql = "SELECT *\r\n"
					+ "FROM `btl`.`galery`\r\n"
					+ "WHERE `galery`.`product_id` = ?;";
		    try {
		        conn = MySQLConnect.getConnection();
		        stmt = conn.prepareStatement(sql);
		        stmt.setInt(1, productId);
		        rs = stmt.executeQuery();
		        while (rs.next()) {
		            Galery galery = new Galery();
		            galery.setId(rs.getInt(1));
		            galery.setProductId(rs.getInt(2));
		            galery.setThumbnail(rs.getString(3));
		            galeries.add(galery);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } 
		    return galeries;
	}

	@Override
	public List<Galery> getGaleryInPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumOfGalery() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertGalery(Galery product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGalery(Galery product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGalery(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Galery getGaleryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static void main(String[] args) {
		GaleryDao galeryDao = new GaleryDaoImpl();
		List<Galery> galeries = galeryDao.getGaleryByProductId(1);
		for(Galery galery : galeries) {
			System.out.println(galery);
		}
	}
}
