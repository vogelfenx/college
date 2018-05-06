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
		// DONE adding a new user
		
		boolean status = false;
		
		//initialize connection
		Connection mysqlConnect = conn.init();
		
		String sqlQuery = "INSERT INTO User ("
				+ "userRoleID, "
				+ "login, "
				+ "passw) "
				+ "VALUES (?,?,md5(?))";
		
		PreparedStatement sqlStmt;
		
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			
			sqlStmt.setLong(1, model.getUserRoleID());
			sqlStmt.setString(2, model.getLogin());
			sqlStmt.setString(3, model.getPassword());
			sqlStmt.executeUpdate();
			status = true;
			
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		}
		
		//close connection
		conn.finalize();
		
		return status;
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
				sqlQuery = "select user.userID, employeeID, user.userRoleID from user join employee on employee.userID = user.userID where login = ?";
				sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
				sqlStmt.setString(1, login);
				isExists = sqlStmt.executeQuery();
				isExists.next();
				
				isExists.getLong(1);
				Long userID = isExists.wasNull() ? null : isExists.getLong(1);
				
				isExists.getLong(2);
				Long employeeID = isExists.wasNull() ? null : isExists.getLong(2);
				
				isExists.getLong(3);
				Long userRoleID = isExists.wasNull() ? null : isExists.getLong(3);
				
				currentUser = new User(userID);
				currentUser.setEmployeeID(employeeID);
				currentUser.setLogin(login);
				currentUser.setUserRoleID(userRoleID);
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
