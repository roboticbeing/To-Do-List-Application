/**
 *  @author: Jessica Krishtul
 */
package btp400.a2.models;

public class ToDoList {
	private String title;
	private String description;
	private String status;
	private String priority;

	public ToDoList() {
		
	}

	public ToDoList(String title, String description, String status, String priority) {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
}
