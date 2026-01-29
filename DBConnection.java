package layers;

import java.sql.*;

public class DBConnection {
	
	// Database Connection
	private static Connection connection;

    public static Connection getConnection() {
    	if (connection == null) {
           try {
        	          	   
        	   String url = "jdbc:mysql://localhost:3306/Bangtandb";
        	   String username = "root";
        	   String password = "root";
              connection = DriverManager.getConnection(url, username, password);
           } 
           catch (Exception e) {
              e.printStackTrace();
              
           }
        }
    	return connection;
    }
}
