/**
 * 
 */
package vault1.CharacterFolder;

import java.awt.Graphics;
import java.io.IOException;
import java.util.LinkedList;

import renderer.WorldLayout;

/**
 * @author Mohid Aslam
 *
 */
public class Controller {

	/**
	 * 
	 */
	public static LinkedList<Shooter> b = new LinkedList<Shooter>();

	Shooter TempBullet;

	WorldLayout game;

	/**
	 * 
	 * @param game
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
	 * @param g
	 * @throws IOException
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
	 * @param block
	 */
	public void addBullet(Shooter block) {
		b.add(block);
	}

	/**
	 * 
	 * @param block
	 */
	public void removeBullet(Shooter block) {
		b.remove(block);
	}

}
