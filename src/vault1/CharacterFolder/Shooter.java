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

	String bullet = "Assets/Pictures/Projectile_v1.png";

	BufferedImage image;
	double rotation;

	public Shooter(int x, int y, WorldLayout game , double rotation) {
		this.x = x  ;
		this.y = y;
		this.rotation = rotation;
	}

	public void setX(int X) {
		x = X +x;
	}
	public void setY(int Y) {
		y = Y;
	}

	public void tick() {
		if(rotation == 0){
		y -= 50;
		}
		if(rotation == 180){
			y += 50;
		}
		if(rotation == 90){
			x += 50;
		}
		if(rotation == 270){
			x -= 50;
		}
	}

	public void render(Graphics g) throws IOException {
		BufferedImage manager = ImageIO.read(new File(this.bullet));
		g.drawImage(manager, WorldLayout.xOffset + this.x, this.y + WorldLayout.yOffset, null);
	}
}
