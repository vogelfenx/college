package buchungssystem.models.employee;

import buchungssystem.dao.employee.IRole;

public enum Role extends Model {
	Administrator,
	Manager,
	Sachbearbeiter;
	
	/*
	 * folgende Methode ist zu benutzen, um alle Enums zur�ckzukliefern 
	 * public static EnumClass[] values(){return arrays}
	 */
	
}
