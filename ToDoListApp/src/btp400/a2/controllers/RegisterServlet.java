package btp400.a2.controllers;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import btp400.a2.dao.UserDao;
import btp400.a2.models.User;

//import btp400.a2.models.HashUtil;

/**
 * Servlet implementation class RegisterUser
 * @author Jessica Krishtul
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerForm.jsp"); 
		dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
		// todo: you probably want to ask them to confirm their password, and
		// you should also validate the password to make sure it's a "strong"
		// password
		             
//		UserDao dao = new UserDao();
		
//		ArrayList<User> user;
//		try {
//			user = dao.runQuery();
//			System.out.println(user);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		 
//		// make sure this customer isn't already in the database
//		if (dao.findCustomer(email)) {
//		    // customer is already in there - error
//		} else {
//		    // create the salt and password hash
//		    String salt = HashUtil.getSalt();
//		    String passwordHash = HashUtil.getPasswordHash(password, salt);
//		                 
//		    // add the customer to the Customer table
//		    Customer cust = new Customer(firstName, lastName, email, etc...);
//		    int result = dao.addCustomer(cust, passwordHash, salt);
//		    if (result > 0) {
//		        // success
//		    } else {
//		        // failure
//		    }
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String salt = request.getParameter("salt");
		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setSalt(salt);
		
		try {
			userDao.registerUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//redirect to success page/home page
		//response.sendRedirect("testJsp.jsp");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("testJsp.jsp"); 
		dispatcher.forward(request, response);
		//doGet(request, response);
	}

}
