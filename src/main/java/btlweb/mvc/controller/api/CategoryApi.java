package btlweb.mvc.controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import btlweb.mvc.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/category/*")
public class CategoryApi extends HttpServlet{
	// du lieu test
	public static List<Category> categories = new ArrayList<>();
	
	static {
		categories.add(new Category(1, "shirts"));
		categories.add(new Category(2, "t-shirts"));
		categories.add(new Category(3, "polo"));
		categories.add(new Category(4, "hoodies"));
	}
	
	private Gson _gson = new Gson();
	
	private void sendAsJson(HttpServletResponse response, Object object) throws IOException {
		response.setContentType("application/json");
		
		String res = _gson.toJson(object);
		
		PrintWriter pW = response.getWriter();
		
		response.setStatus(200);
		pW.print(res);
		pW.flush();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			List<Category> categories = CategoryApi.categories;
			sendAsJson(resp, categories);
			return ;
		}
		
		String[] args = pathInfo.split("/");
		if(args.length > 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return ;
		}
		
		int categoryId = Integer.parseInt(args[1]);
		Category category = CategoryApi.categories.get(categoryId - 1);
		if(category == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return ;
		}
		sendAsJson(resp, category);
		return ;
	}
}
