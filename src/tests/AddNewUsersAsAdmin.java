package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import buchungssystem.models.roles.CurrentUser;

public class AddNewUsersAsAdmin {
	
	CurrentUser admin = new CurrentUser();	
	
	@Test
	public void newEntry(){
		assertTrue(admin.addEmployeeToDB("Zenja", "Ivanov", "zl@gmail.com"));
	}

}
