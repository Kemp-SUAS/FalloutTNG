package renderer;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This class controls the background movement and image creation while the
 * program runs. This class makes the background move to give the illusion to
 * the player they are moving.
 * 
 * @author Kieran Wilson, Faduma Ahmed, Simarpal Kalsi
 * 
 *
 */

public class Background {

	/**
	 *  The x value of the background
	 */
	public double x;
	/**
	 *  The y value of the background
	 */
	public double y;
	/**
	 *  The x and y offset value of the background
	 */
	public double oX, oY;
	/**
	 *  The object from worldLayout
	 */
	WorldLayout topDwn;
	/**
	 *  The path file of the image
	 */
	String fileName;

	/**
	 * 
	 * @param x
	 *            The x value of the background
	 * @param y
	 *            The y value of the background
	 * @param TopDwn
	 *            This makes a object of type WorldLayout
	 * @param fileName
	 * 
	 */
	public Background(double x, double y, WorldLayout TopDwn, String fileName) {
		this.oX = x;
		this.oY = y;
		this.fileName = fileName;

	}

	/**
	 * This method is called 60 times a second, and it updates the position of
	 * the backgorund.
	 * 
	 * @param topDwn, object from World Layout
	 */
	public void tick(WorldLayout topDwn)

	{
		this.topDwn = topDwn;
		x = oX + topDwn.xOffset;
		y = oY + topDwn.yOffset;

	}

	/**
	 * 
	 * @param g
	 * @throws IOException
	 */
	public void render(Graphics g) throws IOException {

		BufferedImage manager = ImageIO.read(new File(this.fileName));
		g.drawImage(manager, (int) this.x, (int) this.y, null);

	}

}
