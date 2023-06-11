package btlweb.mvc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dao.FeedbackDao;
import btlweb.mvc.dbconnect.MySQLConnect;
import btlweb.mvc.model.Feedback;

public class FeedbackDaoImpl implements FeedbackDao{

	@Override
	public List<Feedback> getAll() {
		// TODO Auto-generated method stub
		List<Feedback> feedbacks = new ArrayList<>();
		
		String query = "select * from feedback "
					+ "order by id desc";
		
		try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				String email = resultSet.getString(4);
				String phoneNumber = resultSet.getString(5);
				String subject = resultSet.getString(6);
				String note = resultSet.getString(7);
				feedbacks.add(new Feedback(id, firstName, lastName, email, phoneNumber, subject, note));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi get feedback");
		}
		
		return feedbacks;
	}

	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO `feedback` "
				+ "(`first_name`, `last_name`, `email`, `phonenumber`, `subject`, `note`) "
				+ "VALUES "
				+ "(?,?,?,?,?,?);";
		try {
			Connection connection = MySQLConnect.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, feedback.getFirstName());
			pStatement.setString(2, feedback.getLastName());
			pStatement.setString(3, feedback.getEmail());
			pStatement.setString(4, feedback.getPhoneNumber());
			pStatement.setString(5, feedback.getSubject());
			pStatement.setString(6, feedback.getNote());
			
			pStatement.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi orderDao");
			feedback = null;
		}
		return feedback;
	}

}
