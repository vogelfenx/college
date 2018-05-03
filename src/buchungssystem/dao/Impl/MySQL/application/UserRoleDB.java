package buchungssystem.dao.Impl.MySQL.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.application.IUserRole;
import buchungssystem.models.application.UserRole;

public class UserRoleDB implements IUserRole {
	
	DBconnection conn;
	
	public UserRoleDB() {
		conn = new DBconnection("root", "root");
	}

	@Override
	public List<UserRole> getAll() {
		// TODO view all users role's in the system
		return null;
	}

	@Override
	public UserRole getById(Long id) {
		// TODO getting a users role by ID
		return null;
	}

	@Override
	public boolean add(UserRole model) {
		boolean status;
		
		//initialize connection
		Connection mysqlConnect = conn.init();
		
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
		conn.finalize();
		
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
