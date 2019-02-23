package com.servlet.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

public class WebServlet  extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1575064807133089866L;

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	/**
	 * 
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		ServletConfig config= this.getServletConfig();
		ServletContext context= config.getServletContext();
		resp.getWriter().write("Response");
	}
	
	
}
