package buchungssystem.models.roles;

import java.util.Properties;

public class CurrentUser extends Users { 
	
	public CurrentUser() {
		super();
	}
	
	public Properties definePermissionsProperty() {
		Properties permissions = new Properties();
		//customer
		permissions.setProperty("readCustomerTable", "true");
		permissions.setProperty("addCustomer", "true");
		permissions.setProperty("updateCustomer", "true");
		permissions.setProperty("deleteCustomer", "true");
		//user
		permissions.setProperty("readUserTable", "true");
		permissions.setProperty("addUser", "true");
		permissions.setProperty("updateUser", "true");
		permissions.setProperty("deleteUser", "true");
		//mitarbeiter
		permissions.setProperty("readEmployeeTable", "true");
		return permissions;
	}
	
}
