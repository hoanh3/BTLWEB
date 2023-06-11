package btlweb.mvc.controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import btlweb.mvc.model.Feedback;
import btlweb.mvc.service.FeedbackService;
import btlweb.mvc.service.impl.FeedbackServiceImpl;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FeedbackApi extends HttpServlet{
	private Gson _gson = new Gson();
	private FeedbackService _feedbackService = new FeedbackServiceImpl();
	
	private void sendAsJson(HttpServletResponse resp, Object object) throws IOException {
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		String res = _gson.toJson(object);
		
		writer.write(res);
		resp.setStatus(200);
		writer.flush();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
		// TODO Auto-generated method stub
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			try {
				List<Feedback> feedbacks = _feedbackService.getAll();
				sendAsJson(resp, feedbacks);
				return;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("loi feedback api");
			}
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
	}
}
