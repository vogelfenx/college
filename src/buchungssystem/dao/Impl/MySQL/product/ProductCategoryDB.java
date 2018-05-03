package buchungssystem.dao.Impl.MySQL.product;

import java.util.List;

import buchungssystem.dao.i.product.IProductCategory;
import buchungssystem.models.product.ProductCategory;

public class ProductCategoryDB implements IProductCategory {
	
	public ProductCategoryDB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ProductCategory> getAll() {
		// TODO view of all product category's in the system
		return null;
	}

	@Override
	public ProductCategory getById(Long id) {
		// TODO selecting a product category by ID
		return null;
	}

	@Override
	public boolean add(ProductCategory model) {
		// TODO adding new product category
		return false;
	}

	@Override
	public boolean update(ProductCategory model) {
		// TODO save updating a product category (copy the product-category object & and insert this to a new row)
		// !! by copy in new row should to be changed to new ID by all referenced rows in child-tables !!
		return false;
	}

	@Override
	public boolean softDelete(ProductCategory model) {
		// TODO soft delete the product category
		// by disabling should to be disabled all referenced rows in child-tables !!
		return false;
	}

	@Override
	public boolean delete(ProductCategory model) {
		// TODO hard delete a product category
		return false;
	}
	
	
}
