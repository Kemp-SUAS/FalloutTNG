package AssetHandling;

import java.sql.*;
import java.util.ArrayList;
/**
 *  This class connects contains  external raw data from sqlite
 *  and allows you to open and read raw files that have been bundled with the application. 
 * @author Faduma Ahmed, Kieran Wilson, Mohid Aslam, Simar Pal Kalsi
 *Time -- 8:11:16 PM Date Dec 8, 2015
 */
/**
 * @author fadumaahmed
 *
 */
public class AssetManager {

	// The object used for excecuting the static SQLite object
	static Statement stat;
	
		/**
		 *  This static method helps to get the external raw data from SQLite
		 * @param tableName, String of the table name found in SQLite
		 * @param id , the counter of each row
		 * @param column ,The name of the column in the table
		 * @return String, of the all the data that the method s specifically looking for
		 * @throws SQLException , an exception that provides information on a database access error or other errors.
		 * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using: The forName method in class Class.  The findSystemClass method in class ClassLoader . The loadClass method in class ClassLoader.
		 */
		public static String dataBaseGet(String tableName, int id, String column) throws SQLException, ClassNotFoundException{
			 
			// Returns the Class object associated with the class or interface with the given string name.
			Class.forName("org.sqlite.JDBC");
			// SQL statements are executed and results are returned within the context of a connection.
		     Connection c = DriverManager.getConnection("jdbc:sqlite:Assets/Data/data.db");
		     // Creates a Statement object for sending SQL statements to the database. 
		     stat = c.createStatement();
		     // object maintains a cursor pointing to its current row of data
			ResultSet rs = stat.executeQuery("select * from "+ tableName+ " where id =" + id);
			//Retrieves the value of the designated column in the current row of this ResultSet object
			String indexInformation = rs.getString(column);
			
			return indexInformation;
		}
		
		
		
		/**
		 * THis method places all the information in the method dataBaseGet into an Array List
		 * @param tableName, String of the table name found in SQLite
		 * @param id , the counter of each row
		 * @param column ,The name of the column in the table
		 * @return String, of the all the data that the method s specifically looking for
		 * @throws SQLException , an exception that provides information on a database access error or other errors.
		 * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name using: The forName method in class Class.  The findSystemClass method in class ClassLoader . The loadClass method in class ClassLoader.
		 */
		public static ArrayList<String> dataBaseGet(String tableName, String column) throws ClassNotFoundException, SQLException{
			
			//Returns the Class object associated with the class or interface 
			Class.forName("org.sqlite.JDBC");
			
			// SQL statements are executed and results are returned within the context of a connection.
		     Connection c = DriverManager.getConnection("jdbc:sqlite:Assest/Data/data.db");
		     // Creates a Statement object for sending SQL statements to the database. 
		     stat = c.createStatement();
		     // object maintains a cursor pointing to its current row of data
		     ResultSet rs = stat.executeQuery("select * from "+ tableName+ ";");
			// Create a new Array List
		     ArrayList<String> data = new ArrayList<String>();
			while(rs.next())
			{
				//Retrieves the value of the designated column in the current row of this ResultSet object an placces it into an Array
				data.add(rs.getString(column));
			}
			return data;
		}
		
	}























