package buchungssystem.dao.Impl.MySQL.product;

import java.sql.Connection;
import java.util.List;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.product.IWarehouse;
import buchungssystem.models.Model;

public class WarehouseDB implements IWarehouse {
	
	DBconnection conn;
	Connection mysqlConnect;
	
	public WarehouseDB() {
		conn = new DBconnection("root", "root");
		mysqlConnect = conn.init();
	}

	@Override
	public List<Model> getAll() {
		// TODO implementation of getting a view of all Warehouses in the system  
		return null;
	}

	@Override
	public Model getById(Long id) {
		// TODO implementation of getting a Warehouse object by ID
		return null;
	}

	@Override
	public boolean add(Model model) {
		// TODO implementation of adding a new Warehouse into the system
		return false;
	}

	@Override
	public boolean update(Model model) {
		// TODO implementation of save updating a warehouse object
		// !! update referenced rows in child tables !! 
		return false;
	}

	@Override
	public boolean softDelete(Model model) {
		// TODO implementation of disabling a warehouse object
		// !! update referenced rows in child tables !!
		return false;
	}

	@Override
	public boolean delete(Model model) {
		// TODO implementation of hard deleting a warehouse object from the system
		return false;
	}

}
