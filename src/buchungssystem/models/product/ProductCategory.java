package buchungssystem.models.product;

import java.util.GregorianCalendar;

import buchungssystem.models.Model;

public class ProductCategory extends Model{
	
	/* 
	 * Folgende Eigenschaften übernimmt Model.java
	 * 
	 * private Long id; 
	 * private Long lastID;                
	 * private GregorianCalendar validFrom;
	 * private GregorianCalendar validTill;
	 * private boolean isValid;            
	 * 
	 * 
	 */
	
	private Long departmentID;
	private String productCategoryName;
	

	public ProductCategory() {
		super();
	}


	public ProductCategory(Long id) {
		super(id);
	}


	public Long getDepartmentID() {
		return departmentID;
	}


	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}


	public String getProductCategoryName() {
		return productCategoryName;
	}
	
	


	@Override
	public String toString() {
		return "ProductCategory [departmentID=" + departmentID + ", productCategoryName=" + productCategoryName + "]";
	}


	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	
	
}
