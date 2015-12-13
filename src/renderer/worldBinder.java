/**
 * 
 */
package renderer;

import java.sql.SQLException;

/**
 * @author simarpal, Faduma Ahmed, Mohid Aslam, Kieran Wilson
 *
 */
public class worldBinder {
	
	
/**
 * Test world binder
 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		 
		//System.out.println(dataBaseGet("image_strings", 5, "path"));
		wallStringParser("walls", 1, "wallDimensions");
		for(int i = 0; int i < wallDimensions, i++){
			System.out.println(wallDimensions[i]);
			System.out.println(wallStringParser("walls", 1, "wallDimensions"));
		}
	}
	public static String[] wallStringParser(String tableName, int id, String column) throws SQLException, ClassNotFoundException{
		String wallInfo = AssetHandling.AssetManager.dataBaseGet(tableName, id, column);
		String delims = "[/,]+";
		String[] wallDimensions = wallInfo.split(delims);
		
		return wallDimensions;
	}
}
