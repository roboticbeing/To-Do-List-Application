/**
 *  @author: Jeasung Chun 
 */
package btp400.a2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import btp400.a2.models.Task;

public class TodoDao {
	private static final String INSERT_TASKS_SQL = "INSERT INTO task" +
	        "  (title, username, description, status) VALUES " + " (?, ?, ?, ?);";

	    private static final String SELECT_TASK_BY_ID = "select id,title,username,description, status from task where id =?";
	    private static final String SELECT_ALL_TASKS = "select * from task";
	    private static final String DELETE_TASK_BY_ID = "delete from task where id = ?;";
	    private static final String UPDATE_TASK = "update task set title = ?, username= ?, description =?, status = ? where id = ?;";


	    public void insertTodo(Task task) throws SQLException {
	        System.out.println(INSERT_TASKS_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = JDBCTemplate.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASKS_SQL)) {
	            preparedStatement.setString(1, task.getTitle());
	            preparedStatement.setString(2, task.getUsername());
	            preparedStatement.setString(3, task.getDescription());
	            preparedStatement.setBoolean(4, task.getStatus());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException exception) {
	        	JDBCTemplate.printSQLException(exception);
	        }
	    }

	    public Task selectTodo(long todoId) {
	        Task task = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = JDBCTemplate.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASK_BY_ID);) {
	            preparedStatement.setLong(1, todoId);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet result = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (result.next()) {
	                long id = result.getLong("id");
	                String title = result.getString("title");
	                String username = result.getString("username");
	                String description = result.getString("description");
	                boolean status = result.getBoolean("status");
	                task = new Task(id, title, username, description, status);
	            }
	        } catch (SQLException exception) {
	        	JDBCTemplate.printSQLException(exception);
	        }
	        return task;
	    }

	    public List < Task > selectAllTodos() {

	        List < Task > tasks = new ArrayList < > ();

	        try (Connection connection = JDBCTemplate.getConnection();

	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TASKS);) {
	            System.out.println(preparedStatement);
	            ResultSet result = preparedStatement.executeQuery();

	            while (result.next()) {
	                long id = result.getLong("id");
	                String title = result.getString("title");
	                String username = result.getString("username");
	                String description = result.getString("description");
	                boolean status = result.getBoolean("status");
	                tasks.add(new Task(id, title, username, description, status));
	            }
	        } catch (SQLException exception) {
	        	JDBCTemplate.printSQLException(exception);
	        	System.out.println("Error");
	        }
	        return tasks;
	    }

	    public boolean deleteTodo(int id) throws SQLException {
	        boolean deleted;
	        try (Connection connection = JDBCTemplate.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_TASK_BY_ID);) {
	            statement.setInt(1, id);
	            deleted = statement.executeUpdate() > 0;
	        }
	        return deleted;
	    }

	    public boolean updateTodo(Task task) throws SQLException {
	        boolean updated;
	        try (Connection connection = JDBCTemplate.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TASK);) {
	            statement.setString(1, task.getTitle());
	            statement.setString(2, task.getUsername());
	            statement.setString(3, task.getDescription());
	            statement.setBoolean(4, task.getStatus());
	            statement.setLong(5, task.getId());
	            updated = statement.executeUpdate() > 0;
	        }
	        return updated;
	    }
}
