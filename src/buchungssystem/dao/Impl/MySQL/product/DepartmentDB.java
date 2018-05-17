package buchungssystem.dao.Impl.MySQL.product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jws.WebParam.Mode;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.product.IDepartment;
import buchungssystem.models.product.Department;

public class DepartmentDB implements IDepartment {
	
	DBconnection conn;
	Connection mysqlConnect;
	
	private Long departmentID;
	private String title;
	private Date validFrom;
	private Date validTill;
	private boolean isValid;
	private Long lastID;
	
	public DepartmentDB() {
		conn = new DBconnection("root", "root");
		mysqlConnect = conn.init();
	}

	@Override
	public List<Department> getAll() {
		// DONE implementation of a view of all available departments in the system
		
		List<Department> deparments = new ArrayList<Department>();
		
		ResultSet resultSet = null;
		PreparedStatement sqlStmt;
		String sqlQuery;
		
		sqlQuery = "SELECT departmentID, "
				+ "title, "
				+ "validFrom, "
				+ "validTill, "
				+ "isValid, "
				+ "lastID "
				+ "FROM Department";
		
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			resultSet = sqlStmt.executeQuery();
			while (resultSet.next()) {
				
				resultSet.getLong(1);
				departmentID = resultSet.wasNull() ? null : resultSet.getLong(1);
				
				resultSet.getString(2);
				title = resultSet.wasNull() ? null : resultSet.getString(2);
				
				resultSet.getDate(3);
				validFrom = resultSet.wasNull() ? null : resultSet.getDate(3);
				
				resultSet.getDate(4);
				validTill = resultSet.wasNull() ? null : resultSet.getDate(4);
				
				resultSet.getBoolean(5);
				isValid = resultSet.wasNull() ? false : resultSet.getBoolean(5);
				
				resultSet.getLong(6);
				lastID = resultSet.wasNull() ? null : resultSet.getLong(6);
				
				Department department = new Department();
				
				department.setId(departmentID);
				department.setTitle(title);
				
				if (validFrom != null) {
					GregorianCalendar gregorianValidFrom = new GregorianCalendar();
					gregorianValidFrom.setTime(validFrom);
					department.setValidFrom(gregorianValidFrom);
				}
				
				if (validTill != null) {
					GregorianCalendar gregorianValidTill = new GregorianCalendar();
					gregorianValidTill.setTime(validTill);
					department.setValidTill(gregorianValidTill);
				}
				
				department.setValid(isValid);
				department.setLastID(lastID);
				
				deparments.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deparments;
	}

	@Override
	public Department getById(Long id) {
		// DONE implementation of selecting a department by id
		
		Department department = new Department();
		
		ResultSet resultSet;
		PreparedStatement sqlStmt;
		String sqlQuery;
		
		sqlQuery = "SELECT title, "
				+ "validFrom, "
				+ "validTill, "
				+ "isValid, "
				+ "lastID "
				+ "FROM Department where departmentID = ?";
		
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setLong(1, id);
			
			resultSet = sqlStmt.executeQuery();
			resultSet.next();
			
			resultSet.getString(1);
			title = resultSet.wasNull() ? null : resultSet.getString(1);
			
			resultSet.getDate(2);
			validFrom = resultSet.wasNull() ? null : resultSet.getDate(2);
			
			resultSet.getDate(3);
			validTill = resultSet.wasNull() ? null : resultSet.getDate(3);
			
			resultSet.getBoolean(4);
			isValid = resultSet.wasNull() ? false : resultSet.getBoolean(4);
			
			resultSet.getLong(5);
			lastID = resultSet.wasNull() ? null : resultSet.getLong(5);
			
			department.setTitle(title);
			
			if (validFrom != null) {
				GregorianCalendar gregorianValidFrom = new GregorianCalendar();
				gregorianValidFrom.setTime(validFrom);
				department.setValidFrom(gregorianValidFrom);
			}
			
			if (validTill != null) {
				GregorianCalendar gregorianValidTill = new GregorianCalendar();
				gregorianValidTill.setTime(validTill);
				department.setValidTill(gregorianValidTill);
			}
			
			department.setValid(isValid);
			department.setLastID(lastID);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return department;
	}

	@Override
	public boolean add(Department model) {
		// DONE implementation of adding new department to system
		boolean	status = false;
		
		String sqlQuery;
		PreparedStatement sqlStmt;
		
		sqlQuery = "INSERT INTO Department ("
				+ "title, "
				+ "lastID) "
				+ "VALUES (?,?)";
		
			try {
				sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
				
			    if (model.getTitle() != null) {
			    	sqlStmt.setString(1, model.getTitle());
			    } else {
			    	sqlStmt.setString(1, null);
			    }
			    
			    if (model.getLastID() != null) {
			    	sqlStmt.setLong(2, model.getLastID());
			    } else {
			    	sqlStmt.setLong(2, 0);
			    }
			    
			    sqlStmt.executeUpdate();
			    status = true;
			
			} catch (SQLException e) {
				status = false;
				e.printStackTrace();
			}
		return status;
	}

	@Override
	public boolean update(Department model) {
		// TODO implementation of save updating a department (copy the department object & and insert this to a new row)
		// !! by copy in new row should to be changed to new ID by all referenced rows in child-tables !! 
		return false;
	}

	@Override
	public boolean softDelete(Department model) {
		// TODO soft delete a department
		// by disabling should to be disabled all referenced rows in child-tables !!
		return false;
	}

	@Override
	public boolean delete(Department model) {
		// TODO hard delete from system
		return false;
	}

}
