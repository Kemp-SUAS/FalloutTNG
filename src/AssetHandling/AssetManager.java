package AssetHandling;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class connects contains external raw data from sqlite and allows you to
 * open and read raw files that have been bundled with the application.
 * 
 * @author Faduma Ahmed, Kieran Wilson, Mohid Aslam, Simar Pal Kalsi Time --
 *         8:11:16 PM Date Dec 8, 2015
 */
public class AssetManager {

	// The object used for excecuting the static SQLite object
	/**
	 * The object used for excecuting the static SQLite object
	 */
	static Statement stat;

	/**
	 * This static method helps to get the external String data from SQLite
	 * 
	 * @param tableName,
	 *            String of the table name found in SQLite
	 * @param id
	 *            , the counter of each row
	 * @param column
	 *            ,The name of the column in the table
	 * @return String, of the all the data that the method s specifically
	 *         looking for
	 * @throws SQLException
	 *             , an exception that provides information on a database access
	 *             error or other errors.
	 * @throws ClassNotFoundException
	 *             Thrown when an application tries to load in a class through
	 *             its string name using: The forName method in class Class. The
	 *             findSystemClass method in class ClassLoader . The loadClass
	 *             method in class ClassLoader.
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// dataBasePut("test", "Money", "'$100'");
		dataBaseUpdate("test", "Money", 1, "'$200'");
		System.out.println(dataBaseGet("test", 1, "Money"));

	}

	/**
	 * 
	 * @param tableName
	 *            The name of the table being placed into.
	 * @param id
	 *            ID of desired object on the table.
	 * @param column
	 *            Column of the desired object on the table.
	 * @return String Returns a string value.
	 * @throws SQLException
	 *             An exception that provides information on a database access
	 *             error or other errors.
	 * @throws ClassNotFoundException
	 *             exception that provides information on a database access
	 *             error or other errors.
	 */
	public static String dataBaseGet(String tableName, int id, String column)
			throws SQLException, ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:Assets/Data/data.db");
		stat = c.createStatement();
		ResultSet rs = stat.executeQuery("select * from " + tableName + " where id =" + id);
		String indexInformation = rs.getString(column);
		stat.close();
		c.close();
		return indexInformation;
	}

	/**
	 * This static method helps to get the external String data from SQLite and
	 * places it in a String Array
	 * 
	 * @param tableName,String
	 *            of the table name found in SQLite
	 * @param column,the
	 *            counter of each row
	 * @return ArrayList
	 * @throws ClassNotFoundException,an
	 *             exception that provides information on a database access
	 *             error or other errors.
	 * @throws SQLException,
	 *             An exception that provides information on a database access
	 *             error or other errors.
	 */
	public static ArrayList<String> dataBaseGet(String tableName, String column)
			throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:Assest/Data/data.db");
		stat = c.createStatement();
		ResultSet rs = stat.executeQuery("select * from " + tableName + ";");
		ArrayList<String> data = new ArrayList<String>();
		while (rs.next()) {
			data.add(rs.getString(column));
		}
		stat.close();
		c.close();
		return data;
	}

	/**
	 * This static method allows data to be stored in the SQLite database
	 * 
	 * @param tableName
	 *            Name of the table.
	 * @param column
	 *            The column being placed into.
	 * @param value
	 *            The value of the stored string.
	 * @throws SQLException
	 *             exception that provides information on a database access
	 *             error or other errors.
	 * @throws ClassNotFoundException
	 *             An exception that provides information on a database access
	 *             error or other errors.
	 */
	public static void dataBasePut(String tableName, String column, String value)
			throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:Assets/Data/data.db");
		stat = c.createStatement();
		String sql = "INSERT INTO " + tableName + " (id, " + column + ")" + " VALUES (1," + " " + value + ")";
		stat.executeUpdate(sql);
		stat.close();
		c.close();
	}

	/**
	 * 
	 * @param tableName
	 * @param column
	 * @param id
	 * @param value
	 * @throws ClassNotFoundException
	 *             exception that provides information on a database access
	 *             error or other errors.
	 * @throws SQLException
	 *             An exception that provides information on a database access *
	 *             error or other errors.
	 */
	public static void dataBaseUpdate(String tableName, String column, int id, String value)
			throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:Assets/Data/data.db");
		PreparedStatement ps = c.prepareStatement("UPDATE " + tableName + " SET " + column + " = ? WHERE id = ?");
		ps.setString(1, value);
		ps.setInt(2, id);
		ps.executeUpdate();
		ps.close();
		c.close();
	}

}
