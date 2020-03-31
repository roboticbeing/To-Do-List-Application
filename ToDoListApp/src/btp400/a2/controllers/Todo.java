package btp400.a2.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import btp400.a2.dao.TodoDao;
import btp400.a2.models.Task;

/**
 * Servlet implementation class Todo
 */
@WebServlet("/todo")
public class Todo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TodoDao todoDAO = new TodoDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
            	case "/list":
            		listTask(request, response);
            		break;
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertTodo(request, response);
                    break;
                case "/delete":
                    deleteTodo(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateTodo(request, response);
                    break;
                
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listTask(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List<Task> listTask = todoDAO.selectAllTodos();
        request.setAttribute("listTask", listTask);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("todoForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        long id = Integer.parseInt(request.getParameter("id"));
        Task existingTodo = todoDAO.selectTodo(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todoForm.jsp");
        request.setAttribute("todo", existingTodo);
        dispatcher.forward(request, response);

    }

    private void insertTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String title = request.getParameter("title");
        String username = request.getParameter("username");
        String description = request.getParameter("description");


        boolean status = Boolean.valueOf(request.getParameter("status"));
        Task newTodo = new Task(title, username, description, status);
        todoDAO.insertTodo(newTodo);
        response.sendRedirect("list");
    }

    private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String title = request.getParameter("title");
        String username = request.getParameter("username");
        String description = request.getParameter("description");

        boolean status = Boolean.valueOf(request.getParameter("status"));
        Task updateTodo = new Task(id, title, username, description, status);

        todoDAO.updateTodo(updateTodo);

        response.sendRedirect("list");
    }

    private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        todoDAO.deleteTodo(id);
        response.sendRedirect("list");
    }

}
