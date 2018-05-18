package tests;

import java.util.Properties;

import buchungssystem.dao.Impl.MySQL.application.UserDB;
import buchungssystem.dao.Impl.MySQL.employee.EmployeeDB;
import buchungssystem.models.application.User;
import buchungssystem.models.employee.Employee;
import buchungssystem.models.roles.CurrentUser;

public class Authorization {
	Properties permissions = new Properties();
	CurrentUser currentUser;
	User user;
	
	public Authorization(String login, String passwd) {
		UserDB userDB = new UserDB();
		user = userDB.getByLogin(login, passwd);
		if (user != null && user.isValid() == true) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
