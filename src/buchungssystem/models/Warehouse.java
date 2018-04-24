package buchungssystem.models;

public class Warehouse extends Model {
		
	/* 
	 * Folgende Eigenschaften übernimmt Model.java
	 * 
	 * private Long id; 
	 * 
	 */
	
	public Warehouse() {
		super();
	}
	
	public Warehouse(Long id) {
		super(id);
	}
	
	private Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
}
