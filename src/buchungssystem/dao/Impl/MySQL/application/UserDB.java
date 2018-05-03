package buchungssystem.dao.Impl.MySQL.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.application.IUser;
import buchungssystem.models.application.User;

public class UserDB implements IUser{
	
	DBconnection conn;

	public UserDB() {
		conn = new DBconnection("root", "root");
	}

	@Override
	public List<User> getAll() {
		// TODO view of all users in the system
		return null;
	}

	@Override
	public User getById(Long id) {
		// TODO getting a user by ID
		return null;
	}

	@Override
	public boolean add(User model) {
		// TODO adding a new user 
		return false;
	}

	@Override
	public boolean update(User model) {
		// TODO save updating a existing user 
		// userID in all referenced rows in child-tables should to be changed !!
		return false;
	}

	@Override
	public boolean softDelete(User model) {
		// TODO soft deleting 
		return false;
	}

	@Override
	public User getByLogin(String login, String password) {
		// TODO boolean returnCode implement  
		//initialize connection
		Connection mysqlConnect = conn.init();
		
		ResultSet isExists;
		PreparedStatement sqlStmt;
		User currentUser = null;
		
		//check if User exists
		String sqlQuery = "select exists(select login from user where login=? and passw = md5(?)) as 'isExists'";
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setString(1, login);
			sqlStmt.setString(2, password);
			isExists = sqlStmt.executeQuery();
			isExists.next();
			if (isExists.getBoolean(1) == true){
				//sqlQuery = "select userID, employeeID from user natural join employee where login = ?";
				sqlQuery = "select user.userID, employeeID from user join employee on employee.userID = user.userID where login = ?";
				sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
				sqlStmt.setString(1, login);
				isExists = sqlStmt.executeQuery();
				isExists.next();
				Long userID = isExists.getLong(1);
				Long employeeID = isExists.getLong(2);
				currentUser = new User(userID);
				currentUser.setEmployeeID(employeeID);
				currentUser.setLogin(login);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//close connection
		conn.finalize();
		
		return currentUser;
	}

	@Override
	public boolean delete(User model) {
		// TODO hard delete a user obj from system
		return false;
	}

}
