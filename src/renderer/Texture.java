package renderer;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * I think we don't want a static entity because then there could be too many
 * errors so what I am thinking is that if we give the texture to the object
 * then assign it to a specific key.This way when we load the file it will
 * recognize that the file has been used(sprite sheet hold many images so it can
 * be called more than once) then get it from the map instead of loading.
 * Overall it will help with saving and memory management
 * 
 * @author Faduma Ahmed Mohid Aslam Simarpal Kalsi Keiran Wilson
 */
public class Texture {

	private final static HashMap<String, TextureManager> textureMap = new HashMap<String, TextureManager>();

	// store texture in memory so we can use it
	/**
	 * The object from the class Texture Manager
	 */
	@SuppressWarnings("unused")
	private TextureManager manager;

	// if the file is empty
	/**
	 * THe name of the file of the image
	 */
	private String fileName;
	/**
	 *  Object from texture class
	 */
	@SuppressWarnings("unused")
	private Texture texture;

	/**
	 * @param fileName, the name of the image file to be used
	 */
	@SuppressWarnings("unchecked")
	public Texture(String fileName) {
		this.fileName = fileName;

		TextureManager oldTexture = textureMap.get(fileName);

		if (oldTexture != null) {
			manager = oldTexture;
			manager.addReference();
		} else {
			try {
				// it don't support file or input stream, adding that could
				// cause error

				manager = new TextureManager(ImageIO.read(new File(fileName)));
				// ((HashMap<String, Texture>) textureMap).put(fileName,this);

			} catch (IOException imageException) {
				imageException.printStackTrace();

			}
		}

	}

	/**
	 * Overwrites finalize() in super Object AutoMatically Called during Garbage
	 * Collection(in run time)
	 */

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// automatically removes texture when no longer needed
		if (manager.removeReference() && !fileName.isEmpty())
			textureMap.remove(fileName);

		super.finalize();
	}

	/**
	 * @param g, the graphics to be used 
	 * @param x, the x value of image
	 * @param y, the y value of the image
	 * 
	 */
	
	public void render(Graphics g, double x, double y) {

		g.drawImage(manager.getImage(), (int) x, (int) y, null);
	}
	/**
	 * @param g, the graphics to be used 
	 * @param x, the x value of image
	 * @param y, the y value of the image
	 * @param rotation, the rotation value
	 */
	public void render(Graphics g, double x, double y , double rotation) {
		double rotationRequired = Math.toRadians (45);
		double locationX = manager.getImage().getWidth() / 2;
		double locationY = manager.getImage().getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		g.drawImage(op.filter(manager.getImage(), null),  (int)x,  (int)y, null);
		
	}
	
}
