package buchungssystem.models;

import java.util.GregorianCalendar;

/*
 * Hier sind die Eigenschaften deklariert, die bei allen Entity(Klassen) gleich sind.
 */

public class Model {
	
	private Long id;
	//DONE implementation of lastID properties in case of modifying the object in DB
	private Long lastID;
	private GregorianCalendar validFrom;
	private GregorianCalendar validTill;
	private boolean isValid;
	
	public Model() {
		
	}
	
	public Model(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getLastID() {
		return lastID;
	}

	public void setLastID(Long lastID) {
		this.lastID = lastID;
	}

	public GregorianCalendar getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(GregorianCalendar validFrom) {
		this.validFrom = validFrom;
	}

	public GregorianCalendar getValidTill() {
		return validTill;
	}

	public void setValidTill(GregorianCalendar validTill) {
		this.validTill = validTill;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	

}
