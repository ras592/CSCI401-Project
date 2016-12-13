package store.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import store.business.User;
import store.utility.MysqlCon;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if logged in redirect to home
		HttpSession session = request.getSession(false);
		if(session.getAttribute("loggedin") != null && 
				(Boolean)session.getAttribute("loggedin") == true) {
			String url = "/index.jsp";
			System.out.println("login redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		} else {
			// if not display the login page
			String url = "/views/login.jsp";
			System.out.println("login redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(MysqlCon.validateUser(email, password)) {
			request.getSession(true).setAttribute("loggedin", true);
			// set first name last name
			User currentUser = MysqlCon.getUser(email);
			request.getSession(true).setAttribute("current_user", currentUser);
			String url = "/index.jsp";
			System.out.println("login success redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		} else {
			// display errors
			String url = "/views/login.jsp";
			System.out.println("login redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		}
	}
}
