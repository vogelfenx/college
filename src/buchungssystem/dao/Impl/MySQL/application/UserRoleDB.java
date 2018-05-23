package buchungssystem.dao.Impl.MySQL.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.application.IUserRole;
import buchungssystem.models.application.UserRole;

public class UserRoleDB implements IUserRole {
	
	DBconnection conn;
	Connection mysqlConnect;
	
	public UserRoleDB() {
		conn = new DBconnection("root", "root");
		mysqlConnect = conn.init();
	}

	@Override
	public List<UserRole> getAll() {
		// DONE view all users role's in the system
		
		List<UserRole> userRoles = new ArrayList<>();
		UserRole role;
		ResultSet resultSet = null;
		String sqlQuery = "SELECT userRoleID, "
				+ "role FROM UserRole";
		try {
			PreparedStatement sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			resultSet = sqlStmt.executeQuery();
			while (resultSet.next()) {
				Long userRoleID = resultSet.getLong(1);
				
				resultSet.getString(2);
				String roleTitle = resultSet.wasNull() ? null : resultSet.getString(2);
				
				role = new UserRole(userRoleID);
				role.setRole(roleTitle);
				userRoles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userRoles;
	}

	@Override
	public UserRole getById(Long id) {
		// DONE implementation of getting an user role by ID
		//Connection mysqlConnect = conn.init();
		
		UserRole userRole = new UserRole(id);
		
		ResultSet resultSet;
		
		String sqlQuery = "SELECT role FROM UserRole where userRoleID=?";
		
		try {
			PreparedStatement sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setLong(1, id);
			resultSet = sqlStmt.executeQuery();
			resultSet.next();
			
			resultSet.getString(1);
			String role = resultSet.wasNull() ? null : resultSet.getString(1); 
			
			userRole.setRole(role);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userRole;
	}

	@Override
	public boolean add(UserRole model) {
		boolean status;
		
		//initialize connection
		//Connection mysqlConnect = conn.init();
		
		String sqlQuery = "INSERT INTO UserRole(role) VALUE(?)";
		try {
			PreparedStatement sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setString(1, model.getRole());
			sqlStmt.executeUpdate();
			status = true;
		} catch (SQLException e) {
			e.printStackTrace();
			status = false;
		}
		
		//close connection
		//conn.finalize();
		
		return status;
	}

	@Override
	public boolean update(UserRole model) {
		// TODO safe updating a existing users role
		// !! check the referenced rows in child tables !!
		return false;
	}

	@Override
	public boolean softDelete(UserRole model) {
		// TODO soft deleting a users role
		// userID in all referenced rows in child-tables should to be changed
		return false;
	}

	@Override
	public boolean delete(UserRole model) {
		// TODO hard deleting from the system
		return false;
	}

}
