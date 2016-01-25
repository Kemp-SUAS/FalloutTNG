/**
 * 
 */
package vault1.CharacterFolder;

import java.awt.Graphics;
import java.io.IOException;
import java.util.LinkedList;

import renderer.WorldLayout;

/**
 * @author Mohid Aslam, Faduma Ahmed, Keiran Wilson, Simar Pal Kalsi
 *
 */
public class Controller {

	/**
	 * an array list to hold all the Shooter object
	 */
	public static LinkedList<Shooter> b = new LinkedList<Shooter>();

	/**
	 * 
	 *  the object of the class that the bullets are coded in
	 */
	Shooter TempBullet;

	/**
	 * 
	 *  the object of the class that the game is coded in
	 */
	WorldLayout game;

	/**
	 * 
	 * @param game, the object of the class that the game is coded in
	 */
	public Controller(WorldLayout game) {
		this.game = game;

	}

	/**
	 * 
	 */
	public void tick() {
		for (int i = 0; i < b.size(); i++) {
			TempBullet = b.get(i);

			TempBullet.tick();
		}
	}

	/**
	 * 
	 * @param g, the graphics to draw the image
	 * @throws IOException, if there is no proper input/output
	 */
	public void render(Graphics g) throws IOException {// renders all bullets
														// that are created
		for (int i = 0; i < b.size(); i++) {
			TempBullet = b.get(i);

			TempBullet.render(g);
		}
	}

	/**
	 * 
	 * @param block, to add a bullet
	 */
	public void addBullet(Shooter block) {
		b.add(block);
	}

	/**
	 * 
	 * @param block, to remove the bullet
	 */
	public void removeBullet(Shooter block) {
		b.remove(block);
	}

}
