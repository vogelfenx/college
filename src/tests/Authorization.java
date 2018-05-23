package tests;

import java.util.Properties;

import buchungssystem.dao.Impl.MySQL.application.UserDB;
import buchungssystem.dao.Impl.MySQL.application.UserRoleDB;
import buchungssystem.dao.Impl.MySQL.employee.EmployeeDB;
import buchungssystem.models.application.User;
import buchungssystem.models.application.UserRole;
import buchungssystem.models.employee.Employee;
import buchungssystem.models.roles.CurrentUser;

public class Authorization {
	Properties permissions = new Properties();
	static CurrentUser currentUser;
	User user;
	
	public Authorization(String login, String passwd) {
		UserDB userDB = new UserDB();
		UserRoleDB userRoleDB = new UserRoleDB();
		UserRole userRole = new UserRole();
		
		user = userDB.getByLogin(login, passwd);
		userRole = userRoleDB.getById(user.getUserRoleID());
		
		if (user != null && user.isValid() == true) {
			EmployeeDB employeeDB = new EmployeeDB();
			Employee employee = employeeDB.getById(user.getEmployeeID());
			if (employee != null) {
				initializePermission(userRole.getRole());
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

	public static CurrentUser getCurrentUser() {
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
