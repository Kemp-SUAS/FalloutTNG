package vault1.CharacterFolder;
/**
 * Class holds all of the players skill points
 * @author Kieran , Simar
 *
 */
public class PlayerSkillPoints {
	private int strength;
	private int awareness;
	private int endurance;
	private int wit;
	private int intelligence;
	private int dexterity;
	private int luck;
	int carryWeightMultiplier;
	final int CARRY_WEIGHT_CONST = 100;
		

	/**
	 * Defult constructor
	 */
	public PlayerSkillPoints() {

	}
	/**
	 * Constructor for all of the fields
	 * @param str
	 * @param aware
	 * @param end
	 * @param wit
	 * @param intel
	 * @param dex
	 * @param luck
	 */
	public PlayerSkillPoints(int str, int aware, int end, int wit, int intel, int dex, int luck, int carryWeightMultiplier) {
		this.strength = str;
		this.awareness = aware;
		this.endurance = end;
		this.wit = wit;
		this.intelligence = intel;
		this.dexterity = dex;
		this.luck = luck;
	}
	/**
	 * Gets the players Strength stat
	 * @return
	 */
	public int getStrengthStat(){
		return strength;
	}
	/**
	 * Gets the players Awareness stat
	 * @return 
	 */
	public int getAwarenessStat(){
		return awareness;
	}
	/**
	 * Gets the players Endurance stat
	 * @return
	 */
	public int getEnduranceStat(){
		return endurance;
	}
	/**
	 * Gets the players Wit stat
	 * @return
	 */
	public int getWitStat(){
		return wit;
	}
	/**
	 * Gets the players Intelligence stat
	 * @return
	 */
	public int getIntelligenceStat(){
		return intelligence;
	}
	/**
	 * Gets the players Dexterity stat
	 * @return
	 */
	public int getDexterityStat(){
		return dexterity;
	}
	/**
	 * Gets the players Luck stat
	 * @return
	 */
	public int getLuckStat(){
		return luck;
	}
	/**
	 * Gets the plays Maximum carry weight
	 * @return
	 */
	public int getCarryWeightMultiplier(){
		return carryWeightMultiplier * CARRY_WEIGHT_CONST;
	}
	
	/**
	 * Sets the players Strength stat
	 * @return
	 */
	public void setStrengthStat(int str){
		this.strength = str;
	}
	/**
	 * Sets the players Awareness stat
	 * @return
	 */
	public void setAwarenessStat(int aware){
		this.awareness = aware;
	}
	/**
	 * Sets the players Endurance stat
	 * @return
	 */
	public void setEnduranceStat(int end){
		this.endurance = end;
	}
	/**
	 * Sets the players Wit stat
	 * @return
	 */
	public void setWitStat(int wit){
		this.wit = wit;
	}
	/**
	 * Sets the player Intelligence stat
	 * @return
	 */
	public void setIntellignceStat(int intel){
		this.strength = intel;
	}
	/**
	 * Sets the players Dexterity stat
	 * @return
	 */
	public void setDexterityStat(int dex){
		this.strength = dex;
	}
	/**
	 * Sets the players Luck stat
	 * @return
	 */
	public void setLuckStat(int luck){
		this.strength = luck;
	}
	/**
	 * Sets the players maximum carry weight
	 * @param carryWeightMultiplier
	 */
	public void setCarryWeightMultiplier(int carryWeightMultiplier){
		this.carryWeightMultiplier = carryWeightMultiplier;
	}
		
	

}
