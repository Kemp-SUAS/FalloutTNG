package vault1.CharacterFolder;

import java.awt.Image;
import java.util.TimerTask;

import renderer.WorldLayout;

/**
 * 
 * @author Kieran Wilson
 *
 */

public class Weapons {
	public static int damage;
	public static int weaponWeight;
	public static int rateOfFire;
	public static String projectileImage;

	/**
	 * 
	 * @param damage
	 * @param weaponWeight
	 * @param rateOfFire
	 * @param projectileImage
	 */
	public Weapons(int damage, int weaponWeight, int rateOfFire, String projectileImage) {
		this.damage = damage;
		this.weaponWeight = weaponWeight;
		this.rateOfFire = rateOfFire;
	}

	/**
	 * 
	 */
	public Weapons() {

	}

	/**
	 * 
	 * @return damage
	 */
	public int getDamage() {//getter for damage

		return damage;
	}

	/**
	 * 
	 * @return weaponWeight
	 */
	public int getWeaponWeight() {//getter for weaponWeight

		return weaponWeight;
	}

	/**
	 * 
	 * @return rateOfFire
	 */
	public int getRateOfFire() {//getter for rateOfFire

		return rateOfFire;
	}

	/**
	 * 
	 * @return projectileImage
	 */
	public String getProjectileImage() {//getter for projectileImage

		return projectileImage;
	}

	/**
	 * 
	 * @param damage
	 */
	public void setDamage(int damage) { //setter for damage

		this.damage = damage;
	}

	/**
	 * 
	 * @param weaponWeight
	 */
	public void setWeaponWeight(int weaponWeight) { //setter for weaponWeight
		this.weaponWeight = weaponWeight;
	}

	/**
	 * 
	 * @param rateOfFire
	 */
	public void setRateOfFire(int rateOfFire) {//setter for rateOfFire

		this.rateOfFire = rateOfFire;
	}

	/**
	 * 
	 * @param projectileImage
	 */
	public void setProjectileImage(String projectileImage) {//setter for projectileImage

		this.projectileImage = projectileImage;
	}
}
