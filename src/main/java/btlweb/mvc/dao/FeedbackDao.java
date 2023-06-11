package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.Feedback;

public interface FeedbackDao {
	List<Feedback> getAll();
	Feedback addFeedback(Feedback feedback);
}
