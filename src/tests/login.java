package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import buchungssystem.models.application.User;
import buchungssystem.models.application.UserRoleHasPermission;
import buchungssystem.models.employee.Employee;
import buchungssystem.models.employee.Role;
import buchungssystem.models.product.Department;
import buchungssystem.models.product.ProductCategory;
import buchungssystem.models.roles.CurrentUser;

public class login {
	boolean status = false;
	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Login: ");
		String login = sc.nextLine().trim();
		
		System.out.print("Password: ");
		String passwd = sc.nextLine().trim();
		
		sc.close();
		
		Authorization session = new Authorization(login, passwd);
		//wenn den Benutzer nicht gibt, dann Properties sind leer.
		if (session.getPermissions().size() != 0  ) {
			System.out.println(session.getPermissions());
		}
		CurrentUser currentUser = session.getCurrentUser();
		if (session.getPermissions().getProperty("addUser") == "true") {
			
			//add new employee to the system ->
//			status = currentUser.addEmployeeToDB("Kirill", "Petrov", "kp@gmail.com");
			
			//update an Employee by ID ->
//			status = currentUser.updateEmployee(((long)60), new Employee("Ser", "Iljukhin", "vp71@gmail.com"));
			
			//add new role to system ->
//			status = currentUser.addRoleToDB("Demo");
			
			//configure the Permissions of user's role by ID.
//			UserRoleHasPermission userRolePermission = new UserRoleHasPermission();
//			userRolePermission.setPermissionsID(1);
//			userRolePermission.setUserRoleID(4);
//			status = currentUser.configureUserRolePermissions(userRolePermission);
			
			//add new role of employee to the db
//			Role role = new Role();
//			role.setRole("Neuling");
//			status = currentUser.addEmployeeRole(role);
			
			//add new user to db
//			User newUser = new User();
//			newUser.setLogin("Kirill-12");
//			newUser.setPassword("kirill");
//			newUser.setUserRoleID(((long)4));
//			status = currentUser.addUser(newUser);
			
			//adapt user obj to employee obj
//			status = currentUser.adaptUserToEmployee((long) 13, (long) 90);			
			
			//get a view of all users in the system
//			status = currentUser.getAllUsers();
			
			//get a view of all Employees in the system
//			List<Employee> employees = new ArrayList<>();
//			employees = currentUser.getAllEmployees();
			
			//soft delete Employee
//			Employee employee = new Employee((long) 90);
//			employee.setUserID((long) 13);
//			status = currentUser.SoftDeleteEmployee(employee);
			
			//get User by ID
			User user = currentUser.getUserByID((long) 7);
			System.out.println(user.toString());
			
			//get Department by ID
//			Department department = currentUser.getDepartmentByID((long) 12);
//			System.out.println(department.toString());
			
			//get all departments in the system
/*			List<Department> departments = new ArrayList<>();
			departments = currentUser.getAllDepartments();
			
			for (Department department : departments) {
				System.out.println("ID: " + department.getId() + ", " + department.toString() + "\n" + "--");
/*			}
			
			
			//add new department to the system
//			Department department = new Department();
//			department.setTitle("Elektrowerkzeuge");
//			status = currentUser.addDepartmentToDB(department);
			
			//add new Category of a product
//			ProductCategory productCategory = new ProductCategory();
//			productCategory.setProductCategoryName("HammerSu");
//			productCategory.setDepartmentID((long) 12);
//			status = currentUser.addProductCategoryToDB(productCategory);
			
			//get Category of a product by ProductCategoryID
//			ProductCategory productCategory = currentUser.getProductCategoryByID((long) 10);
//			System.out.println(productCategory.toString());
			
			//get all Categories of a product
/*			List <ProductCategory> productCategories = new ArrayList<ProductCategory>();
			productCategories = currentUser.getAllProductCategories();
		
			for (ProductCategory productCategory : productCategories) {
				System.out.println("ID: " + productCategory.getId() + " " + productCategory.toString()+ "\n" + "--");
			}
*/			//
			
		}
		System.out.println(status);
	}

}
