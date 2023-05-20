package btlweb.mvc.dao.impl;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;

import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.dao.GaleryDao;
import btlweb.mvc.dao.ProductDao;
import btlweb.mvc.model.Product;
import btlweb.mvc.model.Category;
import btlweb.mvc.model.Galery;

public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		String sql = "SELECT P.*, C.title FROM product AS P, category AS C WHERE P.category_id = C.id ";
	    try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				int rate = resultSet.getInt(3);
				int price = resultSet.getInt(4);
				int discount = resultSet.getInt(5);
				String thumbnail = resultSet.getString(6);
				String description = resultSet.getString(7);
				Date createAt = resultSet.getDate(8);
				Date updateAt = resultSet.getDate(9);
				Category category = new Category(resultSet.getInt(10), resultSet.getString(11));
				productList.add(new Product(id, title, rate, price, discount, thumbnail, description, createAt, updateAt, category, new ArrayList<>()));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("loi getall product");
	    } 
	    return productList;
	}

	@Override
	public List<Product> getTopSale() {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		String query = "SELECT P.*, C.title FROM `product` AS P, `category` AS C "
				+ "WHERE P.category_id = C.id "
				+ "ORDER BY ROUND((P.price - P.discount) / P.price * 100, 0) DESC "
				+ "LIMIT 10;";
		try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				int rate = resultSet.getInt(3);
				int price = resultSet.getInt(4);
				int discount = resultSet.getInt(5);
				String thumbnail = resultSet.getString(6);
				String description = resultSet.getString(7);
				Date createAt = resultSet.getDate(8);
				Date updateAt = resultSet.getDate(9);
				Category category = new Category(resultSet.getInt(10), resultSet.getString(11));
				productList.add(new Product(id, title, rate, price, discount, thumbnail, description, createAt, updateAt, category, new ArrayList<>()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("loi topsale product dao");
		}
		return productList;
	}
	@Override
	public List<Product> getBestSeller() {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
	    String sql = "SELECT P.*, SUM(OD.num), C.title\r\n"
	    		+ "FROM `product` as P, `order_details` as OD, `category` as C\r\n"
	    		+ "WHERE p.id = OD.product_id AND C.id = P.category_id\r\n"
	    		+ "GROUP BY p.id\r\n"
	    		+ "ORDER BY SUM(OD.num) DESC\r\n"
	    		+ "LIMIT 10;";
	    try {
	        Connection connection = MySQLConnect.getConnection();
	        PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				int rate = resultSet.getInt(3);
				int price = resultSet.getInt(4);
				int discount = resultSet.getInt(5);
				String thumbnail = resultSet.getString(6);
				String description = resultSet.getString(7);
				Date createAt = resultSet.getDate(8);
				Date updateAt = resultSet.getDate(9);
				Category category = new Category(resultSet.getInt(10), resultSet.getString(11));
				productList.add(new Product(id, title, rate, price, discount, thumbnail, description, createAt, updateAt, category, new ArrayList<>()));
	        }
	    } catch (SQLException e) {
	        System.out.println("loi productdao best seller");
	    } 
	    return productList;
	}

	@Override
	public List<Product> searchProductByName(String name) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
	    String sql = "SELECT P.*, C.title FROM product AS P, category AS C WHERE P.category_id = C.id AND P.title LIKE ?;";
	    try {
	        Connection connection = MySQLConnect.getConnection();
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, "%" + name + "%");
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				int rate = resultSet.getInt(3);
				int price = resultSet.getInt(4);
				int discount = resultSet.getInt(5);
				String thumbnail = resultSet.getString(6);
				String description = resultSet.getString(7);
				Date createAt = resultSet.getDate(8);
				Date updateAt = resultSet.getDate(9);
				Category category = new Category(resultSet.getInt(10), resultSet.getString(11));
				products.add(new Product(id, title, rate, price, discount, thumbnail, description, createAt, updateAt, category, new ArrayList<>()));
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
	    String query = "SELECT P.*, C.title FROM product AS P, category AS C WHERE P.id = ? AND P.category_id = C.id";
	    try {	
	    	Connection connection = MySQLConnect.getConnection();
	    	PreparedStatement statement = connection.prepareStatement(query); 
	    	statement.setInt(1, productId);
	    	ResultSet resultSet = statement.executeQuery();
	    	while (resultSet.next()) {
	    		int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				int rate = resultSet.getInt(3);
				int price = resultSet.getInt(4);
				int discount = resultSet.getInt(5);
				String thumbnail = resultSet.getString(6);
				String description = resultSet.getString(7);
				Date createAt = resultSet.getDate(8);
				Date updateAt = resultSet.getDate(9);
				Category category = new Category(resultSet.getInt(10), resultSet.getString(11));
				product = new Product(id, title, rate, price, discount, thumbnail, description, createAt, updateAt, category, new ArrayList<>());
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
	        Connection connection = MySQLConnect.getConnection();
	        String sql = "SELECT P.*, C.title FROM Product AS P, category AS C WHERE category_id=? AND P.category_id = C.id";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, catId);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				int rate = resultSet.getInt(3);
				int price = resultSet.getInt(4);
				int discount = resultSet.getInt(5);
				String thumbnail = resultSet.getString(6);
				String description = resultSet.getString(7);
				Date createAt = resultSet.getDate(8);
				Date updateAt = resultSet.getDate(9);
				Category category = new Category(resultSet.getInt(10), resultSet.getString(11));
				productList.add(new Product(id, title, rate, price, discount, thumbnail, description, createAt, updateAt, category, new ArrayList<>()));
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
	        Connection connection = MySQLConnect.getConnection();
	        String sql = "SELECT COUNT(*) as count FROM Product";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            count = resultSet.getInt("count");
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
	        Connection connection = MySQLConnect.getConnection();
	        String sql = "SELECT P.*, C.title FROM product AS P, category AS C WHERE P.category_id = C.id LIMIT ? OFFSET ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setInt(1, pageSize);
	        statement.setInt(2, offset);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				int rate = resultSet.getInt(3);
				int price = resultSet.getInt(4);
				int discount = resultSet.getInt(5);
				String thumbnail = resultSet.getString(6);
				String description = resultSet.getString(7);
				Date createAt = resultSet.getDate(8);
				Date updateAt = resultSet.getDate(9);
				Category category = new Category(resultSet.getInt(10), resultSet.getString(11));
				productList.add(new Product(id, title, rate, price, discount, thumbnail, description, createAt, updateAt, category, new ArrayList<>()));
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
	        Connection connection = MySQLConnect.getConnection();
	        String query = "INSERT INTO product (title, rate, price, discount, thumbnail, description, create_at, update_at, category_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, product.getTitle());
	        statement.setFloat(2, product.getRate());
	        statement.setInt(3, product.getPrice());
	        statement.setInt(4, product.getDiscount());
	        statement.setString(5, product.getThumbnail());
	        statement.setString(6, product.getDescription());
	        statement.setDate(7, new java.sql.Date(product.getCreatedAt().getTime()));
	        statement.setDate(8, new java.sql.Date(product.getUpdatedAt().getTime()));
	        statement.setInt(9, product.getCategory().getId());
	        result = statement.executeUpdate();
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
	        Connection connection = MySQLConnect.getConnection();
	        String sql = "UPDATE product SET title=?, rate=?, price=?, discount=?, thumbnail=?, description=?, category_id=?, update_at=? WHERE id=?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, product.getTitle());
	        statement.setFloat(2, product.getRate());
	        statement.setInt(3, product.getPrice());
	        statement.setInt(4, product.getDiscount());
	        statement.setString(5, product.getThumbnail());
	        statement.setString(6, product.getDescription());
	        statement.setInt(7, product.getCategory().getId());
	        statement.setDate(8, new java.sql.Date(product.getUpdatedAt().getTime()));
	        statement.setInt(9, product.getId());
	        result = statement.executeUpdate();
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
	        Connection connection = MySQLConnect.getConnection();
	        PreparedStatement statement = connection.prepareStatement("DELETE FROM product WHERE id = ?");
	        statement.setInt(1, id);
	        rowDeleted = statement.executeUpdate();
	        connection.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return rowDeleted;
	}
	
	public static void main(String[] args) {
		ProductDao abc = new ProductDaoImpl();
		System.out.println(abc.getProductByCatId("1"));
//		List<Product> productList = abc.searchProductByName("SWEATER");
//		for (Product i : productList) {
//		    System.out.println(i);
//		}
	}
}
