package buchungssystem.dao.Impl.MySQL.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import buchungssystem.dao.Impl.MySQL.DBconnection;
import buchungssystem.dao.i.product.IProductCategory;
import buchungssystem.models.product.Department;
import buchungssystem.models.product.ProductCategory;

public class ProductCategoryDB implements IProductCategory {
	
	DBconnection conn;
	Connection mysqlConnect;
	
	private Long departmentID;
	private String productCategoryName;
	
	public ProductCategoryDB() {
		conn = new DBconnection("root", "root");
		mysqlConnect = conn.init();
	}

	@Override
	public List<ProductCategory> getAll() {
		// TODO implementation of a view of all product category's in the system
		
		//List<Pro>
		
		
		return null;
	}

	@Override
	public ProductCategory getById(Long id) {
		// DONE implementation of selecting a product category by ID
		ProductCategory productCategory = new ProductCategory(id);
		
		ResultSet resultSet;
		PreparedStatement sqlStmt;
		String sqlQuery;
		
		sqlQuery = "SELECT departmentID, "
				+ "productCategoryName "
				+ "FROM ProductCategory WHERE productCategoryID = ?";
		
		
		
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setLong(1, id);
			
			resultSet = sqlStmt.executeQuery();
			resultSet.next();
			
			resultSet.getLong(1);
			departmentID = resultSet.wasNull() ? null : resultSet.getLong(1);
			
			resultSet.getString(2);
			productCategoryName = resultSet.wasNull() ? null : resultSet.getString(2);
			
			productCategory.setDepartmentID(departmentID);
			productCategory.setProductCategoryName(productCategoryName);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productCategory;
	}

	@Override
	public boolean add(ProductCategory model) {
		// DONE implementation of adding new product category
		boolean status = false;
		
		String sqlQuery;
		PreparedStatement sqlStmt;
		
		sqlQuery = "INSERT INTO ProductCategory ("
				+ "departmentID, "
				+ "productCategoryName) "
				+ "VALUES (?,?)";
		
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			
			if (model.getDepartmentID() != null) {
				sqlStmt.setLong(1, model.getDepartmentID());
			} else {
				sqlStmt.setString(1, null);
			}
			
			if (model.getProductCategoryName() != null) {
				sqlStmt.setString(2, model.getProductCategoryName());
			} else {
				sqlStmt.setString(2, null);
			}
			
			sqlStmt.executeUpdate();
			status = true;
			
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		}
		
		
		return status;
	}

	@Override
	public boolean update(ProductCategory model) {
		// TODO implementation of save updating a product category (copy the product-category object & and insert this to a new row)
		// !! by copy in new row should to be changed to new ID by all referenced rows in child-tables !!
		return false;
	}

	@Override
	public boolean softDelete(ProductCategory model) {
		// TODO implementation of soft delete the product category
		// by disabling should to be disabled all referenced rows in child-tables !!
		return false;
	}

	@Override
	public boolean delete(ProductCategory model) {
		// TODO hard delete a product category
		return false;
	}
	
	
}
