package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import buchungssystem.models.roles.Admin;

public class importEmployeesFromFileToDB {
	
	Admin admin = new Admin();
	
	@Test
	public void importEmployees() {
		assertTrue(admin.importEmployeesToDB("data/inputData"));
	}

}
