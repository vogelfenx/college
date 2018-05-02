package buchungssystem.dao.daoImpl.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import buchungssystem.dao.IUserRole;
import buchungssystem.models.application.UserRole;

public class UserRoleDB implements IUserRole {
	
	DBconnection conn;
	
	public UserRoleDB() {
		conn = new DBconnection("root", "root");
	}

	@Override
	public List<UserRole> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole getById(Long id) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean softDelete(UserRole model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserRole model) {
		// TODO Auto-generated method stub
		return false;
	}

}
