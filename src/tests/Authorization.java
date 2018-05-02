package tests;

import java.util.Properties;

import buchungssystem.dao.daoImpl.MySQL.EmployeeDB;
import buchungssystem.dao.daoImpl.MySQL.UserDB;
import buchungssystem.models.application.User;
import buchungssystem.models.employee.Employee;
import buchungssystem.models.roles.CurrentUser;

public class Authorization {
	Properties permissions = new Properties();
	CurrentUser currentUser;
	
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
				currentUser = new CurrentUser(); 
				permissions = currentUser.definePermissionsProperty();
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

	public CurrentUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CurrentUser admin) {
		this.currentUser = admin;
	}
	
	
	
}
