package buchungssystem.models;

public class ProductCategory extends Model{
	
	/* 
	 * Folgende Eigenschaften übernimmt Model.java
	 * 
	 * private Long id; 
	 * 
	 */
	
	private String name;

	public ProductCategory() {
		super();
	}

	public ProductCategory(Long id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
