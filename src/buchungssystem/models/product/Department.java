package buchungssystem.models.product;

import buchungssystem.models.Model;

public class Department extends Model {
	
	/* 
	 * Folgende Eigenschaften übernimmt Model.java
	 * 
	 * private Long id; 
	 * 
	 */
	
	private String name;
	private ProductCategory productCategoryName;
	
	public Department() {
		super();
	}

	public Department(Long id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategory getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(ProductCategory productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	
	
	
	
}
