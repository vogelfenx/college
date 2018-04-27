package buchungssystem.dao;

import java.util.List;

import buchungssystem.dao.daoImpl.MySQL.DBconnection;
import buchungssystem.models.Model;

/*
 * Um wiederholte Code in Dao Pattern zu vermeiden, benutzen wir dafür ManagerDao Class, die Generic Pattern realisiert.
 * Hier werden die Funktionalitäten deklariert, die für alle Dao Interfaces gleich sind. 
 */
public interface ManagerDao<Type extends Model> {
	
	/*
	 * CRUD
	 */
	
	public List<Type> getAll();
	
	public Type getById(Long id);
	
	public boolean add(Type model);
	
	public boolean update(Type model);
	
	public boolean softDelete(Type model);
	
	//delete permanently 
	public boolean delete(Type model);
	
}
