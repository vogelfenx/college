package buchungssystem.dao;

import buchungssystem.models.User;

/*
 * Hier wird die Funktionalit�t deklariert, die sich nur auf dieses Inferface bezieht 
 */

public interface IUser extends ManagerDao<User> {
	public User getByLogin(String login, String password);
}
