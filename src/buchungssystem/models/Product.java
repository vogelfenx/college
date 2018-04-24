package buchungssystem.models;

public class Product extends Model {
	
	/* 
	 * Folgende Eigenschaften übernimmt Model.java
	 * 
	 * private Long id; 
	 * 
	 */
	
	public Product() {
		super();
	}
	
	public Product(Long id) {
		super(id);
	}
	
	private ProductCategory category;
	private Warehouse warehouseId;
	private String productName;
	private Double price;
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public Warehouse getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Warehouse warehouse) {
		this.warehouseId = warehouse;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
