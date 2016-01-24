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
 * @author Mohid Aslam
 *
 */
public class Shooter {

	private double x;
	private double y;

	String bullet = "Assets/Pictures/Textures/bubbles_v1.png";

	BufferedImage image;
	double rotation;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param game
	 * @param rotation
	 */
	public Shooter(double x, double y, WorldLayout game , double rotation) {
		this.x = x  ;
		this.y = y;
		this.rotation = rotation;
	}

	/**
	 * 
	 * @param X
	 */
	public void setX(double X) {
		x = X +x;
	}
	/**
	 * 
	 * @param Y
	 */
	public void setY(double Y) {
		y = Y;
	}

	/**
	 * 
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
	 * @return angles
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
	 * @param g
	 * @throws IOException
	 */
	public void render(Graphics g) throws IOException {
		BufferedImage manager = ImageIO.read(new File(this.bullet));
		g.drawImage(manager, (int) (WorldLayout.xOffset + this.x), (int) (this.y + WorldLayout.yOffset), null);
	}

	/**
	 * 
	 * @return x
	 */
	public double getX() {//getter for x
		// TODO Auto-generated method stub
		return x;
	}

	/**
	 * 
	 * @return y
	 */
	public double getY() {//getter for y 
		// TODO Auto-generated method stub
		return y;
	}
}
