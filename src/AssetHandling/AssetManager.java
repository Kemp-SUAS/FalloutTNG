package AssetHandling;

import java.sql.*;
import java.util.ArrayList;
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
		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			 
			System.out.println(dataBaseGet("image_strings", 5, "path"));
		}
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


