package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Connection con;
	
	private Database() {
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLBanDT", "sa", "sapassword");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static Connection getConnection() {
		if(con == null)
			new Database();
		return con;
	}
}

