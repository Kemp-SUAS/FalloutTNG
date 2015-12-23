package AssetHandling;

import java.sql.*;
import java.util.ArrayList;
/**
 *  This class connects contains  external raw data from sqlite
 *  and allows you to open and read raw files that have been bundled with the application. 
 * @author Faduma Ahmed, Kieran Wilson, Mohid Aslam, Simar Pal Kalsi
 *Time -- 8:11:16 PM Date Dec 8, 2015
 */
public class AssetManager {
/**
 * 
 * @param args
 */
	 static Statement stat;
	
		public static String dataBaseGet(String tableName, int id, String column) throws SQLException, ClassNotFoundException{
			 Class.forName("org.sqlite.JDBC");
		     Connection c = DriverManager.getConnection("jdbc:sqlite:Assets/Data/data.db");
		     stat = c.createStatement();
			ResultSet rs = stat.executeQuery("select * from "+ tableName+ " where id =" + id);
			String indexInformation = rs.getString(column);
			return indexInformation;
		}
		public static ArrayList<String> dataBaseGet(String tableName, String column) throws ClassNotFoundException, SQLException{
			Class.forName("org.sqlite.JDBC");
		     Connection c = DriverManager.getConnection("jdbc:sqlite:Assest/Data/data.db");
		     stat = c.createStatement();
			ResultSet rs = stat.executeQuery("select * from "+ tableName+ ";");
			ArrayList<String> data = new ArrayList<String>();
			while(rs.next())
			{
				data.add(rs.getString(column));
			}
			return data;
		}
		
	}


