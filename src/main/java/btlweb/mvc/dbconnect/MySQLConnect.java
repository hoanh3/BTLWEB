package btlweb.mvc.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driverName);
			String url = "jdbc:mysql://" + serverName +":" + port + "/" + databaseName;
			conn = DriverManager.getConnection(url, user, password);
		} catch(SQLException | ClassNotFoundException e) {
			System.out.println("Loi ket noi!");
		}
		return conn;
	}
	
	private static final String driverName = "com.mysql.cj.jdbc.Driver";
	private static final String serverName = "localhost";
	private static final String port = "3306";
	private static final String databaseName = "test1";
	private static final String user = "root";
	private static final String password = "123456";
	
	public static void main(String[] args) {
		Connection connection = MySQLConnect.getConnection();
		System.out.println(connection);
	}
}
