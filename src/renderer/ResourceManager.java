

package renderer;
/**
 * Help with Texture.java and keeping track of images, this is really a test class
 * @author Faduma Ahmed, Mohid Aslam Kieran Wilson Simar Pal Kalsi
 *
 */
public  abstract class ResourceManager {
	
	/**
	 * sets the count of the textures
	 */
	protected int count = 1;
	
	public void addReference()
	{
		count++;
		
	}
	/**
	 * 
	 * @return count, the value it has moved 
	 */
	public boolean removeReference()
	{
		count--;
		return count == 0;
		
	}

}
