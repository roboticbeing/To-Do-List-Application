package btp400.a2.dao;

import btp400.a2.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import com.mysql.jdbc.Driver;

public class UserDao {
	
	 public int registerUser(User user) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO user" +
	            "  (user_id, username, password, salt) VALUES " +
	            " (?, ?, ?, ?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/btp400_a2?useSSL=false", "root", "Noh17609");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, 2);
	            preparedStatement.setString(2, user.getUsername());
	            preparedStatement.setString(3, user.getPassword());
	            preparedStatement.setString(4, user.getSalt());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	            //e.printstacktrace
	        }
	        return result;
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
	 
//	private String dbUrl;
//	private String dbName;
//	private String user;
//	private String pass;
	
//	public UserDao() {
//		
//	}
//	
//	public UserDao(String dbUrl, String dbName, String user, String pass) {
//		dbUrl = "jdbc:mysql://localhost:3306/";
//		dbName = "btp400_a2";
//		user = "root";
//		pass = "Noh17609";
//	}
	
//	private Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(dbUrl + dbName, user, pass);
//	}
//	
//	public ArrayList<User> runQuery() throws SQLException {
//		Connection dbConn = getConnection();
//		String sql = "select * from users;";
//		Statement stmt = dbConn.createStatement();
//		ResultSet rs = stmt.executeQuery(sql);
//		ArrayList<User> arr = new ArrayList<>();
//		while (rs.next()) {
//			User user = new User();
//			user.setUsername(rs.getString("username"));
//			user.setPassword(rs.getString("password"));
//			arr.add(user);
//		}
//		dbConn.close();
//		return arr;
//	}
	
//	public int runStatement() {
//		
//	}
	
}
