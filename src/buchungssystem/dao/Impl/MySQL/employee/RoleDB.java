package buchungssystem.dao.Impl.MySQL.employee;

import java.util.List;

import buchungssystem.dao.i.employee.IRole;
import buchungssystem.models.Model;
import buchungssystem.models.employee.Role;

public class RoleDB implements IRole {

	@Override
	public List getAll() {
		// TODO view of all enabled roles for employees
		return null;
	}

	@Override
	public Model getById(Long id) {
		// TODO getting a new role object by id
		return null;
	}

	@Override
	public boolean add(Model model) {
		// TODO adding a new role object into db
		return false;
	}

	@Override
	public boolean update(Model model) {
		// TODO save updating role obj in DB
		// roleID should to be changed in referenced rows in child-tables !!
		return false;
	}

	@Override
	public boolean softDelete(Model model) {
		// TODO soft delete a role obj from db
		// by disabling should to be disabled all referenced rows in child-tables !!
		return false;
	}

	@Override
	public boolean delete(Model model) {
		// TODO hard delete a role obj
		return false;
	}


}
