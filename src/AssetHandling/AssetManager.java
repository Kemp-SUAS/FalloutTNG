package AssetHandling;

import java.sql.*;
/**
 * 
 * @author Simar Pal Kalsi
 *Time -- 8:11:16 PM Date Dec 8, 2015
 */
public class AssetManager {
/**
 * 
 * @param args
 */
	 static Statement stat;
	public static void main(String[] args) throws SQLException {
		 Connection c = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:Assest/Data/string.db");
		       stat = c.createStatement();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Opened database successfully");
			ResultSet rs = stat.executeQuery("select * from image_strings;");
			while(rs.next()) {
				System.out.println("id = " + rs.getInt("id"));
				System.out.println("String = " + rs.getString("path"));
			}
		  }
	// Note no information in .db file yet
	// Please use the sqlite3 shell for inserting data. 


	}


