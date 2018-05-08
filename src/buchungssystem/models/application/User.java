package buchungssystem.models.application;

import java.util.GregorianCalendar;

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
	private String userRole;
	private String login;
	private String password;
	private Long employeeID;
	// DONE private validFrom(creating Date);
	private GregorianCalendar validFrom;
	
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

	
	public GregorianCalendar getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(GregorianCalendar validFrom) {
		this.validFrom = validFrom;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userRoleID=" + userRoleID + ", userRole=" + userRole + ", login=" + login + ", password="
				+ password + ", employeeID=" + employeeID + ", validFrom=" + validFrom + "]";
	}

}
