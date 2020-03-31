package btp400.a2.dao;

import btp400.a2.models.User;
import btp400.a2.utility.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author Jessica Krishtul
 *
 */

public class UserDao {
	   static Connection currentCon = null;
	   static ResultSet rs = null;  
	
	 public int registerUser(User user) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO user" +
	            "  (user_id, username, password, salt) VALUES " +
	            " (?, ?, ?, ?);";

	        int result = 0;
	        int count = 2;
	        count += 1;
	        
	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/btp400_a2?useSSL=false", "root", "Noh17609");
	        	
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, count);
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
	 
	 public static User login(User user) {
		 Statement stmt = null;
		 
		 String username = user.getUsername();
		 String password = user.getPassword();
		 
		 String SEARCH_USERS_SQL = "SELECT * FROM user WHERE username='" 
		 + username 
		 + "' AND password='"
		 + password
		 + "'";
		 
		 try 
	      {
		//connect to DB 
         currentCon = ConnectionManager.getConnection();
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(SEARCH_USERS_SQL);	        
         boolean more = rs.next();
	       
         // if user does not exist set the isValid variable to false
         if (!more) 
         {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            System.out.println(username + password);
            user.setValid(false);
         } 
	        
         //if user exists set the isValid variable to true
         else if (more) 
         {
	     	
            System.out.println("Welcome " + username);
            user.setValid(true);
         }
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
      }

return user;
		 
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