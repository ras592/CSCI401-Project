package store.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import store.business.Product;
import store.business.Status;
import store.business.Store;
import store.business.User;
import store.utility.MysqlCon;

import com.google.gson.Gson;

public class CartAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = null;
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("loggedin") == null) {
			// if not display the login page
			String url = "/views/login.jsp";
			System.out.println("login redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		// id for deleting
		} else if ((Boolean)session.getAttribute("loggedin") == false) {
			// if not display the login page
			String url = "/views/login.jsp";
			System.out.println("login redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		} else if (request.getParameter("id") != null) {
			// remove from cart by id
			try {
				User current_user = (User) session.getAttribute("current_user");
				int id = -1;
				id = Integer.parseInt(request.getParameter("id"));
				if(id != -1 && current_user != null) {
					MysqlCon.removeFromCartById(id, current_user.getUserId());
					
					String json = new Gson().toJson(new Status("success"));
					
					response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    try {
						response.getWriter().write(json);
					} catch (IOException e) {
						e.printStackTrace();
						response.setStatus(500);
					}
				}
			} catch(Exception ex) {
				// do nothing
			}
		} else { // nothing for rendering
			User current_user = (User) session.getAttribute("current_user");
			if (current_user != null) {
				products = MysqlCon.getAllProductsFromCart(current_user.getUserId());
			}
			
		    String json = new Gson().toJson(products);
	
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
				response.setStatus(500);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = null;
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("loggedin") != null &&
				(Boolean)session.getAttribute("loggedin") == true) {
			if (request.getParameter("id") != null) {
				User current_user = (User) session.getAttribute("current_user");
				int id = -1;
				id = Integer.parseInt(request.getParameter("id"));
				if(id != -1 && current_user != null) {
					products = MysqlCon.addProductToCart(id, current_user.getUserId());
				
				    String json = new Gson().toJson(products);
			
				    response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    try {
						response.getWriter().write(json);
					} catch (IOException e) {
						e.printStackTrace();
						response.setStatus(500);
					}
				} else {
					String json = new Gson().toJson(new Status("error"));
					
					response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    try {
						response.getWriter().write(json);
					} catch (IOException e) {
						e.printStackTrace();
						response.setStatus(500);
					}
				}
			} else { // no id to add product to
				String json = new Gson().toJson(new Status("error"));
				
				response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    try {
					response.getWriter().write(json);
				} catch (IOException e) {
					e.printStackTrace();
					response.setStatus(500);
				}
			}
		} else {
			// if not display the login page
			String url = "/views/login.jsp";
			System.out.println("login redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		}
	}
}
