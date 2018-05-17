package buchungssystem.dao.Impl.MySQL.product;

import java.sql.Date;
import java.util.List;

import buchungssystem.dao.i.product.IProduct;
import buchungssystem.models.product.Product;

public class ProductDB implements IProduct {
	
	private Long productID;
	private Long productCategoryID;
	private String productName;
	private double price;
	private Date validFrom;
	private Date validTill;
	private boolean isValid;
	private Long lastID;

	@Override
	public List<Product> getAll() {
		// TODO getAll Product
		return null;
	}

	@Override
	public Product getById(Long id) {
		// TODO getByID Product
		return null;
	}

	@Override
	public boolean add(Product model) {
		// TODO add Product
		boolean status = 
		
		return false;
	}

	@Override
	public boolean update(Product model) {
		// TODO update Product
		return false;
	}

	@Override
	public boolean softDelete(Product model) {
		// TODO softDelete Product
		return false;
	}

	@Override
	public boolean delete(Product model) {
		// TODO delete Product
		return false;
	}

}
