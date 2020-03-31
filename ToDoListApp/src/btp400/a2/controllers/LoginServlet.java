package btp400.a2.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import btp400.a2.dao.UserDao;
import btp400.a2.models.User;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp"); 
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{	    

		     User user = new User();
		     user.setUsername(request.getParameter("username"));
		     user.setPassword(request.getParameter("password"));

		     user = UserDao.login(user);
			   		    
		     if (user.isValid())
		     {
			        
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("loggedUser",user); 
		          response.sendRedirect("index.jsp"); //logged-in page      		
		     }
			        
		     else 
		     response.setContentType("text/html");
		     PrintWriter pw=response.getWriter();
		     pw.println("<script type=\"text/javascript\">");
		     pw.println("alert('Invalid Username or Password');");
		     pw.println("</script>");
		     RequestDispatcher rd=request.getRequestDispatcher("loginForm.jsp");
		     rd.include(request, response);
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		       
	}

}
