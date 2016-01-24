package vault1.CharacterFolder;

import java.awt.Image;

public class Weapons {
	public static int damage;
	public static int weaponWeight;
	public static int rateOfFire;
	public static String projectileImage;
	
	public Weapons(int damage, int weaponWeight, int rateOfFire, String projectileImage) {
		this.damage = damage;
		this.weaponWeight = weaponWeight;
		this.rateOfFire = rateOfFire;
	}
	public Weapons(){
		
	}
	
	public int getDamage() {
		return damage;
	}
	public int getWeaponWeight() {
		return weaponWeight;
	}
	public int getRateOfFire() {
		return rateOfFire;
	}
	public String getProjectileImage() {
		return projectileImage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setWeaponWeight(int weaponWeight) {
		this.weaponWeight = weaponWeight;
	}
	public void setRateOfFire(int rateOfFire) {
		this.rateOfFire = rateOfFire;
	}
	public void setProjectileImage( String projectileImage) {
		this.projectileImage = projectileImage;
	}
	
	
	
	
	
}

