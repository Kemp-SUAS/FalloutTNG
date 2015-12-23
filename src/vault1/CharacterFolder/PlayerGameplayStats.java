package vault1.CharacterFolder;
/**
 * Class holds all the player stats get set methods
 * @author Simar Pal Kalsi , Kieran Wilson, Faduma Ahmed, Mohid Aslam
 *
 */
public class PlayerGameplayStats {
	
	/**
	 *  the health of the player
	 */
	private int health;

	/**
	 *  the abillity of the player
	 */
	private int abilityPoints;

	/**
	 *  the Armour of the player
	 */
	private int armor;

	/**
	 *  the ammunition of the player
	 */
	private int ammo;

	/**
	 *  the toxin levels of the player
	 */
	private int toxinLevels;

	/**
	 *  the toxin resiting capabilities of the player
	 */
	private int toxinResist;

/**
 * Constructor has all the fields
 * @param hp, the players health points 
 * @param ap , the players ability points 
 * @param armP , the players armor points 
 * @param ammoP ,the players ammo points 
 * @param toxP , the players toxin points 
 * @param toxR , the players toxin resisting points 
 * @param relations
 */
	public PlayerGameplayStats(int hp, int ap, int armP, int ammoP, int toxP, int toxR) {
		this.health = hp;
		this.abilityPoints = ap;
		this.armor = armP;
		this.ammo = ammoP;
		this.toxinLevels = toxP;
		this.toxinResist = toxR;
	}
/**
 * Default empty constructor
 */
	public PlayerGameplayStats() {

	}
/**
 * Method gets the health point of the player
 * @return
 * @throws CharacterException
 */
	public int getHealthStat() throws CharacterException{
		// if they dont have any toxin levels
		if(this.toxinLevels != 0){
			return (health - (health*(this.toxinLevels/(100*this.toxinResist))));
		}
		// if they no longer have health points
		if(this.health <= 0){
			
			throw new CharacterException("DEAD");
		}
		return health;
	}
/**
 * Method gets Ability Points
 * @return
 */
	public int getAbilityPoints() throws CharacterException{
		// if they no longer have ability points
		if(this.abilityPoints <= 0){
			throw new CharacterException("NO_AP");
		}
		return abilityPoints;
	}
/**
 * Method gets armour rating
 * @return armor
 */
	public int getArmor() {
		return armor;
	}
/**
 * Method gets ammoun count
 * @return ammo
 */
	public int getAmmo() {
		return ammo;
	}
/**
 * Method gets Toxin Levels
 * @return toxinLevels
 */
	public int getToxinLevel() {
		return toxinLevels;
	}
	/**
	 * Method gets toxin resist
	 * @return toxinResist
	 */
	public int getToxinResist() {
		return toxinResist;
	}
/**
 * method sets health stat
 * @param hp , the players health points
 */
	public void setHealthStat(int hp) {
		this.health = hp;
	}
/**
 * Method sets Ability Points
 * @param ap , the players ability points
 */
	public void setAbilityPoints(int ap) {
		this.ammo = ap;
	}
/**
 * method sets Armour rating
 * @param armP , the players armor points
 */
	public void setArmor(int armP) {
		this.armor = armP;
	}
/**
 * Method sets ammo count
 * @param ammoP , the players ammo points
 */
	public void setAmmo(int ammoP) {
		this.ammo = ammoP;
	}
/**
 * Method sets toxin levels
 * @param toxP , the players toxin points
 */
	public void setToxinLevel(int toxP) {
		this.toxinLevels = toxP;
	}
/**
 * Method sets Toxin Resist
 * @param toxR , the players toxin resisting points
 */
	public void setToxinResist(int toxR) {
		this.toxinLevels = toxR;
	}

/**
 * Method sets NPC relation levels
 * @param relations
 */
}
