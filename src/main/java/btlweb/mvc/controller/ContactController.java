package btlweb.mvc.controller;

import java.io.IOException;

import btlweb.mvc.model.Feedback;
import btlweb.mvc.service.FeedbackService;
import btlweb.mvc.service.impl.FeedbackServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContactController extends HttpServlet{
	private FeedbackService feedbackService = new FeedbackServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/contact.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lastName = req.getParameter("last-name");
		String firstName = req.getParameter("first-name");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phone-number");
		String subject = req.getParameter("subject");
		String note = req.getParameter("note");
		try {
			Feedback feedback = feedbackService.addFeedback(new Feedback(0, firstName, lastName, email, phoneNumber, subject, note));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("post feedback");
		} finally {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/contact.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
