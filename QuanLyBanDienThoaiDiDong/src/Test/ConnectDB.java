package Test;

import java.sql.Connection;
import java.sql.SQLException;

import db.Database;

public class ConnectDB {
	 public static void main(String[] args) throws SQLException,ClassNotFoundException {
		 System.out.println("Get connection ... ");
		 
	      // Lấy ra đối tượng Connection kết nối vào database.
	      Connection conn = Database.getConnection();
	 
	      System.out.println("Get connection " + conn);
	 
	      System.out.println("Done!");
	}
}
