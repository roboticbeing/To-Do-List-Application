package btp400.a2.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import btp400.a2.dao.ToDoDao;
import btp400.a2.models.ToDoList;
/**
 * Servlet implementation class GetToDoListServlet
 */
@WebServlet("/GetToDoListServlet")
public class GetToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ToDoDao toDoDao = new ToDoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetToDoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<ToDoList> toDoList = toDoDao.selectAllTodos();
			request.setAttribute("toDoList", toDoList);
			RequestDispatcher rd=request.getRequestDispatcher("toDoTable.jsp");
		     rd.include(request, response);
		}
	

}
