package tests;

import java.util.Properties;

import buchungssystem.dao.daoImpl.MySQL.EmployeeDB;
import buchungssystem.dao.daoImpl.MySQL.UserDB;
import buchungssystem.models.Employee;
import buchungssystem.models.User;
import buchungssystem.models.roles.Admin;

public class Authorization {
	Properties permissions = new Properties();
	Admin admin;
	
	public Authorization(String login, String passwd) {
		UserDB userDB = new UserDB();
		User user = userDB.getByLogin(login, passwd);
		if (user != null) {
			EmployeeDB employeeDB = new EmployeeDB();
			Employee employee = employeeDB.getById(user.getEmployeeID());
			if (employee != null) {
				System.out.println(user.toString());
				System.out.println(employee.toString());
				initializePermission(employee.getRole());
			}
		} else {
			System.out.println("Den Benutzer gibt es nicht");
		}
	}
	
	private Properties initializePermission(String role){
		switch (role) {
			case "Admin":
				admin = new Admin(); 
				permissions = admin.definePermissionsProperty();
			break;
		}
		return permissions;
	}
	
	public Properties getPermissions() {
		return permissions;
	}

	public void setPermissions(Properties permissions) {
		this.permissions = permissions;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
}
