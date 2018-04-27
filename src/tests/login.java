package tests;

import java.util.Scanner;

import org.junit.Test;

import buchungssystem.models.roles.Admin;

public class login {
	boolean status = false;
	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Login: ");
		String login = sc.nextLine().trim();
		
		System.out.print("Password: ");
		String passwd = sc.nextLine().trim();
		
		Authorization session = new Authorization(login, passwd);
		//wenn den Benutzer nicht gibt, dann Properties sind leer.
		if (session.getPermissions().size() != 0  ) {
			System.out.println(session.getPermissions());
		}
		Admin admin = session.getAdmin();
		if (session.getPermissions().getProperty("addUser") == "true") {
			//status = admin.addEmployeeToDB("Zenja", "mvanov", "zm@gmail.com");
			//status = admin.addRoleToDB("Sachbearbeiter");
			status = admin.updateEmployee(((long)52));
		}
		System.out.println(status);
	}

}
