package buchungssystem.models;

public class UserRole extends Model {
	private String role;

	public UserRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
