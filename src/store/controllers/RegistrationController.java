package store.controllers;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import store.business.User;
import store.utility.MysqlCon;
import store.utility.MailUtil;

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
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
			String url = "/home.jsp";
			System.out.println("registration redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		} else {
			// if not display the registration page
			String url = "/views/registration.jsp";
			System.out.println("registration redirect to: " + url);
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
		String confirm_password = request.getParameter("confirm_password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String country = "US"; 
		
		if (!password.equals(confirm_password)) {
			// a user with the account already exists
			String url = "/views/registration.jsp";
			System.out.println("registration redirect pass not equal to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		} else if(MysqlCon.validateUser(email, password)) {
			// a user with the account already exists
			String url = "/views/registration.jsp";
			System.out.println("registration redirect other user to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		} else if(email != "" && password != "" && first_name != "" &&
				  last_name != "" && address != "" && city != "" &&
				  state != "" && zip != "" && country != "") {
			// set first name last name
			Boolean res = MysqlCon.insert_user(first_name, last_name, email, password, address, city, state, zip, country, 1);
			if(!res) {
				// handle non-working insert
			}
			try {
	            MailUtil.sendMail(email, "Sign Up", "<h1>Thanks for signing up!</h1>", true);
	        }
	        catch(MessagingException e) {
	            this.log(
	                "Unable to send email. \n" +
	                "=====================================\n" +
	                "TO: " + email + "\n" +
	                "FROM: us\n");
	        }
			String url = "/views/login.jsp";
			System.out.println("registration success redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		} else {
			// display errors
			String url = "/views/registration.jsp";
			System.out.println("registration redirect errors to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
		}
	}
}
