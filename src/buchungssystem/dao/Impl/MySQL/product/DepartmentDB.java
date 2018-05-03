package buchungssystem.dao.Impl.MySQL.product;

import java.util.List;

import buchungssystem.dao.i.product.IDepartment;
import buchungssystem.models.product.Department;

public class DepartmentDB implements IDepartment {

	@Override
	public List<Department> getAll() {
		// TODO for a view of all available departments in the system
		return null;
	}

	@Override
	public Department getById(Long id) {
		// TODO for selecting a department by id
		return null;
	}

	@Override
	public boolean add(Department model) {
		// TODO for adding new department to system
		return false;
	}

	@Override
	public boolean update(Department model) {
		// TODO for save updating a department (copy the department object & and insert this to a new row)
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
