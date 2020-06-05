package finalproject.entities;

import entities.Entity;

public class User extends Entity {

	private String userName;
	private String email;
	private String password;
	private String pswReminder;
	
	public User(int id, String userName, String email, String password, String pswReminder) {
		super(id);
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.pswReminder = pswReminder;
	}
	public User() {
		super();
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPswReminder() {
		return pswReminder;
	}
	public void setPswReminder(String pswReminder) {
		this.pswReminder = pswReminder;
	}
	
	
}
