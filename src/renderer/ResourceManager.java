

package renderer;
/**
 * Help with Texture.java
 * @author Faduma Ahmed, Mohid Aslam Kieran Wilson Simar Pal Kalsi
 *
 */
public  abstract class ResourceManager {
	
	protected int count = 1;
	/**
	 * 
	 */
	public void addReference()
	{
		count++;
		
	}
	/**
	 * 
	 * @return count
	 */
	public boolean removeReference()
	{
		count--;
		return count == 0;
		
	}

}
