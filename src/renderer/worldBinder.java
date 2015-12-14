/**
 * 
 */
package renderer;

import java.sql.SQLException;
import java.util.ArrayList;

import renderer.Wall;

/**
 * @author simarpal, Faduma Ahmed, Mohid Aslam, Kieran Wilson
 *
 */
public class worldBinder {
	
	
/**
 * Test world binder
 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		wallStringParser("level_1" ,2 ,"wall");
		
	}
	public static void wallStringParser(String tableName, int id, String column) throws SQLException, ClassNotFoundException{
		String wallInfo = AssetHandling.AssetManager.dataBaseGet(tableName, id, column);
		String delims = "[/,]+";
		String[] wallDimensions = wallInfo.split(delims);
		for(int i = 0; i < wallDimensions.length;i++){
		  System.out.println(wallDimensions[i]);
		}
	
	}
}
