package btlweb.mvc.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(asyncSupported = true, urlPatterns = { "/product/*", "/category/*", "/user/*", "/cart/*"})
public class CORSInterceptor implements Filter {

    private static final String[] allowedOrigins = {
            "http://localhost:3000", "http://localhost:5500", "http://localhost:5501",
            "http://127.0.0.1:3000", "http://127.0.0.1:5500", "http://127.0.0.1:5501"
    };

//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//
//        String requestOrigin = request.getHeader("Origin");
//        if(isAllowedOrigin(requestOrigin)) {
//            // Authorize the origin, all headers, and all methods
//            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", requestOrigin);
//            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "*");
//            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods",
//                    "GET, OPTIONS, HEAD, PUT, POST, DELETE");
//
//            HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//            // CORS handshake (pre-flight request)
//            if (request.getMethod().equals("OPTIONS")) {
//                resp.setStatus(HttpServletResponse.SC_ACCEPTED);
//                return;
//            }
//        }
//        // pass the request along the filter chain
//        filterChain.doFilter(request, servletResponse);
//    }

    @Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		try {
			String requestOrigin = request.getHeader("Origin");
	        if(isAllowedOrigin(requestOrigin)) {
	            // Authorize the origin, all headers, and all methods
	            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", requestOrigin);
	            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "*");
	            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods",
	                    "GET, OPTIONS, HEAD, PUT, POST, DELETE");

	            HttpServletResponse resp = (HttpServletResponse) servletResponse;

	            // CORS handshake (pre-flight request)
	            if (request.getMethod().equals("OPTIONS")) {
	                resp.setStatus(HttpServletResponse.SC_ACCEPTED);
	                return;
	            }
	        }
	        // pass the request along the filter chain
	        filterChain.doFilter(request, servletResponse);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi origin");
		}
	}
    
    private boolean isAllowedOrigin(String origin){
        for (String allowedOrigin : allowedOrigins) {
            if(origin.equals(allowedOrigin)) return true;
        }
        return false;
    }
}
