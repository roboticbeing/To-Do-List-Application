package btp400.a2.dao;

import btp400.a2.models.ToDoList;
import btp400.a2.models.User;
import btp400.a2.utility.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jessica Krishtul
 *
 */

public class ToDoDao {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public int saveList(ToDoList list) throws ClassNotFoundException {
		String INSERT_LIST_SQL = "INSERT INTO list" + "  (title, description, status, priority) VALUES " + " (?, ?, ?, ?);";

		int result = 0;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/btp400_a2?useSSL=false",
				"root", "Noh17609");

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LIST_SQL)) {
			preparedStatement.setString(1, list.getTitle());
			preparedStatement.setString(2, list.getDescription());
			preparedStatement.setString(3, list.getStatus());
			preparedStatement.setString(4, list.getPriority());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
			// e.printstacktrace
		}
		return result;
	}
	
	public List<ToDoList> selectAllTodos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<ToDoList> todos = new ArrayList<>();
		String SELECT_LIST_SQL = "SELECT * FROM list;";

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/btp400_a2?useSSL=false",
				"root", "Noh17609");

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LIST_SQL);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String title = rs.getString("title");
				String description = rs.getString("description");
				String status = rs.getString("status");
				String priority = rs.getString("priority");
				todos.add(new ToDoList(title, description, status, priority));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return todos;
	}
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
