package pkg.db;

import java.sql.*;
import java.util.*;



public class DBConnector {
	

		private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/vt_java";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "";
	    private static final String MAX_POOL = "250";
	    
	 // declaring connection object
	    private Connection connection;
	    // declaring properties object
	    private Properties properties;

	    // create properties
	    private Properties getProperties() {
	        if (properties == null) {
	            properties = new Properties();
	            properties.setProperty("user", USERNAME);
	            properties.setProperty("password", PASSWORD);
	            properties.setProperty("MaxPooledStatements", MAX_POOL);
	        }
	        return properties;
	    }
	    
	 // connect database
	    public Connection connect() {
	        if (connection == null) {
	            try {
	                Class.forName(DATABASE_DRIVER);
	                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
	            } catch (ClassNotFoundException | SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return connection;
	    }

	    // disconnect database
	    public void disconnect() {
	        if (connection != null) {
	            try {
	                connection.close();
	                connection = null;
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	}



