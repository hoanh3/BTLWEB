package btlweb.mvc.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import btlweb.mvc.model.Galery;
import btlweb.mvc.model.Product;
import btlweb.mvc.model.User;
import btlweb.mvc.service.GaleryService;
import btlweb.mvc.service.impl.GaleryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GaleryApi extends HttpServlet{
	
	private GaleryService _galeryService = new GaleryServiceImpl();
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
			String pageId = req.getParameter("pageId");
			if(pageId != null) {
				List<Galery> galeries = _galeryService.getGaleryInPage(Integer.parseInt(pageId));
				sendAsJson(resp, galeries);
				return ;
			}
			return;
		}
		
		String[] args = pathInfo.split("/");
		if(args.length > 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return ;
		}
		
		int pid = Integer.parseInt(args[1]);
		List<Galery> galery = _galeryService.getGaleryByProductId(pid);
		sendAsJson(resp, galery);
		return ;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
				StringBuffer buffer = new StringBuffer();
				BufferedReader reader = req.getReader();
				
				String line = "";
				while((line=reader.readLine()) != null) {
					buffer.append(line);
				}
				
				String payload = buffer.toString();
				
				Galery galery = _gson.fromJson(payload, Galery.class);
				_galeryService.insertGalery(galery);
				
				sendAsJson(resp, galery);
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		return;
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
				StringBuffer buffer = new StringBuffer();
				BufferedReader reader = req.getReader();
				
				String line = "";
				while((line=reader.readLine()) != null) {
					buffer.append(line);
				}
				
				String payload = buffer.toString();
				
				Galery galery = _gson.fromJson(payload, Galery.class);
				_galeryService.updateGalery(galery);
				
				sendAsJson(resp, galery);
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		return;
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

		if(pathInfo == null || pathInfo.equals("/")){
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		int galeryId = Integer.parseInt(splits[1]);
		
		
		Galery galery = _galeryService.getGaleryById(galeryId);
		
		if(galery == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		int status = _galeryService.deleteGalery(galeryId);
		if(status == 0) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		} else {
			sendAsJson(resp, galery);
		}
		return;
	}
}
