package buchungssystem.models.employee;

import buchungssystem.models.Model;

public class Role extends Model {
	private String role;

	public Role(Long id) {
		super(id);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + "]";
	}
	
}
