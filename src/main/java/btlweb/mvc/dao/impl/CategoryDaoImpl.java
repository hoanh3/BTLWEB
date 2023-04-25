package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dao.CategoryDao;
import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Category;
import btlweb.mvc.model.Product;

public class CategoryDaoImpl implements CategoryDao{

	Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		List<Category> categories = new ArrayList<>();
		String sql = "SELECT `category`.`id`,\r\n"
				+ "    `category`.`title`\r\n"
				+ "FROM `btl`.`category`;";
	    try {
	        conn = MySQLConnect.getConnection();
	        stmt = conn.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            Category category = new Category();
	            category.setId(rs.getInt("id"));
	            category.setTitle(rs.getString("title"));
	            categories.add(category);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return categories;
	}

	@Override
	public int getNumOfCategory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Category> getCategoryInPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
