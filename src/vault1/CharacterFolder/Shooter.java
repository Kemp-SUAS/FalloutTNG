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
 * @author Mohid
 *
 */
public class Shooter {

	private int x;
	private int y;

	String bullet = "Assets/Pictures/Textures/Objects/Inventory_Icons/luckycharms.png";

	BufferedImage image;

	public Shooter(int x, int y, WorldLayout game) {
		this.x = x;
		this.y = y;
	}

	public void tick() {
		y -= 10;
	}

	public void render(Graphics g) throws IOException{
		BufferedImage manager = ImageIO.read(new File(this.bullet));
		g.drawImage(manager, this.x, this.y, null);
	}
}
