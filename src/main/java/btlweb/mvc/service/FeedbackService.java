package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Feedback;

public interface FeedbackService {
	List<Feedback> getAll();
	Feedback addFeedback(Feedback feedback);
}
