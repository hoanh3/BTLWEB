package btlweb.mvc.dao.impl;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dao.CategoryDao;
import btlweb.mvc.model.Category;
import btlweb.mvc.dbconnect.MySQLConnect;

public class CategoryDaoImpl implements CategoryDao{
	
	Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		List<Category> categoryList = new ArrayList<>();

	    try {
	         conn = MySQLConnect.getConnection();
	        String sql = "SELECT * FROM category";
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery();

	        while (rs.next()) {
	            Category category = new Category();
	            category.setId(rs.getInt("id"));
	            category.setTitle( rs.getString("title"));
	            categoryList.add(category);   
	        }

	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return categoryList;
	}
	@Override
	public int getNumOfCategory() {
		// TODO Auto-generated method stub
		int count = 0;

	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "SELECT COUNT(*) FROM category";
	        stmt = conn.prepareStatement(sql);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return count;
	}

	@Override
	public List<Category> getCategoryInPage(int pageId) {
		// TODO Auto-generated method stub
		List<Category> categoryList = new ArrayList<>();
	    Connection conn = MySQLConnect.getConnection();
	    int recordsPerPage = 8;
	    int startRecord = (pageId - 1) * recordsPerPage;

	    try {
	        String query = "SELECT * FROM category ORDER BY id ASC LIMIT ? OFFSET ?";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setInt(1, startRecord);
	        stmt.setInt(2, recordsPerPage);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Category category = new Category();
	            category.setId(rs.getInt("id"));
	            category.setTitle(rs.getString("title"));
	            categoryList.add(category);
	        }

	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return categoryList;
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		Category category = null;
	    

	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "SELECT id, title FROM category WHERE id=?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, id);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            category = new Category();
	            category.setId(rs.getInt("id"));
	            category.setTitle(rs.getString("title"));
	        }
	    } catch (SQLException ex) {
	    	 ex.printStackTrace();
	    } 

	    return category;
	}

	@Override
	public int insertCategory(Category category) {
		// TODO Auto-generated method stub
		int result = 0;
	    
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "INSERT INTO category (title) VALUES (?)";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, category.getTitle());
	        result = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
	        conn = MySQLConnect.getConnection();
	        String query = "UPDATE category SET title = ? WHERE id = ?";
	        stmt = conn.prepareStatement(query);
	        stmt.setString(1, category.getTitle());
	        stmt.setInt(2, category.getId());
	        result = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return result;
	}
	@Override
	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		int result = 0;
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "DELETE FROM category WHERE id = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, id);
	        result = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

}
