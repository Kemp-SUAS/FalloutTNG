package vault1.CharacterFolder;

import java.sql.SQLException;

import AssetHandling.AssetManager;

public class Inventory {
	PlayerGameplayStats playerStats;
	PlayerSkillPoints playerSP; 
	public Inventory(PlayerGameplayStats playerStats,PlayerSkillPoints playerSP) {
		this.playerStats = playerStats;
		this.playerSP = playerSP;
	}
	
	
	public static void main(String[] args) throws CharacterException, ClassNotFoundException, SQLException{
		
			
		int health;
		int wit;
		double carryWeight;
		PlayerGameplayStats playerStats = new PlayerGameplayStats();
		PlayerSkillPoints playerSP = new PlayerSkillPoints(); 
		@SuppressWarnings("unused")
		Inventory inventory = new Inventory(playerStats, playerSP);
		playerStats.setHealthStat(100);
		health = playerStats.getHealthStat();
		System.out.println(health);
		
		playerSP.setWitStat(5);
		wit = playerSP.getWitStat();
		System.out.println(wit);
		
		
		carryWeight = playerSP.getCarryWeightMultiplier();
		System.out.println(carryWeight);
		
		Inventory.consumeables(playerStats, playerSP, 2 );
		Inventory.consumeables(playerStats, playerSP, 5 );
		Inventory.consumeables(playerStats, playerSP, 9 );
		
		health = playerStats.getHealthStat();
		wit = playerSP.getWitStat();
		carryWeight = playerSP.getCarryWeightMultiplier();
		
		System.out.println(health);
		System.out.println(wit);
		System.out.println(carryWeight);
		
	}
	
	
	
	public static void consumeables (PlayerGameplayStats playerStats, PlayerSkillPoints playerSkillPoints , int id) throws ClassNotFoundException, SQLException, CharacterException{
		String item = AssetManager.dataBaseGet("items", id , "effect"); 
		String delims = "[,]+";
		String[] transfer = item.split(delims);
		int value  = Integer.parseInt(transfer[1]);
		System.out.println("Hello" + transfer[0]);
		System.out.println("Hello from the other side " + playerStats.getToxinLevel()+ value);
		if(transfer[0] == "toxicgone"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "toxresist"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinResist(playerStats.getToxinResist()+ value);			
		}
		
		if(transfer[0] == "health"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setHealthStat(playerStats.getHealthStat()+ value);			
		}
		
		if(transfer[0] == "armor"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setArmor(playerStats.getArmor()+ value);			
		}
		
		if(transfer[0] == "ammo"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setAmmo(playerStats.getAmmo()+ value);			
		}
		
		if(transfer[0] == "abilitypoints"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setAbilityPoints(playerStats.getAbilityPoints()+ value);			
		}
		
		if(transfer[0] == "str"){
			value = Integer.parseInt(transfer[1]);
			playerSkillPoints.setStrengthStat(playerSkillPoints.getStrengthStat()+ value);			
		}
		
		if(transfer[0] == "aware"){
			value = Integer.parseInt(transfer[1]);
			playerSkillPoints.setAwarenessStat(playerSkillPoints.getAwarenessStat()+ value);			
		}
		
		if(transfer[0] == "end"){
			value = Integer.parseInt(transfer[1]);
			playerSkillPoints.setEnduranceStat(playerSkillPoints.getEnduranceStat()+ value);			
		}
		
		if(transfer[0] == "wit"){
			value = Integer.parseInt(transfer[1]);
			playerSkillPoints.setWitStat(playerSkillPoints.getWitStat()+ value);			
		}
		
		if(transfer[0] == "int"){
			value = Integer.parseInt(transfer[1]);
			playerSkillPoints.setIntellignceStat(playerSkillPoints.getIntelligenceStat()+ value);			
		}
		
		if(transfer[0] == "dex"){
			value = Integer.parseInt(transfer[1]);
			playerSkillPoints.setDexterityStat(playerSkillPoints.getDexterityStat()+ value);			
		}
		
		if(transfer[0] == "luck"){
			value = Integer.parseInt(transfer[1]);
			playerSkillPoints.setLuckStat(playerSkillPoints.getLuckStat()+ value);			
		}
		
		if(transfer[0] == "carryweight"){
			value = Integer.parseInt(transfer[1]);
			playerSkillPoints.setCarryWeightMultiplier((int) (playerSkillPoints.getCarryWeightMultiplier()+ value));			
		}
	
	}

}
