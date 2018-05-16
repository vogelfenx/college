package buchungssystem.dao.Impl.MySQL.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.application.IUserRoleHasPermission;
import buchungssystem.models.application.UserRoleHasPermission;

public class UserRoleHasPermissionDB implements IUserRoleHasPermission {

	DBconnection conn;
	Connection mysqlConnect;
	
	public UserRoleHasPermissionDB() {
		conn = new DBconnection("root", "root");
		mysqlConnect = conn.init();
	}
	
	@Override
	public List<UserRoleHasPermission> getAll() {

		return null;
	}

	@Override
	public UserRoleHasPermission getById(Long id) {
		
		return null;
	}

	//configure permissions for a role of users(for a group)
	@Override
	public boolean add(UserRoleHasPermission model) {
		boolean returnCode = false;
		
		//initialize connection
		Connection mysqlConnect = conn.init();
		
		String sqlQuery = "INSERT INTO UserRoleHasPermission (userRoleID, permissionID) VALUES (?,?)";
		
		PreparedStatement sqlStmt;
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setInt(1, model.getUserRoleID());
			sqlStmt.setInt(2, model.getPermissionsID());
			sqlStmt.executeUpdate();
			returnCode = true;
		} catch (SQLException e) {
			returnCode = false;
			e.printStackTrace();
		}
		
		return returnCode;
	}

	@Override
	public boolean update(UserRoleHasPermission model) {

		return false;
	}

	@Override
	public boolean softDelete(UserRoleHasPermission model) {

		return false;
	}

	@Override
	public boolean delete(UserRoleHasPermission model) {

		return false;
	}

}
