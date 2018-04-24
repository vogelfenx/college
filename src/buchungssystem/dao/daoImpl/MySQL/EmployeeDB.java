package buchungssystem.dao.daoImpl.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import buchungssystem.dao.IEmployeeDao;
import buchungssystem.models.Employee;

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
			
			Long userID  = resultSet.getLong(1);
			Long roleID = resultSet.getLong(2);
			String role = resultSet.getString(3);
			Long departmentID = resultSet.getLong(4);
			String firstName = resultSet.getString(5);
			String lastName = resultSet.getString(6);
			String email = resultSet.getString(7);
			String phoneNumber = resultSet.getString(8);
			boolean isValid = resultSet.getBoolean(9);
			
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
			// TODO Auto-generated catch block
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
		
		String sqlQuery = "INSERT INTO employee(firstName, lastName, firmaEmail) VALUES(?,?,?)";
		try {
			PreparedStatement sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setString(1, model.getFirstName());
			sqlStmt.setString(2, model.getLastName());
			sqlStmt.setString(3, model.getEmail());
			sqlStmt.executeUpdate();
			status = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = false;
		}
		
		//close connection
		conn.finalize();
		
		return status;
	}

	@Override
	public boolean update(Employee model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Employee model) {
		// TODO Auto-generated method stub
		return false;
	}

}
