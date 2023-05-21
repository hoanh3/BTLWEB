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
	
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		List<Category> categoryList = new ArrayList<>();
		String query = "SELECT * FROM category";

	    try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            Category category = new Category();
	            category.setId(resultSet.getInt("id"));
	            category.setTitle(resultSet.getString("title"));
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
		String query = "SELECT COUNT(*) FROM category";

	    try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            count = resultSet.getInt(1);
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
		String query = "SELECT * FROM category ORDER BY id ASC LIMIT ? OFFSET ?";

	    try {
		    Connection conn = MySQLConnect.getConnection();
		    int recordsPerPage = 8;
		    int startRecord = (pageId - 1) * recordsPerPage;
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setInt(1, recordsPerPage);
	        preparedStatement.setInt(2, startRecord);
	        ResultSet rs = preparedStatement.executeQuery();

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
		String query = "SELECT id, title FROM category WHERE id=?";
	    

	    try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, id);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            category = new Category();
	            category.setId(resultSet.getInt("id"));
	            category.setTitle(resultSet.getString("title"));
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
		String query = "INSERT INTO category (title) VALUES (?)";
	    
	    try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, category.getTitle());
	        result = preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		int result = 0;
		String query = "UPDATE category SET title = ? WHERE id = ?";
		try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, category.getTitle());
	        preparedStatement.setInt(2, category.getId());
	        result = preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return result;
	}
	@Override
	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		int result = 0;
		String query = "DELETE FROM category WHERE id = ?";
	    try {
	    	Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, id);
	        result = preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	public static void main(String[] args) {
		CategoryDao categoryDao = new CategoryDaoImpl();
		System.out.println(categoryDao.getCategoryById(1));
		List<Category> categories = categoryDao.getCategoryInPage(1);
		System.out.println(categories.size());
		for(Category category : categories) {
			System.out.println(category);
		}
	}
}
