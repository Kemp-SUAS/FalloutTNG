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

	/**
	 * object of controller.java
	 */
	private Controller c;

	/**
	 * Takes the key pressed by the user and changes the background image
	 * accordingly
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent event) {

		int keyCode = event.getKeyCode();
		if (keyCode == event.VK_I) {
			WorldLayout.fpsStat = 0;

			WorldLayout.inventoryPanel = true;
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
		if (keyCode == event.VK_ENTER) {
			WorldLayout.enter = true;
		}
		if (keyCode == event.VK_SPACE) {
			WorldLayout.space = true;
		}
		if (keyCode == event.VK_R) {
			WorldLayout.space = true;
		}
		if (keyCode == event.VK_1) {

			WorldLayout.one = true;
		}
		if (keyCode == event.VK_2) {

			WorldLayout.two = true;
		}
		if (keyCode == event.VK_3) {

			WorldLayout.three = true;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
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
		if (keyCode == event.VK_ENTER) {
			WorldLayout.enter = false;
		}
		if (keyCode == event.VK_SPACE) {
			WorldLayout.space = false;
		}
		if (keyCode == event.VK_R) {
			WorldLayout.space = false;
		}

		if (keyCode == event.VK_I) {

			WorldLayout.inventoryPanel = false;
		}
		if (keyCode == event.VK_1) {

			WorldLayout.one = false;
		}
		if (keyCode == event.VK_2) {

			WorldLayout.two = false;
		}
		if (keyCode == event.VK_3) {

			WorldLayout.three = false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent event) {

	}

}
