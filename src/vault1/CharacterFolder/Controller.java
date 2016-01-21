/**
 * 
 */
package vault1.CharacterFolder;

import java.awt.Graphics;
import java.io.IOException;
import java.util.LinkedList;

import renderer.WorldLayout;

/**
 * @author Aslam 1
 *
 */
public class Controller {

	public static LinkedList<Shooter> b = new LinkedList<Shooter>();

	Shooter TempBullet;
	
	WorldLayout game;
	
	public Controller (WorldLayout game){
		this.game = game;
	
	}

	public void tick() {
		for (int i = 0; i < b.size(); i++) {
			TempBullet = b.get(i);

			TempBullet.tick();
		}
	}

	public void render(Graphics g) throws IOException {
		for (int i = 0; i < b.size(); i++) {
			TempBullet = b.get(i);

			TempBullet.render(g);
		}
	}

	public void addBullet(Shooter block) {
		b.add(block);
	}

	public void removeBullet(Shooter block) {
		b.remove(block);
	}

}
