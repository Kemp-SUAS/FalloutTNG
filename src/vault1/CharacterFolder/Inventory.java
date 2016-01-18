package vault1.CharacterFolder;

import java.sql.SQLException;

import AssetHandling.AssetManager;

public class Inventory {

	public Inventory() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public static void cosumeables (PlayerGameplayStats playerStats, PlayerSkillPoints playerSkillPoints , int id) throws ClassNotFoundException, SQLException, CharacterException{
		String item = AssetManager.dataBaseGet("items", id , "effect"); 
		String delims = "[,]+";
		String[] transfer = item.split(delims);
		int value = 0;
		
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
			playerSkillPoints.setCarryWeightMultiplier(playerSkillPoints.getCarryWeightMultiplier()+ value);			
		}
	
	}

}
