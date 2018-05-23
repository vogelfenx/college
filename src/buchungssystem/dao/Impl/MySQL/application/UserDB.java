package buchungssystem.dao.Impl.MySQL.application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.application.IUser;
import buchungssystem.models.application.User;
import buchungssystem.models.employee.Employee;

public class UserDB implements IUser{
	
	DBconnection conn;
	Connection mysqlConnect;

	public UserDB() {
		conn = new DBconnection("root", "root");
		mysqlConnect = conn.init();
	}

	@Override
	public List<User> getAll() {
		// DONE implementation of a view of all users in the system
		
		Connection mysqlConnect = conn.init();
		
		List<User> users = new ArrayList<User>();
		
		ResultSet resultSet = null;
		
		String sqlQuery = "SELECT userID,"
				+ "userRoleID,"
				+ "login,"
				+ "validFrom "
				+ "FROM User";
		
		try {
			PreparedStatement sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			resultSet = sqlStmt.executeQuery();
			while (resultSet.next()) {
				Long userID = resultSet.getLong(1);
				
				resultSet.getLong(2);
				Long roleID = resultSet.wasNull() ? null : resultSet.getLong(2);
				
				resultSet.getString(3);
				String login = resultSet.wasNull() ? null : resultSet.getString(3);
				
				resultSet.getDate(4);
				Date validFrom = resultSet.wasNull() ? null : resultSet.getDate(4);
				GregorianCalendar creatingDate = new GregorianCalendar();
				creatingDate.setTime(validFrom);
				
				
				User user = new User(userID);
				
				user.setUserRoleID(roleID);
				user.setLogin(login);
				user.setValidFrom(creatingDate);
				
				users.add(user);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	@Override
	public User getById(Long id) {
		// TODO implementation of a getting a user by ID
		
		User user = new User(id);
		
		GregorianCalendar gregorianDate = new GregorianCalendar();
		
		ResultSet resultSet;
		PreparedStatement sqlStmt;
		
		String sqlQUery = "SELECT userRoleID, "
				+ "login, "
				+ "validFrom, "
				+ "validTill, "
				+ "isValid, "
				+ "lastID "
				+ "FROM User where userID = ?";
		
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQUery);
			sqlStmt.setLong(1, id);
			resultSet = sqlStmt.executeQuery();
			resultSet.next();
			
			resultSet.getLong(1);
			Long userRoleID = resultSet.wasNull() ? null : resultSet.getLong(1);
			
			resultSet.getString(2);
			String login = resultSet.wasNull() ? null : resultSet.getString(2);
			
			resultSet.getDate(3);
			Date validFrom = resultSet.wasNull() ? null : resultSet.getDate(3);
			
			resultSet.getDate(4);
			Date validTill = resultSet.wasNull() ? null : resultSet.getDate(4);
			
			resultSet.getBoolean(5);
			Boolean isValid = resultSet.wasNull() ? null : resultSet.getBoolean(5);
			
			resultSet.getLong(6);
			Long lastID = resultSet.wasNull() ? null : resultSet.getLong(6);
			
			user.setUserRoleID(userRoleID);
			user.setLogin(login);
			
			if (validFrom != null) {
				gregorianDate.setTime(validFrom);
				user.setValidFrom(gregorianDate);
			}
			if (validTill != null) {
				gregorianDate.setTime(validTill);
				user.setValidTill(gregorianDate);
			}
			
			user.setValid(isValid);
			user.setLastID(lastID);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean add(User model) {
		// DONE implementation of adding a new user
		
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
		//conn.finalize();
		
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
		// TODO implementation of a soft deleting 
		boolean status = false;
		
		String sqlQuery = "UPDATE User SET isValid = 0, passw = '' WHERE userID = ?";
		try {
			PreparedStatement sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setLong(1, model.getId());
			sqlStmt.executeUpdate();
			status = true;
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		}
		return status;
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
				sqlQuery = "select user.userID, "
						+ "employeeID, "
						+ "user.userRoleID, "
						+ "user.isValid from user join employee on employee.userID = user.userID where login = ?";
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
				
				isExists.getBoolean(4);
				boolean isValid = isExists.wasNull() ? null : isExists.getBoolean(4);
				
				currentUser = new User(userID);
				currentUser.setEmployeeID(employeeID);
				currentUser.setLogin(login);
				currentUser.setUserRoleID(userRoleID);
				currentUser.setValid(isValid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//close connection
		//conn.finalize();
		
		return currentUser;
	}

	@Override
	public boolean delete(User model) {
		// TODO hard delete a user obj from system
		return false;
	}

	public User getByLogin(String login) {
		User user = new User();
		ResultSet resultSet;
		String sqlQuery = "select userID, "
				+ "userRoleID, "
				+ "isValid from user where login = ?";
		try {
			PreparedStatement sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setString(1, login);
			resultSet = sqlStmt.executeQuery();
			resultSet.next();
			
			Long userID = resultSet.getLong(1);
			
			resultSet.getLong(2);
			Long userRoleID = resultSet.wasNull() ? null : resultSet.getLong(2);
			
			resultSet.getBoolean(3);
			boolean isValid = resultSet.wasNull() ? null : resultSet.getBoolean(3);
			
			user.setId(userID);
			user.setUserRoleID(userRoleID);
			user.setValid(isValid);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
	}

}
