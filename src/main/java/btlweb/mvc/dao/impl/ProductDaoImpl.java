package btlweb.mvc.dao.impl;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;

import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.dao.ProductDao;
import btlweb.mvc.model.Product;
import btlweb.mvc.model.Category;

public class ProductDaoImpl implements ProductDao{
	Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		String sql = "SELECT P.*, C.title FROM product AS P, category AS C WHERE P.category_id = C.id ";
	    try {
	        conn = MySQLConnect.getConnection();
	        stmt = conn.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            Product product = new Product();
	            product.setId(rs.getInt("id"));
	            product.setTitle(rs.getString("title"));
	            product.setRate(rs.getFloat("rate"));
	            product.setPrice(rs.getInt("price"));
	            product.setDiscount(rs.getInt("discount"));
	            product.setThumbnail(rs.getString("thumbnail"));
	            product.setDescription(rs.getString("description"));
	            product.setCreatedAt(rs.getDate("create_at"));
	            product.setUpdatedAt(rs.getDate("update_at"));
	            product.setCategory(new Category(rs.getInt("category_id"), rs.getString("title")));
	            productList.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return productList;
	}

	@Override
	public List<Product> getTopSale() {
		// TODO Auto-generated method stub
		 List<Product> productList = new ArrayList<>();
		String sql = "SELECT P.*, C.title " +
                "FROM product AS P, category AS C " +
				"WHERE P.category_id = C.id " +
                "ORDER BY rate DESC " +
                "LIMIT 10";
   try {
       conn = MySQLConnect.getConnection();
       stmt = conn.prepareStatement(sql);
       rs = stmt.executeQuery();
       while (rs.next()) {
    	   Product product = new Product();
           product.setId(rs.getInt("id"));
           product.setTitle(rs.getString("title"));
           product.setRate(rs.getFloat("rate"));
           product.setPrice(rs.getInt("price"));
           product.setDiscount(rs.getInt("discount"));
           product.setThumbnail(rs.getString("thumbnail"));
           product.setDescription(rs.getString("description"));
           product.setCreatedAt(rs.getDate("create_at"));
           product.setUpdatedAt(rs.getDate("update_at"));
           product.setCategory(new Category(rs.getInt("category_id"), rs.getString("title")));
           productList.add(product);
       }
   } catch (SQLException e) {
       e.printStackTrace();
   } 
   return productList;
}
	@Override
	public List<Product> getBestSeller() {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
	    String sql = "SELECT P.*, C.title " +
	                 "FROM product AS P, category AS C " +
	                 "WHERE P.category_id = C.id " +
	                 "ORDER BY sales DESC " +
	                 "LIMIT 10";
	    try {
	        conn = MySQLConnect.getConnection();
	        stmt = conn.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	        	Product product = new Product();
	            product.setId(rs.getInt("id"));
	            product.setTitle(rs.getString("title"));
	            product.setRate(rs.getFloat("rate"));
	            product.setPrice(rs.getInt("price"));
	            product.setDiscount(rs.getInt("discount"));
	            product.setThumbnail(rs.getString("thumbnail"));
	            product.setDescription(rs.getString("description"));
	            product.setCreatedAt(rs.getDate("create_at"));
	            product.setUpdatedAt(rs.getDate("update_at"));
	            product.setCategory(new Category(rs.getInt("category_id"), rs.getString("title")));
	            productList.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return productList;
	}

	@Override
	public List<Product> searchProductByName(String name) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
	    String sql = "SELECT P.*, C.title FROM product AS P, category AS C WHERE P.category_id = C.id AND P.name LIKE ?";
	    try {
	        conn = MySQLConnect.getConnection();
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, "%" + name + "%");
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	        	Product product = new Product();
	            product.setId(rs.getInt("id"));
	            product.setTitle(rs.getString("title"));
	            product.setRate(rs.getFloat("rate"));
	            product.setPrice(rs.getInt("price"));
	            product.setDiscount(rs.getInt("discount"));
	            product.setThumbnail(rs.getString("thumbnail"));
	            product.setDescription(rs.getString("description"));
	            product.setCreatedAt(rs.getDate("create_at"));
	            product.setUpdatedAt(rs.getDate("update_at"));
	            product.setCategory(new Category(rs.getInt("category_id"), rs.getString("title")));
	            products.add(product);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } 
	    
