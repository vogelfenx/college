package buchungssystem.models.roles;

import java.util.ArrayList;
import java.util.List;

import buchungssystem.dao.daoImpl.File.EmployeeFile;
import buchungssystem.dao.daoImpl.MySQL.EmployeeDB;
import buchungssystem.dao.daoImpl.MySQL.UserRoleDB;
import buchungssystem.models.Employee;
import buchungssystem.models.UserRole;

public class Users {
	private String login;
	
	public Users() {
		
	}
	
	public Users(String login) {
		this.login = login;
	}
	
	//Einen neuen Mitarbeiter in der Datenbank hinzufügen.
	public boolean addEmployeeToDB(String firstName, String lastName, String email) {
		boolean returnCode=false;
				
		//create new Employee 
		Employee newEmployee = new Employee(firstName, lastName, email);
		EmployeeDB emplImpl = new EmployeeDB();
		
		returnCode = emplImpl.add(newEmployee);
		
		return returnCode;
	}

	//Mitarbeiter-Liste von einer csv-Datei in die DB importieren.
	public boolean importEmployeesToDB(String file) {
		boolean status = false;
		List <Employee> employees = new ArrayList<Employee>();
		
		//Erstellung eines neues Objektes der Class EmployeeFile(DaoImpl) 
		EmployeeFile newEmployee = new EmployeeFile(file);
		
		//getAll(): List <Employee>
		employees = newEmployee.getAll();
		
		for (Employee employee : employees) {
			addEmployeeToDB(employee.getFirstName(), employee.getLastName(), employee.getEmail());
		}
		if (employees == null || employees.size() == 0) {
			status = false;
		}
		return status;	
	}
	
	public boolean addRoleToDB(String role) {
		boolean status = false;
		UserRole userRoleObj = new UserRole(role);
		UserRoleDB userRoleDB = new UserRoleDB();
		status = userRoleDB.add(userRoleObj);
		return status;
	}
	
	public boolean updateEmployee(Long EmployeeID) {
		boolean status = false;
		EmployeeDB employeeDB = new EmployeeDB();
		Employee employeeObj = employeeDB.getById(EmployeeID);
		System.out.println(employeeObj.toString());
		
		//disable this employee
		employeeDB.softDelete(employeeObj);	
		//employeeDB = new EmployeeDB();
		
		//copy this employee into next row with updated attributes
		System.out.println(employeeObj.toString());
		status = employeeDB.add(employeeObj);
		
		return status;
	}
	
	
	//getter&setter
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
}
