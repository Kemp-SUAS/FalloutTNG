package vault1.CharacterFolder;

import java.sql.SQLException;

import AssetHandling.AssetManager;

public class Inventory {

	public Inventory() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public static void cosumeables (PlayerGameplayStats playerStats, PlayerSkillPoints playerSkillPoints , int id) throws ClassNotFoundException, SQLException{
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
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "health"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "armor"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "ammo"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "abilitypoints"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "str"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "aware"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "end"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "wit"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "int"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "dex"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "luck"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
		
		if(transfer[0] == "carryweight"){
			value = Integer.parseInt(transfer[1]);
			playerStats.setToxinLevel(playerStats.getToxinLevel()+ value);			
		}
	
	}

}
