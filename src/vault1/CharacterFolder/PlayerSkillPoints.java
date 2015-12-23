package vault1.CharacterFolder;
/**
 * Class holds all of the players skill points
 * @author Faduma Ahmed, Kieran Wilson Simar pal Kalsi Mohid Aslam
 *
 */
public class PlayerSkillPoints {
	/**
	 *  The strength of the player
	 */
	private int strength;
	/**
	 *  The awareness of the player
	 */
	private int awareness;
	/**
	 *  The endurance of the player
	 */
	private int endurance;
	/**
	 *  The wit of the player
	 */
	private int wit;
	/**
	 *  The intelligence of the player
	 */
	private int intelligence;
	/**
	 *  The dexterity of the player
	 */
	private int dexterity;
	/**
	 *  The luck of the player
	 */
	private int luck;
	/**
	 *  The how much the points will multiply by 
	 */
	public int carryWeightMultiplier;
	/**
	 *  The the carry weight points of the player
	 */
	final int CARRY_WEIGHT_CONST = 100;
		

	/**
	 * Defult constructor
	 */
	public PlayerSkillPoints() {

	}
	
	/** Sets the players stats
	 * @param strength , the strength of the player
	 * @param awareness , the awareness of the player
	 * @param endurance , the endurance of the player
	 * @param wit , the wit of the player
	 * @param intelligence , the intelligence of the player
	 * @param dexterity , the dexterity of the player
	 * @param luck ,the luck of the player
	 * @param carryWeightMultiplier ,carry weight points of the player
	 */
	public PlayerSkillPoints(int strength, int awareness, int endurance, int wit, int intelligence, int dexterity, int luck, int carryWeightMultiplier) {
		this.strength = strength;
		this.awareness = awareness;
		this.endurance = endurance;
		this.wit = wit;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		this.luck = luck;
		this.carryWeightMultiplier= carryWeightMultiplier;
	}
	/**
	 * Gets the players Strength stat
	 * @return strength, of the player
	 */
	public int getStrengthStat(){
		
		return strength;
	}
	
	/**
	 * Gets the players Awareness stat
	 * @return  awareness , of the player
	 */
	public int getAwarenessStat(){
		
		return awareness;
	}
	
	/**
	 * Gets the players Endurance stat
	 * @return endurance , of the player
	 */
	public int getEnduranceStat(){
		
		return endurance;
	}
	/**
	 * Gets the players Wit stat
	 * @return wit , of the player
	 */
	public int getWitStat(){
		
		return wit;
	}
	/**
	 * Gets the players Intelligence stat
	 * @return intelligence , of the player
	 */
	public int getIntelligenceStat(){
		
		return intelligence;
	}
	/**
	 * Gets the players Dexterity stat
	 * @return  dexterity, of the player
	 */
	
	public int getDexterityStat(){
		
		return dexterity;
	}
	/**
	 * Gets the players Luck stat
	 * @return luck , of the player
	 */
	
	public int getLuckStat(){
		
		return luck;
	}
	
	/**
	 * Gets the plays Maximum carry weight
	 * @return  totalCarryWeight , the total multiplied weight points of the player
	 */
	public int getCarryWeightMultiplier(){
		
		int totalCarryWeight= carryWeightMultiplier * CARRY_WEIGHT_CONST;
		
		return totalCarryWeight;
	}
	
	
	/**
	 * Sets the players Strength stat
	 * 
	 */
	
	public void setStrengthStat(int strength){
		
		this.strength = strength;
	}
	
	/**
	 * Sets the players Awareness stat
	 * 
	 */
	public void setAwarenessStat(int awareness){
		this.awareness =  awareness;
		
	}
	/**
	 * Sets the players Endurance stat
	 * 
	 */
	public void setEnduranceStat(int endurance){
		this.endurance = endurance;
	}
	/**
	 * Sets the players Wit stat
	 *
	 */
	public void setWitStat(int wit){
		this.wit = wit;
	}
	/**
	 * Sets the player Intelligence stat
	 * 
	 */
	public void setIntelligenceStat(int intelligence){
		this.strength = intelligence;
	}
	/**
	 * Sets the  players Dexterity stat
	 * 
	 */
	public void setDexterityStat(int dexterity){
		this.strength = dexterity;
	}
	/**
	 * Sets the players Luck stat
	 * 
	 */
	public void setLuckStat(int luck){
		this.strength = luck;
	}
	/**
	 * Sets the players maximum carry weight
	 * 
	 */
	public void setCarryWeightMultiplier(int carryWeightMultiplier){
		this.carryWeightMultiplier = carryWeightMultiplier;
	
	
	
	
	}
		
	

}
