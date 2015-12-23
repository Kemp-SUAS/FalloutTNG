/**
 * 
 */
package renderer;

import java.sql.SQLException;
import java.util.ArrayList;

import renderer.Wall;

/**
 *  This class helps to determine the  level the player is on and the set up of that level
 * @author simarpal, Faduma Ahmed, Mohid Aslam, Kieran Wilson
 *
 */
public class worldBinder {
	
/**
 * Test world binder
 */
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Calls the method and the level
		wallStringParser("1");	
	}
	//Gets wall dimensions from database and stores it into an arraylist. Method of doing so can be improved upon,
	//however this seems to be the simplest, working way for now
	public static void wallStringParser(String level) throws SQLException, ClassNotFoundException{
		
		// gets the level the player is on
		String table = "level_"+level;
		// Uses the method from AssetManager to retrive external raw dara
		String wallString = AssetHandling.AssetManager.dataBaseGet(table, 1, "wall");
		// Sets the table
		String delims = "[\\/\\,]+";
		//Splits this string around matches of the given regular expression.
		String[] transfer = wallString.split(delims);
		// Creattes a new array list
		ArrayList<String> wallDimensions = new ArrayList<String>();
		for(int i = 0; i < transfer.length;i++){
			// add ifo to the Array List via Loop
			wallDimensions.add(transfer[i]);
		}
		//removes the first index of the ArrayList
		wallDimensions.remove(0);
	
	}
}