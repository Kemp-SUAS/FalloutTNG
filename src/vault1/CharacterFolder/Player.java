package vault1.CharacterFolder;

import java.awt.Color;
import renderer.Texture;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import renderer.WorldLayout;
import renderer.InputHandler;

/**
 * This class controls the image of the player and where the image is located on the screen.
 * @author Faduma Ahmed, Kieran Wilson
 *
 */
public class Player {

	private static double x = 368;
	private static double y = 268;
	WorldLayout topDwn;
	double rotation;
	static Texture playerMode_up = new Texture("Assets/Pictures/Textures/Character/Unsorted/Characters/Shooter2.png");
	

	/**
	 * 
	 * @param topDwn
	 */
	public void tick(WorldLayout topDwn) {
		this.topDwn = topDwn;

	}

	/**
	 * 
	 * @param g
	 */
	public void render(Graphics g) {

		playerMode_up.render(g, x, y);
	}

	/**
	 * Main method used for testing the altering of values inside the player class.
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println(x);
		x = x + 30;
		System.out.println(x);		
		System.out.println(y);
		y = y - 40;
		System.out.println(y);
		
		System.out.println(playerMode_up);
		playerMode_up = new Texture ("Assets/Pictures/Textures/bubbles_v1.png");
		System.out.println(playerMode_up);
		}

	/**
	 * This class is run in the main method and draws the image on the screen.
	 * @param g
	 * @param rotation
	 */
	public void render(Graphics g, double rotation) {
		BufferedImage manager = null;
		try {
			manager = ImageIO.read(new File("Assets/Pictures/Textures/Character/Unsorted/Characters/Shooter2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double rotationRequired = Math.toRadians(rotation);
		double locationX = manager.getWidth() / 2;
		double locationY = manager.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		g.drawImage(op.filter(manager, null), (int) x, (int) y, null);

	}
}
