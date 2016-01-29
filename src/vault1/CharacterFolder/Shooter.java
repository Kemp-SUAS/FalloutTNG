/**
 * 
 */
package vault1.CharacterFolder;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import renderer.Texture;
import renderer.WorldLayout;

/**
 *  The shooter movements and direction
 * @author Mohid Aslam, Faduma ahmed, Keiran Wilson, Simar Pal Kalsi
 *
 */
public class Shooter {
	
	

	/**
	 *  the y value
	 */
	private double x;
	/**
	 *  the x value
	 */
	private double y;

	/**
	 *  the image path
	 */
	String bullet = "Assets/Pictures/Textures/bubbles_v1.png";

	/**
	 *  the image to be used
	 */
	BufferedImage image;
	
	/**
	 *  the rotational value
	 */
	double rotation;

	/**
	 * 
	 * @param x, the x value
	 * @param y, the y value
	 * @param game, the object from world layout
	 * @param rotation, the rotational angle 
	 */
	public Shooter(double x, double y, WorldLayout game , double rotation) {
		this.x = x  ;
		this.y = y;
		this.rotation = rotation;
	}

	/**
	 * 
	 * @param X, , sets the y value
	 */
	public void setX(double X) {
		x = X +x;
	}
	/**
	 * 
	 * @param Y, sets the y value
	 */
	public void setY(double Y) {
		y = Y;
	}

	/**
	 * bullet shoots in direction the player is facing
	 */
	public void tick() {//bullet shoots in direction the player is facing
		if(rotation == 0){
		y -= 30;
		}
		if(rotation == 45){
			y-=15;
			x += 15;
		}
		if(rotation == 90){
			x += 30;
		}
		if(rotation == 135){
			
			x += 15;
			y += 15;
		}
		if(rotation == 180){
			y += 30;
		}
		if(rotation == 225){
			y += 15;
			x -= 15;
		}
		
		if(rotation == 270){
			x -= 30;
		}
		if(rotation == 315){
			x -= 15;
			y -= 15;
		}
	}
	
	/**
	 * 
	 * @return angles, that will sets the rotation value
	 */
	public String getDirection(){//bullet shoots in direction player is facing
		if(rotation == 0){
			return "0";
			}
			if(rotation == 45){
				return "45";
			}
			if(rotation == 90){
				return "90";
			}
			if(rotation == 135){
				return "135";
			}
			if(rotation == 180){
				return "180";
			}
			if(rotation == 225){
				return "225";
			}
			
			if(rotation == 270){
				return "270";
			}
			if(rotation == 315){
				return "315";
			}
			return "null";
	}

	/**
	 * 
	 * @param g, the graphics for drawing
	 * @throws IOException, if there is an error inputting the file
	 */
	public void render(Graphics g) throws IOException {
		BufferedImage manager = ImageIO.read(new File(this.bullet));
		g.drawImage(manager, (int) (WorldLayout.xOffset + this.x), (int) (this.y + WorldLayout.yOffset), null);
	}

	/**
	 * 
	 * @return x,  the value of the x
	 */
	public double getX() {//getter for x
		// TODO Auto-generated method stub
		return x;
	}

	/**
	 * 
	 * @return y, the value of the y
	 */
	public double getY() {//getter for y 
		// TODO Auto-generated method stub
		return y;
	}
}
