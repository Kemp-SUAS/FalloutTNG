package world;
/**
 * 
 * @author Simarpal Kalsi
 *
 */

public class verticalTransition { //this class uses 2 y coordinates and an x coordinate to create an
	                             //area where the player can transition to the next level on the vertical edges 

	//variables used for transition between levels
	int y1,y2,x1,levelId;
	/**
	 * 
	 * @param y1
	 * @param y2
	 * @param x1
	 * @param levelId
	 */
	public verticalTransition( int y1 , int y2, int x1 , int levelId)
	{
		//x and y values where the transition will occur
		this.y1 = y1;
		this.y2 = y2;
		this.x1 = x1;
		this.levelId = levelId;
	}
	public int[] getDomain(){
		return new int[] {this.y1,this.y2,this.x1};
	}
	/**
	 * 
	 * @return levelID
	 */
	public int getLevel(){
		return this.levelId;
	}
	/**
	 * 
	 * @return y1
	 */
	public int getY1(){
		//y1 getter method
		return this.y1;
	}
	/**
	 * 
	 * @return y2
	 */
	public int getY2(){
		//y2 getter method
		return this.y2;
	}
	/**
	 * 
	 * @return x1
	 */
	public int getX1(){
		//x1 getter method
		return this.x1;
	}
}
