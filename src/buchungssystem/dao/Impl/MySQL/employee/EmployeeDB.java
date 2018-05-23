package buchungssystem.dao.Impl.MySQL.employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.employee.IEmployeeDao;
import buchungssystem.models.employee.Employee;

public class EmployeeDB implements IEmployeeDao{

	DBconnection conn;
	Connection mysqlConnect;
	
	public EmployeeDB() {
		conn = new DBconnection("root", "root");
		mysqlConnect = conn.init();
	}
	
	@Override
	public List<Employee> getAll() {
		//DONE implementation of a view of all employees in the system
		
		List<Employee> employees = new ArrayList<Employee>();
		
		ResultSet resultSet = null;
		
		String sqlQuery = "SELECT employeeID, "
				+ "departmentID, "
				+ "roleID, "
				+ "userID, "
				+ "firstName, "
				+ "lastName, "
				+ "firmaEmail, "
				+ "phoneNumber, "
				+ "validFrom, "
				+ "validTill, "
				+ "isValid, "
				+ "lastID "
				+ "FROM Employee";
		
		try {
			PreparedStatement sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			resultSet = sqlStmt.executeQuery();
			while (resultSet.next()) {
				Long employeeID = resultSet.getLong(1);
				
				resultSet.getLong(2);
				Long departmentID = resultSet.wasNull() ? null: resultSet.getLong(2);                            
				                                                                                            
				resultSet.getLong(3);                                                                       
				Long roleID = resultSet.wasNull() ? null : resultSet.getLong(3);
				
				resultSet.getLong(4);                                                                       
				Long userID = resultSet.wasNull() ? null : resultSet.getLong(4);
				                       				                                                                                            
				resultSet.getString(5);                                                                     
				String firstName = resultSet.wasNull() ? null : resultSet.getString(5);                     
				                                                                                            
				resultSet.getString(6);                                                                     
				String lastName = resultSet.wasNull() ? null : resultSet.getString(6);                      
				                                                                                            
				resultSet.getString(7);                                                                     
				String email = resultSet.wasNull() ? null : resultSet.getString(7);                         
					                                                                                        
				resultSet.getString(8);                                                                     
				String phoneNumber = resultSet.wasNull() ? null : resultSet.getString(8);                   
				
				resultSet.getDate(9);
				Date validFrom = resultSet.wasNull() ? null : resultSet.getDate(9);
				
				resultSet.getDate(10);
				Date validTill = resultSet.wasNull() ? null : resultSet.getDate(10);
				
				resultSet.getBoolean(11);                                                                    
				boolean isValid = resultSet.wasNull() ? null : resultSet.getBoolean(11);
				
				resultSet.getLong(12);
				Long lastID = resultSet.wasNull() ? null : resultSet.getLong(12);
				
				Employee employee = new Employee(employeeID);
				                                                                                                                                                                                                                                                
				employee.setDepartmentID(departmentID);
				employee.setRoleID(roleID);
				employee.setUserID(userID);
				employee.setFirstName(firstName);                                                    
				employee.setLastName(lastName);                                                      
				employee.setEmail(email);                                                            
				employee.setPhoneNumber(phoneNumber);
				
				if (validFrom != null) {
					GregorianCalendar gregorianValidFrom = new GregorianCalendar();
					gregorianValidFrom.setTime(validFrom);
					employee.setValidFrom(gregorianValidFrom);
				}
				
				if (validTill != null) {
					GregorianCalendar gregorianValidTill = new GregorianCalendar();
					gregorianValidTill.setTime(validTill);
					employee.setValidTill(gregorianValidTill);
				}
				
				employee.setValid(isValid);
				employee.setLastID(lastID);
	
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public Employee getById(Long id) {
		//TODO remove role + join statement in sqlQuery
		//TODO date fields & other fields implementation
		
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
			boolean isValid = resultSet.wasNull() ? false : resultSet.getBoolean(9);

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
		//conn.finalize();

		return currentEmployee;
	}
	
	public Employee getByUserID(Long userID) {
		
		Employee employee = new Employee();
		
		GregorianCalendar gregorianDate = new GregorianCalendar();
		
		ResultSet resultSet;
		
		String sqlQuery = "SELECT employeeID, "
				+ "departmentID, "
				+ "roleID, "
				+ "firstName, "
				+ "lastName, "
				+ "firmaEmail, "
				+ "phoneNumber, "
				+ "validFrom, "
				+ "validTill, "
				+ "isValid, "
				+ "lastID "
				+ "FROM Employee WHERE userID = ?";
		
		try {
			PreparedStatement sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setLong(1, userID);
			resultSet = sqlStmt.executeQuery();
			resultSet.next();
			
			resultSet.getLong(1);
			Long employeeID = resultSet.wasNull() ? null : resultSet.getLong(1);
			
			resultSet.getLong(2);
			Long departmentID = resultSet.wasNull() ? null : resultSet.getLong(2);
			
			resultSet.getLong(3);
			Long roleID = resultSet.wasNull() ? null : resultSet.getLong(3);
			
			resultSet.getString(4);
			String firstName = resultSet.wasNull() ? null : resultSet.getString(4);
			
			resultSet.getString(5);
			String lastName = resultSet.wasNull() ? null : resultSet.getString(5);
			
			resultSet.getString(6);
			String firmaEmail = resultSet.wasNull() ? null : resultSet.getString(6);
			
			resultSet.getString(7);
			String phoneNumber = resultSet.wasNull() ? null : resultSet.getString(7);
			
			resultSet.getDate(8);
			Date validFrom = resultSet.wasNull() ? null : resultSet.getDate(8);
			
			resultSet.getDate(9);
			Date validTill = resultSet.wasNull() ? null : resultSet.getDate(9);
			
			resultSet.getBoolean(10);
			boolean isValid = resultSet.wasNull() ? null : resultSet.getBoolean(10);
			
			resultSet.getLong(11);
			Long lastID = resultSet.wasNull() ? null : resultSet.getLong(11);
			
			employee.setId(employeeID);
			employee.setDepartmentID(departmentID);
			employee.setRoleID(roleID);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(firmaEmail);
			employee.setPhoneNumber(phoneNumber);
			
			if (validFrom != null) {
				gregorianDate.setTime(validFrom);
				employee.setValidFrom(gregorianDate);
			}
			
			if (validTill != null) {
				gregorianDate.setTime(validTill);
				employee.setValidTill(gregorianDate);
			}
			
			employee.setValid(isValid);
			employee.setLastID(lastID);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return employee;	
	}

	@Override
	public boolean add(Employee model) {
		
		boolean status;		
		
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
				//Default 0 = Neulinge
				sqlStmt.setInt(2, 0);
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
			
			if (model.getLastID() != null) {
				sqlStmt.setInt(8, model.getLastID().intValue());
			} else {
				sqlStmt.setInt(8, 0);
			}
			
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
	public boolean update(Employee model) {
		boolean status = false;
		
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
		//conn.finalize();
		
		return status;
	}

	//delete permanently
	@Override
	public boolean delete(Employee model) {
		
		return false;
	}

}
