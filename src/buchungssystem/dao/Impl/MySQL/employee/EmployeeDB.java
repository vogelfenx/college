package buchungssystem.dao.Impl.MySQL.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.employee.IEmployeeDao;
import buchungssystem.models.employee.Employee;

public class EmployeeDB implements IEmployeeDao{

	DBconnection conn;
	
	public EmployeeDB() {
		conn = new DBconnection("root", "root");
	}
	
	@Override
	public List<Employee> getAll() {

		return null;
	}

	@Override
	public Employee getById(Long id) {
		
		//initialize connection
		Connection mysqlConnect = conn.init();
		
		ResultSet resultSet;
		PreparedStatement sqlStmt;
		String sqlQuery;
		Employee currentEmployee = new Employee(id);
		
		sqlQuery = "select userID,"
				+ " roleID, role, "
				+ "departmentID, "
				+ "firstName, lastName,"
				+ "firmaEmail,"
				+ "phoneNumber,"
				+ "isValid"
				+ " from employee"
				+ " NATURAL JOIN role where employeeID = ?";
		
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setLong(1, id);
			resultSet = sqlStmt.executeQuery();
			resultSet.next();
							
			resultSet.getLong(1);
			Long userID = resultSet.wasNull() ? null : resultSet.getLong(1);  

			resultSet.getLong(2);
			Long roleID = resultSet.wasNull() ? null : resultSet.getLong(2);

			resultSet.getString(3);
			String role = resultSet.wasNull() ? null : resultSet.getString(3);
					
			resultSet.getLong(4);
			Long departmentID = resultSet.wasNull() ? null : resultSet.getLong(4);
			
			resultSet.getString(5);
			String firstName = resultSet.wasNull() ? null : resultSet.getString(5);

			resultSet.getString(6);
			String lastName = resultSet.wasNull() ? null : resultSet.getString(6);
			
			resultSet.getString(7);
			String email = resultSet.wasNull() ? null : resultSet.getString(7);
				
			resultSet.getString(8);
			String phoneNumber = resultSet.wasNull() ? null : resultSet.getString(8);
			
			resultSet.getBoolean(9);
			boolean isValid = resultSet.wasNull() ? null : resultSet.getBoolean(9);

			currentEmployee.setUserID(userID);
			currentEmployee.setRoleID(roleID);
			currentEmployee.setRole(role);
			currentEmployee.setDepartmentID(departmentID);
			currentEmployee.setFirstName(firstName);
			currentEmployee.setLastName(lastName);
			currentEmployee.setEmail(email);
			currentEmployee.setPhoneNumber(phoneNumber);
			currentEmployee.setValid(isValid);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//close connection
		conn.finalize();

		return currentEmployee;
	}

	@Override
	public boolean add(Employee model) {
		
		boolean status;
		
		//initialize connection
		Connection mysqlConnect = conn.init();
		
		String sqlQuery = "INSERT INTO Employee ("
				+ "departmentID, "
				+ "roleID, "
				+ "userID, "
				+ "firstName, "
				+ "lastName, "
				+ "firmaEmail, "
				+ "phoneNumber, "
				+ "lastID) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement sqlStmt;
		
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			
			if (model.getDepartmentID() != null) {
				sqlStmt.setInt(1, model.getDepartmentID().intValue());
			} else {
				sqlStmt.setString(1, null);
			}

			if (model.getRoleID() != null){
				sqlStmt.setInt(2, model.getRoleID().intValue());
			} else {
				sqlStmt.setString(2, null);
			}
			
			if (model.getUserID() != null){
				sqlStmt.setInt(3, model.getUserID().intValue());
			} else {
				sqlStmt.setString(3, null);
			}
			
			sqlStmt.setString(4, model.getFirstName());
			
			sqlStmt.setString(5, model.getLastName());

			sqlStmt.setString(6, model.getEmail());

			if (model.getPhoneNumber() != null){
				sqlStmt.setString(7, model.getPhoneNumber());
			} else {
				sqlStmt.setString(7, null);
			}
			
			sqlStmt.setInt(8, model.getLastID().intValue());

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
	public boolean update(Employee model) {
		boolean status = false;
		//initialize connection
		Connection mysqlConnect = conn.init();
		
		String sqlQuery = "UPDATE Employee SET "
				+ "departmentID = ?, "
				+ "roleID = ?, "
				+ "userID = ?, "
				+ "firstName = ?, "
				+ "lastName = ?, "
				+ "firmaEmail = ?, "
				+ "phoneNumber = ?, "
				+ "validTill = null "
				+ "WHERE employeeID = ?";
		try {
			PreparedStatement sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			
			if (model.getDepartmentID() != null) {
				sqlStmt.setInt(1, model.getDepartmentID().intValue());
			} else {
				sqlStmt.setString(1, null);
			}
			
			if (model.getRoleID() != null) {
				sqlStmt.setInt(2, model.getRoleID().intValue());
			} else {
				sqlStmt.setString(2, null);
			}
			
			if (model.getUserID() != null) {
				sqlStmt.setInt(3, model.getUserID().intValue());
			} else {
				sqlStmt.setString(3, null);
			}
			
			if (model.getFirstName() != null) {
				sqlStmt.setString(4, model.getFirstName());
			} else {
				sqlStmt.setString(4, null);
			}
			
			if (model.getLastName() != null) {
				sqlStmt.setString(5, model.getLastName());
			} else {
				sqlStmt.setString(5, null);
			}
			
			if (model.getEmail() != null) {
				sqlStmt.setString(6, model.getEmail());
			} else {
				sqlStmt.setString(6, null);
			}
			
			if (model.getPhoneNumber() != null) {
				sqlStmt.setString(7, model.getPhoneNumber());
			} else {
				sqlStmt.setString(7, null);
			}
			
			if (model.getId() != null) {
				sqlStmt.setInt(8, model.getId().intValue());
			} else {
				sqlStmt.setString(8, null);
			}
			
			sqlStmt.executeUpdate();
			
			status = true;
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		}
		
		
		
		return status;
	}

	//update isValid status to false (= 0 = disabled)
	@Override
	public boolean softDelete(Employee model) {
		
		boolean status;
		
		//initialize connection
		Connection mysqlConnect = conn.init();
		
		//disable this employee and set firmaEmail(primary key) to null
		String sqlQuery = "UPDATE Employee SET isValid = 0, firmaEmail = employeeID where employeeID = ?";
		try {
			PreparedStatement sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setInt(1, model.getId().intValue());
			sqlStmt.executeUpdate();
			model = null;
			status = true;
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		}	
		
		//close connection
		conn.finalize();
		
		return status;
	}

	//delete permanently
	@Override
	public boolean delete(Employee model) {
		
		return false;
	}

}
