package buchungssystem.models.application;

import buchungssystem.models.Model;

public class User extends Model {

	/* 
	 * Folgende Eigenschaften übernimmt Model.java
	 * 
	 * private Long id; 
	 * private Long lastID;
	 * 
	 */
	
	private Long userRoleID;
	private String login;
	private String password;
	private Long employeeID;
	// TODO private validFrom;
	
	public User() {
		super();
	}

	public User(Long id) {
		super(id);
	}

	public Long getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(Long userRoleID) {
		this.userRoleID = userRoleID;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "User [userRoleID=" + userRoleID + ", login=" + login + ", password=" + password + ", employeeID="
				+ employeeID + "]";
	}
	
	
	
}