	    return products;
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		Product product = null;
	    String query = "SELECT P.*, C.title FROM product AS P, category AS C WHERE id = ? AND P.category_id = C.id";
	    try {	
	    	conn = MySQLConnect.getConnection();
	    	stmt = conn.prepareStatement(query); 
	    	stmt.setInt(1, productId);
	    	rs = stmt.executeQuery();
	    	while (rs.next()) {
	            
	                product = new Product();
	                product.setId(rs.getInt("id"));
		            product.setTitle(rs.getString("title"));
		            product.setRate(rs.getFloat("rate"));
		            product.setPrice(rs.getInt("price"));
		            product.setDiscount(rs.getInt("discount"));
		            product.setThumbnail(rs.getString("thumbnail"));
		            product.setDescription(rs.getString("description"));
		            product.setCreatedAt(rs.getDate("create_at"));
		            product.setUpdatedAt(rs.getDate("update_at"));
		            product.setCategory(new Category(rs.getInt("category_id"), rs.getString("title")));
	            
	        }
	    }
	     catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return product;
	
	}
	

	@Override
	public List<Product> getProductByCatId(String catId) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "SELECT P.*, C.title FROM Product AS P, category AS C WHERE category_id=? AND P.category_id = C.id";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, catId);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	        	Product product = new Product();
	            product.setId(rs.getInt("id"));
	            product.setTitle(rs.getString("title"));
	            product.setRate(rs.getFloat("rate"));
	            product.setPrice(rs.getInt("price"));
	            product.setDiscount(rs.getInt("discount"));
	            product.setThumbnail(rs.getString("thumbnail"));
	            product.setDescription(rs.getString("description"));
	            product.setCreatedAt(rs.getDate("create_at"));
	            product.setUpdatedAt(rs.getDate("update_at"));
	            product.setCategory(new Category(rs.getInt("category_id"), rs.getString("title")));
	            productList.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return productList;
	}

	@Override
	public int getNumberOfProduct() {
		// TODO Auto-generated method stub
		int count = 0;
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "SELECT COUNT(*) as count FROM Product";
	        stmt = conn.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt("count");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return count;
	}

	@Override
	public List<Product> getProductInPage(int pageId) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
	    int pageSize = 8; 
	    int offset = (pageId - 1) * pageSize;
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "SELECT P.*, C.title FROM product AS P, category AS C WHERE P.category_id = C.id LIMIT ? OFFSET ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, pageSize);
	        stmt.setInt(2, offset);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	        	Product product = new Product();
	            product.setId(rs.getInt("id"));
	            product.setTitle(rs.getString("title"));
	            product.setRate(rs.getFloat("rate"));
	            product.setPrice(rs.getInt("price"));
	            product.setDiscount(rs.getInt("discount"));
	            product.setThumbnail(rs.getString("thumbnail"));
	            product.setDescription(rs.getString("description"));
	            product.setCreatedAt(rs.getDate("create_at"));
	            product.setUpdatedAt(rs.getDate("update_at"));
	            product.setCategory(new Category(rs.getInt("category_id"), rs.getString("title")));
	            productList.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return productList;
	}
	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		int result = 0;
	    try {
	        conn = MySQLConnect.getConnection();
	        String query = "INSERT INTO product (title, rate, price, discount, thumbnail, description, create_at, update_at, category_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        stmt = conn.prepareStatement(query);
	        stmt.setString(1, product.getTitle());
	        stmt.setFloat(2, product.getRate());
	        stmt.setInt(3, product.getPrice());
	        stmt.setInt(4, product.getDiscount());
	        stmt.setString(5, product.getThumbnail());
	        stmt.setString(6, product.getDescription());
	        stmt.setDate(7, new java.sql.Date(product.getCreatedAt().getTime()));
	        stmt.setDate(8, new java.sql.Date(product.getUpdatedAt().getTime()));
	        stmt.setInt(9, product.getCategory().getId());
	        result = stmt.executeUpdate();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } 
	    return result;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		int result = 0;
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "UPDATE product SET title=?, rate=?, price=?, discount=?, thumbnail=?, description=?, category_id=?, update_at=? WHERE id=?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, product.getTitle());
	        stmt.setFloat(2, product.getRate());
	        stmt.setInt(3, product.getPrice());
	        stmt.setInt(4, product.getDiscount());
	        stmt.setString(5, product.getThumbnail());
	        stmt.setString(6, product.getDescription());
	        stmt.setInt(7, product.getCategory().getId());
	        stmt.setDate(8, new java.sql.Date(product.getUpdatedAt().getTime()));
	        stmt.setInt(9, product.getId());
	        result = stmt.executeUpdate();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } 
	    return result;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		int rowDeleted = 0;
	    try {
	        Connection conn = MySQLConnect.getConnection();
	        PreparedStatement statement = conn.prepareStatement("DELETE FROM product WHERE id = ?");
	        statement.setInt(1, id);
	        rowDeleted = statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return rowDeleted;
	}
	
	public static void main(String[] args) {
		ProductDaoImpl abc = new ProductDaoImpl();
		List<Product> productList = abc.getAll();
		for (Product i : productList) {
		    System.out.println(abc);
		}
	}
}
