package vault1.CharacterFolder;

public class PlayerSkillPoints {
	private int strength;
	private int awareness;
	private int endurance;
	private int wit;
	private int intelligence;
	private int dexterity;
	private int luck;

	public PlayerSkillPoints() {

	}
	public PlayerSkillPoints(int str, int aware, int end, int wit, int intel, int dex, int luck) {
		this.strength = str;
		this.awareness = aware;
		this.endurance = end;
		this.wit = wit;
		this.intelligence = intel;
		this.dexterity = dex;
		this.luck = luck;
	}
	public int getStrengthStat(){
		return strength;
	}
	public int getAwarenessStat(){
		return awareness;
	}
	public int getEnduranceStat(){
		return endurance;
	}
	public int getWitStat(){
		return wit;
	}
	public int getIntelligenceStat(){
		return intelligence;
	}
	public int getDexterityStat(){
		return dexterity;
	}
	public int getLuckStat(){
		return luck;
	}
	
	public void setStrengthStat(int str){
		this.strength = str;
	}
	public void setAwarenessStat(int aware){
		this.awareness = aware;
	}
	public void setEnduranceStat(int end){
		this.endurance = end;
	}
	public void setWitStat(int wit){
		this.wit = wit;
	}
	public void setIntellignceStat(int intel){
		this.strength = intel;
	}
	public void setDexterityStat(int dex){
		this.strength = dex;
	}
	public void setLuckStat(int luck){
		this.strength = luck;
	}
	
	
	
	

}
