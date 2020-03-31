package btp400.a2.models;

/**
 * 
 * @author Jessica Krishtul
 *
 */

public class User {
	private String username;
	private String password;
	private String salt;
	public boolean valid;

	public User() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public boolean isValid() {
	         return valid;
	}

    public void setValid(boolean newValid) {
	         valid = newValid;
    }	

}