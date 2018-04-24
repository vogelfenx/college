package tests;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ManagerDAO {
	private Connection dbConnection;
	private String db_url;
	private String user;
	private String passwd;
    private ManagerDAO() {
        try {
        	//Driver
            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = DriverManager.getConnection(db_url, user, passwd);
            
        } catch (Exception ex) {
        	System.out.print("t");
        }
        
        
        
        
    }
}
