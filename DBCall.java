package pkg.db;

import java.sql.*;
public class DBCall {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnector con =new DBConnector();
		Connection c1 = con.connect();
		System.out.println(c1);
		con.disconnect();

	}


}
