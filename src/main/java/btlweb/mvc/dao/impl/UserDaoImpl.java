package btlweb.mvc.dao.impl;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Role;
import btlweb.mvc.model.User;
import btlweb.mvc.dao.UserDao;

public class UserDaoImpl implements UserDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	

	@Override
	public List<User> getAll() {
		List<User> userList = new ArrayList<>();
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "SELECT U.*, R.name FROM user as U, role as R WHERE U.role_id = R.id";
	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setFirstName(rs.getString("first_name"));
	            user.setLastName(rs.getString("last_name"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            user.setPhoneNumber(rs.getString("phoneNumber"));
	            user.setCity(rs.getString("city"));
	            user.setDistrict(rs.getString("district"));
	            user.setStreetAddress(rs.getString("street_address"));
		        user.setRole(new Role(rs.getInt("role_id"), rs.getString("name")));
	            userList.add(user);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userList;
	}
	   
	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = null;
		   try {
		      conn = MySQLConnect.getConnection();
		      String sql = "SELECT U.*, R.name FROM user as U, role as R where email = ? and U.role_id = R.id;";
		      ps = conn.prepareStatement(sql);
		      ps.setString(1, email);
		      rs = ps.executeQuery();
		      if (rs.next()) {
		         user = new User();
		         user.setId(rs.getInt("id"));
		         user.setFirstName(rs.getString("first_name"));
		         user.setLastName(rs.getString("last_name"));
		         user.setEmail(rs.getString("email"));
		         user.setPassword(rs.getString("password"));
		         user.setPhoneNumber(rs.getString("phoneNumber"));
		         user.setCity(rs.getString("city"));
		         user.setDistrict(rs.getString("district"));
		         user.setStreetAddress(rs.getString("street_address"));
		         user.setRole(new Role(rs.getInt("role_id"), rs.getString("name")));
		      }
		   } catch (SQLException e) {
		      e.printStackTrace();
		   } 
		   return user;
		}
		

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		   
		   User user = null;
		   try {
		      conn = MySQLConnect.getConnection();
		      String sql = "SELECT U.*, R.name FROM user as U, role as R where U.id = ? and U.role_id = R.id;";
		      ps = conn.prepareStatement(sql);
		      ps.setInt(1, id);
		      rs = ps.executeQuery();
		      if (rs.next()) {
		         user = new User();
		         user.setId(rs.getInt("id"));
		         user.setFirstName(rs.getString("first_name"));
		         user.setLastName(rs.getString("last_name"));
		         user.setEmail(rs.getString("email"));
		         user.setPassword(rs.getString("password"));
		         user.setPhoneNumber(rs.getString("phoneNumber"));
		         user.setCity(rs.getString("city"));
		         user.setDistrict(rs.getString("district"));
		         user.setStreetAddress(rs.getString("street_address"));
		         user.setRole(new Role(rs.getInt("role_id"), rs.getString("name")));
		      }
		   } catch (SQLException e) {
		      e.printStackTrace();
		   } 
		   return user;
		}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		int rows = 0;
		try {
		      conn = MySQLConnect.getConnection();
		      String sql = "INSERT INTO user (first_name, last_name, email, password, phonenumber, city, district, street_address, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		      ps = conn.prepareStatement(sql);
		      ps.setString(1, user.getFirstName());
		      ps.setString(2, user.getLastName());
		      ps.setString(3, user.getEmail());
		      ps.setString(4, user.getPassword());
		      ps.setString(5, user.getPhoneNumber());
		      ps.setString(6, user.getCity());
		      ps.setString(7, user.getDistrict());
		      ps.setString(8, user.getStreetAddress());
		      ps.setInt(9, 2);
		      rows = ps.executeUpdate();
		   } catch (SQLException e) {
		      e.printStackTrace();
		   }
		return rows;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		int rows = 0;
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "DELETE FROM user WHERE id = ?";
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        rows = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		int rows = 0;
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "UPDATE user SET first_name = ?, last_name = ?, email = ?, password = ?, phoneNumber = ?, city = ?, district = ?, street_address = ? WHERE id = ?";
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, user.getFirstName());
		    ps.setString(2, user.getLastName());
		    ps.setString(3, user.getEmail());
		    ps.setString(4, user.getPassword());
		    ps.setString(5, user.getPhoneNumber());
	        ps.setString(6, user.getCity());
		    ps.setString(7, user.getDistrict());
		    ps.setString(8, user.getStreetAddress());
	        ps.setInt(9, user.getId());
	        rows = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public List<User> getUserInPage(int pageId) {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<>();
	    try {
	        conn = MySQLConnect.getConnection();
	        int pageSize = 8; // Số lượng user trong một trang
	        int offset = (pageId - 1) * pageSize; // Vị trí bắt đầu lấy user
	        String sql = "SELECT U.*, R.name FROM user as U, role as R WHERE U.role_id = R.id LIMIT ? OFFSET ?";
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, pageSize);
	        ps.setInt(2, offset);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setFirstName(rs.getString("first_name"));
	            user.setLastName(rs.getString("last_name"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            user.setPhoneNumber(rs.getString("phoneNumber"));
	            user.setCity(rs.getString("city"));
	            user.setDistrict(rs.getString("district"));
	            user.setStreetAddress(rs.getString("street_address"));
		        user.setRole(new Role(rs.getInt("role_id"), rs.getString("name")));
	            userList.add(user);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userList;
	}

	@Override
	public int getNumOfUser() {
		// TODO Auto-generated method stub
		int count = 0;
	    try {
	        conn = MySQLConnect.getConnection();
	        String sql = "SELECT COUNT(*) FROM user";
	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		System.out.println(userDao.delete(1));
	}


}
