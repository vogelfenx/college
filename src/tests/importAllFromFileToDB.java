package tests;

import buchungssystem.models.roles.Admin;

public class importAllFromFileToDB {

	public static void main(String[] args) {
		Admin admin = new Admin("Kirill");
		admin.importEmployeesToDB("data/test");
	}

}
