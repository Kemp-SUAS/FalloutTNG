package vault1.CharacterFolder;

import java.awt.Image;
import java.util.TimerTask;

import renderer.WorldLayout;

/**
 * THis class takes care of all the weapons and criteria to be used
 * @author Kieran Wilson, Mohid Alsam, Keiran Wilson, Simar Pal Kalsi
 *
 */

public class Weapons {

	/**
	 *  the amount of damage
	 */
	public static int damage;

	/**
	 *  the weight of weapon
	 */
	public static int weaponWeight;
	

	/**
	 *  the rate of the fire
	 *  
	 */  
	public static int rateOfFire;
	
	
	/**
	 *  the projection o the image
	 */
	public static String projectileImage;

	/**
	 * 
	 * @param damage, the damage points
	 * @param weaponWeight, the weight of the weapon
	 * @param rateOfFire, the rate of the weapon
	 * @param projectileImage, image being projectiled
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
	 * @return damage, getter for damage
	 */
	public int getDamage() {//getter for damage

		return damage;
	}

	/**
	 * 
	 * @return weaponWeight, getter for weaponWeight
	 */
	public int getWeaponWeight() {//getter for weaponWeight

		return weaponWeight;
	}

	/**
	 * 
	 * @return rateOfFire, getter for rateOfFire
	 */
	public int getRateOfFire() {//getter for rateOfFire

		return rateOfFire;
	}

	/**
	 * 
	 * @return projectileImage, getter for projectileImage
	 */
	public String getProjectileImage() {//getter for projectileImage

		return projectileImage;
	}

	/**
	 * 
	 * @param damage, setter for damage

	 */
	public void setDamage(int damage) { //setter for damage

		this.damage = damage;
	}

	/**
	 * 
	 * @param weaponWeight, setter for weaponWeight
	 */
	public void setWeaponWeight(int weaponWeight) { //setter for weaponWeight
		this.weaponWeight = weaponWeight;
	}

	/**
	 * 
	 * @param rateOfFire, setter for rateOfFire
	 */
	public void setRateOfFire(int rateOfFire) {//setter for rateOfFire

		this.rateOfFire = rateOfFire;
	}

	/**
	 * 
	 * @param projectileImage, setter for projectileImage
	 */
	public void setProjectileImage(String projectileImage) {//setter for projectileImage

		this.projectileImage = projectileImage;
	}
}
