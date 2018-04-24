package buchungssystem.dao.daoImpl.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import buchungssystem.dao.IUser;
import buchungssystem.models.User;

public class UserDB implements IUser{
	
	DBconnection conn;

	public UserDB() {
		conn = new DBconnection("root", "root");
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(User model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getByLogin(String login, String password) {
		
		//initialize connection
		Connection mysqlConnect = conn.init();
		
		ResultSet isExists;
		PreparedStatement sqlStmt;
		User currentUser = null;
		
		//check if User exists
		String sqlQuery = "select exists(select login from user where login=? and passw = md5(?)) as 'isExists'";
		try {
			sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
			sqlStmt.setString(1, login);
			sqlStmt.setString(2, password);
			isExists = sqlStmt.executeQuery();
			isExists.next();
			if (isExists.getBoolean(1) == true){
				//sqlQuery = "select userID, employeeID from user natural join employee where login = ?";
				sqlQuery = "select user.userID, employeeID from user join employee on employee.userID = user.userID where login = ?";
				sqlStmt = mysqlConnect.prepareStatement(sqlQuery);
				sqlStmt.setString(1, login);
				isExists = sqlStmt.executeQuery();
				isExists.next();
				Long userID = isExists.getLong(1);
				Long employeeID = isExists.getLong(2);
				currentUser = new User(userID);
				currentUser.setEmployeeID(employeeID);
				currentUser.setLogin(login);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close connection
		conn.finalize();
		
		return currentUser;
	}

}
