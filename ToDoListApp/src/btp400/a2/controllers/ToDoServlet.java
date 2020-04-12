package btp400.a2.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import btp400.a2.dao.ToDoDao;
import btp400.a2.dao.UserDao;
import btp400.a2.models.ToDoList;

/**
 * Servlet implementation class ToDoServlet
 */
@WebServlet("/ToDoServlet")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ToDoDao toDoDao = new ToDoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		String priority = request.getParameter("priority");
		
		ToDoList list = new ToDoList();
		
		list.setTitle(title);
		list.setDescription(description);
		list.setStatus(status);
		list.setPriority(priority);
		
		try {
			toDoDao.saveList(list);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 response.setContentType("text/html");
	     PrintWriter pw=response.getWriter();
	     pw.println("<script type=\"text/javascript\">");
	     pw.println("alert('List Saved!');");
	     pw.println("</script>");
	     RequestDispatcher rd=request.getRequestDispatcher("ToDoTable.jsp");
	     rd.include(request, response);
		
	}

}
