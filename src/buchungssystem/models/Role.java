package buchungssystem.models;

import buchungssystem.dao.IRole;

public enum Role extends Model {
	Administrator,
	Manager,
	Sachbearbeiter;
	
	/*
	 * folgende Methode ist zu benutzen, um alle Enums zurückzukliefern 
	 * public static EnumClass[] values(){return arrays}
	 */
	
}
