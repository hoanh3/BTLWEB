package btlweb.mvc.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import btlweb.mvc.model.Order;
import btlweb.mvc.model.dto.OrderDetailDto;
import btlweb.mvc.service.OrderDetailService;
import btlweb.mvc.service.OrderService;
import btlweb.mvc.service.impl.OrderDetailServiceImpl;
import btlweb.mvc.service.impl.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OrderApi extends HttpServlet{
	private Gson _gson = new Gson();
	private OrderService _orderService = new OrderServiceImpl();
	private OrderDetailService _orderDetailService = new OrderDetailServiceImpl();
	
	private void sendAsJson(HttpServletResponse resp, Object object) throws IOException {
		resp.setContentType("application/json");
		
		String json = _gson.toJson(object);
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.print(json);
		printWriter.flush();
		resp.setStatus(200);
		
		return;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession session = req.getSession();
		
//		System.out.println(session.getAttribute("admin"));
		
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			List<Order> orders = _orderService.getAll();
			
			sendAsJson(resp, orders);
			return;
		}
		
		String[] splits = pathInfo.split("/");
		if(splits.length == 2) {
			int oid = Integer.parseInt(splits[1]);
			
			List<OrderDetailDto> orderDetailDtos = _orderDetailService.getOrderDetailInOrder(oid);
			
			sendAsJson(resp, orderDetailDtos);
			
			return;
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		return;
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		} else {
			String[] splits = pathInfo.split("/");
			if(splits.length == 2) {
				int oid = Integer.parseInt(splits[1]);
				_orderService.updateStatus(oid, 1);

				sendAsJson(resp, splits);
				return;
			} else {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
				
		}
		return;
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pathInfo = req.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		} else {
			String[] splits = pathInfo.split("/");
			if(splits.length == 2) {
				int oid = Integer.parseInt(splits[1]);
				_orderService.delete(oid);
				
				sendAsJson(resp, splits);
				return;
			} else {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
		return;
	}
}
