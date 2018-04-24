package buchungssystem.dao.daoImpl.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnection {
	
	private String urlToDB = "jdbc:mysql://localhost/kassensystem?autoReconnect=true&useSSL=false";
	
	private String userDB;
	private String password;
	
	private Connection mysqlConnect;
	
	private Properties properties = new Properties();
	
	public DBconnection(String userDB, String password) {
		
		this.userDB = userDB;
		this.password = password;
		
	}
	
	public Connection init(){
		if (mysqlConnect == null ) {
			try {                                                           
				Class.forName("com.mysql.jdbc.Driver");
				
				//creating & setting properties for DB access using class Properties 
				properties.setProperty("user", userDB);
				properties.setProperty("password", password);
				
				System.out.println("Connect to DB as " + properties.getProperty("user"));
				mysqlConnect = DriverManager.getConnection(urlToDB, properties);
			} catch (ClassNotFoundException e) {                            
				e.printStackTrace();                                        
			} catch (SQLException e) {                                      
				e.printStackTrace();                                        
			}                                                               
		}
		return mysqlConnect;
	}
	
	public void finalize() {
		try {
			mysqlConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
