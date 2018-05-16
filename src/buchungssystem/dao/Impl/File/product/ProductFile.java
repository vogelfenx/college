package buchungssystem.dao.Impl.File.product;

import java.util.List;

import buchungssystem.dao.ManagerDao;
import buchungssystem.dao.i.product.IProduct;
import buchungssystem.models.product.Product;

public class ProductFile implements IProduct {

	@Override
	public List<Product> getAll() {
		// TODO implementation of transfer all data's from a csv-file to DB
		return null;
	}

	@Override
	public Product getById(Long id) {
		return null;
	}

	@Override
	public boolean add(Product model) {
		// TODO implementation of transfer all data's from DB to a csv-file
		return false;
	}

	@Override
	public boolean update(Product model) {
		return false;
	}

	@Override
	public boolean softDelete(Product model) {
		return false;
	}

	@Override
	public boolean delete(Product model) {
		return false;
	}


}
