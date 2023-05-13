package btlweb.mvc.controller.api;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.oracle.wls.shaded.org.apache.xpath.operations.And;

import btlweb.mvc.model.dto.ProductSADto;
import btlweb.mvc.service.ProductAvaiService;
import btlweb.mvc.service.impl.ProductAvaiServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductSAApi extends HttpServlet{
	private ProductAvaiService _productAvaiService = new ProductAvaiServiceImpl();
	private Gson _gson = new Gson();
	
	private void sendAsJson(HttpServletResponse response, Object object) throws IOException {
		response.setContentType("application/json");
		
		String res = _gson.toJson(object);
		
		PrintWriter pWriter = response.getWriter();
		
		pWriter.print(res);
		response.setStatus(200);
		pWriter.flush();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			String pid = req.getParameter("pid");
			String sid = req.getParameter("sid");
			if(pid != null && sid != null) {
				int avai = _productAvaiService.getProductSA(Integer.parseInt(pid), Integer.parseInt(sid));
				ProductSADto productSADto = new ProductSADto(Integer.parseInt(pid), Integer.parseInt(sid), avai);
				sendAsJson(resp, productSADto);
				return;
			}
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		return;
	}
}
