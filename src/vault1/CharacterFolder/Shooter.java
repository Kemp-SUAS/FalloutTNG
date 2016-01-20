/**
 * 
 */
package vault1.CharacterFolder;

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

	private double x;
	private double y;

	Texture bullet = new Texture("Assets/Pictures/Textures/Objects/Inventory_Icons/luckycharms.png");

	BufferedImage image;

	public Shooter(int x, int y, WorldLayout game) {
		this.x = x;
		this.y = y;
	}

	public void tick() {
		y -= 10;
	}

	public void render(Graphics g) {
		bullet.render(g, (int) x, (int) y);
	}
}
