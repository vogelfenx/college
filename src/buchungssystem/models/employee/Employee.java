package buchungssystem.models.employee;

import buchungssystem.models.Model;

public class Employee extends Model {
	//TODO all employees should have roleID!!
	
	/* 
	 * Folgende Eigenschaften übernimmt Model.java
	 * 
	 * private Long id; 
	 * private Long lastID;
	 * 
	 */
	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Long roleID;
	private String role;
	private Long userID;
	private Long departmentID;
	private boolean isValid;
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public Employee(Long id) {
		super(id);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getRoleID() {
		return roleID;
	}
	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}
	public Long getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", roleID=" + roleID + ", role=" + role + ", userID=" + userID + ", departmentID="
				+ departmentID + ", isValid=" + isValid + "]";
	}
	
	
	
}
