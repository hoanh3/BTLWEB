package btlweb.mvc.service.impl;

import java.util.List;

import btlweb.mvc.dao.FeedbackDao;
import btlweb.mvc.dao.impl.FeedbackDaoImpl;
import btlweb.mvc.model.Feedback;
import btlweb.mvc.service.FeedbackService;

public class FeedbackServiceImpl implements FeedbackService{
	private FeedbackDao feedbackDao = new FeedbackDaoImpl();
	
	@Override
	public List<Feedback> getAll() {
		// TODO Auto-generated method stub
		return feedbackDao.getAll();
	}

	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackDao.addFeedback(feedback);
	}

}
