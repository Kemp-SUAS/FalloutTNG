/**
 * 
 */
package vault1.CharacterFolder;

import java.util.ArrayList;
import java.util.TimerTask;
import renderer.WorldLayout;


/**
 * @author Mohid Aslam
 *
 */
public class ReloadTime extends TimerTask {

	private WorldLayout game;
	private ArrayList<Shooter> bullets = new ArrayList<Shooter>();
	private Controller c;
	/**
	 * 
	 */
	public ReloadTime() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		bullets.add(new Shooter(400 - WorldLayout.xOffset, 300 - WorldLayout.yOffset, game, WorldLayout.rotation));
		//c.addBullet(bullets.get(bullets.size()));
	}

}
