package tests;

import java.util.Scanner;

import org.junit.Test;

import buchungssystem.models.application.User;
import buchungssystem.models.application.UserRoleHasPermission;
import buchungssystem.models.employee.Employee;
import buchungssystem.models.employee.Role;
import buchungssystem.models.roles.CurrentUser;

public class login {
	boolean status = false;
	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Login: ");
		String login = sc.nextLine().trim();
		
		System.out.print("Password: ");
		String passwd = sc.nextLine().trim();
		
		sc.close();
		
		Authorization session = new Authorization(login, passwd);
		//wenn den Benutzer nicht gibt, dann Properties sind leer.
		if (session.getPermissions().size() != 0  ) {
			System.out.println(session.getPermissions());
		}
		CurrentUser currentUser = session.getCurrentUser();
		if (session.getPermissions().getProperty("addUser") == "true") {
			
			//add new employee to the system ->
//			status = currentUser.addEmployeeToDB("Zenja", "mvanov", "zm@gmail.com");
			
			//update an Employee by ID ->
//			status = currentUser.updateEmployee(((long)61), new Employee("Sergey", "Iljukhin", "seryi70@gmail.com"));
			
			//add new role to system ->
//			status = currentUser.addRoleToDB("Demo");
			
			//configure the Permissions of user's role by ID.
//			UserRoleHasPermission userRolePermission = new UserRoleHasPermission();
//			userRolePermission.setPermissionsID(1);
//			userRolePermission.setUserRoleID(4);
//			status = currentUser.configureUserRolePermissions(userRolePermission);
			
			//add new role of employee to the db
//			Role role = new Role();
//			role.setRole("Praktikant");
//			status = currentUser.addEmployeeRole(role);
			
			//add new user to db
//			User newUser = new User();
//			newUser.setLogin("Kirill");
//			newUser.setPassword("kirill");
//			newUser.setUserRoleID(((long)5));
//			status = currentUser.addUser(newUser);
			
			//adapt user obj to employee obj
//			status = currentUser.adaptUserToEmployee((long)8, (long)60);			
		}
		System.out.println(status);
	}

}
