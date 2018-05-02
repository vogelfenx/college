package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import buchungssystem.models.roles.CurrentUser;

public class importEmployeesFromFileToDB {
	
	CurrentUser admin = new CurrentUser();
	
	@Test
	public void importEmployees() {
		assertTrue(admin.importEmployeesToDB("data/inputData"));
	}

}
