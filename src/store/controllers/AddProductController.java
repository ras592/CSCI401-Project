package store.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import store.utility.MysqlCon;
import store.business.Store;
import store.business.User;

public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if logged in redirect to add_product
		// must be a logged in store user
		HttpSession session = request.getSession(false);
		Store currentStore = null;
		if(session.getAttribute("loggedin") != null && 
				session.getAttribute("current_user") != null) {
			if((Boolean)session.getAttribute("loggedin") != true) {
				// if not display the login page
				String url = "/views/login.jsp";
				System.out.println("add product redirect to: " + url);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
				dispatcher.forward(request,response);
			}
			if (session.getAttribute("current_store") != null) {
				currentStore = (Store)session.getAttribute("current_store");
			} else {
				User currentUser = (User)session.getAttribute("current_user");
				currentStore = MysqlCon.getStoreByUserId(currentUser.getUserId());
			}
			if (currentStore != null) {
				session.setAttribute("current_store", currentStore);
			} else {
				String url = "/views/store_registration.jsp";
				System.out.println("add product redirect to: " + url);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
				dispatcher.forward(request,response);
			}
			String url = "/views/add_product.jsp";
			System.out.println("add product redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		} else {
			// if not display the login page
			String url = "/views/login.jsp";
			System.out.println("add product redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		}
	}
}