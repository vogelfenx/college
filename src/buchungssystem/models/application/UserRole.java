package buchungssystem.models.application;

import buchungssystem.models.Model;

public class UserRole extends Model {
	private String role;

	public UserRole(Long id) {
		super(id);
	}
	
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
