package buchungssystem.models.application;

import java.util.GregorianCalendar;

import buchungssystem.models.Model;

public class User extends Model {
	//TODO remove fields then they are in Model.java

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
	private GregorianCalendar validTill;
	private boolean isValid;
	private Long lastID;
	
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
		super.setChanged();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
		super.setChanged();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		super.setChanged();
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
		super.setChanged();
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
		super.setChanged();
	}

	public GregorianCalendar getValidTill() {
		return validTill;
	}

	public void setValidTill(GregorianCalendar validTill) {
		this.validTill = validTill;
	}
	
	public boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Long getLastID() {
		return lastID;
	}

	public void setLastID(Long lastID) {
		this.lastID = lastID;
	}

	@Override
	public String toString() {
		return "User [userRoleID=" + userRoleID + ", userRole=" + userRole + ", login=" + login + ", password="
				+ password + ", employeeID=" + employeeID + ", validFrom=" + validFrom + ", validTill=" + validTill
				+ ", lastID=" + lastID + "]";
	}


}
