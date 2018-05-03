package buchungssystem.dao.Impl.MySQL.application;

import java.util.List;

import buchungssystem.dao.i.application.IPermission;
import buchungssystem.models.application.Permission;

public class PermissionDB implements IPermission {

	@Override
	public List<Permission> getAll() {
		// TODO view of all permissions in system
		//at this time the feature isn't necessary for the application
		return null;
	}

	@Override
	public Permission getById(Long id) {
		// TODO select a permission to view permission's details
		//at this time the feature isn't necessary for the application
		return null;
	}

	@Override
	public boolean add(Permission model) {
		return false;
	}

	@Override
	public boolean update(Permission model) {
		return false;
	}

	@Override
	public boolean softDelete(Permission model) {
		return false;
	}

	@Override
	public boolean delete(Permission model) {
		return false;
	}

}
