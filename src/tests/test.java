package tests;

import buchungssystem.dao.daoImpl.MySQL.UserDB;
import buchungssystem.models.application.User;

public class test {

	public static void main(String[] args) {
		String inputLogin = "Kirill";
		String password = "tere1234";
		
		UserDB test = new UserDB();
		User user = test.getByLogin(inputLogin, password);
		System.out.println(user.getId());
	}

}
