package renderer;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

import vault1.CharacterFolder.Controller;
import vault1.CharacterFolder.Shooter;

/**
 * This class controls the backgrounds movements by using the arrow keys to
 * change the x and y values of the background.
 * 
 * @author Kieran Wilson, Mohid Aslam, Simar Kalsi, Faduma Ahmed
 * 
 *
 */
public class InputHandler implements KeyListener {

	private Controller c;

	/**
	 * Takes the key pressed by the user and changes the background image
	 * accordingly
	 */
	public void keyPressed(KeyEvent event) {

		int keyCode = event.getKeyCode();
		if (keyCode == event.VK_I) {
			// world.setFps(0);
			// world.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// Inventory inventory = new Inventory();
		}

		if (keyCode == event.VK_LEFT) {
			WorldLayout.left = true;
		}

		if (keyCode == event.VK_RIGHT) {
			WorldLayout.right = true;
		}
		if (keyCode == event.VK_UP) {
			WorldLayout.up = true;
		}
		if (keyCode == event.VK_DOWN) {
			WorldLayout.down = true;
		}
		if (keyCode == event.VK_E) {
			WorldLayout.enter = true;
		}
		if (keyCode == event.VK_SPACE) {
			WorldLayout.space = true;
		}
		if (keyCode == event.VK_R) {
			WorldLayout.space = true;
		}
	}

	@Override
	/**
	 * When the user releases a key, it stops the command done previously
	 */
	public void keyReleased(KeyEvent event) {
		int keyCode = event.getKeyCode();
		if (keyCode == event.VK_LEFT) {
			WorldLayout.left = false;

		}
		if (keyCode == event.VK_RIGHT) {
			WorldLayout.right = false;

		}

		if (keyCode == event.VK_UP) {
			WorldLayout.up = false;

		}
		if (keyCode == event.VK_DOWN) {
			WorldLayout.down = false;

		}
		if (keyCode == event.VK_E) {
			WorldLayout.enter = false;
		}
		if (keyCode == event.VK_SPACE) {
			WorldLayout.space = false;
		}
		if (keyCode == event.VK_R) {
			WorldLayout.space = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent event) {

	}

}
