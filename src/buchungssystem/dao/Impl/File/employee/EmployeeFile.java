package buchungssystem.dao.Impl.File.employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.employee.IEmployeeDao;
import buchungssystem.models.employee.Employee;

public class EmployeeFile implements IEmployeeDao{
	
	// Die Datei, die für die DaoImpl benutzt wird.
	String file;
	
	public EmployeeFile(String file) {
		this.file=file;
	}
	
	//export from DB to file
	public boolean addAll(List<Employee> employees) {
		
		return false;
	}

	//import from file to ArrayList<>
	@Override
	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<Employee>();
		String current; 
		String[] attribute;
		
		try {
			InputStream f = new FileInputStream(file);
			DataInputStream dataIn = new DataInputStream(f);
			dataIn.readLine();
			while ((current = dataIn.readLine()) != null){
				attribute  = current.split(" ");
				Employee newEmployee = new Employee(attribute[0], attribute[1], attribute[2]);
				employees.add(newEmployee);
			}
			dataIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employees;
	}
	

	@Override
	public Employee getById(Long id) {
		return null;
	}

	@Override
	public boolean add(Employee model) {
		File file = new File("data/"+model.getLastName()+" "+model.getFirstName());
		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			fw.write("test");
			fw.flush();
			fw.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Employee model) {
		return false;
	}

	@Override
	public boolean softDelete(Employee model) {
		return false;
	}

	@Override
	public boolean delete(Employee model) {
		return false;
	}

}
