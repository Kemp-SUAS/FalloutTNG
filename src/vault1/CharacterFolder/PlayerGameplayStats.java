package vault1.CharacterFolder;
/**
 * Class holds all the player stats get set methods
 * @author Simar , Kieran
 *
 */
public class PlayerGameplayStats {
	private int health;
	private int abilityPoints;
	private int armor;
	private int ammo;
	private int toxinLevels;
	private int toxinResist;

/**
 * Constructor has all the fields
 * @param hp
 * @param ap
 * @param armP
 * @param ammoP
 * @param toxP
 * @param toxR
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
		if(this.toxinLevels != 0){
			return (health - (health*(this.toxinLevels/(100*this.toxinResist))));
		}
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
		if(this.abilityPoints <= 0){
			throw new CharacterException("NO_AP");
		}
		return abilityPoints;
	}
/**
 * Method gets armour rating
 * @return
 */
	public int getArmor() {
		return armor;
	}
/**
 * Method gets ammoun count
 * @return
 */
	public int getAmmo() {
		return ammo;
	}
/**
 * Method gets Toxin Levels
 * @return
 */
	public int getToxinLevel() {
		return toxinLevels;
	}
	/**
	 * Method gets toxin resist
	 * @return
	 */
	public int getToxinResist() {
		return toxinResist;
	}
/**
 * method sets health stat
 * @param hp
 */
	public void setHealthStat(int hp) {
		this.health = hp;
	}
/**
 * Method sets Ability Points
 * @param ap
 */
	public void setAbilityPoints(int ap) {
		this.ammo = ap;
	}
/**
 * method sets Armour rating
 * @param armP
 */
	public void setArmor(int armP) {
		this.armor = armP;
	}
/**
 * Method sets ammo count
 * @param ammoP
 */
	public void setAmmo(int ammoP) {
		this.ammo = ammoP;
	}
/**
 * Method sets toxin levels
 * @param toxP
 */
	public void setToxinLevel(int toxP) {
		this.toxinLevels = toxP;
	}
/**
 * Method sets Toxin Resist
 * @param toxR
 */
	public void setToxinResist(int toxR) {
		this.toxinLevels = toxR;
	}

/**
 * Method sets NPC relation levels
 * @param relations
 */
}
