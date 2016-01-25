/**
 * 
 */
package vault1.CharacterFolder;

import java.util.ArrayList;
import java.util.TimerTask;
import renderer.WorldLayout;

/**
 * This class creates a delay for the bullets when shot
 * @author Mohid Aslam, Faduma Ahmed, Keiran Wilson, SimaPal Kalsi
 *
 */
public class ReloadTime extends TimerTask {

	// This class creates a delay for the bullets when shot
	/**
	 * object from world Layout class
	 */
	private WorldLayout game;
	/**
	 * array list to hold bullets
	 */
	private ArrayList<Shooter> bullets = new ArrayList<Shooter>();
	/**
	 * object from controller class
	 */
	private Controller c;

	
	/**
	 * The time to delay the movement of the bullets
	 */
	public ReloadTime() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	
	public void run() {
		// TODO Auto-generated method stub
		bullets.add(new Shooter(400 - WorldLayout.xOffset, 300 - WorldLayout.yOffset, game, WorldLayout.rotation));
		// c.addBullet(bullets.get(bullets.size()));
	}

}
