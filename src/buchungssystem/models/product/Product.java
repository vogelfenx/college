package buchungssystem.models.product;

import java.util.GregorianCalendar;

import buchungssystem.models.Model;

public class Product extends Model {
	
	/* 
	 * Folgende Eigenschaften übernimmt Model.java
	 * 
	 * private Long id; 
	 * private Long lastID;                          
	 * private GregorianCalendar validFrom;          
	 * private GregorianCalendar validTill;          
	 * private boolean isValid;                      
	 * 
	 */
	
	private String categoryName;
	private Long warehouseID;
	private String productName;
	private Double price;
	
	public Product() {
		super();
	}
	
	public Product(Long id) {
		super(id);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(Long warehouseID) {
		this.warehouseID = warehouseID;
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

	@Override
	public String toString() {
		return "Product [categoryName=" + categoryName + ", warehouseID=" + warehouseID + ", productName=" + productName
				+ ", price=" + price + ", getId()=" + getId() + ", getLastID()=" + getLastID() + ", getValidFrom()="
				+ getValidFrom() + ", getValidTill()=" + getValidTill() + ", isValid()=" + isValid() + "]";
	}

}
