package vault1.CharacterFolder;

public class PlayerStats {
	private int health;
	private int abilityPoints;
	private int armor;
	private int ammo;
	private int toxinLevels;
	private int relations;

	public PlayerStats(int hp, int ap, int armP, int ammoP, int toxP, int relations) {
		this.health = hp;
		this.abilityPoints = ap;
		this.armor = armP;
		this.ammo = ammoP;
		this.toxinLevels = toxP;
		this.relations = relations;
	}

	public PlayerStats() {

	}

	public int getHealthStat() {
		return health;
	}

	public int getAbilityPoints() {
		return abilityPoints;
	}

	public int getArmor() {
		return armor;
	}

	public int getAmmo() {
		return ammo;
	}

	public int getToxinLevel() {
		return toxinLevels;
	}

	public int getRelationsLevel() {
		return relations;
	}

	public void setHealthStat(int hp) {
		this.health = hp;
		this.getToxinLevel();
	}

	public void setAbilityPoints(int ap) {
		this.ammo = ap;
	}

	public void setArmor(int armP) {
		this.armor = armP;
	}

	public void setAmmo(int ammoP) {
		this.ammo = ammoP;
	}

	public void setToxinLevel(int toxP) {
		this.toxinLevels = toxP;
	}

	public void setRelationsLevel(int relations) {
		this.relations = relations;
	}

}
