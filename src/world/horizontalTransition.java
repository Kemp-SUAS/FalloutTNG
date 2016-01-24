package world;

public class horizontalTransition {// this class uses 2 y coordinates and an x
									// coordinate to create an
	// area where the player can transition to the next level on the vertical
	// edges

	// variables used for transition between levels
	int x1, x2, y1, levelId;

	/**
	 * 
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param levelId
	 */
	public horizontalTransition(int x1, int x2, int y1, int levelId){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.levelId = levelId;
	}

	public int[] getDomain() {
		return new int[] { this.x1, this.x2, this.y1 };
	}

	/**
	 * 
	 * @return levelId
	 */
	public int getLevel() {
		return this.levelId;
	}

	/**
	 * 
	 * @return x1
	 */
	public int getX1() {
		return this.x1;
	}

	/**
	 * 
	 * @return x2
	 */
	public int getX2() {
		return this.x2;
	}

	/**
	 * 
	 * @return y1
	 */
	public int getY1() {
		return this.y1;
	}
}
