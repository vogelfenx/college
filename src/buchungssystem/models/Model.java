package buchungssystem.models;

/*
 * Hier sind die Eigenschaften deklariert, die bei allen Entity(Klassen) gleich sind.
 */

public class Model {
	
	private Long id;
	//DONE implement lastID properties in case of modifying the object in DB
	private Long lastID;
	
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
	
	

}
