package buchungssystem.models;

/*
 * Hier sind die Eigenschaften deklariert, die bei allen Entity(Klassen) gleich sind.
 */

public class Model {
	
	private Long id;
	
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

}
