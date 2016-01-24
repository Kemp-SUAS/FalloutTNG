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
 * 
 * @author Faduma Ahmed
 *
 */
public class Player {

	double x = 368;
	double y = 268;
	WorldLayout topDwn;
	double rotation;
	Texture playerMode_up = new Texture("Assets/Pictures/Textures/Character/Unsorted/Characters/Shooter2.png");

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
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

	}

	/**
	 * 
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
