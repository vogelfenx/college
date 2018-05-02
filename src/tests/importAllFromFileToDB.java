package tests;

import buchungssystem.models.roles.CurrentUser;

public class importAllFromFileToDB {

	public static void main(String[] args) {
		CurrentUser admin = new CurrentUser("Kirill");
		admin.importEmployeesToDB("data/test");
	}

}
