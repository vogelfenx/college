package buchungssystem.models;

public class User extends Model {

	/* 
	 * Folgende Eigenschaften übernimmt Model.java
	 * 
	 * private Long id; 
	 * 
	 */
	
	private String login;
	private String password;
	private long employeeID;
	
	public User() {
		super();
	}

	public User(Long id) {
		super(id);
	}
	
	public User(String login) {
		this.login = login;
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

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", employeeID=" + employeeID + "]";
	}
	
	
	
	
	
}
