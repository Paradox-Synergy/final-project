package finalproject.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import finalproject.entities.generics.JPAEntity;

@Entity(name = "Utente")
@Table(name = "utenti")
public class Utente extends JPAEntity {

	private String userName = "Username";
	private String email = "user.name@aigi.it";
	private String password = "00000000";
	private String pswReminder = "8-0";
	
	public Utente(int id, String userName, String email, String password, String pswReminder) {
		super(id);
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.pswReminder = pswReminder;
	}
	public Utente() {
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
