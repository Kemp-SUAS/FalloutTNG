package renderer;

import com.sun.prism.Texture;

/**
 * 
 * @author Faduma Ahmed Kieran Wilson Mohid Aslam Simar Pal Kalsi
 * 
 */

public class ParallaxLayer {

	private Texture texture;
	private int x, y;
	private int width, height;
	private int dx;
	// If we want a gap I don't know if we really need to
	private int gap;
	private boolean left, right;
	
	public ParallaxLayer(Texture texture, int dx, int gap)
	
	{
		this.texture= texture;
		this.dx= dx;
		this.gap= gap;
		// I think we need a Texture Class to handle the width and height
		//this.width= Texture.getWidth;
		//this.height=Texture.getHeight;
		this.x=this.y=0;
		
	}
		public ParallaxLayer(Texture texture, int dx)
	
	{
			this(texture,dx,0);
	}
		
		
	public void setRight()
	{
		right= true;
		left= false;
		
	}
	
	public void setLeft()
	{
		right= false;
		left= true;
		
	}
	
	public void stop()
	{
		right=left=false;
	}

	public void move()
	{
		if (right)

		{

			x = (x + dx) % (width + gap);
		} else {
			x = (x - dx) % width;

		}

	}
	
}
