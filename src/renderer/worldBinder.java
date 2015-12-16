/**
 * 
 */
package renderer;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author simarpal, Faduma Ahmed, Mohid Aslam, Kieran Wilson
 *
 */
public class worldBinder {
	
	
/**
 * This class is an access way from the sqLITE data on to the code.It allows other classes to accces the information
 * Test world binder
 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		wallStringParser("1");
		
	}
	public static void wallStringParser(String level) throws SQLException, ClassNotFoundException{
		String table = "level_"+level;
		String wallString = AssetHandling.AssetManager.dataBaseGet(table, 1, "wall");
		String delims = "[/,]+";
		String[] wallDimensions = wallString.split(delims);
		for(int i = 0; i < wallDimensions.length;i++){
		  System.out.println(wallDimensions[i]);
		}
	
	}
}
