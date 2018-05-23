package buchungssystem.dao.Impl.MySQL.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.employee.IRole;
import buchungssystem.models.Model;
import buchungssystem.models.employee.Role;

public class RoleDB implements IRole {
	
	DBconnection conn;
	Connection mysqlConnect;
	
	public RoleDB() {
		conn = new DBconnection("root", "root");
		mysqlConnect = conn.init();
	}

	@Override
	public List getAll() {
		// TODO to view of all enabled roles of employees
		return null;
	}

	@Override
	public Role getById(Long id) {
		// DONE implementation of a getting a new role of employees by id
		
		Role role = new Role(id);
		
		ResultSet resultSet;
		String sqlQuery = "SELECT role FROM Role where roleID=?";
		
		PreparedStatement sqlStmt;
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setLong(1, id);
			resultSet = sqlStmt.executeQuery();
			resultSet.next();
			
			resultSet.getString(1);
			String roleTitle = resultSet.wasNull() ? null : resultSet.getString(1);
			
			role.setRole(roleTitle);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return role;
	}

	@Override
	public boolean add(Role model) {
		// DONE implementation of adding a new role of employees into db
		
		boolean status = false; 
		
		//initialize connection
		//Connection mysqlConnect = conn.init();
		
		String sqlQuery = "INSERT INTO Role (role) VALUE (?)";
		
		PreparedStatement sqlStmt;
		
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			
			if (model.getRole() != null) {
				sqlStmt.setString(1, model.getRole());
				sqlStmt.executeUpdate();
			}
			
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
	public boolean update(Role model) {
		// TODO to save update role of employees in DB
		// roleID should to be changed in referenced rows in child-tables !!
		return false;
	}

	@Override
	public boolean softDelete(Role model) {
		// TODO to soft delete a role of employees from db
		// by disabling should to be disabled all referenced rows in child-tables !!
		return false;
	}

	@Override
	public boolean delete(Role model) {
		// TODO hard delete a role obj
		return false;
	}


}
