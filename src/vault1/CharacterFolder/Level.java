package vault1.CharacterFolder;

import java.sql.SQLException;

import AssetHandling.AssetManager;

public class Level {
	
	private String levelName;
	private String imageData;
	private String wallData;
	private String playerPosition;
	private String playerData;
	private String npcData;
	private int id;
	
	
	public Level(int id) {
		this.id = id;
		
	}
	
	public Level(){

	}
	public String getLevelName(){
		return levelName;		
	}
	public String getImageData(){
		return imageData;
	}
	public String getWallData(){
		return wallData;
	}
	public String getPlayerPosition(){
		return playerPosition;
	}
	public String getPlayerData(){
		return playerData;
	}
	public String getNpcData(){
		return npcData;	
	}
	
	public void setLevelName(String levelName) throws ClassNotFoundException, SQLException{
		 this.levelName = AssetManager.dataBaseGet("Level", id , "levelName");
	}
	public void setImageData(String imageData) throws ClassNotFoundException, SQLException{
		 this.imageData = AssetManager.dataBaseGet("Level", id, "imageData");
	}
	public void setWallData(String wallData) throws ClassNotFoundException, SQLException{
		 this.wallData = AssetManager.dataBaseGet("Level", id, "wallData");
	}
	public void setPlayerPosition(String playerPosition) throws ClassNotFoundException, SQLException{
		 this.playerPosition = AssetManager.dataBaseGet("Level", id, "playerPos");
	}
	public void setPlayerData(String playerData) throws ClassNotFoundException, SQLException{
		 this.playerData = AssetManager.dataBaseGet("Level", id, "playerData");
	}
	public void npcData(String npcData) throws ClassNotFoundException, SQLException{
		 this.npcData = AssetManager.dataBaseGet("Level", id, "npcData");
	}
	
} 

