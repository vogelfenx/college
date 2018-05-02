package buchungssystem.dao;

import buchungssystem.models.application.User;

/*
 * Hier wird die Funktionalität deklariert, die sich nur auf dieses Inferface bezieht 
 */

public interface IUser extends ManagerDao<User> {
	public User getByLogin(String login, String password);
}
