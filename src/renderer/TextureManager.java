package renderer;

import java.awt.image.BufferedImage;

/**
 * @author Faduma Ahmed, Mohid Aslam, Keiran Wilson, Simarpal Kalsi
 *
 */
public class TextureManager extends ResourceManager {

	public BufferedImage image;

	public TextureManager(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage getImage() {
		return image;
	}

}
