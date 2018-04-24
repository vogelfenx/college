package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import buchungssystem.models.roles.Admin;

public class AddNewUsersAsAdmin {
	
	Admin admin = new Admin();	
	
	@Test
	public void newEntry(){
		assertTrue(admin.addEmployeeToDB("Zenja", "Ivanov", "zl@gmail.com"));
	}

}
