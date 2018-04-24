package buchungssystem.models.roles;

import java.util.Properties;

public class Admin extends Users { 
	
	public Admin() {
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
		return permissions;
	}
	
	
}
