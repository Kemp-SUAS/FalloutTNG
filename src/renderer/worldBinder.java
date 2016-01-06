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
		wallStringParser("1");	
	}
	//Gets wall dimensions from database and stores it into an arraylist. Method of doing so can be improved upon,
	//however this seems to be the simplest, working way for now
	public static void wallStringParser(String level) throws SQLException, ClassNotFoundException{
		String table = "level_"+level;
		String wallString = AssetHandling.AssetManager.dataBaseGet(table, 1, "wall");
		String delims = "[\\/\\,]+";
		String[] transfer = wallString.split(delims);
		ArrayList<String> wallDimensions = new ArrayList<String>();
		for(int i = 0; i < transfer.length;i++){
			wallDimensions.add(transfer[i]);
		}
		wallDimensions.remove(0);
	}
}