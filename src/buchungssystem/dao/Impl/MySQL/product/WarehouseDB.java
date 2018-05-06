package buchungssystem.dao.Impl.MySQL.product;

import java.util.List;

import buchungssystem.dao.i.product.IWarehouse;
import buchungssystem.models.Model;

public class WarehouseDB implements IWarehouse {

	@Override
	public List<Model> getAll() {
		// TODO to get the view of all Warehouses in the system  
		return null;
	}

	@Override
	public Model getById(Long id) {
		// TODO to get a Warehouse object by ID
		return null;
	}

	@Override
	public boolean add(Model model) {
		// TODO to add a new Warehouse into the system
		return false;
	}

	@Override
	public boolean update(Model model) {
		// TODO to save update a warehouse object
		// !! update referenced rows in child tables !! 
		return false;
	}

	@Override
	public boolean softDelete(Model model) {
		// TODO disabling a warehouse object
		// !! update referenced rows in child tables !!
		return false;
	}

	@Override
	public boolean delete(Model model) {
		// TODO hard delete a warehouse object from the system
		return false;
	}

}
